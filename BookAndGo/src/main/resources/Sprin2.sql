INSERT INTO hotel 
VALUES
( 'Hilton', 2001, '123 UNCC BLD Charlotte NC', 0006, 01),
( 'Days Inn', 2002, '124 UNCC BLD Charlotte NC', 0001, 02),
('Stay In', 2003, '123 UNCC BLD Charlotte NC', 0007, 03);

CREATE TABLE event_table
(
 event_name VARCHAR (25),
 event_id INT (4) PRIMARY KEY,
 event_times VARCHAR(25),
 hotel_id int(25)
 );
 
 CREATE TABLE room
 (
 hotel_id int(25),
 room_id int(25) PRIMARY KEY,
 room_floor int(25),
 room_type VARCHAR (25),
 roomAvailableFlag VARCHAR (25),
 no_of_beds int(25)
 );

ALTER TABLE Hotel CHANGE Room_id room_id  int(25);

CREATE TABLE book(
booking_id int(25) PRIMARY KEY,
room_id int(25) ,
users_nameFirst VARCHAR (25),
users_email VARCHAR (25)

);
CREATE TABLE Payment(
booking_id int(25),
payment_id int(25) PRIMARY KEY,
payment_date DATETIME

);