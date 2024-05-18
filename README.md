Automation script for Webook web application

Installation Process:
1- Install Java JDK 11 on the machine and create an environment variable to check that it's run globally 
2- Install Apache Maven through this link as per machine requirments https://maven.apache.org/download.cgi and create an environment variable to run it globally 
3- Install Eclips IDE to run the environment
4- Download and install TestNG blugin upon Eclips IDE to ensure that it will work as expected 

====================================

Build the Framework
1- Create a Maven project through eclips
2- Add All the dependencies in the pom.xml file 
   I used selenium version 4.20 so it will not required to download any driver , TestNg 7.8 
3- I used BeforeTest and AfterTest annotations so this has a lot of benifits as will prevent dublication of initialization and tearDown the browser each time
3- Run the WeBookRegistration Class as TestNG test



 I have created a method to generate a rondom email each time using timeStampe to register with unique email every time
 
