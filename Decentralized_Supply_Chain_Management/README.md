# Decentralized Supply Chain Management 

A basic application that has been implemented with smart contracts, which are the fundamental technology of Ethereum blockchain.

## Getting Started

Principally, the application simulates some behaviours of the supply chain such as Retailers, Suppliers, and Customers. In the retailer section, we have Market and Order tabs, which are essentially inserted information regarding the parts of items and state of orders (isCompleted, isNotCompleted) respectively. In the supplier section, we have process order and Add Items to Market tabs that one can use to add information into the decentralized database. Once we added information into the decentralized database, the system itself should be synchronized in a quick manner. In central authorizations, one can remember that the synchronization is handled by the central authority (e.g. Google Drive). In that case, synchronization from supplier to retailer should be completed in order to provide a decentralized service.

### Prerequisites

You need to install nodejs, npm, and ganache GUI

Tested versions are: 
nodejs v13.6.0
npm 6.14.4

### Installing

First of all we need to start the Ganache GUI. Then we need to type the following command under /backend of 
the project directory.

```
truffle compile
```

And we need to migrate to the Blockchain database

```
truffle migrate
```

Secondly, we need to come into the folder of /frontend in the main project directory.

```
npm install
```

And then type the following command

```
npm start
```

Accordingly, our application is ready to go.

### Screen Pictures of the Application


## Authors

* **Orcun Oruc** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)


## Acknowledgments

* Give the main repository reference
