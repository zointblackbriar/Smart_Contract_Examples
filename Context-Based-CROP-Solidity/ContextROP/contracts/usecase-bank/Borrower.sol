//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "../component-CROP/ComponentRole.sol"; 

contract Borrower is ComponentRole {
    uint internal borrowAmount; 

    function borrow(uint _amount) public onlyWhenActive {
        borrowAmount += _amount; 
    }

    function repay(uint _amount) public onlyWhenActive {
        require (_amount > borrowAmount);
        borrowAmount -= _amount; 
    }

    function getBalance() public view onlyWhenActive returns(uint){
        return borrowAmount; 
    }
}