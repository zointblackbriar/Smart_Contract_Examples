// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "../contracts/component-CROP/InterfaceIds.sol";
import "./RoleEvaluator.sol";
import "./TeamEvaluator.sol";

contract TestComponentRole_TypeSafety {

    RoleEvaluator internal role;

    function beforeEach() public {
        role = new RoleEvaluator();
    }

    function testSetCoreAcceptsZeroAddress() public {
        try role.setCore(address(0)) {
            // Should succeed
        } catch Error(string memory /*reason*/) {
            Assert.fail("");
        } 
    }

    function testSetCoreAcceptsCoreAddress() public {
        // Given
        ComponentCore core = new ComponentCore();

        // Then
        try role.setCore(address(core)) {
            // Should succeed
        } catch Error(string memory /*reason*/) {
            Assert.fail("");
        } 
    }

    function testSetCoreDoesNotAcceptRoleAddress() public {
        // Given
        RoleUpdatedV2 role2 = new RoleUpdatedV2();

        // Then
        try role.setCore(address(role2)) {
            Assert.fail("");
        } catch Error(string memory /*reason*/) {
            // Failure expected
        } 
    }

    function testSetTeamAcceptsZeroAddress() public {
        try role.setTeam(address(0)) {
            // Should succeed
        } catch Error(string memory /*reason*/) {
            Assert.fail("");
        } 
    }

    function testSetTeamAcceptsTeamAddress() public {
        // Given
        TeamEvaluator team = new TeamEvaluator();

        // Then
        try role.setTeam(address(team)) {
            // Should succeed
        } catch Error(string memory /*reason*/) {
            Assert.fail("");
        } 
    }

    function testSetTeamDoesNotAcceptRoleAddress() public {
        // Given
        RoleUpdatedV2 role2 = new RoleUpdatedV2();

        // Then
        try role.setTeam(address(role2)) {
            Assert.fail("");
        } catch Error(string memory /*reason*/) {
            // Failure expected
        } 
    }
}
