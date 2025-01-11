//SPDX-License-Identifier

pragma solidity >=0.8.7; 
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721Royalty.sol";


contract NFTContract is ERC721Royalty {
    constructor(address _receiver, uint96 _feeNumerator) ERC721("Royalties", "RYLT") {
        _setDefaultRoyalty(_receiver, _feeNumerator);
    }

    function safeMint(address toAddress, uint256 tokenID, address receiver, uint96 feeNumerator) public {
        _safeMint(toAddress, tokenID);
        _setTokenRoyalty(tokenID, receiver, feeNumerator);
    }
}