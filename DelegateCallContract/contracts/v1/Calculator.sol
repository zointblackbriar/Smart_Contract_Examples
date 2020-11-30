// "SPDX-Licence-Identifier: MIT"


pragma solidity >=0.4.22 <=0.7.0;

contract Calculator {
	uint256 public calculateResult;

	address public user; //return the address of public value;

	event Add(uint256 a, uint256 b); //important for the full-stack app

	function add(uint256 a, uint256 b) public returns (uint256) {
		calculateResult = a + b;

		emit Add(a ,b);
		user = msg.sender;

		return calculateResult;
	}
}
