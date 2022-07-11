//SPDX-License-Identifier: MIT 
pragma solidity >=0.8.7; 

import "@openzeppelin/contracts/access/Ownable.sol";
import "@openzeppelin/contracts/token/ERC721/ERC721.sol";

contract NFTContract is Ownable, ERC721("HelloNFT", "HNFT"){
    uint tokenID;
    mapping(address=>tokenMetaData[]) public ownershipRecord; 

    struct tokenMetaData {
        uint tokenId; 
        uint timeStamp; 
        string tokenURI;
    }

    function mintToken(address recipient) onlyOwner public {
        
    }

}