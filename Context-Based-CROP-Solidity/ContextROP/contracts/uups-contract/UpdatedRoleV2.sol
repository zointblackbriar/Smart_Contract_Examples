// SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "./ExtendedRole.sol";

contract UpdatedRoleV2 is ExtendedRole {
    ///@dev increments the slices when called
    function refillSlice() external {
        storageValue += 1;
    }

    ///@dev returns the contract version
    function contractVersion() external pure returns (uint256) {
        return 2;
    }
}
