const identity = require('@iota/identity-wasm/node')

async function main() {
    console.log("main method starts");
    // The creation step generates a keypair, builds an identity
    // and publishes it to the IOTA mainnet.
    const builder = new identity.AccountBuilder();
    const account = await builder.createIdentity();

    // Retrieve the DID of the newly created identity.
    const did = account.did();

    // Print the DID of the created Identity.
    console.log(did.toString())

    // Print the local state of the DID Document
    console.log(account.document());

    // Print the Explorer URL for the DID.
    console.log(`Explorer Url:`, 
identity.ExplorerUrl.mainnet().resolverUrl(did));
}

main()
