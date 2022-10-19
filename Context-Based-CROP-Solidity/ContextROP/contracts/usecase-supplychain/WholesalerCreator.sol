// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.7;

import "../component-CROP/RoleCreator.sol";
import "./Wholesaler.sol";

contract WholesalerCreator is RoleCreator {

    function createFor(bytes32 spec) override external returns (ComponentRole) {
        return new Wholesaler();
    }
}
