

contract Ownable {
    address public owner;

    event ownershipEvent(address indexed previous);
    event ownershipTransferring(address indexed previous, address indexed newOne);

    //msg.sender will be the person who currently connecting with the contract.
    constructor() public {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner);
        _;
    }

    function transferOwnership(address _newOwner) public onlyOwner {
        require(_newOwner != address(0)); 
        emit ownershipTransferring(owner, _newOwner);
        owner = _newOwner;
    }

    function retakeOwnership() public onlyOwner {
        emit ownershipEvent(owner);
        owner = address(0);
    }
}