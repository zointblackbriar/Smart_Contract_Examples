pragma solidity ^0.5.12; 

contract ERC20Solidity {
    string public constant name = "ERC20Solidity";
    string public constant symbol = "BSC";
    uint8 public constant decimals = 18; 

    event Approval(address indexed tokenOwner, address indexed spender, uint tokens); 
    event Transfer(address indexed from, address indexed to, uint tokens); 

    mapping (address => uint256) balances;  // key - value
    mapping (address => mapping(address => uint256)) allowed; 

    uint256 totalSupply_; 

    using SafeMath for uint256; 

    constructor(uint256 total) public {
        totalSupply_ = total; 
        balances[msg.sender] = totalSupply_;
    }

    function totalSupply() public view returns (uint256) {
        return totalSupply_;
    }

    function balanceOf(address tokenOwner) public view returns (uint) {
        return balances[tokenOwner];
    }

    function transfer(address receiver, uint numberTokens) public returns (bool) {
        //we need more tokens that we are spending
        require(numberTokens <= balances[msg.sender]);
        //SafeMath.sub will throw if there is not enough balance
        balances[msg.sender] = balances[msg.sender].sub(numberTokens); 
        balances[receiver] = balances[receiver].add(numberTokens);
        emit Transfer(msg.sender, receiver, numberTokens);
        return true;
    }

    function approve(address delegate, uint numberTokens) public returns (bool) {
        allowed[msg.sender][delegate] = numberTokens;
        emit Approval(msg.sender, delegate, numberTokens);
        return true; 
    }
}
    library SafeMath {
        function sub(uint256 a, uint256 b) internal pure returns (uint256) {
            assert(b <= a); 
            return a - b; 
        }

        function add(uint256 a, uint256 b) internal pure returns (uint256) {
            uint256 c = a + b; 
            assert(c >= a);
            return c; 
        }
    }

