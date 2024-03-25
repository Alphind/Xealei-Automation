Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* You may use, distribute and modify this code for internal purpose,  however,
distribution outside the organization * is prohibited without prior and proper
license agreement


**Xealei Automation Testing**

## Introduction:

This project automates the testing of the Xealei application using Java Selenium.
The project follows a Behavior-Driven Development (BDD) framework approach with feature files written in Gherkin syntax, and JUnit for validation purpose.
Each module contains its own set of test scenarios, corresponding Page Object Models (POM), and data stored in Excel files for testing various functionalities.

## Setup Prerequisites:

- Java Development Kit (JDK) installed
- Eclipse IDE installed
- Git Hub installed (If needed)

## Installation:

1. Create one folder in your local machine.
2. Open Eclipse IDE (Create workspace inside where the folder is created)
3. Clone this repository: using Git Bash 
   i.e :- git clone [Repository Url].
4. In Eclipse - Go to File > Open Projects from File System...
5. Click on the Directory... button.
6. Navigate to the root directory of the cloned repository.
7. Select the directory and click 'Open'
8. The project should now appear in the Import Source section.
9. Click Finish to import the project.

## Configuration:

- Each module contains its own 'pom.xml'(By its module name) file for managing dependencies and configurations specific to that module.
- Here the 'Configuration properties' File to choose the browser type, Image/File Upload and download, Screenshots needed for Passed and Failed Scenarios and
  other parameters are setting up in the respective 'Config.properties' files located within the modules.

## Dependencies:

   Below are the major dependencies included in the project '.xml' file:

1. Maven    > (Dependency Management)
2. Selenium > (Web browser Automation)
3. Junit    > (Assert Validation)
4. Cucumber > (Behavior-Driven Development (BDD) testing framework)


## Usage
## Running Tests

   There are 2 ways to run the scripts:

1. Junit Test Runner:
- Navigate to src/test/java > org.alphind.xealei.runner > test runner class (*that need to Run) > Right click > Run As > Junit Test.

2. Maven Run :
- Right click on the project Name > Run As > Maven build > Goals > Syntax : -f (XML File Name including.xml) clean install > Click Run.
  [i.e: -f sanity.xml clean install].

- For combined runs (e.g., sanity):
 Use Sanity Test Runner class or 'Sanity.xml' file.

## Test Reports

- Test reports are generated inside the 'Extent Reports > Reports.html' file of each Run
- Use the generated HTML reports to review test results.
  
NOTE : *Before initiating every test run, it is recommended to download or review the existing test report. It will be automatically deleted once the new
        execution of the test scripts.

## Data Storage

- Test datas are stored in Excel files within the project with each module's data organized into separate sheets within the Excel file.
- Modify test datas directly in the Excel files as needed for test scenarios.


**NOTE : *Ensure your code adheres to the project's coding standards. If any further questions or need additional assistance, feel free 
to ask Automation Team!***

