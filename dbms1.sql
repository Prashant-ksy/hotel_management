-- Create the database
CREATE DATABASE HotelManagement;

-- Use the new database
USE HotelManagement;

-- Table for Hotel
CREATE TABLE Hotel (
    Hotel_ID INT PRIMARY KEY AUTO_INCREMENT,
    H_Name VARCHAR(100),
    Location VARCHAR(255),
    E_mail VARCHAR(100),
    Contact_No VARCHAR(15)
);

-- Table for Room
CREATE TABLE Room (
    Room_No INT PRIMARY KEY AUTO_INCREMENT,
    Type VARCHAR(50),
    Status VARCHAR(20),
    Hotel_ID INT,
    FOREIGN KEY (Hotel_ID) REFERENCES Hotel(Hotel_ID)  -- Room to Hotel (Has, N to 1)
);

-- Table for Hall
CREATE TABLE Hall (
    Hall_ID INT PRIMARY KEY AUTO_INCREMENT,
    Capacity INT,
    CommUnit VARCHAR(50),
    Hotel_ID INT,
    FOREIGN KEY (Hotel_ID) REFERENCES Hotel(Hotel_ID)  -- Hall to Hotel (Banquet, 1 to N)
);

-- Table for Table (Guest seating)
CREATE TABLE Table_Seating (
    Table_ID INT PRIMARY KEY AUTO_INCREMENT,
    Capacity INT,
    Availability VARCHAR(20)
);

-- Table for Employee
CREATE TABLE Employee (
    Emp_ID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Position VARCHAR(50),
    HireDate DATE,
    Salary DECIMAL(10, 2),
    DOB DATE,
    Hotel_ID INT,
    FOREIGN KEY (Hotel_ID) REFERENCES Hotel(Hotel_ID)  -- Employee to Hotel (Works_In, N to 1)
);

-- Table for Menu (Dishes)
CREATE TABLE Menu (
    Dish_ID INT PRIMARY KEY AUTO_INCREMENT,
    D_Name VARCHAR(100),
    Price DECIMAL(10, 2),
    Description TEXT,
    Hotel_ID INT,
    FOREIGN KEY (Hotel_ID) REFERENCES Hotel(Hotel_ID)  -- Menu to Hotel (Restaurant, 1 to N)
);

-- Table for Guest
CREATE TABLE Guest (
    Guest_ID INT PRIMARY KEY AUTO_INCREMENT,
    F_Name VARCHAR(50),
    L_Name VARCHAR(50),
    DOB DATE,
    Phone_No VARCHAR(15),
    Address VARCHAR(255),
    Hotel_ID INT,
    FOREIGN KEY (Hotel_ID) REFERENCES Hotel(Hotel_ID)  -- Guest to Hotel (optional)
);

-- Table for Order
CREATE TABLE Order_Details (
    Order_ID INT PRIMARY KEY AUTO_INCREMENT,
    DateTime DATETIME,
    Amount DECIMAL(10, 2),
    Guest_ID INT,
    FOREIGN KEY (Guest_ID) REFERENCES Guest(Guest_ID),
    Table_ID INT,
    FOREIGN KEY (Table_ID) REFERENCES Table_Seating(Table_ID)  -- Order to Table (On, N to 1)
);

-- Table for Payment
CREATE TABLE Payment (
    Pay_ID INT PRIMARY KEY AUTO_INCREMENT,
    Method VARCHAR(50),
    Status VARCHAR(20),
    DateTime DATETIME,
    Order_ID INT UNIQUE,
    FOREIGN KEY (Order_ID) REFERENCES Order_Details(Order_ID)  -- Order to Payment (Pay, 1 to 1)
);

-------------------------------------------------
-- M-to-N Relationship Tables
-------------------------------------------------

-- Table for Guest <-> Room (Booking) with extra attributes
CREATE TABLE Booking (
    Guest_ID INT,
    Room_No INT,
    Amount DECIMAL(10, 2),
    C_in DATE,
    C_out DATE,
    PRIMARY KEY (Guest_ID, Room_No),
    FOREIGN KEY (Guest_ID) REFERENCES Guest(Guest_ID),
    FOREIGN KEY (Room_No) REFERENCES Room(Room_No)
);

-- Table for Guest <-> Hall (Reservation) with extra attributes
CREATE TABLE Reservation (
    Guest_ID INT,
    Hall_ID INT,
    Amount DECIMAL(10, 2),
    FromDate DATE,
    ToDate DATE,
    Type VARCHAR(50),
    PRIMARY KEY (Guest_ID, Hall_ID),
    FOREIGN KEY (Guest_ID) REFERENCES Guest(Guest_ID),
    FOREIGN KEY (Hall_ID) REFERENCES Hall(Hall_ID)
);

-- Table for Menu <-> Order (What) with extra attribute Quantity
CREATE TABLE What (
    Order_ID INT,
    Dish_ID INT,
    Quantity INT,
    PRIMARY KEY (Order_ID, Dish_ID),
    FOREIGN KEY (Order_ID) REFERENCES Order_Details(Order_ID),
    FOREIGN KEY (Dish_ID) REFERENCES Menu(Dish_ID)
);

-- Table for Room <-> Payment (Booking with Room)
CREATE TABLE Room_Payment (
    Room_No INT,
    Pay_ID INT,
    PRIMARY KEY (Room_No, Pay_ID),
    FOREIGN KEY (Room_No) REFERENCES Room(Room_No),
    FOREIGN KEY (Pay_ID) REFERENCES Payment(Pay_ID)
);

-- Commit the changes
COMMIT;
