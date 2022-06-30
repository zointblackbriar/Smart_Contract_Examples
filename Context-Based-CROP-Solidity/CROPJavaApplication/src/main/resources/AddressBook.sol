//SPDX-License-Identifier: MIT
pragma solidity ^0.7.6;

contract AddressBook {
    mapping(address => address[]) private _addresses;
    mapping(address => mapping(address => string)) private _aliases;

    function getAddresses() public view returns (address[] memory) {
        return _addresses[msg.sender];
    }

    function addAddress(address addr, string memory aliasSample) public {
        _addresses[msg.sender].push(addr);
        _aliases[msg.sender][addr] = aliasSample;
    }

    function removeAddress(address addr) public {
        uint length = _addresses[msg.sender].length;
        for(uint i = 0; i < length; i++) {
            if (addr == _addresses[msg.sender][i]) {
                if (1 < _addresses[msg.sender].length && i < length-1) {
                    _addresses[msg.sender][i] = _addresses[msg.sender][length-1];
                }
                delete _addresses[msg.sender][length-1];
                //instead of the following code
                // use pop() _addresses[msg.sender].length--;
                _addresses[msg.sender].pop();
                delete _aliases[msg.sender][addr];
                break;
            }
        }
    }

    function getAlias(address addr) public view returns (string memory) {
        return _aliases[msg.sender][addr];
    }
}