const { assert } = require("chai");
const { web3 } = require("hardhat");

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

    describe("making donations", () => {
        const value = web3.utils.toWei('0.0001'); 
        const donor = accounts[2]; 

        it("increases occurredDonationCount", async() => {
            const currentDonationCount = await fundraiser.getDonationCounts(); 
            await fundraiser.donate({from: donor, value}); 
            const newDonationCount = await fundraiser.getDonationCounts(); 
            //difference between count of the new donation and old donation
            const difference = newDonationCount - currentDonationCount; 
            assert.equal(difference, value, "one more donation has occurred");
        });
        it("includes donation in occurredDonations" , async() => {
            await fundraiser.donate({from: donor, value}); 
            const {values, dates} = await fundraiser.occurredDonations({from: donor}); 

            assert.equal(value, values[0], "values should match"); 
            assert(dates[0], "date should be present"); 
            console.log("dates: " + dates[0]); 
        }); 

        //For the withdraw function, we need to define the following features
        //1) Require the sender to match the owner address
        //2) Transfer the contract balance to the beneficiary
        //3) Emit a withdraw event
        //Withdrawing test group
        describe("withdrawing funds", () => {
            beforeEach(async() => {
                await fundraiser.donate({from: accounts[2], value: web3.utils.toWei('0.1')});
            });

        });

        describe("access control", () => {
            it("throws an error when called from a non-owner account", async() => {
                try {
                    //console.log("owner account: " + fundraiser.ownerAccount()); 
                    console.log("account[0] is: " + accounts[3]);
                    await fundraiser.withdrawDonation({from:accounts[3]}); 
                        assert.fail("withdraw was not restricted to owners");
                } catch(err) {
                    const expectedError = "Ownable: caller is not the owner"; 
                    const actualError = err.reason; 
                    assert.equal(actualError, expectedError, "should not be permitted")
                }
            });

            it("it permits to call the contract from owner account", async() => {
                try {
                    await fundraiser.withdrawDonation({from: owner});
                    assert(true, "no errors were thrown"); 
                } catch(err) {
                    assert.fail("should not thrown an error"); 
                }
            }); 

            it("tranfers balance to beneficiary", async () => {
                const currentContractBalance = await web3.eth.getBalance(fundraiser.address); 
                const currentBeneficiaryBalance = await web3.eth.getBalance(beneficiary); 
                await fundraiser.withdrawDonation({from: owner}); 
                const newContractBalance = await web3.eth.getBalance(fundraiser.address); 
                const newBeneficiaryBalance = await web3.eth.getBalance(beneficiary); 

                const beneificaryDifference = newBeneficiaryBalance - currentBeneficiaryBalance; 
                assert.equal(newContractBalance, 0, "contract should have a 0 balance"); 
                assert.equal(beneificaryDifference, currentContractBalance, "beneficiary should receive all the funds"); 
            }); 

            it("Check transaction logs", async() => {
                const tx = await fundraiser.withdrawDonation({from: owner}); 
                const expectedEvent = "Withdraw"; 
                const actualEvent = tx.logs[0].event; 

                assert.equal(actualEvent, expectedEvent, "events should match"); 
            }); 
        });


    });
}); 