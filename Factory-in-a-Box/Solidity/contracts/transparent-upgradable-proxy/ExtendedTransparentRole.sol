//SPDX-License-Identifier: MIT 
pragma solidity >=0.8.7;


import "./TransparentUpgradeableProxy.sol";

//@dev this is only in the development stage. Further improvements necessary
contract ExtendedTransparentRole {

    uint public sampleVariable; 

    ///@dev required by the the Transparent Proxy Pattern
    // function _admin() internal view override returns (address) {}

    //Sample function to get a message
    function getMessage() public pure returns(string memory) {
        return "Updated Role Version1";
    }

    function changeStateVariable() external {
        require(sampleVariable > 1, "be careful about the state variable"); 
        sampleVariable += 3; 
    }

}