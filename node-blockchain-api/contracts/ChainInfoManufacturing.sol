//SPDX-License-Identifier: MIT
pragma solidity >=0.4.21 <0.7.0;

contract ChainInfo {
    //we should define some id values
    uint public _product_id = 0;
    uint public _intermediary_id = 0;
    uint public track_product_id = 0;
    //tracking products
    struct track_product {
        uint _product_id;
        uint _owner_id;
        address _productOwnerAddress; //this address will be important
        uint _timeStamp;
    } 
    //assign to a hash map
    mapping(uint => track_product) public tracks;

    // product data structure
    struct product {
        string _product_name;
        uint _product_cost;
        string _product_specs;
        address productOwnerAddress;
        uint _supply_date;
    }
    mapping(uint => product) public products;

    struct intermediary {
        string _username;
        string _password;
        string _userType;
        address _intermediaryAddress;
    }

    mapping(uint => intermediary) public thirdParties;

    function createIntermediary(string memory name, string memory password, address u_address, string memory typeOfChain) public returns (uint) {
        uint user_id = _intermediary_id++;
        thirdParties[user_id]._username = name; //public to private assignment
        thirdParties[user_id]._password = password;
        thirdParties[user_id]._intermediaryAddress = u_address;
        thirdParties [user_id]._userType = typeOfChain;

        return user_id; // this will be important for Nodejs API
    }

    function userLogin(uint userid, string memory username, string memory password, string memory userType) public view returns (bool) {
            if(keccak256(abi.encodePacked(thirdParties[userid]._username)) == keccak256(abi.encodePacked(username))) //keccak256 statement checks the hash contents
                if(keccak256(abi.encodePacked(thirdParties[userid]._password)) == keccak256(abi.encodePacked(password))){
                    return (true);
                }
        return (false);
    }
}