//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 


contract CellConfigurator {
    string public companyName; 
    string  public companyId; 
    bool public isProductionEnvLeased; 
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
}