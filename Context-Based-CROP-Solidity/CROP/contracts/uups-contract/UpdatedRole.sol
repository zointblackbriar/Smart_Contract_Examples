//SPDX-License-Identifier: MIT 
pragma solidity >=0.7.0 <0.9.0;


import "@openzeppelin/contracts-upgradeable/proxy/utils/Initializable.sol";
import "@openzeppelin/contracts-upgradeable/proxy/utils/UUPSUpgradeable.sol";
import "@openzeppelin/contracts-upgradeable/access/OwnableUpgradeable.sol";

contract UpdatedRole is Initializable, UUPSUpgradeable, OwnableUpgradeable {

    uint public sampleVariable; 

    ///@dev required by the OZ UUPS module
    function _authorizeUpgrade(address) internal override onlyOwner {}

    function initializeRoleOwner(address roleAddress) public initializer {

    }

    //Sample function to get a message
    function getMessage() public pure returns(string memory) {
        return "Updated Role Version1";
    }

    function changeStateVariable() external {
        require(sampleVariable > 1, "be careful about the state variable"); 
        sampleVariable += 3; 
    }

}