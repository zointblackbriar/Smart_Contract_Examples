pragma solidity 0.5.12;

contract ABIEncoding {
    address public addr; 
    uint public uIntVar;
    uint8 public uIntVar8; 
    uint16 public uIntVar16;  


    constructor() public {
        addr = 0x611B947ec990Ba4e1655BF1A37586467144A2D65;
        uIntVar = 20; 
        uIntVar8 = 25; 
        uIntVar16 = 30; 
    }

    function encode() public view returns (bytes memory) {
        return abi.encode(addr, uIntVar, uIntVar8, uIntVar16);
    }

    function encodePacked() public view returns (bytes memory) {
        return abi.encodePacked(addr, uIntVar, uIntVar8, uIntVar16);
    }

    function encodeWithSelector() public view returns (bytes memory) {
        return abi.encodeWithSelector(bytes4(keccak256(" testMethod(uint256, uin8")), uIntVar, uIntVar8);
    }

}