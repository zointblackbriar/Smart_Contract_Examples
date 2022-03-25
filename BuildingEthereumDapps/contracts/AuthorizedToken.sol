//"SPDX-License-Identifier: MIT"
pragma solidity ^0.8.4; 

contract AuthorizedToken {
    mapping (address => uint256) public tokenBalance; 
    mapping (address => bool) public frozenAccount; 
    event Transfer(address currentContract, address remoteContract, uint256 amount);
    event FrozenEvent(address targetAddress, bool isFreezed);

    address public ownerContract;
    uint256 public constant maxTransferLimit = 50000;

    modifier onlyOwner() {
        require(msg.sender == ownerContract);
        _;
    }

    function transfer(address _remoteAddress, uint256 _amount) public  {
        require(checkLimit(_amount));
        tokenBalance[msg.sender] -= _amount; 
        tokenBalance[_remoteAddress] += _amount;
        emit Transfer(msg.sender, _remoteAddress, _amount); //Logged
    }

    function checkLimit(uint256 _amount) public pure returns (bool){
        if(_amount < maxTransferLimit)
            return true; 
        return false;
    }

    function validateAccount(address _account) public returns (bool) {
        if(frozenAccount[_account] && tokenBalance[_account ] > 0)
            return true;
        return false;
    }

    function makeTheAccountFrozen(address targetAddress, bool isFreezed) onlyOwner public  {
        frozenAccount[ targetAddress ] = isFreezed;
        emit FrozenEvent(targetAddress, isFreezed);
    }

}