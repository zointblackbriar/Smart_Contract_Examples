
pub contract UseCaseSupplyChainNetwork {
	pub let retailer: String
    pub let manufacturer: String 
    pub let wholesaler: String

	init() {
		self.retailer = "Hello Message from Retailer"
        self.manufacturer = "Hello Message from Retailer"
		self.wholesaler = "Hello Message from Retailer"
	}

	//Message from the Retailer Item!
	pub fun messageFromRetailer(): String {
		return self.retailer
	}

    //Message from the Wholesaler Item!
	pub fun messageFromWholesaler(): String {
		return self.wholesaler
	}

	//Message from the Manufacturer Item!
	pub fun messageFromManufacturer(): String {
		return self.manufacturer
	}

}


