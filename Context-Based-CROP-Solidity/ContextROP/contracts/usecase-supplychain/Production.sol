//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "../component-CROP/ComponentRole.sol";
import "../component-CROP/Team.sol";
import "./Retailer.sol";
import "./Wholesaler.sol";
import "./RetailerCreator.sol";
import "./WholesalerCreator.sol";


contract Production is Team {
    Retailer retailerRole; 
    Wholesaler wholesalerRole; 

    bytes32 retailerSpec = keccak256("RETAILER"); 
    bytes32 wholesalerSpec = keccak256("WHOLESALER"); 

    function getRetailerRole() external returns(Retailer){
        require(address(retailerRole) != address(0x0));

        this.addRoleCreator(retailerSpec, new RetailerCreator()); 
        retailerRole = Retailer(this.addRole(retailerSpec)); 
        return retailerRole; 
    } 

    function getWholesalerRole() external returns(Wholesaler) {
        require(address(wholesalerRole) != address(0x0)); 
        this.addRoleCreator(wholesalerSpec, new WholesalerCreator());
        wholesalerRole = Wholesaler(this.addRole(wholesalerSpec));
        return wholesalerRole;
    }
}