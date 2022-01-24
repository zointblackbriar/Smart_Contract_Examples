from pyteal import *
from pyteal.ast import scratch 


def approval_program(): 
    handle_creation = Seq([
        App.globalPut(Bytes("Count"), Int(0)), Return(Int(1))
    ])

    #handles
    handle_optin = Return(Int(0))

    handle_closeout = Return(Int(0))

    handle_updateapp = Return(Int(0))

    handle_deleteapp = Return(Int(0))

    scratchCount = ScratchVar(TealType.uint64)

    add = Seq([
        scratchCount.store(App.globalGet(Bytes("Count"))),
        App.globalPut(Bytes("Count"), scratchCount.load() + Int(1)),
        Return(Int(1))
    ])

    deduct = Seq([
    scratchCount.store(App.globalGet(Bytes("Count"))),
        If(scratchCount.load() > Int(0),
            App.globalPut(Bytes("Count"), scratchCount.load() - Int(1)),
        ),
        Return(Int(1))
    ])

    #The NoOp transaction type is the primary location where application logic will be implemented in most smart contracts
    #This example requires an add and a deduct function, to increment and decrement the counter respectively, to be handled for NoOp application transactions
    handle_noop = Cond(
        [And(
            Global.group_size() == Int(1), 
            Txn.application_args[0] == Bytes("Add")
        ), add], 
        [And(
            Global.group_size() == Int(1), 
            Txn.application_args[0] == Bytes("Deduct")
        ), deduct],
    )

    # program = Return(Int(1))
    program = Cond(
        [Txn.application_id() == Int(0), handle_creation],
        [Txn.on_completion() == OnComplete.OptIn, handle_optin],
        [Txn.on_completion() == OnComplete.CloseOut, handle_closeout], 
        [Txn.on_completion() == OnComplete.UpdateApplication, handle_updateapp], 
        [Txn.on_completion() == OnComplete.DeleteApplication, handle_deleteapp], 
        [Txn.on_completion() == OnComplete.NoOp, handle_noop]
    )
    # Mode.Application(c) specifies that this is a smart contract
    return compileTeal(program, Mode.Application, version=5)

def clear_state_program():
    program = Return(Int(1))
    print("program state: ", program)
    # Mode.Application specifies that this is a smart contract
    return compileTeal(program, Mode.Application, version=5)

approval_program()
clear_state_program()