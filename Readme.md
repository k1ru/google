# Google Search Test
A small tutorial task for selenium+testng+maven relations used for testing google.com search
# Preconditions
* maven 3.3.9 or higher should be installed https://maven.apache.org/download.cgi

# How to use
* Get maven project from github and place it to any location at your PC
* Navigate to the project's root folder
* Perform maven command: mvn test

# Configuration
* Main configuration file is testng.xml which is located here: src\test\resources\testng.xml
* You can perform initial setup of the test parameters like browser [chrome, firefox, ie], test suites to be executed and so on...

# Test steps
* Navigating to google.com and check page title
* Verifying that search text area exists
* Verifying that button "Search" exists
* Performing search with google by pattern and checking results
