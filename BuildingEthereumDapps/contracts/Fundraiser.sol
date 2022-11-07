//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "@openzeppelin/contracts/access/Ownable.sol"; 
import "@openzeppelin/contracts/utils/math/SafeMath.sol";

contract Fundraiser is Ownable {

    using SafeMath for uint256; 

    struct Donation {
        uint256 value; 
        uint256 date; 
    }

    mapping(address => Donation[]) private _donations; 

    event DonationConfirmed(address indexed donor, uint256 value); 
    event WithdrawDonation(string description, uint256 amount); 

    string public name; 
    string public url; 
    string public imageURL; 
    string public description; 

    address payable public beneficiary; 
    address public ownerAccount; 

    uint256 public publicDonations; //Es zeigt die Anzahl der Spenden 
    uint256 public donationCount; 

    constructor(string memory _name, string memory _url, string memory _imageURL, string memory _description, address payable _beneficiary, address _custodian) {
        name = _name; 
        url = _url; 
        imageURL = _imageURL; 
        description = _description; 
        beneficiary = _beneficiary; 
        ownerAccount = _custodian;
    }

    function setBeneficiary(address payable _beneficiary) public onlyOwner {
        beneficiary = _beneficiary;

    }

    function getDonationCounts() public view returns(uint256) {
        return _donations[msg.sender].length; 
    }

    function donate() public payable {
        Donation memory donation = Donation( {
            value: msg.value,
            date: block.timestamp 
        }); 
        _donations[msg.sender].push(donation); 
        publicDonations = publicDonations.add(msg.value); 
        donationCount++; 

        emit DonationConfirmed(msg.sender, msg.value);
    }

    function occurredDonations() public view returns(uint256[] memory values, uint256[] memory dates) {
        // uint256[] memory values; 
        // uint256[] memory dates; 

        uint256 count = getDonationCounts(); 
        values = new uint256[](count); 
        dates = new uint256[](count); 

        for(uint256 i = 0; i < count; i++) {
            Donation storage donation = _donations[msg.sender][i]; 
            values[i] = donation.value; 
            dates[i] = donation.date; 
        }

        return (values, dates);
    }

    function withdrawDonation() public onlyOwner {
        uint256 balance  = address(this).balance; 
        beneficiary.transfer(balance); 
        emit WithdrawDonation("Diese Betrag wurde abgehoben", balance); 
    }

    fallback() external payable {
        publicDonations = publicDonations.add(msg.value); 
        donationCount++;
    }

    receive() external payable {
        
    }
}