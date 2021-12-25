// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0; 

contract SimpleCoin {
    mapping(address => uint256) public coinBalance; 
    mapping(address => mapping (address => uint256)) public allowance; 
    mapping(address => bool) public frozenAccount;
    address public owner; 

    event Transfer (address indexed from, address indexed to, uint256 value); //emit is necessary
    event FrozenAccount(address target, bool frozen); // 

    modifier onlyOwner {
        require(msg.sender == owner);
        _;
    }

    constructor(uint256 _initialSupply ) public {
        owner = msg.sender; 
        mint(owner, _initialSupply);
    }

    function mint(address _recipient, uint256 _mintedAmount) public onlyOwner {
        coinBalance[_recipient] += _mintedAmount; 
        emit Transfer(owner, _recipient, _mintedAmount); //Logging function
    }

    function freezeAccount(address target, bool freeze) public onlyOwner {
        frozenAccount[target] = freeze; 
        emit FrozenAccount(target, freeze);
    }

    function authorize(address _authorizedAccount, uint256 _allowance) public returns (bool success) {
        allowance[msg.sender][_authorizedAccount] = _allowance; 
        return true; 
    }

    function transferFrom(address _from, address _to, uint256 _amount) public returns (bool success) {
        require(_to != 0x0); 
        require(coinBalance[_from] > _amount ); 
        require(coinBalance[_to] + amount); 
        require(_amount <= allowance[_from][msg.sender]);
        coinBalance[_from] -= _amount; 
        coinBalance[_to] += _amount; 
        allowance[_from][msg.sender] -= _amount; 
        emit Transfer(_from, _to, _amount); //three params
        return true; 
    }
}