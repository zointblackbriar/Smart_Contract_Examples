### SYSTEM REQUIREMENTS
> Truffle v5.1.4 (core: 5.1.4)

> Solidity - 0.8.7 (solc-js)

> Web3.js v1.2.1

> Node v14.15.4

### USEFUL INFORMATION

For Truffle 5.1.4 version, use the following commands for compilation and migration

```bash
npx truffle migrate
npx truffle compile
npx truffle test
npx truffle deploy
```

Install Truffle 5.5.14 with the following command: 

```bash
 npm install -g truffle@5.5.14
 ```


### INSTALLATION

Install the openzeppelin libraries

```bash
npm i @openzeppelin/contracts-upgradeable
```

Install hardhat gas reporter

```bash
npm install hardhat-gas-reporter
```
Deploy a contract

```bash 
npx hardhat run --network localhost migrations/1_deploy_extendedrole.js
npx hardhat run --network localhost migrations/2_deploy_updatedroleV2.js
npx hardhat run --network localhost migrations/3_deploy_UUPSProxyrole.js
```

You should change the const PROXY address according to the address of deploy_pizza_v1

