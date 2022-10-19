// SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

// Open Zeppelin libraries for controlling upgradability and access.
import "@openzeppelin/contracts-upgradeable/proxy/utils/Initializable.sol";
import "@openzeppelin/contracts-upgradeable/proxy/utils/UUPSUpgradeable.sol";
import "@openzeppelin/contracts-upgradeable/access/OwnableUpgradeable.sol";
import "../component-CROP/ComponentRole.sol"; 

contract UUPSProxyRole is Initializable, UUPSUpgradeable, OwnableUpgradeable, ComponentRole {

    uint public borrowAmount; 
    uint public amountOfInvestment; 

    ///@dev no constructor in upgradable contracts. Instead we have initializers
    function initialize() public initializer {
        ///@dev as there is no constructor, we need to inititalze the OwnableUpgradeable explicitly
        __Ownable_init();
    }

    ///@dev required by the OZ UUPS module
    function _authorizeUpgrade(address) internal override onlyOwner {}

}
