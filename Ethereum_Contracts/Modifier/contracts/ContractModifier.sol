pragma solidity ^0.5.0;

interface Regulator {
    function checkValue(uint amount) external returns (bool); //first interface function
    function loan() external returns (bool);

}

contract Bank is Regulator { //implements Regulator
    uint private value;
    address private owner;  //adress of this contract

    modifier ownerFunc() {
        require(owner == msg.sender);
        _;
    }

    constructor(uint _amount) public {
        value = _amount;
        owner = msg.sender;
    }



}

contract ContractModifier is Bank(0) {  //Bank(0) is contructor passing
    string private name;
    uint private age;

    function setName(string memory _name ) public {
        name = _name;
    }

    function getName() public view returns(string memory){
        return name;
    }

    function setAge(uint _age) public {
        age = _age;
    }

    function getAge()public view returns (uint) {
        return uint;
    }
}

contract TestThrows {
    function testAssert() public pure {
        assert(1==2);
    }

    function testRequire() public pure {
        require(2==1);
    }

    function testRevert() public pure {
        revert();
    }

    function testThrow() public pure {
        //throw;
    }
}