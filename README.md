# seleniumDemo
How to Install project in eclipse:

1. Install java jre 1.8
2. import the code as new Maven project into eclipse
3. Open Help -> Install new software and press Add button
4. Set name TestNG and Location http://dl.bintray.com/testng-team/testng-eclipse-release and click Add
5. Select the TestNG from the drop down menu in working with and wait for a bit until you see the testng checkbox below. Select it and press next untill you install it. At some point it will propmpt you and you need to choose install anyway. After that it will require restart.
6. Right click on the deus_automation project and select properties.
7. Select Build path and on the Libraries tab select JRE System Library, click edit and from execution environment select JavaSE-18(jre.1.8) and click OK
8. Also click Add Library and add TestNG. Click Apply and Close.
9. Right Click on the project and go to Maven -> Update Project..
10. Select everything except the first checkbox and press ok.
11. Download from https://chromedriver.chromium.org/downloads chomedriver (select the same version as your installed chrome) and save it on C:\MyTools\webdriver

In order to run it right navigate to src/main/resources and right click on DeusSuite.xml. Select run As TestNG Suite

What this demo suite does:
1. Open page and navigate to the given page
2. Login
3. Click on Qa Project
4. Upload a File
5. Verify its uploaded
6. Delete it
