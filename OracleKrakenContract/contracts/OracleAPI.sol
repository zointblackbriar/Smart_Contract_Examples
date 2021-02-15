pragma solidity ^0.5.0; 
//Imports the Oraclize client code from their Github repository
import "./oraclizeAPI_0.5.sol";

//Inherits from the base contract usingOraclize
contract OracleAPI is usingOraclize {
    //State variable holding the external data: exchange rate for Ether to Bitcoin from Kraken
    string public ETHXBT;
    
    event newOraclizeQuery(string description);  //Event logging whether the data query has been sent to Oraclize
    event newKrakenPriceTicker(string price); //Event logging whether Oraclize has returned the requested data.
    
    constructor() public {
        oraclize_setProof(proofType_TLSNotary | proofStorage_IPFS); 
        update();
    }
    
    //Callback invoked by Oraclize when returning the requested data to the contract
    function __callback(bytes32 myID, string memory result, bytes memory proof) public {
        if(msg.sender != oraclize_cbAddress()) revert(); 
        
        ETHXBT = result; //Updates the ETHXBT state with the value that Oraclize returned
        
        emit newKrakenPriceTicker(ETHXBT);  //Logs the requested data that Oraclize has returned
        
        update(); //Trigger a new update so that the contract keeps refreshing ETHXBT continuously
    }
    
    function update() public payable {
        if(oraclize.getPrice("URL") > this.balance) {  //Check if the contract has enough Ether to fund the data request to Oraclize
            newOraclizeQuery("Oraclize query was not sent"); 
        } 
        else {  //Data request to the Oraclize pattern
            newOraclizeQuery("Oraclize query was sent, standing by for the answer"); 
            oraclize_query(60, "URL", "json(https://api.kraken.com/0/public/Assets)");
        }
    }
}