# @version ^0.3.7

interface RoleInterface: 
	# get address of owner 
	def owner() -> address: view
	# set new owner 
	def setOwner(owner: address): nonpayable 
	# send ETH function
	def sendETH(): payable 
	# set owner and send ETH
	def setOwnerAndSendEth(owner: address): payable

	