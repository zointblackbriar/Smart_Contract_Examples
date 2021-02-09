pragma solidity ^0.5.12; 

contract OracleContract {

    //Contract owner
    address public owner; 

    //Marketprice Storage
    uint public marketPriceStorage; 

    //Callback function -- for logging
    event callbackMarketPrice();

    constructor() public  {
        //constructor will set the message owner to the contract
        owner = msg.sender;
    }

    function updatePrice() public {
        emit callbackMarketPrice();
    }

    function setMarketPrice(uint256 price) public {
        //It should be done by a trusted oracle
        require(msg.sender == owner); 
        marketPriceStorage=price;
    }

    function getMarketPrice() view public returns (uint) {
        return marketPriceStorage;
    }
}