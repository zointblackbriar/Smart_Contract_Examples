pragma solidity ^0.5.12;

// exchanging tokens to Ethereum
// exchanging Ethereum to tokens

// We’ll start our Decentralized exchange code by adding our simple ERC20 codebase:
interface IERC20 {
    function totalSupply() external view returns (uint256);
    function balanceOf() external view returns (uint256);
    function allowance(address owner, address spender) external view returns (uint256);

    function transfer(address recipient, uint256 amount) external returns (bool);
    function approve(address spender, uint256 amount) external returns (bool);
    function transferFrom(address sender, address recipient, uint256 amount) external returns (bool);

    event Transfer(address indexed from, address indexed to, uint256 value); //from an address to an address
    event Approval(address indexed owner, address indexed spender, uint256 value);

}


contract ERC20 is IERC20 {
    string public constant name = "ERC20Basic";
    string public constant symbol = "ERC";
    uint8 public constant 
}