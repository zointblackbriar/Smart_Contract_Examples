//"SPDX-License-Identifier: MIT"
pragma solidity ^0.8.4; 

contract SimpleCrowdSale {
    mapping (address => uint256) public coinBalanceMapping; 
    mapping (address => mapping(address => uint256)) public allowanceMapping;
    mapping (address => bool) public frozenAccountMapping;
    address owner; 


    //we will define two different events
    event Transfer(address fromAnAddress, address toAnAddress, uint256 amountUInt256);
    event FrozenAccount(address targetAddress, bool frozenFlagBoolean);


    modifier onlyOwner() {
        if(msg.sender != owner) revert(); 
        _;
    }

    constructor(uint256 _initialValue ) {
        owner = msg.sender; //the contract address has been assigned
        mintingTokens(owner, _initialValue);
    } 

    function transferSomeValues(address _toAnAddress, uint256 _amountUint256) public {
        require(coinBalanceMapping[owner] > _amountUint256); 
        require(coinBalanceMapping[_toAnAddress] + _amountUint256 >= coinBalanceMapping[_toAnAddress]);
        coinBalanceMapping[owner] -= _amountUint256; //decrease the amount from the current contract
        coinBalanceMapping[_toAnAddress] += _amountUint256; //increate the amount for the transferred contract
        emit Transfer(owner, _toAnAddress, _amountUint256);
    }

    function authorizeContractTransfer(address _authorizedAccount, uint256 _allowanceValue) public returns (bool success) {  
        allowanceMapping[msg.sender][_authorizedAccount] = _allowanceValue;
        return true; 
    }

    function transferFromAnAddress() public {

    }

    function mintingTokens(address _recipientAddress, uint256 _mintedAmountUint256) onlyOwner public{
        coinBalanceMapping[_recipientAddress] += _mintedAmountUint256; //Add this ammount to the contract
        emit Transfer(owner, _recipientAddress, _mintedAmountUint256); //Write it into the contract logs.
    }

    function freezeAccount(address _targetAddress, bool _freezeFlag) onlyOwner public {
        frozenAccountMapping[_targetAddress] = _freezeFlag; 
        emit FrozenAccount(_targetAddress, _freezeFlag);
    }
}