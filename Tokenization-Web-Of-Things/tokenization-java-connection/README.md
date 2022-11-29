## Extract Contracts

```bash
mvn web3j:generate-sources
```

Question is how to compile external Openzeppelin contracts in java language? 

Run the main method as follows: 

```bash
mvn exec:java -Dexec.mainClass="de.tudresden.webofthingstokenization.App"
```

