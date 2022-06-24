// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;


contract BoxedFactory {
    string private companyName; 
    string private companyId; 
    bool private isProductionEnvLeased; 
    address owner; 
    mapping(address => uint) balance; 

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

    function setCompanyName(string memory _companyName) public {
        companyName = _companyName; 
    }

    function setCompanyId(string memory _companyId) public {
        companyId = _companyId;
    }
}