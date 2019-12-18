INSERT INTO `student` VALUES
(1,'Keanu','Andrew','Reeves', '86030503227', '1978-06-05'),
(2,'John','George','Doe', '66020303227', '1966-02-03'),
(3,'Jet','Bill','Lee', '86042303227', '1986-04-23'),
(4,'Angelina','Mary','Jolie', '88071103227', '1988-07-11'),
(5,'Drew','Andy','Barrymore', '80111003227', '1980-11-10');

    INSERT INTO `address` VALUES
	(1,'Lipowa 11','Warszawa','20-722','Zamieszkania'),
	(2,'Krakowska 2','Lublin','20-522','Zamieszkania'),
	(3,'Parkowa 2/8','Katowice','10-546','Zamieszkania'),
	(4,'Zamkowa 21','Zabrze','66-854','Korespondencyjny'),
	(5,'Rynek 9','Lublin','20-123','Zamieszkania'),
	(6,'Zielona 10','Warszawa','20-700','Zamieszkania');


    INSERT INTO `student_address` VALUES
	(1,1,2),
	(2,2,1),
    (3,2,4),
	(4,3,3),
	(5,4,5),
	(6,5,6);
