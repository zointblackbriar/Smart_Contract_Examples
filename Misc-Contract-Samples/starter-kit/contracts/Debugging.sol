pragma solidity ^0.5.0; 

contract Debugging {

    uint[] private storageVal; 

    //function assignment
    //public pure
    //assert two Values such as value1 == value2
    function assignment() public pure {
        uint value1;
        uint value2; 
        assert(value1 == value2 ); 
    }

    //memoryAllocation function // public pure
    // assign a string memory value 
    //bytes(string).length = random number
    function memoryAllocation() public pure {
        string memory testVal = "helloworld";
        assert(bytes(testVal).length == 10); 
    }
    

    //storageAllocation // public 
    //storage value named as storageVal and its an uint array
    //push values and compare the length == 4
    function storageAllocation() public {
        storageVal.push(3); 
        storageVal.push(4);
        assert(storageVal.length == 4);
    }
}