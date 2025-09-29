# Practica Tenpo

Se puede utilizar el docker compose para usar la imagen que publique como solocita el documento de la prueba

#Imagen Docker: 
luismalpik/testenpo:1.0

Por otro lado se puede usar Postman par hacer el consumo de los 2 endpoints

# Primer Endpoint
POST
URL: http://localhost:8080/v1/operation/sum
BODY (REQUEST) DE EJEMPLO:
```
{
"firstNumber": 4,
"secondNumber": 9
}
```

# Segundo Endpoint
GET
URL: http://localhost:8080/v1/record/all
BODY (RESPONSE) DE EJEMPLO:
```
[
    {
    "endpointName": "v1/operation/sum",
    "parameter": "4.0 and 9.0",
    "date": "2025-09-29T22:24:26.315+00:00",
    "result": "14.95"
    }
]
```
