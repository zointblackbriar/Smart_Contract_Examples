pragma solidity >=0.4.21 <0.7.0;

contract AssetTransfer {
    //we should define the states
    enum StateType {
        Active,
        OfferPlaced,
        PendingInspection //add rest of it
    };
    address public transferCompany;
    string public Descriptor;
    uint public AskingPrice;
    StateType public State
}