pragma solidity ^0.8.0; 


contract Pubsub {
    function publish (bytes32 _event) external{ //can be called externally -- das kann als external angerufen werden 

    }

    function addSubscriber(bytes32 _event, string memory _subscriber) external { // can be called externally

    }

    function removeSubscriber(bytes32 _event, string memory _subscriber) external {
        
    }

    
}



