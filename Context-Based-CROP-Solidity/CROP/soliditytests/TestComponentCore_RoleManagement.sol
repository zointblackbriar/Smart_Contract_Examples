// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "./RoleEvaluator.sol";
import "./RoleCreatorMock.sol";
import "./TeamEvaluator.sol";

contract TestComponentCore_RoleManagement {

    ComponentCore internal component;
    Team internal team;

    bytes32 f1spec = keccak256("RoleMock1");
    bytes32 f2spec = keccak256("RoleMock2");

    function beforeEach() public {
        component = new ComponentCore();

        team = new TeamEvaluator();
        team.addRoleCreator(f1spec, new RoleCreatorMock());
        team.addRoleCreator(f2spec, new RoleCreatorUpdatedMockV2());
        team.addRole(f1spec);
        team.addRole(f2spec);

        component.activateTeam(address(team));
    }

    function testAddRoleDoesNotAddANewRoleIfItHasAZeroAddress() public {
        // Given 
        address role1 = team.getRole(f1spec);
        component.addRole(f1spec, role1);

        // When
        component.addRole(f1spec, address(0));

        // Then
        Assert.equal(component.getRole(f1spec), role1, "");
    }

    function testAddRoleOverwritesTheCurrentRoleForTheSameSpec() public {
        // Given 
        address role1 = team.getRole(f1spec);
        component.addRole(f1spec, role1);

        // When
        team.addRoleCreator(f1spec, new RoleCreatorMock());
        team.addRole(f1spec);
        address role1Updated = team.getRole(f1spec);
        component.addRole(f1spec, role1Updated);

        // Then
        Assert.equal(component.getRole(f1spec), role1Updated, "");
    }

    function testWeCanRetrieveTheRoleAfterItIsAdded() public {
        // Given 
        address role1 = team.getRole(f1spec);
        component.addRole(f1spec, role1);

        // When
        address receivedRole = component.getRole(f1spec);

        // Then
        Assert.equal(receivedRole, role1, "");
    }

    function testGetRoleReturnsEmptyAddressForAnUnknownRole() public {
        // When
        address receivedRole = component.getRole(f2spec);

        // Then
        Assert.isZero(receivedRole, "");
    }

    function testIsPlayingRoleReturnsTrueWhenRoleIsAdded() public {
        // Given 
        address role1 = team.getRole(f1spec);
        component.addRole(f1spec, role1);

        // When
        bool isPlayingRole1 = component.isPlayingRole(f1spec);

        // Then
        Assert.isTrue(isPlayingRole1, "");
    }

    function testIsPlayingRoleReturnsFalseWhenRoleIsNotAdded() public {
        // When
        bool isPlayingRole2 = component.isPlayingRole(f2spec);

        // Then
        Assert.isFalse(isPlayingRole2, "");
    }

    function testRemoveRoleRendersRoleUnusable() public {
        // Given 
        address role1 = team.getRole(f1spec);
        component.addRole(f1spec, role1);

        // When
        component.removeRole(f1spec);

        // Then
        try RoleEvaluator(role1).sampleFunction() {
            Assert.fail("");
        } catch Error(string memory /*reason*/) {
            // Failure expected.
        } 
    }

    function testIsPlayingRoleReturnsFalseAfterRemoveRole() public {
        // Given
        address role1 = team.getRole(f1spec);
        component.addRole(f1spec, role1);
        
        // When
        component.removeRole(f1spec);
        bool isPlayingRole1 = component.isPlayingRole(f1spec);

        // Then
        Assert.isFalse(isPlayingRole1, "");
    }
}
