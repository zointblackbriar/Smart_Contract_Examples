pragma solidity ^0.5.12; 


//@title DataTypes samples
//@author Orcun Oruc
//@notice the contract has been referenced to this repository https://github.com/willitscale/learning-solidity/blob/master/tutorial-06/DataTypes.sol

contract DataTypes {
    bool myBool = false; 

    int8 myInt = -128; 
    uint8 myUInt = 255; 

    string myString; 
    uint8[] myStringArr; 

    byte myValue; 
    bytes1 myBytes1; 
    bytes32 myBytes32; 

    event TakeSomeData(uint[] helloArray);

    enum Action {ADD, REMOVE, UPDATE}

    //define an action of enum type
    Action action = Action.ADD; 

    address payable myAddress; 

    function assignAddress() public {
        myAddress = msg.sender; 
        myAddress.balance; 
        myAddress.transfer(10);
    }

    uint[] myIntArray = [1, 2, 3];  //array of integer

    function arrayFunction() public {
        myIntArray.push(12);
        myIntArray.length; 
        myIntArray[0]; 
        emit TakeSomeData(myIntArray);
    }

    uint[10] myFixedArray; 

    struct Account {
        uint balance; 
        uint dailyLimit; 
    }

    Account myAccount; 

    function structFunction() public {
        myAccount.balance = 100; 
    }

    mapping (address => Account) _accounts; 

    //fallback function
    function() external payable {
        _accounts[msg.sender].balance += msg.value; 
    }

    function getBalance() public view returns (uint) {
        return _accounts[msg.sender].balance; 
    }
}