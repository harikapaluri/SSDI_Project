/**** CREATE TABLE ****/
CREATE TABLE employeetbl (
        e_id INT NOT NULL AUTO_INCREMENT,
        e_name VARCHAR(100),
        e_email VARCHAR(200),
        e_gender VARCHAR(100),
        PRIMARY KEY (e_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**** INSERT RECORDS ****/
INSERT INTO employeetbl (e_id, e_name, e_email, e_gender) VALUES (100, 'Severus', 'severus.snape@hogwarts.com', 'F');
INSERT INTO employeetbl (e_id, e_name, e_email, e_gender) VALUES (101, 'Harry', 'harry.potter@hogwarts.com', 'M');
INSERT INTO employeetbl (e_id, e_name, e_email, e_gender) VALUES (102, 'April', 'april.o.neil@gmail.com', 'F');
INSERT INTO employeetbl (e_id, e_name, e_email, e_gender) VALUES (103, 'Daniel', 'daniel.atlas@eye.com', 'M');
INSERT INTO employeetbl (e_id, e_name, e_email, e_gender) VALUES (104, 'Albus', 'albus.dumbledore@hogwarts.com', 'M');
INSERT INTO employeetbl (e_id, e_name, e_email, e_gender) VALUES (105, 'Hermione', 'hermione.granger@hogwarts.com', 'F');

/**** DISPLAY RECORDS ****/
SELECT * FROM employeetbl;