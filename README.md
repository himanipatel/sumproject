# Sum Project
Application which will perform sum of digits within input string.
 
- This is Java 8 Maven application.
- It have below features:
	- Accepts command to either read input string from file OR from command-prompt OR accept hexadecimal string
	- Accepts input string and provide sum of digits in base 10
	- Read from file (file name is configurable in config.properties), and provide sum of all digits inside it
	- Perform sum of hexadecimal digits and provide sum in base 10 

- It have 4 packages
- com.comcast.sumproject.executor: Contains main method class
- com.comcast.sumproject.service: Contains Interface( wrapper layer) for service classes
- com.comcast.sumproject.service.impl: Contains service implementation (Actual business logic)
- com.comcast.sumproject.util: Contains util classes like ConfigManager (Singleton class to load property file)

- Automated Test Cases
- 17 test cases to check logic with various inputs

Follow the steps to build/test and execute: 
1) Build maven project with "mvn clean install" command. This will build the project and execute automated test cases.
2) Run the application: Go to target directory and execute java -jar sumproject-exec.jar command, provide input as prompted

- I have developed,test and execute this application using eclipse