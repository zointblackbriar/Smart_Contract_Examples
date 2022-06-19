//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

contract SimpleCoin {
    mapping(address => uint256 ) public coinBalance; 

    //Logging of the SimpleCoin
    event TransferLog(address indexed from, address indexed to, uint256 value); 

    constructor(uint256 _initialSupply) 
    {
        coinBalance[msg.sender] = _initialSupply; 
    }

    function transfer(address _toAddress, uint256 _amount) public returns(bool){
        require(coinBalance[msg.sender] > _amount); 
        require(coinBalance[_toAddress] + _amount >= coinBalance[_toAddress]);
        coinBalance[msg.sender] -= _amount; 
        coinBalance[_toAddress] += _amount; 
        //Logging
        emit TransferLog(msg.sender, _toAddress, _amount); 
        return true;
    }
}