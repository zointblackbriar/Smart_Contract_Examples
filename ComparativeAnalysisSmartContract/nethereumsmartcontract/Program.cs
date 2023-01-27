// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");

using System; 
using System.Threading.Tasks; 
using System.Numerics;
using Nethereum.Web3;
using Nethereum.Web3.Accounts;
using Nethereum.Web3.Accounts.Managed;
using Nethereum.Hex.HexTypes;


namespace NethereumSample {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("Main method");
            //ComponentRole Interface
            Demo.ComponentRole cr = new Demo.ComponentRole(); 
            cr.sampleBehaviorA();
            Demo.ComponentCore cc = new Demo.ComponentCore(); 
            cc.sampleBehaviorB();
            GetAccountBalanceRemoteConnection().Wait();
            GetAccountBalanceToLocalConnection().Wait();
            MakeSampleTransfer().Wait(); 
        }

        static async Task GetAccountBalanceRemoteConnection()
        {
            var web3 = new Web3("https://celo-mainnet.infura.io/v3/28a8adcd36874c9d987bc99afc97bd44");
            var balance = await web3.Eth.GetBalance.SendRequestAsync("0xc26eC4b9f9eb157fE23b29AE342a7A30f90A146c"); 
            Console.WriteLine($"Balance in Wei :{balance.Value}"); 
        }

        static async Task GetAccountBalanceToLocalConnection() 
        {
            var web3 = new Web3("http://localhost:8545"); 
            var balance = await web3.Eth.GetBalance.SendRequestAsync("0x1902adC179f20Dc762425aF56fBc62DF49c492DC"); 
            Console.WriteLine($"Balance in Wei :{balance.Value}"); 
        }

        static async Task MakeSampleTransfer() {
            try {
                Console.WriteLine("MakeSampleTransfer function");
                var privateKey = "0xdd10a09af47e5ec05c9e2c7073393e1372177960d4a38266ffcd5fed2e1afb06"; 
                var account = new Account(privateKey); 
                var web3 = new Web3(account); 
                var toAddress = "0x1902adC179f20Dc762425aF56fBc62DF49c492DC"; 
                var transaction = await web3.Eth.GetEtherTransferService().TransferEtherAndWaitForReceiptAsync(toAddress, 1.11m); 
                Console.WriteLine(transaction);
            } catch(Exception ex) {
                Console.WriteLine("An Exception has occurred: {0}", ex.Message); 
            }


        }
    }
}
