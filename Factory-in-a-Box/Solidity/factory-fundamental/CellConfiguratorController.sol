//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "./FactoryBoxRoles.sol";


contract CellConfiguratorController is FactoryBoxRoles {

    constructor() public {

    }
    function getType() public pure override returns(Constants.ClassType) {
        return Constants.ClassType.CellConfiguratorController;
    }

}