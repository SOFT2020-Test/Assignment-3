# Assignment-3   
- Jonatan Bakke https://github.com/JonatanMagnusBakke
- Jonas Hein - https://github.com/Zenzus
- Thomas Ebsen - https://github.com/Srax   
- [Assignment Link](Assignment-3-Description.pdf)  

## Setup
What you'll need:
1. Docker to set up a virtual mysql database.
2. MySQL Workbench or any mysql client.
3. Your favorite IDE that can run java, we use IntelliJ.

## How to run the project
1. Setup docker's virtual mysql server with this command: `docker run -d --rm --name mysql-test-db -e MYSQL_ROOT_PASSWORD=password -p 3307:3306 mysql`.
2. Connect to the docker database through your client with the username and password we setup earlier: `uname: root`, `pw: password`.
3. Setup your database by running this script:   
```MYSQL
CREATE SCHEMA IF NOT EXISTS BookingSystem;
use BookingSystem;

create table Customers (
	ID int not null auto_increment,
	firstname varchar(255) not null,
	lastname varchar(255),
	birthdate date,
	PRIMARY KEY (ID)
);

create table Employees (
       ID int not null auto_increment,
       firstname varchar(255) not null,
       lastname varchar(255) not null,
       birthdate date,
       PRIMARY KEY (ID)
 );
 
 create table Bookings (		
	ID int not null auto_increment,	
	customerId int not null,	
	employeeId int not null,	
	date Date not null,		
	start Time not null,		
	end Time not null,		
	primary key (ID),		
	foreign key (customerId)	
		references Customers(ID)
		on delete cascade,	
	foreign key (employeeId)	
		references Employees(ID)
		on delete cascade	
);

ALTER TABLE `BookingSystem`.`Customers` 
ADD COLUMN `phonenumber` VARCHAR(45) NULL AFTER `birthdate`;
```

Finally, clone the project and run it up in your favorite IDE. If setup correct you should see it running with all the tests passing.  
**NOTE:** You may have to run the test twice before everyone passes. It is because docker doesn't finish setting up the database before running some of the tests).
First Run (SETUP)        |  Second Run (SUCCESS)
:-------------------------:|:-------------------------:
![failed](/test-failing-screenshot.png)  |  ![passed](/test-passing-screenshot.png)
