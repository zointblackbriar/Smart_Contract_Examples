pragma solidity ^0.8.0; 

contract Token {
    function transferFrom(address _fromAddress, address _toAddress, uint256 _value) public virtual returns(bool checkFlag) ; 

}