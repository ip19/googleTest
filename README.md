Framework: TestNg;


build automation system: Gradle;


Parametrization: Domain, Browser, Resolution (base.properties file);


logger: slf4j (logback.xml file);


Parallelization: "maxParallelForks = 2" into build.gradle file;


Reporting: Allure

HOW TO RUN TESTS:

There are 3 ways:

1. Clicking on run button in intellij idea (one by one running).

2. Using gradle panel on the right side of Intellij idea (will execute tests in parallel):

a) Click on Gradle panel;

b) Click on build folder;

c) Execute build task.

3. Execute 'gradle build' command (will execute tests in parallel).

HOW TO RUN TESTS + ALLURE REPORT:

1. Using gradle panel on the right side of Intellij idea (will execute tests in parallel):

a) Click on Gradle panel;

b) Click on build folder;

c) Execute build task.

2. Using same gradle panel:

a) Click on other folder;

b) Execute allureReport task (to generate report);

c) Execute allureServe task (to view report);
