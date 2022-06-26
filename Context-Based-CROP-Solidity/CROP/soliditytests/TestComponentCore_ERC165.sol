// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "../contracts/component-CROP/InterfaceIds.sol";

contract TestComponentCore_ERC165 {

    ComponentCore internal component = new ComponentCore();

    function testSupportsErc165() public {
        Assert.isTrue(component.supportsInterface(0x01ffc9a7), "");
    }

    function testSupportsComponentInterface() public {
        Assert.isTrue(component.supportsInterface(InterfaceIds.COMPONENT_ID), "");
    }

    function testDoesNotSupportComponentRoleInterfaceId() public {
        Assert.isFalse(component.supportsInterface(InterfaceIds.COMPONENT_ROLE_ID), "");
    }

    function testDoesNotSupportTeamInterfaceId() public {
        Assert.isFalse(component.supportsInterface(InterfaceIds.TEAM_ID), "");
    }

    function testDoesNotSupportRandomInterfaceIds() public {
        Assert.isFalse(component.supportsInterface(0x01ffc9a8), "");
    }
}
