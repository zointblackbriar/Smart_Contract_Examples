pub contract BasicNFT {
    //Declare NFT Type
    pub resource NFT {
        pub let id: UInt64

        //String mapping to hold metadata
        pub var metadata : {String: String}
    }
}