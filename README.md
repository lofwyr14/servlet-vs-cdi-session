# servlet-vs-cdi-session
Tests Servlet with @SessionScoped attributes

The question was: It is possible it @Inject a @SessionScoped object
into a @WebServlet?

(In general, attributes in Servlets can't contain different 
data, because there is only one servlet for all request.)

## TomEE

```
mvn clean package tomee:run
```

## Liberty

```
mvn clean package liberty:run
```

## Check

Browse TomEE: http://localhost:8080/test/servlet or

Browse Liberty: http://localhost:9080/test/servlet

(there is 1 second wait in the code)

With 2 Browsers same URL you will see that:
* Servlet ist same identity
* Session counter works
