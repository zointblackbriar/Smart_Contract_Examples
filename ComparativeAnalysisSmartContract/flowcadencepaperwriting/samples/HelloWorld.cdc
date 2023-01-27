
pub contract HelloWorld {
	pub let greeting: String

	init() {
		self.greeting = "Hello Smart Contract from Cadence"
	}

	//Public function that returns our friendly greeting!
	pub fun hello(): String {
		return self.greeting
	}
}

