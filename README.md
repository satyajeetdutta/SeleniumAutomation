 <h1>SeleniumAutomation</h1>
 <h2>TestVagrant Project</h2>
     In SeleniumAutomation Repository has test case implementation for movie release date and release country which needs to be validated in WikiPedia and IMDB. It allows you to change movie name as your like which can be changed in GlobalData.properties file which is present "TestVagrant\SeleniumAutomation\src\main\java\resources\GlobalData.properties" file path in the project . This makes it a perfect automation test case for general purpose usage. 
 <h2>Files and its Features</h2>
-Under src/main/java there are three packages namely AbstractComponents, PageObjects and Resources.<br>
-In AbstractComponents,there is a java file AbstractComponents which contains reusable components such as explicit wait.<br>
-In PageObjects,there are different java files which contains related page objects.<br>
-In resources, one java java file contains extent report declaration and properties file.<br>
-Similarly in src/test/java contains two packages namely test and testcomponts.<br>
-In test package,it contains test cases that needs to be run to see if we are getting the desired output or not.<br>
-In testComponent contains reusable test components such as testng listers and basetest java file. In basetest java file, it has lunching the browser ,terminating browser etc.<br>
  <h2>Test Case and its Execution</h2>
  To execute the test case we need to add particular test case name in testng.xml file which in present in testSuites folder, and we need to run them as testng suite. The default html report will be generate in reports folder.We can run the same testcase by going to the project folder in the pc and staring command prompt(in windows) or terminal(in macOS) and giving command as mvn test -P{ProfileIDName},where {ProfileIDName} is present in pom.xml file.
 <h2>Getting Started</h2>
 You need to have java and maven in your system with environment value setup done.If your are executing the test case in ecplise ,please install testng from eclipse market place. 