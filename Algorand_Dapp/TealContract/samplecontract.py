from pyteal import * 


def approval_program(): 
    handle_creation = Seq([
        App.globalPut(Bytes("Count"), Int(0)), Return(Int(1))
    ])

    #handles
    handle_optin = Return(Int(0))

    handle_closeout = Return(Int(0))

    handle_updateapp = Return(Int(0))

    handle_deleteapp = Return(Int(0))


    program = Return(Int(1))
    # Mode.Application(c) specifies that this is a smart contract
    return compileTeal(program, Mode.Application, version=5)

def clear_state_program():
    program = Return(Int(1))
    print("program state: ", program)
    # Mode.Application specifies that this is a smart contract
    return compileTeal(program, Mode.Application, version=5)

approval_program()
clear_state_program()