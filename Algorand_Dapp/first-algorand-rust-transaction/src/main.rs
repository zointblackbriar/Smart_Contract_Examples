use algonaut::Kmd;
use std::error::Error;

fn main() -> Result<(), Box<dyn Error>> {
    let kmd = Kmd::new()
        .bind("http://localhost:4002")
        .auth("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        .client_v1()?;

    let list_response = kmd.list_wallets()?;
    if let Some(wallet) = list_response.wallets.get(0) {
        println!("Wallet Name: {}, ID: {}", wallet.name, wallet.id);
    } else {
        println!("No wallets found.");
    }

    Ok(())
}

#[cfg(test)]
mod tests {
    use super::*;

    // This is an integration test that requires a running kmd instance.
    #[test]
    fn list_wallets_integration_test() -> Result<(), Box<dyn Error>> {
        let kmd = Kmd::new()
            .bind("http://localhost:4002")
            .auth("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            .client_v1()?;

        let list_response = kmd.list_wallets();
        
        assert!(list_response.is_ok());

        Ok(())
    }
}
