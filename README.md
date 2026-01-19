# Amazon Automation Task

## Requirements
- Java 21+
- Maven
- Chrome Browser
- Allure CLI

## Setup

1. Clone repository
2. Install dependencies
   mvn clean install

3. Run tests
   mvn test

4. Generate report
   allure serve target/allure-results

## Screenshots
Screenshots are automatically captured on test failure and stored in /each test on allure.

## Scenarios Covered
1. Login with unregistered email
2. Add items to cart and verify name, price, quantity and subtotal
3. Account access pages without login
