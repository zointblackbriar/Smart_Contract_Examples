//SPDX-License-Identifier: MIT
pragma solidity >=0.8.0;
import "@openzeppelin/contracts/token/ERC20/IERC20.sol";
import "@openzeppelin/contracts/utils/introspection/ERC165Checker.sol";
import "@openzeppelin/contracts/utils/introspection/ERC165.sol";

interface SampleInterface{
    function getValue() external view returns(uint);    
}

abstract contract InterfaceSeparator is ERC165, SampleInterface {
    uint internal value; 

    function geValue(address storageAddress) public view returns(uint){
        return SampleInterface(storageAddress).getValue();
    }

    function supportsInterface(bytes4 interfaceId) public pure override returns (bool) {
        return interfaceId == 0x01ffc9a7 || interfaceId == 0x75b24222; 
    }   

    function setValue(uint v) external {
        value = v; 
    }
}
