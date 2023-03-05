# neo-service-worker
 
To run neo-service-worker you will need at minimum the following hardware
 
* Oracle JDK 8
* Maven 3
* Intel Core i5 or higher
* 8 GB RAM
 
 
Only Docker Compose version 3.2 and up are supported. More information regarding docker-compose versions can be found
[here](https://docs.docker.com/compose/compose-file/compose-versioning/#compatibility-matrix)
 
This project template is tested with:
 
* [Docker for Mac](https://www.docker.com/docker-mac)
* [Docker for Windows](https://www.docker.com/docker-windows)
 
If your environment does not support Docker for Mac/Windows, then you must use the native MsSQL.
 
* Navigate to [neo-service-lib-core](https://github.com/BankABC/neo-service-lib-core) project and compile it by executing following command.
  * cd ../neo-service-lib-core/
  * mvn clean install

* Navigate to [neo-service-lib-swagger](https://github.com/BankABC/neo-service-lib-swagger) project and compile it by executing following command.
  * cd ../neo-service-lib-swagger/
  * mvn clean install
  
* Navigate to [neo-service-lib-test](https://github.com/BankABC/neo-service-lib-test) project and compile it by executing following command.
  * cd ../neo-service-lib-test/
  * mvn clean install

* Build the neo-service-worker
    * mvn clean install  



Open a new terminal, go to your project folder, navigate to the `neo-service-worker/docker/sqlserver` folder, where the docker-compose.yml file is
located and run `docker-compose up -d` to start MsSQL. Schemas are automatically created the first time
it starts.

Configure environment variable for accessing third party API.

`urbis.service.base-url` For urbis service base url

`urbis.service.authorisation.token` For urbis authorisation token.
`com.neo.customers.service.baseUrl` for customers service base URL.
`com.neo.cards.service.baseUrl` for cards service base URL.

Navigate to project directory and execute below command

mvn clean install

Go to project folder execute spring boot command from project root itself.

mvn spring-boot:run


* [Kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
* [Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)
* [Python3]
```bash
brew install python3
```


1. Make sure minikube is running:
```bash
minikube status
```
and start it if it's stopped:
```bash
minikube start
```

2. Build and deploy the microservice on your minikube cluster:
```bash
make dev
```

3. Open access to your minikube:
```bash
kubectl proxy
```

4. Check if the microservice works:
```bash
curl 127.0.0.1:8001/v1/api/worker
```