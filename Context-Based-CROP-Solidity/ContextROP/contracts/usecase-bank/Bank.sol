//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "../component-CROP/ComponentRole.sol";
import "../component-CROP/Team.sol";
import "./Borrower.sol";
import "./Investor.sol";
import "./BorrowerCreator.sol";
import "./InvestorCreator.sol";


contract Bank is Team {
    Borrower borrowerRole; 
    Investor investorRole; 

    bytes32 borrowerSpec = keccak256("BORROWER"); 
    bytes32 investorSpec = keccak256("INVESTOR"); 

    function getBorrowerRole() external returns(Borrower){
        require(address(borrowerRole) != address(0x0));

        this.addRoleCreator(borrowerSpec, new BorrowerCreator()); 
        borrowerRole = Borrower(this.addRole(borrowerSpec)); 
        return borrowerRole; 
    } 

    function getInvestorRole() external returns(Investor) {
        require(address(investorRole) != address(0x0)); 
        this.addRoleCreator(investorSpec, new InvestorCreator());
        investorRole = Investor(this.addRole(investorSpec));
        return investorRole;
    }
}