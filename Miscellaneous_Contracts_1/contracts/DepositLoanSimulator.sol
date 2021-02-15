// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

interface  Regulator {
    function checkValue(uint amount) external returns (bool); 
    function loan() external returns (bool);
    
    
}

contract Bank is Regulator {
    uint private value; 
    address private owner; 
    
    modifier ownerFunc {
        require(owner == msg.sender); 
        _;
    }
    
    constructor(uint _amount) public {
        value = _amount; 
        owner = msg.sender; 
    }
    
    function deposit(uint _amount) public ownerFunc {
        value += _amount;
    }
    
    function withdraw(uint _amount) public ownerFunc {
        value -= _amount;
    }
    
    function balance() public view returns (uint) {
        return value;
    }
    
    function checkValue(uint amount) public returns (bool) {
        return value >= amount;
    }
    
    function loan() public returns (bool) {
        return value > 0;
    }
    
    
    
}

    //private value
    //private age
    //My first Contract 
    //Set Name 
    //Get Name
    //Set age
    //Get age
    
contract MyFirstContract is Bank(10) {
    string private value;
    uint private age; 
    
    function getName() public view returns (string memory) {
        return value;
    }
    
    function setName(string memory _value) public  {
        value = _value;
    }
    
    function getAge() public view returns (uint) {
        return age;
    }
    
    function setAge(uint _age) public {
        age = _age;
    }
    
}

contract TestThrow {
    function testAssert() public pure {
        assert (1 == 2);
    }
    
    function testRequire() public pure {
        require(2 == 1);
    }
    
    
    function testRevert() public pure {
        revert(); 
    }
    
}