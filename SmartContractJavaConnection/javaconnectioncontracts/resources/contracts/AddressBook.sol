// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

contract AddressBook {
    mapping(address => address[]) private _address;  //address array
    mapping(address => mapping(address => string)) private _aliases; //address (key) - string(Value) mapping


    function getAddresses() public view returns (address[] memory) {
        return _address[msg.sender];
    }

    function addAddresses(address addr, string memory aliasStr ) public {
        _address[msg.sender].push(addr);
        _aliases[msg.sender][addr] = aliasStr;  //why aliasStr???? 
    }

    function removeAddresses(address addr) public {
        uint length = _address[msg.sender].length; 
        for(uint i = 0; i < length; i++) {
            if(addr == _address[msg.sender][i]) { //matching address values
                if( 1 < _address[msg.sender].length && i < length - 1) {
                    _address[msg.sender][i] = _address[msg.sender][length - 1];
                }

                delete _address[msg.sender][length-1];
                _address[msg.sender].pop(); // _address[msg.sender].length--
                delete _aliases[msg.sender][addr];
                break;
            }
        }
    }

    function getAlias(address addr) public view returns (string memory) {
        return _aliases[msg.sender][addr];
    }
}

