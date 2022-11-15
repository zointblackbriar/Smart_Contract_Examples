const { assert } = require("console");
require('chai').use(require('chai-as-promised')).should();

const FundraiserContract = artifacts.require("Fundraiser"); 

contract("Fundraiser", accounts => {
    let fundraiser; 
    const name = "Beneficiary Name";
    const url = "www.samplebeneficiary.com"; 
    const description = "samplebeneficiary"; 
    const imageurl = "www.sampleimageurl.com"; 
    const beneficiaryAccount = accounts[1]; 
    const custodianAccount = accounts[0];

        describe("deployment", () => {

            beforeEach(async() => {
                fundraiser = await FundraiserContract.new(
                    name,
                    url,
                    imageurl,
                    description
                )
            });
    

            it("gets beneficiary name", async() => {
                const actual = await fundraiser.name(); 
                console.log(actual.toString());
                actual.toString().should.equal(name); 
            });

            it("gets the beneficiary url", async() => {
                const actual = await fundraiser.url();
                actual.toString().should.equal(url); 
            });

            it("gets the beneficiary image url ", async() => {
                const actual = await fundraiser.imageURL();
                actual.toString().should.equal(imageurl);
            });

            it("gets the description of the contract", async() => {
                const actual = await fundraiser.description(); 
                actual.toString().should.equal(description);
            });
        });
    });
