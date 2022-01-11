// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

import "./ConvertLib.sol";

//Diese Code wird benutzt um dies zu testen.

contract MetaCoin {
    mapping(address => uint) balances; 

    event Transfer(address indexed _from, address indexed _to, uint256 _value);

    constructor() public {
        balances[tx.origin] = 10000;
    }

    //Münze test machen wir hier selber
    function sendCoin(address receiverAddress, uint amount) public returns (bool){
        if(balances[msg.sender] < amount ) return false; //wend die Address des Contracts unter der angegebenen Wert ist, müssen wir den False zurückgeben
        balances[msg.sender] -= amount;
        balances[receiverAddress] += amount; //anderer Vertrag
        emit Transfer(msg.sender, receiverAddress, amount);
        return true;
    }

    function getBalanceInEth(address addr) public view returns(uint) {
        return ConvertLib.convert(getBalance(addr), 2);
    }

    function getBalance(address addr) public view returns(uint) { //zurückkehrt einen Wert
        return balances[addr];
    }

}