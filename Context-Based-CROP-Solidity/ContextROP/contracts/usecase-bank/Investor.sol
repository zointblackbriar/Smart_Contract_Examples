// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.7;

import "../component-CROP/ComponentRole.sol"; 

contract Investor is ComponentRole {
    uint internal amountOfInvestment; 

    function invest(uint _amount) public  onlyWhenActive {
        amountOfInvestment += _amount; 
    }

    function withdraw(uint _amount) public onlyWhenActive {
        if(_amount > amountOfInvestment) {
            amountOfInvestment = 0; 
        } else {
            amountOfInvestment -= _amount;
        }

    } 


}