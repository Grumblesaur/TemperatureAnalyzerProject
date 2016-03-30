CREATE TABLE APP.LOCATION (
  "Symbol" VARCHAR(45) NOT NULL primary key,
  "Location" VARCHAR(45) NOT NULL);


CREATE TABLE APP.SENSOR (
  "Serial_Number" INT NOT NULL primary key,
  "Location_Symbol" VARCHAR(45)
        NOT NULL REFERENCES APP.LOCATION ("Symbol"));


CREATE TABLE APP.MEASUREMENT (
  "Temperature" INT NOT NULL,
  "Date" DATE,
  "TIME" TIME,
  "Location_Symbol" VARCHAR(45) NOT NULL 
        REFERENCES APP.Location ("_Symbol"));
  
 
