## GLOVO service app
This service is for processing orders according to the REST API 
#### For local run:
- active profile "default"
- testing profile "test"
- postgresDB run from docker
- test profile is run on H2 DB

#### API

- Create Order example curl
```
curl --location 'http://localhost:8082/api/v1/orders' \
--header 'Content-Type: application/json' \
--data '{
    "cost": 2210.1,
    "date": "2024-03-18",
    "products" : [
        {
            "name" : "product1",
            "cost" : 100.0
        },
        {
            "name" : "product2",
            "cost" : 200.0
        },
        {
            "name" : "product3",
            "cost" : 300.0
        }
    ]
}'
```

- Get Order example curl
```
curl --location 'http://localhost:8082/api/v1/orders/1' \