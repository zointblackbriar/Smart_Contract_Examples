//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

contract SimpleCoin {
    mapping(address => uint256 ) public coinBalance; 
    mapping(address => mapping(address => uint)) public allowance; 
    mapping(address => bool) public frozenAccount;
    address public owner; 

    //Logging of the SimpleCoin
    event TransferLog(address indexed from, address indexed to, uint256 value); 
    event FrozenAccountLog(address target, bool frozen); 

    constructor(uint256 _initialSupply) 
    {   
        owner = msg.sender;
        coinBalance[msg.sender] = _initialSupply; 
    }

    modifier onlyOwner {
        require(msg.sender == owner, "msg.sender has a problem");
        _;
    }

    function mint(address _recipient, uint _mintedAmount)  public onlyOwner{
        coinBalance[_recipient] += _mintedAmount; 
        emit TransferLog(owner, _recipient, _mintedAmount); 
    }

    function freeze(address _freezedAccount, bool isFreezed) public onlyOwner {
        frozenAccount[_freezedAccount] = isFreezed; 
        emit FrozenAccountLog(_freezedAccount, isFreezed);
    }

    function authorize(address _authorizedAccount, uint _allowance) public returns(bool) {
        allowance[msg.sender][_authorizedAccount] = _allowance;
        return true;
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

    function transferFrom(address _from, address _to, uint _amount) public returns (bool) {
        require(_to != 0x0); 
        require(coinBalance[_from] > _amount);
        require(coinBalance[_to] + _amount > coinBalance[_to]); 
        require(_amount <= allowance[_from][msg.sender]);
        coinBalance[_from] -= _amount; 
        coinBalance[_to] += _amount; 
        allowance[_from][msg.sender] -= _amount;
        emit TransferLog(_from, _to, _amount); 
        return true;
    }
}