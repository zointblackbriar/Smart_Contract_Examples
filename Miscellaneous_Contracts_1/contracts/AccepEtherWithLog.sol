pragma solidity 0.5.16;


contract AcceptEtherWithLog {
    event Deposited(address indexed _who, uint256 _amount);

    function deposit() public payable { //function example to accept ETH
        //Emits the Deposited event in Logs of transaction data
        emit Deposited(msg.sender, msg.value);
    }
}