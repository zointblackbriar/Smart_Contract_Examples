//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "../component-CROP/ComponentRole.sol"; 

contract Retailer is ComponentRole {
    uint internal itemsInInventoryRetailer; 

    function pushInventory(uint _item) public  onlyWhenActive {
        itemsInInventoryRetailer += _item; 
    }

    function popInventory(uint _item) public onlyWhenActive {
        require(_item < itemsInInventoryRetailer, "we need to check boundary for itemsInInventory");
        itemsInInventoryRetailer -= _item;
    } 

    function getInventoryStatus() public view onlyWhenActive returns(uint){
        return itemsInInventoryRetailer; 
    }
}