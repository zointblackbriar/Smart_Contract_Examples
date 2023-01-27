### Flow Cadence Blockchain Development Notes

Please install the CLI of Flow framework

```bash
brew install flow-cli
```


```bash
flow init

Configuration initialized
Service account: 0xf8d6e0586b0a20c7

You need to start flow emulator in order to initiate port number in the local host 
environment.

Start emulator by running: 'flow emulator'
Reset configuration using: 'flow init --reset'
```

Flow Local Emulator and create a user: 

```bash
Enter an account name: samplecadence
✔ Local Emulator

❗ This command will perform the following:
 - Generate a new ECDSA P-256 public and private key pair.
 - Create a new account on Local Emulator paired with the public key.
 - Save the newly-created account to flow.json.


Please note that the newly-created account will only be available while you keep the emulator service 
running. If you restart the emulator service, all accounts will be reset. If you want to persist accounts 
between restarts, please use the '--persist' flag when starting the flow emulator.

🎉 New account created with address 0x01cf0e2f2f715450 and name samplecadence.

Here’s a summary of all the actions that were taken:
 - Added the new account to flow.json.
```


### Sample Smart Contract Deployment by Flow Cadence

```bash
flow accounts add-contract ./UseCaseSupplyChainNetwork.cdc
```

Output as follows: 

```bash
Transaction ID: 9c415533c329c5ac37f704edd889b19704010a2d7c3c99d8676e98926b530bdc
Contract 'HelloWorld' deployed to the account 'f8d6e0586b0a20c7'.

Address	 0xf8d6e0586b0a20c7
Balance	 999999999.99600000
Keys	 1

Key 0	Public Key		 
c93c552ebadc803f4199e7f195d3413adc6b0309a68b938fd870a6f8521ffa5419e6f1e588ee2b0ea41e443d4fa65d5d1f42062957d1918402d0c917c5096a57
	Weight			 1000
	Signature Algorithm	 ECDSA_P256
	Hash Algorithm		 SHA3_256
	Revoked 		 false
	Sequence Number 	 2
	Index 			 0

Contracts Deployed: 11
Contract: 'FlowEpoch'
Contract: 'FlowStakingCollection'
Contract: 'FlowDKG'
Contract: 'FlowServiceAccount'
Contract: 'FlowContractAudits'
Contract: 'FlowStorageFees'
Contract: 'HelloWorld'
Contract: 'FlowIDTableStaking'
Contract: 'LockedTokens'
Contract: 'StakingProxy'
Contract: 'FlowClusterQC'
```

Contact Remove with the following script

```bash
flow accounts remove-contract HelloWorld
```

Execution a script

```bash
flow scripts execute script.cdc "Sample Message" "Hello, World" -log
```

Result from the Script

```bash
INFO[4709] ⭐  Script executed                            computationUsed=3 scriptID=e66fd5987017d2fe7fb0294a2390c0e01b68d2d13d1a013905d182db81e7eb61
```


## Send a transaction

```bash
flow transactions send tx.cdc "Foo" 1 2 3.5 0x1
```

Result can be seen as follows: 

```bash
Transaction ID: 675e5b112d39e8f234ccfa0bd344f7f1238b18b54493d577cc1d1dafee61591f

Status          ✅ SEALED
ID              675e5b112d39e8f234ccfa0bd344f7f1238b18b54493d577cc1d1dafee61591f
Payer           f8d6e0586b0a20c7
Authorizers     [f8d6e0586b0a20c7]

Proposal Key:
    Address     f8d6e0586b0a20c7
    Index       0
    Sequence    6

No Payload Signatures

Envelope Signature 0: f8d6e0586b0a20c7
Signatures (minimized, use --include signatures)

Events:  None


Code (hidden, use --include code)

Payload (hidden, use --include payload)
```