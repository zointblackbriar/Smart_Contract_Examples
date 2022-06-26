// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "../contracts/component-CROP/InterfaceIds.sol";
import "./FakeRole.sol";
import "./FakeTeam.sol";

contract TestComponentRole_TypeChecking {

    FakeRole internal role;

    function beforeEach() public {
        role = new FakeRole();
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
        FakeRoleSecond role2 = new FakeRoleSecond();

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
        FakeTeam team = new FakeTeam();

        // Then
        try role.setTeam(address(team)) {
            // Should succeed
        } catch Error(string memory /*reason*/) {
            Assert.fail("");
        } 
    }

    function testSetTeamDoesNotAcceptRoleAddress() public {
        // Given
        FakeRoleSecond role2 = new FakeRoleSecond();

        // Then
        try role.setTeam(address(role2)) {
            Assert.fail("");
        } catch Error(string memory /*reason*/) {
            // Failure expected
        } 
    }
}
