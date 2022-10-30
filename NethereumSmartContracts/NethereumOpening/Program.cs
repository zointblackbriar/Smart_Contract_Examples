using System; 
using System.Threading.Tasks; 
using System.Threading; 
using Nethereum.Web3; 

namespace NethereumOpening {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("sample message");
            // GetAccountBalance.Wait();
            sampleFunction();
            Console.ReadLine();
        }

        // static async Task GetAccountBalance() {
        //     var web3 = new Web3("https://mainnet.infura.io/v3/28a8adcd36874c9d987bc99afc97bd44");
        //     var balance = await web3.Eth.GetBalance.SendRequestAsync("0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae"); 
        //     Console.WriteLine($"Balance in Wei: {balance.Value}"); 

        //     var etherAmount = Web3.Convert.FromWei(balance.Value); 
        //     Console.WriteLine($"Balance in Ether: {etherAmount}");
        //     // Console.WriteLine("GetAccountBalance");
        // }


        static void sampleFunction() {
            Action<object> action = (object obj) => 
                                        {
                                            Console.WriteLine("Task={0}, obj={1}, Thread={2}", 
                                            Task.CurrentId, obj, Thread.CurrentThread.ManagedThreadId); 
                                        };

            Task t1 = new Task(action, "alpha"); 

            Task t2 = new Task.Factory.StartNew(action, "beta"); 

            t2.Wait(); 
            t1.Start();

            Console.WriteLine("t1 has been launched. {Main Thread = {0}}", Thread.CurrentThread.ManagedThreadId);
             
        }
    }
}
