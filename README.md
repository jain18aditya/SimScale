# SimScaleTest
Framework Details:
1. Framework is written in Page Object Model where starting point will be Cucumber feature files.
2. Feature files are consist of plain English language steps. 
3. All pages and page action are on one place and action on pages (Background code for cucumber steps) are in Cucumber steps.
4. No Hard coded data is used and reading data from application.properties file.
5. Now you can select which browser to use for execution you need to pass the same in application.properties file.

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
1. Clone this project
2. Gradle will download all the dependencies.
3. Run tests: 
	1. Run as either JUnit from runner file (Right click on TestRunner file present in package com.kindred.runner and run as JUnit)
	2. Run command prompt and navigate to project folder and run "gradle test"
4. Check reports.
