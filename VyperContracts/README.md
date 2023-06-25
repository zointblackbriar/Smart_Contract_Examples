## PREREQUISITES

Install vyper through docker: 

```bash
docker pull vyperlang/vyper
```

To run the compiler use the `docker run` command: 

```bash
docker run -v $(pwd):/code vyperlang/vyper helloworld.vy 
```

Alternatively you can log into the docker image and execute vyper command: 

```bash
docker run -v $(pwd):/code -it --entrypoint /bin/bash /vyperlang/vyper 
root@0ß193ß1293:/code# vyper helloworld.vy 
```


