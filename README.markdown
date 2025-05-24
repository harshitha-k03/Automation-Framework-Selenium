# Selenium Automation Framework

![Selenium](https://img.shields.io/badge/Selenium-4.8.1-brightgreen) ![Java](https://img.shields.io/badge/Java-11+-blue) ![TestNG](https://img.shields.io/badge/TestNG-7.7.0-orange) ![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-red)

A robust and scalable test automation framework built with **Selenium WebDriver**, **Java**, **TestNG**, and **Jenkins**, designed for efficient and reliable web application testing. This framework leverages the **Page Object Model (POM)** for maintainability, integrates advanced reporting with **ExtentReports** and **Allure**, and supports **CI/CD** through Jenkins for automated test execution.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Reports and Outputs](#reports-and-outputs)
- [Test Data](#test-data)
- [Jenkins Integration](#jenkins-integration)
- [Contributing](#contributing)
- [License](#license)

## Overview
The **Selenium Automation Framework** is a comprehensive solution for automating web application testing. It combines industry-standard tools and best practices to deliver a modular, maintainable, and scalable testing environment. Key highlights include data-driven testing with Excel and JSON, retry mechanisms for flaky tests, video recording of test sessions, and seamless CI/CD integration with Jenkins.

This framework is ideal for QA engineers, developers, and teams looking to automate browser-based testing with detailed reporting and continuous integration capabilities.

## Features
- **Page Object Model (POM)**: Organizes test code into reusable page classes, enhancing maintainability and reducing code duplication.
- **TestNG**: Enables structured test execution, parallel testing, and advanced test configuration for efficient test runs.
- **ExtentReports & Allure**: Generates detailed, visually appealing test reports with screenshots and logs for better test analysis.
- **Jenkins CI/CD**: Automates test execution on code commits, ensuring continuous testing in development pipelines.
- **Email Notifications**: Sends post-execution test reports via email for quick stakeholder updates.
- **Logging with Log4j**: Captures detailed logs for debugging and traceability during test execution.
- **Data-Driven Testing**: Supports test data from **Excel** and **JSON** files, enabling flexible test case parameterization.
- **Retry Mechanism**: Automatically retries failed tests up to 2 times to handle intermittent failures.
- **Video Recording**: Records test sessions as AVI files for visual debugging and documentation.

## Prerequisites
Before setting up the framework, ensure you have the following:
- **Java 11+**: Installed and configured (verify with `java -version`).
- **Maven 3.6+**: For dependency management (verify with `mvn -version`).
- **Chrome Browser**: Latest version installed.
- **ChromeDriver**: Compatible with your Chrome version, downloadable from [here](https://chromedriver.chromium.org/downloads).
- **Jenkins**: For CI/CD (optional, if using automated pipelines).
- **SMTP Server**: For email notifications (e.g., Gmail SMTP with an app-specific password).
- **Git**: For cloning the repository (verify with `git --version`).

## Setup Instructions
Follow these steps to set up the framework locally:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/harshitha-k03/SeleniumAutomationFramework.git
   cd SeleniumAutomationFramework
   ```

2. **Install Dependencies**:
   - Run the following command to download all required libraries:
     ```bash
     mvn clean install
     ```

3. **Configure the Framework**:
   - Update `src/test/resources/config.properties` with:
     - Path to ChromeDriver (e.g., `chrome.driver.path=/path/to/chromedriver`).
     - Application URL (e.g., `url=https://your-application-url.com`).
   - Configure email settings in `src/main/java/email/EmailUtil.java`:
     - Replace `your-email@gmail.com` and `your-app-password` with your SMTP credentials.
     - Example for Gmail:
       ```java
       String from = "your-email@gmail.com";
       String password = "your-gmail-app-password";
       String to = "recipient-email@example.com";
       ```

4. **Verify Test Data**:
   - Ensure `src/test/resources/testdata.xlsx` contains:
     ```
     | username | password |
     |----------|----------|
     | user1    | pass1    |
     | user2    | pass2    |
     ```
   - Ensure `src/test/resources/testdata.json` contains:
     ```json
     [
         {"username": "user1", "password": "pass1"},
         {"username": "user2", "password": "pass2"}
     ]
     ```

## Running Tests
To execute the test suite:
```bash
mvn test
```
- Tests are defined in `src/test/java/tests/LoginTest.java`.
- The TestNG suite (`src/test/resources/testng.xml`) supports parallel execution with 2 threads.

## Reports and Outputs
- **ExtentReports**: Generated at `reports/ExtentReport.html`. Open in a browser for a detailed, interactive report.
- **Allure Reports**: Results are stored in `target/allure-results`. View them by running:
  ```bash
  allure serve target/allure-results
  ```
- **Video Recordings**: Test session videos are saved as AVI files in `test-recordings/`.

## Test Data
- **Excel**: Located at `src/test/resources/testdata.xlsx`. Contains `username` and `password` columns for data-driven tests.
- **JSON**: Located at `src/test/resources/testdata.json`. Provides test data in JSON format for flexibility.

## Jenkins Integration
To set up the framework with Jenkins for CI/CD:
1. Install Jenkins and configure it with Maven and JDK.
2. Create a new pipeline job in Jenkins.
3. Point the pipeline to the `Jenkinsfile` in the repository root.
4. Configure the GitHub repository URL in Jenkins:
   ```plaintext
   https://github.com/harshitha-k03/SeleniumAutomationFramework.git
   ```
5. Install the Allure plugin in Jenkins for Allure report generation.
6. Trigger builds manually or configure webhooks for automatic builds on code commits.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit (`git commit -m "Add your feature"`).
4. Push to your branch (`git push origin feature/your-feature`).
5. Open a pull request with a detailed description of your changes.

Please ensure your code follows the existing style and includes relevant tests.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

*Built with ❤️ by [Harshitha K](https://github.com/harshitha-k03).*