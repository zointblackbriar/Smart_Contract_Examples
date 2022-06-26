// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "./FakeRole.sol";
import "./FakeRoleCreator.sol";
import "./FakeTeam.sol";

contract TestComponentCore_RoleManagement {

    ComponentCore internal component;
    Team internal team;

    bytes32 f1spec = keccak256("FAKEROLE1");
    bytes32 f2spec = keccak256("FAKEROLE2");

    function beforeEach() public {
        component = new ComponentCore();

        team = new FakeTeam();
        team.addRoleCreator(f1spec, new FakeRoleCreator());
        team.addRoleCreator(f2spec, new FakeRoleCreatorSecond());
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
        team.addRoleCreator(f1spec, new FakeRoleUpdatedCreator());
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
        try FakeRole(role1).sampleFunction() {
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
