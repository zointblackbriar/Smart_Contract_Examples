// SPDX-License-Identifier: MIT
pragma solidity >=0.8.7;

import "./openzeppelincontracts/token/ERC721/ERC721.sol"; 
import "./openzeppelincontracts/access/Ownable.sol"; 


contract AuthenticationNFT is ERC721, Ownable {
    constructor() ERC721("AuthenticationNFT", "ANFT") {

    }

    function safeMint(address to, uint tokenId) public onlyOwner {
        _safeMint(to, tokenId);
    }
}

