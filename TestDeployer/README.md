# Test Deployment of a Smart Contract

This is going to be the first deployment of a smart contract in a test network. We will use testrpc

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You should install the following packages

```
Nodejs : v8.10.0
npm: v3.5.2
```


### Installing

For the development purpose please type the following commands

```
sudo apt update
```

```
sudo apt install nodejs
```

```
sudo apt install npm 
```

Then compile all the npm packages with the following command

```
sudo apt install build-essential 
```


```
nodejs -v  
```
You can check the version above mentioned code snippet.
And then we install hdwallet-provider

```
npm install @truffle/hdwallet-provider  
```
To install truffle and ethereum testrpc, please type as below.

```
sudo npm install -g truffle

```


```
sudo npm install -g ethereumjs-testrpc
  
```

Then system will be ready:)
## Running the tests

There is no test has been provided


### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

To deploy into the testrpc network, please type

```
truffle deploy --network testrpc
```

We have defined testrpc in truffle-config.js file and you can use it. Before typing the truffle deploy command, please type the following code piece.

```
testrpc
```


## Built With

There is no build system
<!--
* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds -->

## Contributing

<!-- Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us. -->

## Versioning

<!-- We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). -->

## Authors

* **Orcun Oruc** - *Initial work* - <!-- [PurpleBooth](https://github.com/PurpleBooth) -->

<!-- See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project. -->

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## References

* https://www.digitalocean.com/community/tutorials/how-to-install-node-js-on-ubuntu-18-04
* https://gist.github.com/PurpleBooth/109311bb0361f32d87a2
* https://medium.com/@techgeek628/how-to-install-and-execute-truffle-on-an-ubuntu-16-04-7ebb3444707e

