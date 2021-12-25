import json
from algosdk.v2client import algod
from algosdk import account, mnemonic
from algosdk.future.transaction import AssetConfigTxn, AssetTransferTxn, AssetFreezeTxn
import sys

### The check for sys.real_prefix covers virtualenv, the equality of non-empty sys.base_prefix with sys.prefix covers venv.

def is_venv():
    return(hasattr(sys, 'real_prefix') or (hasattr(sys, 'base_prefix') and sys.base_prefix != sys.prefix))

is_venv()

#It was shown for the demonstration purposes.
# Account mnemonics
# test function for the mnemonics
def test_func():
    mnemonic1 = "account1";
    mnemonic2 = "account2";
    mnemonic3 = "account3";

    accounts = {}
    counter = 1
    for mnem in [mnemonic1, mnemonic2, mnemonic3]:
        accounts[counter] = {}
        accounts[counter]['pk'] = mnemonic.to_public_key(mnem)
        accounts[counter]['sk'] = mnemonic.to_private_key(mnem)
        counter += 1

    #Specify your node address and token. This must be updated

    algod_address = "give here the remote address of algorand"
    algod_token = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

def mini_func():
    #generate an account
    private_key, address = account.generate_account()
    print("Private key: " + private_key)
    print("Address: " + address)

    #check if the address is valid
    if encoding.is_valid_address(address):
        print("The address is valid!")
    else:
        print("The address is invalid")
