# Getting Started

### Reference Documentation
### to run MongoDB(on Mac)
1. make sure /data/db exists
2. sudo mongod


### TO ADD OAuth2 security to any Spring REST API
1. git clone the project at  https://github.com/mpanicker/hotel-reservation-oauth
2. run oauth-authorization-server - the Authorization Server (port = 8081)
3. to get a auth token
POST http://localhost:8081/spring-security-oauth-server/oauth/token?username=john&password=123&grant_type=password&client_id=reservation-api-read-client
Authorization
Basic Auth
Username:reservation-api-read-client
Password:secret 
4. Use the above token as a Bearer token while invoking reservation api
5. Run angularjs/oauth-ui-password (port = 8084) to get token using a UI


#### TO ADD a new client id
1. insert into Auth server resources/data.sql

2. Add an entry in OAuth2AuthorizationServerConfigJwt.java
.and()
.withClient("reservation-api-client-1")
.secret(passwordEncoder().encode("secret"))
.authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
.scopes("reservation", "read", "write")
.accessTokenValiditySeconds(3600) // 1 hour
.refreshTokenValiditySeconds(2592000) // 30 days
3. Add new user name and password for new users in 
WebSecurityConfig.java

# Assignment
1. Figure out why Add a CorsFilter-Why is this needed?
2. Figure out why MethodSecurityConfig- Why is this needed?
3. Add a new client id with read and write access
4 Add a new end user with USER Role
5. Add a new end user with ADMIN role

# To build and run using Docker
1. ./mvnw install dockerfile:build
2. ./mvnw install docker:build(Apple M1 chip. see common errors below)
3. ./mvnw install docker:build -DskipTests

4. docker run -p 8080:8080 -t api/hotel-reservation:latest

# to deploy to AWS ECS
1. create a personal cli profile either by using aws configure set region us-west-2 --profile personal
or by editing .aws/credentials file directly
2. aws ecr get-login --no-include-email --profile personal
3. copy paste output from previous command(we should get Login Succeeded message)
4. find the hotet-resevation image id using 'docker images' command
5. docker tag <image id from previous step>  079580827622.dkr.ecr.us-east-1.amazonaws.com/hotel-reservation
6. create a ECR repository called hotel-reservation(every image needs a new repo)
7. docker push 079580827622.dkr.ecr.us-east-1.amazonaws.com/hotel-reservation:latest 
8. run ECS wizard(https://aws.amazon.com/getting-started/tutorials/deploy-docker-containers/)


#API Endpoint
1. GET localhost:8080/api/v1/reservation/4wBcXGrQ

2. GET localhost:8080/api/v1/reservation?email=m_panicker@yahoo.com

3. localhost:8080/api/v1/reservation?email=joe@techprotech.com

4. 

# To set up and use DynamoDB as the database (instead of Mongo)
1. set up aws cli and configure it i.e. run "aws configure" or add aws_access_key_id/aws_secret_access_key in ~/.aws/credentials
2. Add AWS_PROFILE=<profile name to connect to aws> to your env variables. For IntelliJ , add it through run configuration(the program uses one of a chain of credential providers)
3. create a table called "reservation_db" in the appropriate aws region with "bookingNumber" as the partition key
4. 


# java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
IntelliJ java version issue
select the project and File menu --> Project Structure
and ensure JDK 8

#to deploy as a lambda
1. sam local start-api --template sam.yaml
#####1.a Pom.xml must only have maven-shade-plugin otherwise we will get ClassNotFound exception for StreamLambdaHandler
To deploy to AWS using CF
1. aws cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket reservation-api-lambda
2. aws cloudformation deploy --template-file output-sam.yaml --stack-name ReservationApi --capabilities CAPABILITY_IAM
3. The Lambda and API gateway will take time to respond. First few times I got
timeout error, then "API status DOWN" and then eventually it worked

# common errors
1.
Not able to execute a .sh file: /bin/bash^M: bad interpreter when running ./mvnw 
due to windows new line character. Run the below in macos
sed -i -e 's/\r$//' mvnw ./mvnw install dockerfile:build

2.
for Mac M1 chip
replace
<groupId>com.spotify</groupId>
<artifactId>dockerfile-maven-plugin</artifactId>

with
<groupId>io.fabric8</groupId>
<artifactId>docker-maven-plugin</artifactId>

3.
Caused by: javax.xml.bind.JAXBException: Implementation of JAXB-API has not been found on module path or classpath
add
<!-- JAXB API -->
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>

		<!-- JAXB RI -->
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.4</version>
		</dependency>

4.
no main manifest attribute, in /app.jar
shade plugin with transformers and mainclass

5
org.springframework.context.ApplicationContextException: Unable to start web server; nested exception is org.springframework.context.ApplicationContextException: Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
