// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "../contracts/component-CROP/ComponentRole.sol";
import "../contracts/component-CROP/RoleCreator.sol";
import "./FakeRole.sol";

contract FakeRoleCreator is RoleCreator {
    function createFor(bytes32 spec) external override returns (ComponentRole) {
        return new FakeRole();
    }
}

contract FakeRoleUpdatedCreator is RoleCreator {
    function createFor(bytes32 spec) external override returns (ComponentRole) {
        return new FakeRoleUpdated();
    }
}

contract FakeRoleCreatorSecond is RoleCreator {
    function createFor(bytes32 spec) external override returns (ComponentRole) {
        return new FakeRoleSecond();
    }
}
