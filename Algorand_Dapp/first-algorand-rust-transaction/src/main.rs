use algonaut::core::{Address, MicroAlgos};
use algonaut::transaction::{BaseTransaction, Payment, Transaction, TransactionType};
use algonaut::{Algod, Kmd};
use std::error::Error;
use std::env;
// use dotenv::dotenv;



fn main() -> Result<(), Box<dyn Error>> {

    // dotenv().ok();
    // println!("Hello, world!");
    let kmd = Kmd::new()
        .bind("http://localhost:4002")
        .auth("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        .client_v1()?;

    println!("result of the kmd is: {}", kmd ); 

    let list_response = kmd.list_wallets();
    let wallet_id = match list_response


    Ok(())
}
