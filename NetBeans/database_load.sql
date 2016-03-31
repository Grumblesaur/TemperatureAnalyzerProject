CREATE TABLE APP.LOCATION (
  Symbol VARCHAR(3) NOT NULL unique primary key,
  Location VARCHAR(45) NOT NULL),
    CONSTRAINT unique (Symbol);

CREATE TABLE APP.SENSOR (
  Serial_Number INT NOT NULL primary key,
  Location_Symbol VARCHAR(3)
        NOT NULL REFERENCES APP.LOCATION (Symbol));


CREATE TABLE APP.MEASUREMENT (
  Temperature INT NOT NULL,
  DMY DATE,
  Clock TIME,
  Location_Symbol VARCHAR(3) NOT NULL 
        REFERENCES APP.Location (Symbol));
  
 
