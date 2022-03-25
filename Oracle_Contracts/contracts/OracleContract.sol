// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.8.0;


import "./OraclizeAPI.sol";

contract OracleContract is usingOraclize{
    string public EURUSD; 
    // address payable owner;

    function updatePrice() public payable {
        if(oraclize_getPrice("URL") > address(this).balance) {
            //Handle out of funds here
        } else {
            //New api
            oraclize_query("URL", "json(https://data.fixer.io/latest?symbols=USD).rates.USD");
        }
    }

    function __calback(bytes32 _id, string memory result) public {
        require(msg.sender == oraclize_cbAddress()); 
        EURUSD = result;
    }
}
