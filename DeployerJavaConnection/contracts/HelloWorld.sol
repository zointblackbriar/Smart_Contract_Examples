//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 


contract HelloWorld {
    function sayHello() public pure returns(string memory) {
        return("hello world");
    }
}