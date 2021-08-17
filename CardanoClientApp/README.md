### CREATE A PROJECT

You can create a sample project with the following command: 

```bash
mvn archetype:generate -DgroupId=com.tudresden  -DartifactId=CardanoClientApp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeVersion=1.4
```

### API KEY

To get an API Key, you need to register through the website 

[Blockfrost](https://blockfrost.io/)


### SYSTEM REQUIREMENTS

Maven               | Java          | Operating System
------------------- | ------------- |  ------------- 
Apache Maven 3.6.3  | 1.8.0.231     |  macOSX 10.14.6


### RUN THE APPLICATION

Please use the following command: 

```bash
mvn clean compile 
```