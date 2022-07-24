// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "../component-CROP/ComponentRole.sol";
import "../component-CROP/RoleCreator.sol";


contract SampleSupplyChainRole is ComponentRole {
    function sampleFunction() public onlyWhenActive { }
}

contract Factory is ComponentRole { 
    string public factoryName ; 

    function setName(string memory _name) public {
        factoryName = _name;
    }

}

contract WholeSaler is ComponentRole {
    string public wholesalerName ;

    function setName(string memory _name) public {
        wholesalerName = _name;
    }   
}


contract SupplyChainNetwork {

}
