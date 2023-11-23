# Spring Tracing Example

This is a simple example of how to use Spring Cloud Sleuth to trace a request through a Spring Boot applications 
in microservices architecture.

## How it works
There are 3 services:
 - `web-facade` - a web application that receives requests and calls other services
 - `rest-service` - a REST service that returns a name
 - `queue-service` - a service that receives messages from a queue and audit (logs) them

## How to run
Build Docker images:
```bash
mvn clean spring-boot:build-image 
```
This command will build Docker images for all services:
 - `docker.io/library/web-facade:0.0.1-SNAPSHOT`
 - `docker.io/library/rest-service:0.0.1-SNAPSHOT`
 - `docker.io/library/queue-service:0.0.1-SNAPSHOT`

Once images are built, you can run them using `docker-compose`:
```bash
cd docker
docker compose up
```

## How to test
To test the application, you can use `curl`:
```bash
curl http://localhost:8080/?name=Batman
```
Result would be something like:
```text
Batman, Hello from Galadriel
```
And in logs you can see something like:
```text
web-facade     | 2023-11-23 01:18:03.073  INFO [web-facade,fb502d77543e7f75,fb502d77543e7f75] 1 --- [nio-8080-exec-5] c.v.t.mdclogtraining.HelloController     : GET hello. name='Batman'
web-facade     | 2023-11-23 01:18:03.084  INFO [web-facade,fb502d77543e7f75,fb502d77543e7f75] 1 --- [nio-8080-exec-5] c.v.training.mdclogtraining.NameClient   : Calling name service at 'http://rest-service:8081/api/name'
rest-service   | 2023-11-23 01:18:03.113  INFO [rest-service,fb502d77543e7f75,07f850786f2f9c3a] 1 --- [nio-8081-exec-4] c.v.training.restservice.NameService     : New name='Galadriel'
queue-service  | 2023-11-23 01:18:03.131  INFO [queue-service,fb502d77543e7f75,8dcd4c5f573fdc3b] 1 --- [ntContainer#0-1] c.v.training.queueservice.AuditService   : Audit message: Hello from Galadriel
```
Pay attention on trace id `fb502d77543e7f75` - it is the same for all involved services.