// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "../contracts/component-CROP/InterfaceIds.sol";
import "./RoleEvaluator.sol";

contract TestComponentRole_ERC165 {

    RoleEvaluator internal role;

    function beforeEach() public {
        role = new RoleEvaluator();
    }

    function testSupportsErc165() public {
        Assert.isTrue(role.supportsInterface(0x01ffc9a7), "");
    }

    function testSupportsComponentRoleInterface() public {
        Assert.isTrue(role.supportsInterface(InterfaceIds.COMPONENT_ROLE_ID), "");
    }

    function testDoesNotSupportComponentInterfaceId() public {
        Assert.isFalse(role.supportsInterface(InterfaceIds.COMPONENT_ID), "");
    }

    function testDoesNotSupportTeamInterfaceId() public {
        Assert.isFalse(role.supportsInterface(InterfaceIds.TEAM_ID), "");
    }

    function testDoesNotSupportRandomInterfaceIds() public {
        Assert.isFalse(role.supportsInterface(0x01ffc9a8), "");
    }
}
