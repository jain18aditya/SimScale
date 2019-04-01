# SimScaleTest

## Test Strategy document:
https://docs.google.com/document/d/1KTkrOEQerUPJ9lYC-OiFYhvoN_1awZlTjVZ0Hw1oi1c/edit?ts=5c9b15f3#

Framework Details:
1. Framework is written in Page Object Model where starting point will be Cucumber feature files.
2. Feature files are consist of plain English language steps. 
3. All pages and page action are on one place and action on pages (Background code for cucumber steps) are in Cucumber steps definition file
4. No Hard coded data is used and reading data from application.properties file.
5. You can select which browser to use for execution you need to pass the same through Jenkins CI tool if integrated or you can set the browser in environment variable else it will pick from properties file where you can changes which browser you want use.

Logging:
6. Used log4j for gathering logs and log file will be generated at root location.
7. Used hooks class of Cucumber to improve the logging.

Screenshot:
8. Framework takes snapshots if failed at any point.

Reports:
9. A very good Cucumber reports are generated under target folder

CI:
10. Can be easily linked with CI tool and if required all values can be passed through CI tool itself.

# Run requirement:
- Windows
1. Clone this project
2. Gradle will download all the dependencies.
3. Run tests: 
	a. Run as JUnit from runner file (Right click on TestRunner file present in package com.kindred.runner and run as JUnit)
	b. Run as cucumber feature files(Right click on feature file present in src/test/java/resources and run Cucumber feature)
	c. Run command prompt and navigate to project folder and run "gradle build"

Note: If gradle command is not working try “gradlew build”  from project folder or install gradle from “https://gradle.org/install/”


- Linux
Install following packages:
sudo apt-get install openjdk-8-jdk
sudo apt-get install gradle
	
Open terminal
Navigate to project folder
Run "gradle build"
