#Extend Api

## How to run
Need to first set environment variables
```
`BOT_EMAIL`
`BOT_PASSWORD`
```


If running from intellij, you can set them and run the main class VirtualCardApiApplication.


## Endpoints
```
curl localhost:8080/virtualcard
curl localhost:8080/virtualcard/<id>/transactions
curl localhost:8080/transaction/<id>
```