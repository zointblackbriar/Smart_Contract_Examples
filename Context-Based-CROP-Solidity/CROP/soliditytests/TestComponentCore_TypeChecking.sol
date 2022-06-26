// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "./FakeRole.sol";
import "./FakeRoleCreator.sol";
import "./FakeTeam.sol";

contract TestComponentCore_TypeChecking {

    ComponentCore internal component;
    Team internal team;

    bytes32 f1spec = keccak256("FAKEROLE1");

    function beforeEach() public {
        component = new ComponentCore();

        team = new FakeTeam();
        team.addRoleCreator(f1spec, new FakeRoleCreator());
        team.addRole(f1spec);
    }

    function testActivatingNonTeamContractFails() public {
        // Given
        address randomRoleContract = team.getRole(f1spec);

        // Then
        try component.activateTeam(randomRoleContract) {
            Assert.fail("");
        } catch Error(string memory /*reason*/) {
            // Failure expected.
        } 
    }

    function testActivatingTeamContractSucceeds() public {
        try component.activateTeam(address(team)) {
            // Should succeed.
        } catch Error(string memory /*reason*/) {
            Assert.fail("");
        } 
    }

    function testAddingComponentAsRoleFails() public {
        // Given
        Component core2 = new ComponentCore();

        // Then
        try component.addRole(f1spec, address(core2)) {
            Assert.fail("");
        } catch Error(string memory /*reason*/) {
            // Failure expected.
        } 
    }
}
