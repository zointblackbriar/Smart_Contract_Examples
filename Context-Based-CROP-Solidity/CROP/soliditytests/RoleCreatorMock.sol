// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "../contracts/component-CROP/ComponentRole.sol";
import "../contracts/component-CROP/RoleCreator.sol";
import "./RoleEvaluator.sol";

contract RoleCreatorMock is RoleCreator {
    function createFor(bytes32 spec) external override returns (ComponentRole) {
        return new RoleEvaluator();
    }
}

contract RoleCreatorUpdatedMock is RoleCreator {
    function createFor(bytes32 spec) external override returns (ComponentRole) {
        return new RoleUpdated();
    }
}

contract RoleCreatorUpdatedMockV2 is RoleCreator {
    function createFor(bytes32 spec) external override returns (ComponentRole) {
        return new RoleUpdatedV2();
    }
}
