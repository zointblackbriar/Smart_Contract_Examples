const { assert } = require("console");
const FundraiserContract = artifacts.require("Fundraiser"); 

FundraiserContract("Fundraiser", accounts => {
    let fundraiser; 
    const name = "Beneficiary Name";
    const url = "www.samplebeneficiary.com"; 
    const description = "samplebeneficiary"; 
    const beneficiaryAccount = accounts[1]; 
    const custodianAccount = accounts[0];

    describe("initialization", () => {
        beforeEach(async() => {
            fundraiser = await FundraiserContract.new(
                name,
                url,
                description,
                beneficiaryAccount,
                custodianAccount
            )
        });
        it("gets beneficiary name", async() => {
            const actual = await fundraiser.name(); 
            assert.equal(actual, name, "names should match"); 
        });

    });
});