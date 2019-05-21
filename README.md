## Instruction

### Build
```
mvn package
```

### Run
*Instance1* : `java -Duser.profile=p1 -jar target/messaging-assignment-0.0.1-SNAPSHOT.jar --server.port=8080`
*Instance2* : `java -Duser.profile=p2 -jar target/messaging-assignment-0.0.1-SNAPSHOT.jar --server.port=8081`

#### /send message
```
curl -X POST \
  http://localhost:8081/send \
  -H 'Content-Type: application/json' \
  -d '{
	"Message" : "This is the Third Message"
}'
```

#### Some other commands

port can be 8080/8081 based on the profile p1/p2.

```
curl localhost:8081/messages/get/read
curl localhost:8081/messages/get/unread
curl localhost:8081/messages/get/all
curl localhost:8081/messages/get/sent
curl localhost:8081/messages/get/received
curl localhost:8081/messages/delete/all
```