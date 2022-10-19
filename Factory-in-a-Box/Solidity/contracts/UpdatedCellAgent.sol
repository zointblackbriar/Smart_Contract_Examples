//SPDX-License-Identifier: MIT 
pragma solidity >=0.8.7;


import "@openzeppelin/contracts-upgradeable/proxy/utils/Initializable.sol";
import "@openzeppelin/contracts-upgradeable/proxy/utils/UUPSUpgradeable.sol";
import "@openzeppelin/contracts-upgradeable/access/OwnableUpgradeable.sol";


// initialize() : Upgradable contracts should have an initialize method in place of constructors, and also the initializer keyword makes sure that the contract is initialized only once
// _authorizeUpgrade() : This method is required to safeguard from unauthorized upgrades because in the UUPS pattern the upgrade is done from the implementation contract, 
// whereas in the transparent proxy pattern, the upgrade is done via the proxy contract
// changeStateVariable() : A simple function to reduce the storage variable whenever called

contract UpdatedCellAgent is Initializable, UUPSUpgradeable, OwnableUpgradeable {

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