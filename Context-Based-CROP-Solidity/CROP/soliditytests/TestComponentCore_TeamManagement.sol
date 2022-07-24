// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";
import "../contracts/component-CROP/ComponentCore.sol";
import "../contracts/component-CROP/InterfaceIds.sol";
import "./TeamEvaluator.sol";

contract TestComponentCore_TeamManagement {

    ComponentCore internal component;
    Team internal team;

    function beforeEach() public {
        component = new ComponentCore();
        team = new TeamEvaluator();
    }

    function testRetrieveTeamAfterActivating() public {
        // Given 
        component.activateTeam(address(team));

        // When
        address currentTeam = component.getActiveTeam();

        // Then
        Assert.equal(currentTeam, address(team), "");
    }

    function testRetrieveTeamAfterDeactivating() public {
        // Given 
        component.activateTeam(address(team));
        component.deactivateTeam();

        // When
        address currentTeam = component.getActiveTeam();

        // Then
        Assert.isZero(currentTeam, "");
    }
}
