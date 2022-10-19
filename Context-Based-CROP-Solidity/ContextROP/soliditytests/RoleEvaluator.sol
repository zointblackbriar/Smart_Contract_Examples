// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "../contracts/component-CROP/ComponentRole.sol";

contract RoleEvaluator is ComponentRole {
    function sampleFunction() public onlyWhenActive { }
}

contract RoleUpdated is ComponentRole { }

contract RoleUpdatedV2 is ComponentRole { }
