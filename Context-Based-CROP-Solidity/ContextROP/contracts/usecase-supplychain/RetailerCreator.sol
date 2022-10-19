// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.7;

import "../component-CROP/RoleCreator.sol";
import "./Retailer.sol";

contract RetailerCreator is RoleCreator {

    function createFor(bytes32 spec) override public returns (ComponentRole) {
        return new Retailer();
    }
}
