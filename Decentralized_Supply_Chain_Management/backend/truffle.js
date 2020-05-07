
// This has been planned for development environment
// If you have a plan to deploy in the Ropsten network, please insert your configuration here.
module.exports = {
  // See <http://truffleframework.com/docs/advanced/configuration>
  // to customize your Truffle configuration!
  networks:{
    development:{
      host:"localhost",
      port:7545,
      network_id:'*'
    }
  }
};
