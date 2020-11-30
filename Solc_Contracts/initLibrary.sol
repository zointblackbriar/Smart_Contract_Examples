// SPDX-License-Identifier: MIT

pragma solidity >=0.4.0 <=0.7.0;

library GetCode {
	function at(address _addr) public view returns (bytes memory opcodes){
		//insert assembly keyword
		assembly {
			//retrieve the size of the code, this needs assembly
			let size := extcodesize(_addr)
			// allocate output byte array -- this could alse be done
			opcodes := mload(0x40)

			//new "memory end" including padding 
			//mstore(0x40, add(opcodes, and(add(add(size, 0x20), 0x1f), not(0x1f)))

			//store length in memory
			mstore(opcodes, size)

			//actually retrieve the code, this needs assembly
			extcodecopy(_addr, add(opcodes, 0x20), 0, size)
			
		}
	}
}

contract MyContract {
	using MathLib for uint; // you should use the library of Mathlib
	
	uint256 a = 10;
	uint256 b = 10;

	uint256 c = a.add(b);
}

library MathLib
{
	function add(uint256 a, uint256 b) external pure returns (uint256)
	{
		uint256 result = a + b;
		assert( result >= a); //assert or require
		return result;
	}
}
	
