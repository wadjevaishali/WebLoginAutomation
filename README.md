# Libreview Web Login Automation
This project demonstrates web automation using selenium webdriver, java, testng and maven.

## Prerequisites
Before running the project, ensure you have the following prerequisites:

* Java Development Kit (JDK) 8 or higher installed
* Apache Maven installed
* Chrome browser

## Installation
Clone the repository:
> git clone https://github.com/wadjevaishali/WebLoginAutomation.git

Navigate to the project directory:
> cd AbbottWebAutomation

## Configuration
User preferrences and credentials are set to defualt values. If willing to provide different values, please set the appropriate values for the following properties:
> libreviewCountry
> 
> libreviewLanguage
> 
> libreviewUsername
> 
> libreviewPassword
> 
> outlookPassword

Please note that username for libreview and outlook is same hence no need for a separate email.

## Usage
To run the automation test with default values, use the following command:
> mvn clean test

To run the automation test with user defined values, use the following command:

> mvn clean test -DlibreviewUsername="enter your username" -DlibreviewPassword="enter your password" -DlibreviewCountry="enter preferred country" -DlibreviewLanguage="enter preferred language" -DoutlookPassword="enter outlook password"

e.g.
>  mvn test -DlibreviewUsername=codechallengeadc@outlook.com -DlibreviewPassword=P@ssword$12 -DlibreviewCountry="United States" -DlibreviewLanguage=English -DoutlookPassword=P@ssword$1234 

This command will compile the project, run the tests, and generate the test reports.

## Test Development
The tests are written using TestNG framework and can be found under the src/test/java directory. Feel free to modify and extend them according to your needs.

## Limitations
The test was developed to meet the suggested requirements hence there is a scope for improvement to be able to handle other responsibilities like running on multiple browsers, in parallel, design patterns incorporation etc.

## Troubleshooting
If the maven dependencies are not downloaded and added in the classpath, try running below command before running tests

>mvn clean install