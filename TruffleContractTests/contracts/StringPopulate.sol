pragma solidity ^0.8.0; 

contract StringPopulate1 {
    uint counter; 
}

contract StringPopulate2 {
    uint counter = 0; 
    mapping(uint => string) stringPopulate; //maps an integer to a string

    function push(string memory testparam) public {
        stringPopulate[counter] = testparam; 
        counter++; 
    }

    function get(uint indexparam) public view returns (string memory){
        return stringPopulate[indexparam];
    }

    function getTheCounterParam() public view returns (uint) {
        return counter; 
    }
}