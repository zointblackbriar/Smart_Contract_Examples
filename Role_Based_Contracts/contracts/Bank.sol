pragma solidity >=0.4.21 <0.7.0;

contract Bank {
    struct ROLES {
        string Customer;
        string Consultant;
        string BankAccounts; // how do we define one - to -one relationship in object oriented language.
        string MoneyTransfer; 
    }

    string _name; //for banking name

    function login (uint id, uint cred) public  view returns (bool) {
        // fill it up
        return false;
    }

    function executeTransactions() public view returns (bool){
        //true or false;
        return false;
    }

    // Case: Between Data
    // One to one association is represented by a key-value pair. This type of association is used in Hash Tables and is implemented as Map in C++.
    // Such a structure can be conceived by using two arrays.
}