const solanaWeb3 = require('@solana/web3.js'); 
const fs = require('fs').promises; 
const BufferedLayout = require('buffer-layout');

console.log(solanaWeb3);
console.log(BufferedLayout)

const solanaJSON =  {
    setupConnection: (network) => {
        const connection = new solanaWeb3.Connection(network);
        console.log(connection);
        return connection; 
    },

    createUser: async() => {
        const user = new solanaWeb3.Account(); 
        console.log(`New solana account created: ${user.publicKey}`);
        return user;
    },

    loadUser: async(privateKeyForBuffer) => {
        const user = new solanaWeb3.Account(privateKeyForBuffer);
        console.log(`Loaded solana account: ${user.publicKey}`);
        return user;
    }
}

solanaJSON.setupConnection("hello network"); //Unpleasant test for the function
solanaJSON.createUser();
solanaJSON.loadUser(); 