//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "./FactoryBoxRoles.sol";


contract CellConfigurator is FactoryBoxRoles {
    //Each participant should have unique Id in the network. 
    string public companyName; 
    string  public companyId; 
    bool public isProductionEnviornmentLeased; 
    string public serviceProviderID; //public key of service provider ID
    string public machineID; //public key of machine asset
    address owner; 
    mapping(address => uint) balance; 

    modifier onlyOwner() {
        require(msg.sender == owner); 
        _;
    }

    constructor(uint sampleAsset) {
        owner = msg.sender;
        balance[msg.sender] = sampleAsset;
    }

    function getCompanyName() public view returns(string memory) {
        return companyName; 
    } 

    function getCompanyId() public view returns(string memory) {
        return companyId; 
    }

    function setCompanyName(string memory _companyName) onlyOwner public {
        companyName = _companyName; 
    }

    function setCompanyId(string memory _companyId) onlyOwner public {
        companyId = _companyId;
    }

    function getType() public pure override returns(Constants.ClassType) {
        return Constants.ClassType.CellConfigurator;
    }

}