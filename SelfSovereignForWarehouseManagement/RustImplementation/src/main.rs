

use std::path::PathBuf;
use identity::account::Account;
use identity::account::IdentitySetup;
use identity::account::Result;
// use identity::account_storage::Stronghold;
use identity::iota::ResolvedIotaDocument;
#[tokio::main]
async fn main() -> Result<()>{
  // Print IOTA Identity header
  println!();
  println!(r#"  _____ ____ _______          _____    _            _   _ _         "#);
  println!(r#" |_   _/ __ \__   __|/\      |_   _|  | |          | | (_) |        "#);
  println!(r#"   | || |  | | | |  /  \       | |  __| | ___ _ __ | |_ _| |_ _   _ "#);
  println!(r#"   | || |  | | | | / /\ \      | | / _` |/ _ \ '_ \| __| | __| | | |"#);
  println!(r#"  _| || |__| | | |/ ____ \    _| || (_| |  __/ | | | |_| | |_| |_| |"#);
  println!(r#" |_____\____/  |_/_/    \_\  |_____\__,_|\___|_| |_|\__|_|\__|\__, |"#);
  println!(r#"                                                               __/ |"#);
  println!(r#"                                                              |___/ "#);

  // Print welcome text
  println!();

  let stronghold_path: PathBuf = "./example-strong.hodl".into();
  let password: String = "my-password".into();
  let stronghold: Stronghold = Stronghold::new(&stronghold_path, Some(password), None).await?;

  // Create a new identity with default settings and
  // Stronghold as the storage.
  let account: Account = Account::builder()
    .storage(stronghold)
    .create_identity(IdentitySetup::default())
    .await?;

  println!("[Example] Local Document = {:#?}", account.document());

  // Fetch the DID Document from the Tangle
  //
  // This is an optional step to ensure DID Document consistency.
  let resolved: ResolvedIotaDocument = account.resolve_identity().await?;

  println!("[Example] Tangle Document = {:#?}", resolved);

  Ok(())
}
