pragma solidity ^0.5.0; 

import "./oracleAPI_0.5.sol";
// import "./strings.sol";

contract Betting is usingOraclize{
    string public matchId; 
    uint public amount; 
    string public url; 

    address public takingBet; 
    address public awayBet; 

    function Betting(string _matchId, uint _amount, string _url) {
        
    }
}