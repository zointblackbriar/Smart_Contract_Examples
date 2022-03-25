// SPDX-Licence-Identifier : MIT
pragma solidity ^0.8.4; 

contract ReleasableSimpleCoin {
    mapping (address => uint256 ) public balancedAccount; 

    event Transfer(address indexed from, address indexed to, uint256 value);

    constructor() {
        //harcoded address
        balancedAccount[0x14723A09ACff6D2A60DcdF7aA4AFf308FDDC160C] = 10000; 
    }

    function transfer(address _to, uint256 _amount) public {
        require(balancedAccount[msg.sender] > _amount);
        require(balancedAccount[_to] + _amount >= balancedAccount[_to]);
        balancedAccount[msg.sender] -= _amount;
        balancedAccount[_to] += _amount;
        emit Transfer(msg.sender, _to, _amount);
    }
}