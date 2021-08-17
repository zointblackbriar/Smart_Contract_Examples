const bufferToHex = require( "ethereumjs-util");
const Transaction = require( '@ethereumjs/tx' );

const tx = new Transaction(
    'sampleaddress',
    {chain: 'ropsten', hardfork:'petersburg'}
)

// random address from the Ropsten test network
if(tx.validate() && bufferToHex(tx.getSenderAddress()) == '0x7245907F5f6D4eb9c164F8D6f69fa1e20f5611f3') {
    console.log('Tx has been verified');
} else {
    console.error('Invalid tx');
}

