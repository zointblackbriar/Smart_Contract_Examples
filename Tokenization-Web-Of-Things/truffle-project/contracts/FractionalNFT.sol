//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 


import "./openzeppelincontracts/token/ERC20/ERC20.sol";
import "./openzeppelincontracts/token/ERC721/IERC721.sol";
import "./openzeppelincontracts/access/Ownable.sol";
import "./openzeppelincontracts/token/ERC20/extensions/draft-ERC20Permit.sol";
import "./openzeppelincontracts/token/ERC721/utils/ERC721Holder.sol";


contract FractionalNFT is ERC20, Ownable, ERC20Permit, ERC721Holder{
    //State variables
    IERC721 public collection; 
    uint public tokenId; 
    bool public initialized = false; 
    bool public forSale = false; 
    uint public salesPrice; 
    bool public canRedeem = false; 

    //Permission for the ERC20 Token from ERC721 non-fungible token
    constructor() ERC20("WebOfThingsToken", "WTT") ERC20Permit("WebOfThingsToken") {

    }

    function initialize(address _collection, uint _tokenId, uint _amount) external onlyOwner {
        require(!initialized, "Already initialized"); 
        require(_amount > 0, "Amount needs to be more than 0"); 
        collection = IERC721(_collection); 
        //Token contract checks to see that the receiver is an IERC721Receiver
        collection.safeTransferFrom(msg.sender, address(this), _tokenId); 
        //Assign tokenId
        tokenId = _tokenId; 
        initialized = true; 
        _mint(msg.sender, _amount); 
    }
}