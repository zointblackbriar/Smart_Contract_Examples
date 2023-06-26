# @version ^0.3.7

enum Roles: 
	RETAILER
	WHOLESALER
	PRODUCER



interface RoleInterface: 
	# get address of owner 
	def owner() -> address: view
	# set new owner 
	def setOwner(owner: address): nonpayable 
	# send ETH function
	def sendETH(): payable 
	# set owner and send ETH
	def setOwnerAndSendEth(owner: address): payable


interface WholeSaler: 
	def owner() -> address: view
	def setOwner(owner: address): nonpayable

interface Retailer: 
	def owner() -> address: view
	def setOwner(owner: address): nonpayable

	
# store contract having the above interface
test: public(RoleInterface)	

@external
def __init__(test: address):
	# store contract instance
	self.test = RoleInterface(test)
	# assign address from self.test
	addr: address = self.test.address


@external 
@view
def getOwner() -> address: 
	return self.test.owner()

@external 
def getOwnerFromAddress(test: address) -> address: 
	# you can also call functions by passing in the address of the interface
	return RoleInterface(test).owner()

@external 
def setOwner(owner: address): 
	# show sample properties of enum in Vyper contract
	# Declaring an enum variable
	role: Roles = Roles.RETAILER

	self.test.setOwner(owner)


@external
@payable
def sendETH():
	self.test.sendETH(value=msg.value)

@external
@payable
def setOwnerAndSendEth(owner: address):
	self.test.setOwnerAndSendEth(owner, value=msg.value)

