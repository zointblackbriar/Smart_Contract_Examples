var assert = require('assert'); 
const { isTypedArray } = require('util/types');
// const fs = require('fs'); 
// const solc = require('solc'); 
// const Web3 = require('web3');
// const web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:8545"));

describe('String', function() {
    describe('#length()', function() {
        it('the length of the string "Ethereum" should be 8', function() {
            assert.equal(8, 'Ethereum'.length);
        });
    });
});

