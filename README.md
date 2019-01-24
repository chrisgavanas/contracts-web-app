# contracts-web-app

Suggested solution for EE's Spring Boot Assignment

##Description
```bash
This is the web-app part of the assignment, exposing contract and user specific information REST endpoints.

All /api/admin endpoints are secured and available to authorized admin users only. 

In order to acess them, a Basic Authentication token should be provider in the Authorization header of the request.

In order to get a basic auth token you can hit /login endpoint with the credentials that exist in the resources/import.sql script for the users.

For more info refer to the swagger document.

A running instance can be found on https://contracts-web-app.herokuapp.com

```

## Swagger Link

* http://localhost:8080/swagger-ui.html
