const EthereumTx = require('ethereumjs-tx').Transaction
const HookedWeb3Provide = require("hooked-web3-provider");
const Web3 = require('web3');


var provider = new HookedWeb3Provide({
    host: "http://localhost:8545",
    transaction_signer: {
        hasAddress: function(address, callback) {
            callback(null, true);
        }, 
        signTransaction : function(tx_params, callback) {
            //Transaction parameters
            var rawTx = {
                gasPrice: web3.toHex(tx_params.gasprice),
                gasLimit: web3.toHex(tx_params.gas),
                value: web3.toHex(tx_params.value),
                from: tx_params.from,
                to: tx_params.to,
                nonce: web3.toHex(tx_params.nonce)
            }; 

            //change with the correct address for ethereum js tx
            var privateKey = new Uint8Array(Buffer.from('c53b3d4865d0c8edf422f40fde21d2fdf1dd03e8eb7af10edbbb39ff7d2ec604', 'hex'));
            console.log(typeof privateKey);
            const tx = new EthereumTx(rawTx); 
            tx.sign(privateKey);

            callback(null, tx.serialize().toString('hex'))
        }
    }
});

var web3 = new Web3(provider);

//Broadcast the transaction
web3.eth.sendTransaction({
    from: "0x967F12B4338526BeDaf1e254B13a9C0327B7E350",
    to: "0x9084EF9Eed68Bd0201a0B231eAF67E51388b9cC5",
    value : web3.toWei("0.1", "ether"),
    gasPrice: "20000000000", 
    gas: "6721975"
}, function(error, result) {
    console.log(error, result);
});