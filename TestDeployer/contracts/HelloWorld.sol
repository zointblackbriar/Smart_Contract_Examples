pragma solidity >=0.4.21 <0.7.0;


contract HelloWorld {
    function sayHello() public pure returns(string memory) {
        return("hello world");
    }
}