# UUPS Proxy Pattern

## Setup:

- Clone the repo

- Install the dependencies
  `npm install`

- Create a new file `.env` from `.env.example`

```sh
cp .env .env.example
```

- In `.env` file add `INFURA_API_KEY`, `PRIVATE_KEY` and `ETHERSCAN_API_KEY`

> Note: This project uses Hardhat

## Compiling:

- To compile the contracts

```sh
npm run compile
```

## Testing:

- To run the unit tests, use the command.

```sh
npm run tests
```

## Deployment and Upgrades:

- To deploy the v1 contract to kovan run :

```sh
npm run deploy_v1 kovan
```

- To upgrade to V2, run :

```sh
npm run upgrade_v2 kovan
```

> Note: More networks can be configured in the `hardhat.config.js` file.

## Verification:

To verify the contracts on Etherscan

```sh
npx hardhat verify --network kovan <DEPLOYED_CONTRACT_ADDRESS>
```

Install the following npm modules

```bash
npm install --save-dev ethers
npm install --save-dev @nomiclabs/hardhat-ethers
npm install --save-dev @openzeppelin/hardhat-upgrades
``` 

and then 

```bash
npx hardhat console
```

Deploy a contract

```bash 
npx hardhat run --network localhost scripts/1_deploy_firstcontract_v1.js
```

You should change the const PROXY address according to the address of 1_deploy_firstcontract_v1

Result is

```bash
FirstContract deployed to: 0xc82752F9F4077C067a8c88411b1dED9F702C6CAf
FirstContract upgraded successfully
```

Then you need to deploy updated contract according to the deployment address of First Contract (First Contract is the proxy contract)

```bash
npx hardhat run --network localhost scripts/2_upgrade_updatedcontract.js
```

Before this step, activate the ganache from the following command or from hardhat

```bash 
npx hardhat node
```

or

```bash
ganache-cli
```

Install the following module for gas calculation 


```bash
require("hardhat-gas-reporter");
```


### CITATION

This proxy contract sample has been sourced from the following blog. 

https://blog.logrocket.com/using-uups-proxy-pattern-upgrade-smart-contracts/

