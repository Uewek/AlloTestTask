        Test task for QaTestLab

        Please create a Selenium-based framework using the following Portal:
https://rozetka.com.ua/ua/. (Rozetka upgrade security, so I do task on https://allo.ua)
● Your framework should be able to execute tests in multiple threads in at least
Google Chrome and Mozilla Firefox browsers.
● Ensure that your framework is easily configurable to change the execution
platform (OS: Windows, MacOS, Linux) and test execution browser.
● Please use a reliable elements’ location strategy.
● Implement the Page Object pattern for the test automation structure.
● Use any compatible with the Selenium programming language you prefer.

Steps to automate:
I. Search for a product
1. Open the Rozetka website.
2. Enter a search term (e.g., "iPhone") into the search bar.
3. Click the search icon or press Enter.
4. Assert that at least two search results related to the entered term are
      displayed.
      II. Filter results
1. Repeat all the steps from case I.
2. Filter items by price (e.g. from 30000 to 40000 UAH).
3. Assert that items are exactly what you requested and are filtered correctly.

Additional:
The following tasks are optional and will not affect the final grade of your work but
are considered a plus:
● Add Allure as a reporting tool for test results to your framework.
● Add the ability to change the browser on which tests will be executed from the
command line.

        Installation
1. Simply copy all files from repository in that place what you want! But for successful execution
on your computer must be installed Java and Maven!


        Execution
1. Open project root folder.
2. Open terminal.
3. Run one of below CLI commands (without " ").


    CLI Commands
1. Command "mvn test" - standard run in default configuration (OS - Linux, Browser -Chrome);
2. Command "mvn test -DplatformAndBrowser=<os>_<browser>" - run with selected not default platform and browser
(present 4 variants: linux_chrome, windows_chrome, linux_firefox, windows_firefox) if you set some another value ;
test suite will fall by exception.
3. Command "mvn -Dmaven.surefire.debug test" run in default configuration with debugger. Yor IDE
must be configured!
4. Command like "mvn -Dmaven.surefire.debug test -DplatformAndBrowser=linux_chrome" run in debug mode with chosen
OS and Browser combination.