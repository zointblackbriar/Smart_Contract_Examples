package de.tudresden.cardanoconnection;

import com.bloxbean.cardano.client.account.Account;
import com.bloxbean.cardano.client.api.helper.TransactionHelperService;
import com.bloxbean.cardano.client.common.model.Networks;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        fromMnemonic2Network(); 
    }


    private static void fromMnemonic2Network() throws  Exception{
        String phrase24W = "coconut you order found animal inform tent anxiety pepper aisle web horse source indicate eyebrow viable lawsuit speak dragon scheme among animal slogan exchange";
        String address0 = "addr_test1qzsaa6czesrzwp45rd5flg86n5hnwhz5setqfyt39natwvsl5mr3vkp82y2kcwxxtu4zjcxvm80ttmx2hyeyjka4v8psa5ns0z"; 

        Account account = new Account(Networks.testnet(), phrase24W); 
        System.out.println("account baseAddress: " + account.baseAddress()); 
        System.out.println("account mnemonic: " + account.mnemonic());
    }
}
