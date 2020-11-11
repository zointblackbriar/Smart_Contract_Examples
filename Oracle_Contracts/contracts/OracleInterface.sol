pragma solidity ^0.5.16;

contract OracleInterface {
    mapping(bytes32 => uint) matchToIndex;
    Match[] matches;

    struct Match {
        bytes32 id;
        string name;
        string participants;
        uint8 participantCount;
        uint date;
        MatchOutcome outcome;
        int8 winner;
    }

    enum MatchOutcome {
        Pending, //match has not been fought to decision
        Underway, //match has started & is underway
        Draw, //anything other than a clear winner (e.g. cancelled)
        Decided //Index of participant who is the winner.
    }

    //This function has a bug in output return value.
    function getPendingMatches() public view returns (bytes32[] memory)
    {
        uint count = 0;

        //count of the pending machines
        for(uint i = 0; i < matches.length; i++)
        {
            if(matches[i].outcome == MatchOutcome.Pending) //outcome of MatchOutcome
            {
                count++;
            }

            //collect up all the pending matches
            bytes32[] memory output = new bytes32[](count);

            if(count > 0) {
                uint index = 0;
                for(uint n = matches.length; n > 0; n--) {
                    if(matches[n-1].outcome == MatchOutcome.Pending)
                        output[index++] = matches[n-1].id;
                }
            }
        }

        return output;
    }

    function getAllMatches() public view returns (bytes32[] memory);

    function matchExists(bytes32 _matchId) public view returns (bool);

    function getMatch(bytes32 _matchId) public view returns (
        bytes32 id,
        string memory name, 
        string memory participants, 
        uint8 participantCount,
        uint date,
        MatchOutcome outcome,
        int8 winner);

    //get the most recent match or pending match
    function getMostRecentMatch(bool _pending) public view returns (  //view keyword means that function will not modify state of contract.
        bytes32 id,
        string memory name,
        string memory participants,
        uint participantCount,
        uint date,
        MatchOutcome outcome,
        int8 winner) {
            bytes32 matchId = 0;
            bytes32[] memory ids;

            if(_pending) {
                ids = getPendingMatches();
            } else 
            {
                ids = getAllMatches();
            }
            if(ids.length > 0){
                matchId = ids[0];
            }

            //by default, return a null match
            return getMatch(matchId);
        }

    
    function matchExists(bytes32 _matchId) public view returns (bool) {
        if(matches.length == 0)
        {
            return false;
        }

        uint index = matchToIndex[_matchId];
        return (index > 0);  //check the index 
    }
    
    
}