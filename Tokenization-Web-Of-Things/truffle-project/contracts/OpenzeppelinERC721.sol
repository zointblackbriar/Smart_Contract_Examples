//SPDX-License-Identifier: MIT
pragma solidity >= 0.8.7; 

// import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
// import "@openzeppelin/contracts/utils/Counters.sol";
// import "@openzeppelin/contracts/access/Ownable.sol"; 
import "./openzeppelincontracts/token/ERC721/ERC721.sol";
import "./openzeppelincontracts/utils/Counters.sol";
import "./openzeppelincontracts/access/Ownable.sol"; 


contract OpenZeppelinERC721 is ERC721, Ownable{
    // using Counters for Counters.Counter; 
    // Counters.Counter private _tokenIDs; 
    // mapping(address)
    using Counters for Counters.Counter; 
    event Logging(string description, uint value);

    Counters.Counter private _tokenIdCounter;

    constructor() ERC721("SampleItem", "ITM") public {
    }

    function safeMint(address _toAddress) public onlyOwner{
        uint tokenId = _tokenIdCounter.current();
        emit Logging("token id is: ", tokenId);
        _tokenIdCounter.increment(); 
        _safeMint(_toAddress, tokenId);
    }

}