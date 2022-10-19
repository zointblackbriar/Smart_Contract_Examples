#!/bin/bash 

npx hardhat run --network localhost migrations/1_deploy_extendedrole.js
npx hardhat run --network localhost migrations/3_deploy_UUPSProxyrole.js
