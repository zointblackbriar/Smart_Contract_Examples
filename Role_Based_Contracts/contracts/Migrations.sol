pragma solidity >=0.4.21 <0.7.0;

import "./Person.sol";

contract Migrations {
  address public owner;
  uint public last_completed_migration;

  constructor() public {
    owner = msg.sender;
  }

  modifier restricted() {
    if (msg.sender == owner) _;
  }

  function setCompleted(uint completed) public restricted {
    last_completed_migration = completed;
  }
  
  function upgrade(address new_address) public restricted {
    Migrations upgraded = Migrations(new_address);
    upgraded.setCompleted(last_completed_migration);
  }

  function printFunction() public pure returns(string memory) {
    // it("should succeed", async function() {
    //     await debug(Sample.sayHello(accounts[1], {from: accounts[0]}));
    // });
    return("Hello Boysen Group");
  } 

}
