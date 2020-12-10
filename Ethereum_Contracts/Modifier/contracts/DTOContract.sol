pragma solidity ^0.5.0;

interface Regulator {
    function checkValue(uint amount) external returns (bool);
    function loan() external returns (bool);
}

contract Bank is Regulator {
    uint private value; 

    constructor(uint _amount) public {
        value = _amount;
    }

    function deposit(uint _amount) public {
        value += _amount;  // amount has been added to value in order to provide deposit
    }

    function withdraw(uint _amount) public {
        if(checkValue(_amount)) {
            value -= _amount;
        }
    }

    function checkValue(uint _amount) public returns (bool) {
        return value >= _amount;
    }

    function loan() public returns (bool) {
        return value > 0; 
    }
}

    contract DTOContract is Bank(10) {
        string private name;
        uint private age; 

        function setName(string memory _name) public {
            name = _name;
        }

        function getname() public view returns (string memory){
            return name;
        }

        function setAge(uint _age) public {
            age = _age;
        }

        function getAge() public view returns (uint){
            return age;
        }
    }