const FundraiserContract = artifacts.require("Fundraiser"); 

contract("Fundraiser", accounts => {
    let fundraiser; 
    const name = "Beneficiary Name"; 
    const url = "benefiaryname.org"; 
    const imageURL = "https://sampledonation.com"; 
    const description = "This is a sample application donation process"; 
    const beneficiary = accounts[1]; 
    const owner = accounts[0];

    describe("initialize contract", () => {
        beforeEach(async() => {
            fundraiser = await FundraiserContract.new(name, url, imageURL, description, beneficiary,  owner);
        }); 

        it("gets the beneficiary name", async() => {
            const actual = await fundraiser.name(); 
            assert.equal(actual, name, "names should match"); 
        });

        it("gets the beneficiary url", async() => {
            const actual = await fundraiser.url(); 
            assert.equal(actual, url, "url should match");
        });

        it("gets the beneficiary image url", async()=> {
            const actual = await fundraiser.imageURL(); 
            assert.equal(actual, imageURL, "imageURL should match"); 
        });

        it("description should be tested", async() => {
            const actual = await fundraiser.description(); 
            assert.equal(actual, description, "description should match");
        });

        //Test for accounts
        it("beneficiary address should be tested", async() => {
            const actual = await fundraiser.beneficiary(); 
            console.log("beneficiary address: " + beneficiary); 
            assert.equal(actual, beneficiary, "beneficiary addresss should match");
        }); 

        it("owner address should be tested", async() => {
            const actual = fundraiser.ownerAccount(); 
            console.log("owner address: " + owner); 
            assert.equal(actual, owner, "owner address should match");
        });
    });


    describe("beneficiary testing", () => {
        const newBeneficiary = accounts[2]; 
        it("updated beneficiary when called by owner account", async() => {
            await fundraiser.setBeneficiary(newBeneficiary, {from: owner}); 
            const actualBeneficiary = await fundraiser.beneficiary(); 
            assert.equal(actualBeneficiary, newBeneficiary, "beneficiaries should match"); 
        });
    });
}); 