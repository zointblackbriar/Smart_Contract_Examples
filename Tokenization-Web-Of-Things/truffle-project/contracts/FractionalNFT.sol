//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 


import "./openzeppelincontracts/token/ERC20/ERC20.sol";
import "./openzeppelincontracts/token/ERC721/IERC721.sol";
import "./openzeppelincontracts/access/Ownable.sol";
import "./openzeppelincontracts/token/ERC20/extensions/draft-ERC20Permit.sol";
import "./openzeppelincontracts/token/ERC721/utils/ERC721Holder.sol";
import "./openzeppelincontracts/token/ERC721/ERC721.sol";


// contract FractionalNFT is ERC20, Ownable, ERC20Permit, ERC721Holder{
contract FractionalNFT {

    //State variables
    IERC721 public collection; 
    address payable public ownerAddress;
    uint public tokenId; 
    bool public initialized = false; 
    bool public forSale = false; 
    uint public salesPrice; 
    bool public canRedeem = false; 
    enum ClaimState {initiated, accepting, closed}  
    ClaimState public claimState;
    event Logging();

    //Permission for the ERC20 Token from ERC721 non-fungible token
    // constructor() ERC20("WebOfThingsToken", "WTT") ERC20Permit("WebOfThingsToken") {

    // }

    modifier isOwnerNFT(address _nftAddress, address _ownerAddress, uint256 _tokenID) {
        require(ERC721(_nftAddress).ownerOf(_tokenID) == _ownerAddress); 
        _;
    }

    modifier condition(bool _condition) {
        require(_condition); 
        _;
    }

    modifier onlyOwner() {
        require(msg.sender == ownerAddress); 
        _;
    }

    modifier inClaimState(ClaimState _sampleState) {
        require(claimState == _sampleState);
        _;
    }

    // function initialize(address _collection, uint _tokenId, uint _amount) external onlyOwner {
    //     require(!initialized, "Already initialized"); 
    //     require(_amount > 0, "Amount needs to be more than 0"); 
    //     collection = IERC721(_collection); 
    //     //Token contract checks to see that the receiver is an IERC721Receiver
    //     collection.safeTransferFrom(msg.sender, address(this), _tokenId); 
    //     //Assign tokenId
    //     tokenId = _tokenId; 
    //     initialized = true; 
    //     _mint(msg.sender, _amount); 
    // }

    // function forForAuthenticationSale(uint _price) external onlyOwner {
    //     salesPrice = _price; 
    //     forSale = true; 
    // }

    // function authenticationPurchase() external payable {
    //     require(forSale, "Not for sale"); 
    //     require(msg.value >= salesPrice, "Not enough ether sent"); 
    //     collection.transferFrom(address(this), msg.sender, tokenId); 
    //     forSale = false; 
    //     canRedeem = true; 
    // }

    // function redeem(uint _amount) external {
    //     require(canRedeem, "Redemtion not available"); 
    //     uint totalEther = address(this).balance; 
    //     uint toRedeem = _amount * totalEther / totalSupply(); 

    //     _burn(msg.sender, _amount); 
    //     payable(msg.sender).transfer(toRedeem); 
    // }



}