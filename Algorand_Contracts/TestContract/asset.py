
from pyteal import * 

def approval_program(): 
    on_creation = Seq([
        Assert(Txn.application_args.length() == Int(1)),
        App.globalPut(Bytes("total supply"), Btoi(Txn.application_args[0])),
        App.globalPut(Bytes("reserve"), Btoi(Txn.application_args[0])),
        App.localPut(Int(0), Bytes("admin"), Int(1)),
        App.localPut(Int(0), Bytes("balance"), Int(0)),
        Return(Int(1))
    ])

approval_program()

if __name__ == "__main__":
    