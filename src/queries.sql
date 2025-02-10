create table register(username varchar(200),Full_Name varchar(200),Email varchar(200),Sex varchar(20),Date_of_Birth date,Password varchar(100),Phone_No numeric(10,0),primary key(Username));
select * from register;
truncate table register
create table Donor(Donor_ID varchar(200),Name varchar(200),Age int,Sex varchar(20),Register_Date date,Blood_Type varchar(20),Blood_Quantity int,STATE varchar(200),CITY varchar(200),primary key(Donor_ID));
select * from Donor;