# Spring Boot Demo

The spring boot application exposes Employee information and details stored in In-memory DB H2 through REST API


### Features

 1. H2 : The application will create a in-memory db and populate the data using `schema.sql` and `data.sql`
 2. Logs all HTTP request and response
 3. Unit Test: The application has controller test cases for controller which validate all methods
 


### Instructions

1. Build the executable jar

	` mvn package`
	
2. The build jar is available at `./target/springboot-demo-0.0.1-SNAPSHOT.jar`. Run the jar

	`java -jar ./target/springboot-demo-0.0.1-SNAPSHOT.jar`


### API References

1. GET /check/networkaccess

	The endpoint is to check if the application can access external API
	
	Query Params:- 
	
		1. url : The endpoint to test connectivity
		
	Curl:- 
	
		Request:
	
			```
			curl --location 'localhost:8080/check/networkaccess?url=https%3A%2F%2Fwww.google.com%2F'
		
			```
		
		Response:
	
			Status: 200
		
			```
			<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="en-MY"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="zhYwX1vOlUi7tBYPUSSF1A">(function(){var _g={kEI:'oofuZs7aM4_n0PEPmtva-Qs',kEXPI:'0,793344,2906935,1102,3,48,538613,2872,2891,89155,18161,162437,23024,6700,41948,84371,8155,23350,22436,9779,62658,76208,15816,1804,7734,19358,8176,11814,1635,29276,27083,5212676,998,138,7,4,5991283,2841102,263,305,134,3,5,1,27980322,16673,43886,3,1603,3,2124363,23029351,8163,4636,14986,1450,84045,11647,1672,9304,15164,8181,28847,20583,21669,6755,155,2484,21239,9140,679,4,3916,328,3217,4,1238,1766,7586,5,9143,3,3864,5720,1669,5633,687,7796,3,3015,2695,519,3960,1891,9976,682,282,377,5406,443,2002,829,4971,56,49,2164,2,9,13408,2381,1482,980,529,2767,692........
			```

2. GET /employees/list

	The endpoint retrieve Employee basic information Employee Id, First Name & Last Name

	Curl:- 
	
		Request:
	
			```
			curl --location 'localhost:8080/employees/list'
			
			```
		
		Response:
	
			Status: 200
		
			```
			[
				{
					"employeeId": 1,
					"firstName": "Abe",
					"lastName": "Lincoln"
				},
				.....
		
			```
	
3. POST /employees
	
	The endpoint lets to add new employee to DB
	
	Request body:-
	
		1. employeeId : New employee's id
		2. firstName : First name of the new employee
		3. lastName : Last name of the new employee
	
	Curl:- 
	
		Request:
	
			```
			curl --location 'localhost:8080/employees' \
				 --header 'Content-Type: application/json' \
                 --data '        {
									"employeeId": 10,
									"firstName": "Peter",
									"lastName": "Parker"
								}'
			
			```
		
		Response:
	
			Status: 200
		
			```
			{
				"employeeId": 10,
				"firstName": "Peter",
				"lastName": "Parker"
			}
		
			```
	
4. PUT /employee/{employeeId}

	The endpoint lets you update the basic information of an existing employee
	
	Path parameters:-
	
		1. employeeId : Employee if of the employee whose details you want to update
	
	Request body:-
	
		1. employeeId : Existing employee's id
		2. firstName : First name of the employee
		3. lastName : Last name of the employee
	
	Curl:- 
	
		Request:
	
			```
			curl --location --request PUT 'localhost:8080/employees/10' \
				 --header 'Content-Type: application/json' \
				 --data '        {
									"employeeId": 10,
									"firstName": "Peter Benjamin",
									"lastName": "Parker"
								}'
			
			```
		
		Response:
	
			Status: 200
		
			```
			{
				"employeeId": 10,
				"firstName": "Peter Benjamin",
				"lastName": "Parker"
			}
		
			```
	
5. DELETE /employee/{employeeId}

	The endpoint lets you deletes an employee basic information from the db
	
	Path parameters:-
	
		1. employeeId : Employee if of the employee whose details you want to update
	
	Curl:- 
	
		Request:
	
			```
			curl --location --request DELETE 'localhost:8080/employees/10'
			
			```
		
		Response:
	
			Status: 200
		
			```
			{
				"employeeId": 10,
				"firstName": "Peter Benjamin",
				"lastName": "Parker"
			}
		
			```

6. GET /employee/details

	The endpoint exposes both basic and employement details like employment type, region/location, designation, email address and years of service from the db
	
	Curl:- 
	
		Request:
	
			```
			curl --location 'localhost:8080/employees/details'
			
			```
		
		Response:
	
			Status: 200
		
			```
			[
				{
					"employeeId": 1,
					"firstName": "Abe",
					"lastName": "Lincoln",
					"employeeType": "permanent",
					"region": "usa",
					"designation": "president",
					"email": "abe.lincoln@us.com",
					"yearsOfService": "8"
				},
				.....
		
			```
	
7. GET /employee/details/search

	The endpoint lets users search/filter employee using their employment details and returns paginated response
	
	Query Parameters:-
	
		1. employeeType : filter employees by their employment type
		2. region : filter employees by their region
		3. designation : filter employees by their position/designation
		4. email : filter employee by email address
		5. yearsOfService : filter employee by their years of service
		6. pageSize : the page size for pagination
		7. pageNumber : the page number of the pagination
	
	Curl:- 
	
		Request:
	
			```
			curl --location 'localhost:8080/employees/details/search?region=uk&pageNumber=2&pageSize=2'
			
			```
		
		Response:
	
			Status: 200
		
			```
			{
				"pageNumber": 2,
				"pageSize": 2,
				"totalResults": 3,
				"totalPages": 2,
				"pageData": [
					{
						"employeeId": 5,
						"firstName": "Aubree",
						"lastName": "Spence",
						"employeeType": "permanent",
						"region": "uk",
						"designation": "employee",
						"email": "aubree.spence@uk.com",
						"yearsOfService": "7"
					}
				]
			}
		
			```
			
### Postman project

[Employee Postman](Employee.postman_collection.json)
	

