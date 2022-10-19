// SPDX-License-Identifier: MIT
pragma solidity ^0.8.10;

import "./FirstContract.sol";

contract UpdatedContract is FirstContract {
    ///@dev increments the slices when called
    function refillSlice() external {
        storageValue += 1;
    }

    ///@dev returns the contract version
    function contractVersion() external pure returns (uint256) {
        return 2;
    }
}
