# personalized-data-API
A few notes: <br>

- java8 openJdk, maven, H2DB
- Added a postman collection to the resources package.

DB - H2:
- runing the projects populates tables with the queries in data.sql
  accessing db dashboard:
- dashboard address: http://localhost:8080/h2-console
- datasource.url=jdbc:h2:mem:dev;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
- datasource.driverClassName=org.h2.Driver
- datasource.username=root
- datasource.password=


Testing:
- Product & Shopper tests:
    - added sample test for each.
- internalData api tests:
    - marked as @Ignore * used online client to stub json responses (faster than setting up wiremock), im not sure how long will they be active so please recreate stubs to test the class


missing due to time concerns:
- error handling
- input validation
- more unit tests
- db indexes and keys (foreign key shopper_products.shopper_id, shopper.shopper_id, foreign key shopper_products.product_id, product.product_id)
