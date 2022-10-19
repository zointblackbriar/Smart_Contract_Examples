pragma solidity ^0.4.18;

contract sampleContract {
  address creator;

  constructor() public {
    creator = msg.sender;
  }

  function getContractOwnAddress() public view returns (address) {
    return this;
  }

  /**********
   Standard kill() function to recover funds
   **********/

  function kill() public {
    if (msg.sender == creator) {
      selfdestruct(creator);
      // kills this contract and sends remaining funds back to creator
    }
  }
}
