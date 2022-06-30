// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./Component.sol";
import "./ComponentRole.sol";
import "./InterfaceIds.sol";
import "./ERC165Query.sol";

contract ComponentCore is Component, ERC165Query {

    mapping(bytes32 => ComponentRole) internal playedRoles;

    Team internal activeTeam;

    // MARK: ERC165

    /// @notice Query if a contract implements an interface
    /// @param interfaceID The interface identifier, as specified in ERC-165
    /// @dev Interface identification is specified in ERC-165. This function
    ///  uses less than 30,000 gas.
    /// @return `true` if the contract implements `interfaceID` and
    ///  `interfaceID` is not 0xffffffff, `false` otherwise
    function supportsInterface(bytes4 interfaceID) external override pure returns (bool) {
        return interfaceID == 0x01ffc9a7                 // ERC165
            || interfaceID == InterfaceIds.COMPONENT_ID; // Component
    }

    // MARK: Role management

    /**
     * @dev Grants `role` to `component` and associates it to `spec`.
     */
    function addRole(bytes32 spec, address role) external override{
        if (role == address(0)) return;

        bool isComponentRole = doesContractImplementInterface(role, InterfaceIds.COMPONENT_ROLE_ID);
        require(isComponentRole, "Doesn't support ComponentRole interface.");

        ComponentRole componentRole = ComponentRole(role);
        playedRoles[spec] = componentRole;
        componentRole.setCore(address(this));
    }

    /**
     * @dev Revokes role with `spec` from `component`.
     *
     * If `component` has not been granted the role with `spec`, does nothing.
     */
    function removeRole(bytes32 spec) external override {
        if (!this.isPlayingRole(spec)) return; 
        ComponentRole componentRole = ComponentRole(playedRoles[spec]);
        componentRole.setCore(address(0));
        delete(playedRoles[spec]);
    }

    /**
     * @dev Returns `true` if `component` has been granted role with `spec`.
     */
    function isPlayingRole(bytes32 spec) external override view returns (bool) {
        return address(playedRoles[spec]) != address(0);
    }

    /**
     * @dev Returns the role address that is associated to `spec`. 
     *
     * If `component` has not been granted the role with `spec`, returns 0x00 address.
     */
    function getRole(bytes32 spec) external override returns (address) {
        ComponentRole role = playedRoles[spec];
        if (this.isPlayingRole(spec)) {
           role.setCore(address(this));
        }
        return address(role);
    }

    // MARK: Context management

    /**
     * @dev Sets a `team` to the `component` to indicate entering a context.
     *
     * If another `team` has already been set, it gets overriden.
     */
    function activateTeam(address team) external override {
        bool isTeam = doesContractImplementInterface(team, InterfaceIds.TEAM_ID);
        require(isTeam, "Doesn't support Team interface.");
        activeTeam = Team(team);
    }

    /**
     * @dev Unsets the `team` if there is one activated.
     */
    function deactivateTeam() external override {
        delete(activeTeam);
    }

    /**
     * @dev Returns the `address` of the activated `team`.
     */
    function getActiveTeam() external view override returns (address) {
        return address(activeTeam);
    }
}
