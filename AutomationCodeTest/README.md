## DT Testing Chapter Automation Coding Test

## Get the code

Git: git clone https://github.com/IndumathiSubbiah/AutomationTestCode

## The project directory structure

```
src
  + test
    + java                          Test runners and supporting code
    + resources
      + features                    Feature files
      + drivers                     Bundled webdriver binaries
        + windows
          chromedriver.exe          OS-specific Webdriver binaries
```


## How to run Test cases

```
Method 1 : Run Tests from Command Line

Command 1 : mvn test
Command 2 : mvn test -Dcucumber.options="C:\Users\SAMSUNG\Desktop\todomvc-tests-master\todomvc-tests\src\test\resources\features\addToDoList.feature:16"
Command 3: mvn test -Dcucumber.options="--tags @MVCAppTest"
```

```
Method 2 : Run Tests with JUnit

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},
features= "src/test/resources/features",
tags= "@MVCAppTest"
```

```
Method 3 : Run Tests with Configurations

 - Select Run->Edit Configurations.
 - Select the Type of Configration ( Ex : testNG )
 - Provide the required details :
   1. JRE path
   2. Feature file path
   3. Environment Variable 
   4. Test Kind as Suite etc
```




