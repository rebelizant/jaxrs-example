# jaxrs-example

## Simple example of JAX-RS

To build and start local jetty server on port 8080 use this command:
```
./gradlew jettyRunWar
```
It builds war file, starts jetty, and deploys built war file.

### Domain model
* **Customer** contains a reference to an address
* **Address** is referenced by a customer
* **Order** contains references to a customer and to a list of order items
* **OrderItem** referenced by an order and contains reference to a product
* **Product** contains information abount a product

### "Persistence layer"
It is simple abstraction of a persistence layer. It does not connect to any database actually.

* CustomerRepository which contains such operations as:
```
    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    void updateCustomer(Long id, Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);
```
* OrderRepository(TBD)

### REST layer
Contains a couple of REST resources:
- CustomerResource
- OrderResource(TBD)

1. **CustomerResource** is implemented by **CustomerResourceImpl**. **CustomerResource** endpoints:

    Endpoints support JSON format so far:
    - POST _/customers_ is used to create customer:
        - ```curl -H "Content-Type: application/json" -X POST -d '{"id":1,"firstName":"John","lastName":"Konstantine","address":{"city":"London","country":"UK"}}' http://localhost:8080/jaxrs-example/customers```
    - GET _/customers_ is used to query all customers(pagination TBD):
        - ```curl -i -H "Accept: application/json" http://localhost:8080/jaxrs-example/customers```
    - PUT _/customers/{id}_ is used to update customer's info:
        - ```curl -H "Content-Type: application/json" -X PUT -d '{"firstName":"Vadym","lastName":"Konstantine","address":{"city":"London","country":"UK"}}' http://localhost:8080/jaxrs-example/customers/1```
    - GET _/customers/{id}_ is used to get customer's info by id:
        - ```curl -i -H "Accept: application/json" http://localhost:8080/jaxrs-example/customers/1```
    - DELETE _/customers/{id}_ is used to delete customer by id:
        - ```curl -i -H "Accept: application/json" -X DELETE http://localhost:8080/jaxrs-example/customers/1```

2. **OrderResource** (TBD)




## Know issues:
1. To query customers using start and size query params surrond url with quotation marks, otherwise the second query param will be ignored and set to default value, which is zero:
    
    ```curl -i -H "Accept: application/json" "http://localhost:8080/jaxrs-example/customers?size=1&start=2"```
