// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "../contracts/component-CROP/ComponentRole.sol";

contract FakeRole is ComponentRole {
    function sampleFunction() public onlyWhenActive { }
}

contract FakeRoleUpdated is ComponentRole { }

contract FakeRoleSecond is ComponentRole { }
