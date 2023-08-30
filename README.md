# README (Small world financial test)

This readme includes the setup process and project dependencies w.r.t their versions so that the reviewer can get the project set and run.

## Toolset w.r.t Requirement
### Mandatory tools

| Tool            | Version |
|-----------------|---------|
| `Java`          | 18      |
| `Selenium 4`    | 4.8.2   |
| `cucumber BDD`  | 7.3.3   |
| `Maven`         | 18      |


### Optional Tools
| Tool              | Version | Remarks                                                                                                                                             |
|-------------------|---------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| `Allure reports`  | 2.19.0  | allure reports are integrated with cucumber the report generation and hosting commands will be described below                                      |
| `cucumber TestNG` | 7.3.3   | this module is integrated just for the sake of cucumber test runner so the tests can be integrated, also it can provide its separate reports itself |
### Additional tool/utility
| Tool                              | Version | Remarks                                                                                                                                                                                                                                                                                                                          |
|-----------------------------------|--------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Apache poi` `Excel Reader`       | 5.2.2  | this is an entirely additional feature just to showcase my ability, this module is used to implement the excel reader. Which will provide the facility to read the data from excel files within the umbrella of cucumber bdd. This is an extension as cucumber doest support to read data from excel file like the specflow does |
| `Surefire plugins`                | 1.28.1 | these plugins were integrated so the code can be executed using cli, generation and management of result directories of allure reports                                                                                                                                                                                           |

## How to set up?

1. Install java
2. install git
3. clone repository 
```sh
$ git clone https://github.com/areeq-azam/small-world-test.git
```
4. open project in any IDE
5. load dependencies from pom.xml
6. now simply execute cases by right clicking and then executing of either testng.xml or WebRunner.java
7. after successful execute you can find a cucumber generated and hosted report at the end of the result logs which will look like somewhat. click the url like below which will redirect you to the cucumber report
``` text
┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/db9ecb66-429e-4e18-b5ae-801835d432e3 │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │

===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================


Process finished with exit code 0
└──────────────────────────────────────────────────────────────────────────┘
```
8. if we want the allure report then we'll have to observe that after the execution, the folder allure-results right above the src will be generated which contains the raw data for allure report
9. install allure cli
10. then execute below command. The command will generate and host the locally generated allure report. allure-results are intentionally pushed to github so that the reviewer can have idea how it looks like
```sh
$ allure serve
```

## Project Description
this repository contains 2 main packages i.e. main and test
### 1. Main dir
main directly mostly contains the utility which were required to provide the support to the test scripts and the page elements
#### 1.1 Core utils
this package consist of json and excel reader and generic web driver implementation along with the selenium helper class which contains the ui functions
#### 1.2 Page factory
this package contains a unique but a very useful implementation Page object model. which has very minimal chances of element redundancy and code error by the manual team by providing the simple way of storing the page elements in separate json files along with the locator type
### 2. Test dir
#### 2.1 Hooks class
this class contains before and after hooks which will be executed before and after of every scenario to init and tear down the web driver
#### 2.2 WebRunner class
this class contains the implementation of runners and plugins required by cucumber. allure and other configs binded with cucumber can be handled in this class. the main purpose of this class is to execute the cases
#### 2.3 web suite
this package consists of 3 sub packages to ultimately manage the tests
##### 2.3.1 Feature
this package contains the .feature files, now there are 2 different feature file ***login.feature file uses excel reader to provide an idea of how the test data can be managed through excel files which will ultimately help with the larger dataset for a single case*** and another feature file i.e. ***Home.feature includes the imp test cases with respect to the user journeys and THIS FILE DOES NOT USES EXCEL FILES to read the data for scenario outlines***
##### 2.3.2 Data
this package contains the excel files required by login.feature
##### 2.3.3 Step Definitions
this package contains the step definitions for all the steps. surprisingly there are hardly 4-5 completely reusable steps. The re-usability will ensure the code cleanness, as it guarantees max usage with minimum code redundancy. This style of scripting ensures the maximum utilization of manual QA folks for the purpose of automation.