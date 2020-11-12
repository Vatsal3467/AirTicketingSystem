CREATE TABLE Flight_Detail(
f_id INT PRIMARY KEY,
f_arrival VARCHAR(20),
f_departure VARCHAR(20),
f_datetime date,
Price INT

);

INSERT INTO Flight_Detail VALUES (1,'Toronto','Montreal','2020-11-10',400);
INSERT INTO Flight_Detail VALUES (2,'Toronto','Ottawa','2020-11-15',500);
INSERT INTO Flight_Detail VALUES (3,'Toronto','Vancouver','2020-11-19',460);
INSERT INTO Flight_Detail VALUES (4,'Toronto','Saskatoon','2020-11-25',300);
INSERT INTO Flight_Detail VALUES (5,'Montreal','Edmonton','2020-11-18',400);
INSERT INTO Flight_Detail VALUES (6,'Ottawa','Calgary','2020-11-28',480);
INSERT INTO Flight_Detail VALUES (7,'Saskatoon','Vancouver','2020-12-15',470);
INSERT INTO Flight_Detail VALUES (8,'Ottawa','Edmonton','2020-12-03',600);
INSERT INTO Flight_Detail VALUES (9,'Vancouver','Saskatoon','2020-12-05',370);
INSERT INTO Flight_Detail VALUES (10,'Montreal','Calgary','2020-12-10',490);


select * from Flight_Detail;

