// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.7; 

import "./ComponentRole.sol";

interface RoleCreator {
    /**
     * @dev Creates a concrete instance of a `ComponentRole` from a `spec`.
     */
    function createFor(bytes32 spec) external returns (ComponentRole);
}
