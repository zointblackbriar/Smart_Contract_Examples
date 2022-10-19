// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.7; 

import "./Component.sol";
import "./ComponentRole.sol";
import "./Team.sol";

library InterfaceIds {

    bytes4 constant COMPONENT_ID = type(Component).interfaceId;
    bytes4 constant COMPONENT_ROLE_ID = type(ComponentRole).interfaceId;
    bytes4 constant TEAM_ID = type(Team).interfaceId;

}