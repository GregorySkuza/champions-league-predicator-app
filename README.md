
## About project:

My project is about to develop an application that returns most probable match results for UEFA Champions League.
Input data is attached in [BE_data.json] file. 

## How to run:
### 1. Clone the repository
   
   Please clone the repository by https or ssh (below example of use the https method).
```
git clone https://github.com/GregorySkuza/champions-league-predicator-app.git
```   
### 2. Create database 
You need a working mysql server to run this application.
Create a database. You can do this using the MySQL console or a graphical tool such as MySQL Workbench. 
Here is a sample SQL command to create a database:
``` 
CREATE DATABASE mydb; 
```

### 3.Run the database 

Configure the connection to the MySQL database. 
You can do this by adding the appropriate properties to the application configuration file or by using environment variables. 
Here is an example configuration for the application.properties file: 

``` 
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=<user_name>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update 
``` 
The configuration values listed above should be adapted to your environment.  

### 4.Run application 
You can do this using your IDE or the command line. 
Here is a sample command that will launch the application from the command line:

``` 
java -jar <file_name>.jar 
``` 
Now you can navigate to http://localhost:8080/swagger-ui.html#/ in your browser.
