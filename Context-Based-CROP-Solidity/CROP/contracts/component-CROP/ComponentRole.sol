// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./Component.sol";
import "./ComponentCore.sol";
import "./Team.sol";
import "./InterfaceIds.sol";
import "../ERC165/ERC165Query.sol";

abstract contract ComponentRole is Component, ERC165Query {

    ComponentCore internal core;

    Team internal assignedTeam;

    // MARK: ERC165

    /// @notice Query if a contract implements an interface
    /// @param interfaceID The interface identifier, as specified in ERC-165
    /// @dev Interface identification is specified in ERC-165. This function
    ///  uses less than 30,000 gas.
    /// @return `true` if the contract implements `interfaceID` and
    ///  `interfaceID` is not 0xffffffff, `false` otherwise
    function supportsInterface(bytes4 interfaceID) external override pure returns (bool) {
        return interfaceID == 0x01ffc9a7                      // ERC165
            || interfaceID == InterfaceIds.COMPONENT_ROLE_ID; // ComponentRole
    }
    
    // MARK: ComponentRole specific

    /**
     * @dev Sets the `componentCore` to `role`.
     */
    function setCore(address coreAddress) external {
        if (coreAddress != address(0)) {
            bool isComponent = doesContractImplementInterface(coreAddress, InterfaceIds.COMPONENT_ID);
            require(isComponent, "Doesn't support Component interface.");
        }
        core = ComponentCore(coreAddress);
    }

    /**
     * @dev Sets the `team` to `role`.
     */
    function setTeam(address teamAddress) external {
        if (teamAddress != address(0)) {
            bool isTeam = doesContractImplementInterface(teamAddress, InterfaceIds.TEAM_ID);
            require(isTeam, "Doesn't support Team interface.");
        }
        assignedTeam = Team(teamAddress);
    }

    /**
     * @dev Modifier that checks that `componentCore` has been set and
     *  the core's `team` matches this role's `team`. 
     *
     * Reverts with a descriptive message if the core has not been set.
     *
     * To be used for all role functions that require the core.
     */
    modifier onlyWhenActive {
        require(
            address(core) != address(0), 
            "This function requires the core to be set.");
        require(
            core.getActiveTeam() == address(assignedTeam), 
            "The context for this role is not currently active.");
        _;
    }

    // MARK: Operations forwarded to the ComponentCore object. 

    /**
     * @dev Grants `role` to `component` and associates it to `spec`.
     */
    function addRole(bytes32 spec, address role) external override {
        core.addRole(spec, role);
    }

    /**
     * @dev Revokes role with `spec` from `component`.
     *
     * If `component` has not been granted the role with `spec`, does nothing.
     */
    function removeRole(bytes32 spec) external override {
        core.removeRole(spec);
    }   

    /**
     * @dev Returns `true` if `component` has been granted role with `spec`.
     */
    function isPlayingRole(bytes32 spec) external override view returns (bool) {
        return core.isPlayingRole(spec);
    }

    /**
     * @dev Returns the role address that is associated to `spec`. 
     *
     * If `component` has not been granted the role with `spec`, returns 0x00 address.
     */
    function getRole(bytes32 spec) external override returns (address) {
        return core.getRole(spec);
    } 

    /**
     * @dev Sets a `team` to the `component` to indicate entering a context.
     *
     * If another `team` has already been set, it gets overriden.
     */
    function activateTeam(address team) external override {
        core.activateTeam(team);
    }

    /**
     * @dev Unsets the `team` if there is one activated.
     */
    function deactivateTeam() external override {
        core.deactivateTeam();
    }

    /**
     * @dev Returns the `address` of the activated `team`.
     */
    function getActiveTeam() external view override returns (address) {
        return core.getActiveTeam();
    }
}
