import contract from 'truffle-contract'

import storageArtifact from '../../build/contracts/StorageContract'  //json or Contract file???

const StorageContract = contract(storageArtifact) //myObject = new Object

export {
    StorageContract
}