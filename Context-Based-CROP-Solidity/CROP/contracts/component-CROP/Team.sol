// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./ComponentRole.sol";
import "./RoleCreator.sol";
import "./InterfaceIds.sol";
import "../ERC165/ERC165.sol";
import "../ERC165/ERC165Query.sol";

abstract contract Team is ERC165, ERC165Query {

    mapping(bytes32 => ComponentRole) internal roles;

    mapping(bytes32 => RoleCreator) internal roleCreators;

    // MARK: ERC165

    /// @notice Query if a contract implements an interface
    /// @param interfaceID The interface identifier, as specified in ERC-165
    /// @dev Interface identification is specified in ERC-165. This function
    ///  uses less than 30,000 gas.
    /// @return `true` if the contract implements `interfaceID` and
    ///  `interfaceID` is not 0xffffffff, `false` otherwise
    function supportsInterface(bytes4 interfaceID) external override pure returns (bool) {
        return interfaceID == 0x01ffc9a7            // ERC165
            || interfaceID == InterfaceIds.TEAM_ID; // Team
    }

    // MARK: Team

    /**
     * @dev Adds a role that should be created from `spec`.
     * 
     * Returns the `address` of the newly created role instance.
     */
    function addRole(bytes32 spec) external returns (address) {
        RoleCreator rc = roleCreators[spec];
        ComponentRole role = rc.createFor(spec);
        bool isComponentRole = doesContractImplementInterface(address(role), InterfaceIds.COMPONENT_ROLE_ID);
        require(isComponentRole, "Doesn't support ComponentRole interface.");

        if (role != ComponentRole(address(0))) {
            roles[spec] = role;
            role.setTeam(address(this));
        }
        return address(role);
    }

    /**
     * @dev Removes role with `spec` from `team`.
     *
     * If `team` does not have the role with `spec`, does nothing.
     */
    function removeRole(bytes32 spec) external {
        if (!this.hasRole(spec)) return; 
        ComponentRole componentRole = roles[spec];
        componentRole.setCore(address(0));
        componentRole.setTeam(address(0));
        delete(roles[spec]);
    }

    /**
     * @dev Returns `true` if `team` has role with `spec`.
     */
    function hasRole(bytes32 spec) external view returns (bool) {
        return this.getRole(spec) != address(0);
    }

    /**
     * @dev Returns the role address that is associated to `spec`. 
     *
     * If `team` hdoes not have the role with `spec`, returns 0x00 address.
     */
    function getRole(bytes32 spec) external view returns (address) {
        return address(roles[spec]);
    }

    /**
     * @dev Add a concrete `roleCreator` which is associated to a `spec`. 
     */
    function addRoleCreator(bytes32 spec, RoleCreator roleCreator) external {
        roleCreators[spec] = roleCreator;
    }
}
