# MyTheresa automation tests - Tom Dodd

## Pre-requisites to run code

You will need:

* Java 14 or above
* Maven

## How to run

The code can be built with maven as following:

    mvn clean test

There are currently 3 configuration files to choose from which can be viewed under src/test/resources/com/tom/bdd/config  
You can specify which config file to use as a parameter by -DconfigFile="_propertiles_file.properties_"   
For example:

    mvn clean test -DconfigFile="Firefox_Local_Config.properties"

These properties files allow the user to specify both the browser they want to use, and the
environment to run it in. By default it will run Chromium_Prod_Config.properties

The output will be a cucumber report which will give a temporary link to view in a webpage.

## Test case commentary

### Test case 1 - status codes and JS errors

    Implemented in WebPageHealth.feature 
    
    Given there are around 1700 hyperlinks on the homepage I decided to just test the 4 links at the top of the page so the
    test completes in a timely fashion. Typically I would automate crawling through hyperlinks via the API rather than as a UI test.

### Test case 2 - test login functionality

    Implemented in Login.feature

    This test will fail as expected. Upon clicking the login button it attempts to get a reCAPTCHA however this always fails to connect (I tested this on the homepage flyout login too). 
    In my experience we would disable captcha in the test environments which would sidestep this issue. 
    If there CAPTCHA could connect I would attempt to get the URL in the dom and submit it (after a few seconds to mimic human interaction).
    From what I have read there are some external libraries that deal with CAPTCHA issues also.

### Test case 3 - view Open pull requests and output to CSV

    I didn't implement this but here is what I would do:

    For the number of open pull requests:
    * Navigate to https://github.com/appwrite/appwrite/pulls
    * Using playwright get a locator for the open pull requests number displayed on the page - print this out as part of the test

    For the PR list in CSV format
    * Navigate to https://github.com/appwrite/appwrite/pulls
    * Create an object called PullRequest which holds PR name, created date and author
    * Create a new list<PullRequest> object for storing each PullRequest object
    * Grab a locator that matches each PR in the displayed list, loop through them and add to our list<PullRequest>
    * We will need sub-locators to match the PR name, created date and author - this may require another page object for each PR row
    * Using the data-total-pages element keep looping through each page until there are no more pages remaining, adding each pullRequest to the list along the way
    * Once we have our full list of PRs I would use a third party library called OpenCSV to write each PullRequest object to a row on in a CSV file

### Further improvements

Just some other improvments I would like to make to this framework given the time:

* Upon failure take a screenshot and provide additional debug logging
* A pageobject manager so we only need to instantiate page objects once
* isLoadedChecks - A check if the page has loaded correctly by attempting to locate a locator
  specific to that page
