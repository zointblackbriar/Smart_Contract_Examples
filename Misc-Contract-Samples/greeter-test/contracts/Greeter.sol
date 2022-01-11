pragma solidity >= 0.4.0 <= 0.8.9; 

contract Greeter {
    string private _greeting = "Test String!";
    address private _owner; 

    function greet() external view returns(string memory) {
        // return "Test String!";
        return _greeting;
    }

    function setGreeting(string calldata greeting) external {
        _greeting = greeting;
    }

    function ownerOfContract() public view returns(address) {
        return _owner; 
    }
}