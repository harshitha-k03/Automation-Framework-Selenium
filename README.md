Selenium Automation Framework

A comprehensive test automation framework built with Selenium, Java, TestNG, and Jenkins.

Features





Page Object Model (POM): Enhances maintainability and scalability.



TestNG: Structured test execution with parallel testing.



ExtentReports & Allure: Detailed and visually appealing test reports.



Jenkins: CI/CD integration for automated test execution.



Email Notifications: Sends test reports via email.



Logging: Uses Log4j for detailed logs.



Data-Driven Testing: Supports Excel and JSON data sources.



Retry Mechanism: Retries failed tests up to 2 times.



Video Recording: Records test execution sessions.

Setup





Clone the Repository:

git clone https://github.com/harshitha-k03/SeleniumAutomationFramework.git



Install Dependencies:

mvn clean install



Configure:





Update config.properties with ChromeDriver path and application URL.



Configure EmailUtil.java with SMTP credentials.



Run Tests:

mvn test



Jenkins Setup:





Install Jenkins and configure Maven and JDK.



Create a pipeline job and point it to the Jenkinsfile.

Reports





ExtentReports: reports/ExtentReport.html



Allure Reports: Run allure serve target/allure-results to view.



Videos: test-recordings/*.avi

Test Data





Excel: src/test/resources/testdata.xlsx



JSON: src/test/resources/testdata.json
