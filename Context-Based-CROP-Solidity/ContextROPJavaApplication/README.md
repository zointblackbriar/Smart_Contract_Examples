### CODE INFORMATION

```bash
mvn web3j:generate-sources
```

The following command is enough to take

```bash
mvn clean compile
```

Run the application

```bash
mvn compile exec:java
```

Mnemonic can be used for generating deterministic private keys. There is no way to get all private keys with a script and Ganache-Cli or GUI changes private key at each opening from scratch. Use the following code snippet

```bash
ganache-cli -l 9000000 -m "world reopen cute forward vintage okay drink margin piano buffalo autumn awful"
```