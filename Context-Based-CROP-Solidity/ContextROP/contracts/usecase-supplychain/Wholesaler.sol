// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.7;

import "../component-CROP/ComponentRole.sol"; 

contract Wholesaler is ComponentRole {
    uint internal itemsInInventoryWholeSaler; 

    function pushInventory(uint _item) public  onlyWhenActive {
        itemsInInventoryWholeSaler += _item; 
    }

    function popInventory(uint _item) public onlyWhenActive {
        require(_item < itemsInInventoryWholeSaler, "we need to check boundary for itemsInInventory");
        itemsInInventoryWholeSaler -= _item;
    } 

}