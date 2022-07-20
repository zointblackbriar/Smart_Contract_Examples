//SPDX-License-Identifier: MIT 
pragma solidity >=0.7.0 <0.9.0;

import "./UpdatedRole.sol";

contract UpdatedRoleV2 is UpdatedRole {
    function refillStateVariable() external {
        sampleVariable -= 1;
    }
}