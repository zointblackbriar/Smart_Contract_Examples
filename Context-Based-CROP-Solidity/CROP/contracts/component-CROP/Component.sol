// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "../ERC165/ERC165.sol";

interface Component is ERC165 {
    // MARK: Role management

    /**
     * @dev Grants `role` to `component` and associates it to `spec`.
     */
    function addRole(bytes32 spec, address role) external;

    /**
     * @dev Revokes role with `spec` from `component`.
     *
     * If `component` has not been granted the role with `spec`, does nothing.
     */
    function removeRole(bytes32 spec) external;

    /**
     * @dev Returns `true` if `component` has been granted role with `spec`.
     */
    function isPlayingRole(bytes32 spec) external view returns (bool);

    /**
     * @dev Returns the role address that is associated to `spec`. 
     *
     * If `component` has not been granted the role with `spec`, returns 0x00 address.
     */
    function getRole(bytes32 spec) external returns (address);

    // MARK: Context management

    /**
     * @dev Sets a `team` to the `component` to indicate entering a context.
     *
     * If another `team` has already been set, it gets overriden.
     */
    function activateTeam(address team) external;

    /**
     * @dev Unsets the `team` if there is one activated.
     */
    function deactivateTeam() external;

    /**
     * @dev Returns the `address` of the activated `team`.
     */
    function getActiveTeam() external view returns (address);
}
