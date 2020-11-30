// SPDX-License-Identifier: MIT

pragma solidity ^0.5.16;

contract StorageContract {
    struct Person {
        string name;
        uint age;
    }
    
    mapping(address=>Person) public people; // the people is the key and the Person is the value
    address[] public peopleAddress; //the address of the data structure
    
    function setData (string memory _name, uint _age) public {
        Person memory newPerson = Person({
            name : _name,
            age : _age
        });
        
        people[msg.sender] = newPerson;
        peopleAddress.push(msg.sender);
    }
    
    function getData(address _address) public view returns ( string memory,  uint) {
        return(
            people[_address].name,
            people[_address].age
            );
    }
    
    function getAllAddress() public view returns (address[] memory){
        return peopleAddress;
    }
}