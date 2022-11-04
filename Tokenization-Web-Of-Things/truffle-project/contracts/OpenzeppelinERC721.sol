//SPDX-License-Identifier: MIT
pragma solidity >= 0.8.7; 

import "@openzeppelin/contracts/token/ERC721/ERC721Full.sol";
import "@openzeppelin/contracts/drafts/Counters.sol";

contract OpenZeppelinERC721 {
    // using Counters for Counters.Counter; 
    // Counters.Counter private _tokenIDs; 
    mapping(address)


    constructor() ERC721Full("SampleItem", "ITM") public {

    }

    // function assignItem(address player, string memory tokenURI) public returns(uint256) {
    //     _tokenIDs.increment(); 

    //     uint newItemID = _tokenIDs.current(); 
    //     _mint(player, newItemId); 
    //     _setTokenURI(newItemId, tokenURI); 

    // }
}