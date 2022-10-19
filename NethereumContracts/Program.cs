// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Nethereum.Web3;
using Nethereum.Web3.Accounts;
using Nethereum.Web3.Accounts.Managed;
using Nethereum.Hex.HexTypes;


namespace CSharpTutorials
{
    class Program
    {
        static void Main(string[] args)
        {
            string message = "Hello Dresden!!";

            Console.WriteLine(message);

            SampleClass sampleObject = new SampleClass(); 
            sampleObject.showResult(1, 2);

            GetAccountBalance().Wait(); 
            Console.ReadLine();
        }

        static async Task GetAccountBalance() {
            var web3 = new Web3("https://mainnet.infura.io/v3/28a8adcd36874c9d987bc99afc97bd44"); 
            var balance = await web3.Eth.GetBalance.SendRequestAsync("0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae");
            Console.WriteLine($"Balance in Wei: {balance.Value}"); 

            var etherAmount = Web3.Convert.FromWei(balance.Value); 
            Console.WriteLine($"Balance in Ether: {etherAmount}");
        }
    }
}
