--
-- Sample dataset containing a number of client and Policies
--

-- =================================================================================================
--CLIENT
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (1,'firstname','lastname','admin1','pass1234','HR_MANAGER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (2,'firstname','lastname','admin2','pass1234','HR_MANAGER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (3,'firstname','lastname','user1','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (4,'firstname','lastname','user2','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (5,'firstname','lastname','user3','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (6,'firstname','lastname','user4','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (7,'firstname','lastname','user5','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (8,'firstname','lastname','user6','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (9,'firstname','lastname','user7','pass1234','USER')
INSERT INTO client (client_id,firstname,lastname,username,password,"role") VALUES (9,'firstname','lastname','user8','pass1234','USER')



--INSURANCE_CONTRACT
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (178,'2006-02-03','2016-10-10',0.85156088,'ACTIVE','LIFE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (179,'1981-05-20','2010-06-10',0.101726464,'ACTIVE','LIFE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (180,'1989-08-25','1993-02-17',0.249593552,'ACTIVE','VEHICLE',10)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (163,'1992-06-04','1986-03-16',0.9609156,'ACTIVE','LIFE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (165,'1983-04-29','2016-09-15',0.756230848,'ACTIVE','LIFE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (174,'2000-06-25','1984-07-02',0.1426147456,'ACTIVE','MOBILE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (176,'1986-09-03','2003-06-05',0.1208914688,'ACTIVE','VEHICLE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (142,'1997-04-15','1989-10-25',0.1332809088,'ACTIVE','PROPERTY',4)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (146,'2012-02-14','2017-01-05',0.66344864,'INACTIVE','PROPERTY',4)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (156,'1980-12-05','1983-06-17',0.795561856,'INACTIVE','LIFE',4)


INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (169,'2014-06-26','1991-11-12',0.270854336,'ACTIVE','MOBILE',4)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (177,'2000-12-09','1998-08-03',0.479817696,'ACTIVE','MOBILE',4)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (155,'1981-01-22','2000-07-08',0.518229312,'ACTIVE','LIFE',5)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (168,'2013-02-19','1999-06-01',0.17146824,'ACTIVE','MOBILE',5)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (123,'2014-03-01','1987-01-27',0.283849984,'ACTIVE','MOBILE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (131,'1989-09-18','1998-05-27',0.1185411968,'ACTIVE','MOBILE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (137,'2018-09-16','1994-04-19',0.1103688448,'ACTIVE','MOBILE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (138,'2014-10-20','1987-01-11',0.1138339712,'ACTIVE','MOBILE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (150,'2009-11-27','2003-03-14',0.284599136,'ACTIVE','PROPERTY',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (157,'1991-08-17','2011-04-08',0.1546148352,'ACTIVE','PROPERTY',6)


INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (162,'1981-12-16','1983-11-15',0.1403939328,'ACTIVE','MOBILE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (164,'1987-07-19','2010-04-10',0.84383736,'ACTIVE','LIFE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (166,'1982-07-27','1994-09-25',0.38034432,'ACTIVE','LIFE',6)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (133,'2011-03-14','2006-01-24',0.876632384,'ACTIVE','PROPERTY',7)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (147,'2017-07-12','1985-02-26',0.1043041536,'ACTIVE','VEHICLE',7)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (149,'1987-08-04','1981-08-14',0.602429632,'ACTIVE','PROPERTY',7)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (171,'2013-08-02','1994-04-14',0.1308986496,'ACTIVE','PROPERTY',7)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (127,'1987-12-20','2010-02-09',0.111838272,'ACTIVE','MOBILE',8)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (132,'2000-04-24','1995-06-21',0.519472736,'ACTIVE','PROPERTY',8)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (152,'2016-02-28','1983-06-11',0.694382912,'ACTIVE','LIFE',8)


INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (170,'2001-03-01','1987-02-09',0.929302912,'ACTIVE','PROPERTY',8)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (122,'1983-06-01','2018-09-05',0.32576064,'ACTIVE','PROPERTY',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (128,'1983-05-07','2000-04-07',0.252670144,'ACTIVE','VEHICLE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (129,'1980-06-05','2007-08-24',0.620943936,'ACTIVE','VEHICLE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (135,'2016-08-14','1995-10-12',0.48100592,'ACTIVE','LIFE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (136,'2013-02-09','1993-10-02',0.1189444864,'ACTIVE','VEHICLE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (141,'2004-02-29','2006-05-24',0.1356500352,'ACTIVE','MOBILE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (143,'2008-11-10','2003-07-05',0.982189888,'ACTIVE','VEHICLE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (148,'1991-04-22','1993-09-14',0.1139140352,'ACTIVE','VEHICLE',9)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (173,'1986-06-18','1983-04-13',0.145100992,'ACTIVE','MOBILE',9)


INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (121,'1984-08-14','2004-05-04',0.264326432,'ACTIVE','PROPERTY',10)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (124,'1999-12-01','1998-11-03',0.352670784,'ACTIVE','VEHICLE',10)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (139,'2003-07-21','1994-11-28',0.1209460992,'ACTIVE','VEHICLE',10)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (140,'2015-03-13','1999-10-21',0.626475712,'ACTIVE','LIFE',10)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (175,'2013-05-07','1994-12-21',0.1560178816,'ACTIVE','VEHICLE',10)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (125,'2003-12-03','1988-03-22',0.503096192,'ACTIVE','PROPERTY',1)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (126,'1991-08-11','2005-06-24',0.94276544,'ACTIVE','LIFE',1)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (130,'1981-11-12','2016-01-29',0.61083628,'ACTIVE','MOBILE',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (134,'2010-04-30','1989-05-13',0.193699104,'ACTIVE','VEHICLE',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (144,'2011-11-03','1981-01-23',0.7539744,'ACTIVE','MOBILE',3)


INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (145,'1999-05-06','2008-10-25',0.82308096,'ACTIVE','LIFE',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (151,'1983-04-30','1996-04-23',0.979314432,'ACTIVE','PROPERTY',1)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (153,'2014-04-06','1981-10-27',0.1128182912,'ACTIVE','LIFE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (154,'2004-08-11','2012-11-06',0.520533568,'ACTIVE','LIFE',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (158,'2005-01-15','2011-03-16',0.317441824,'ACTIVE','VEHICLE',3)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (159,'2010-04-12','2004-01-21',0.764181952,'ACTIVE','PROPERTY',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (160,'2002-06-14','2003-01-08',0.5397824,'ACTIVE','MOBILE',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (161,'1995-06-29','1983-11-06',0.16857984,'ACTIVE','PROPERTY',1)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (167,'1990-12-27','1995-10-23',0.140031104,'ACTIVE','PROPERTY',2)
INSERT INTO contract (contract_id,effective_date,expiration_date,premium_amount,contract_status,contract_type,client_id) VALUES (172,'2014-09-22','2007-12-07',0.1545466752,'ACTIVE','LIFE',1)


--LIFE_CONTRACT
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('llamco laboris nisi ut aliquip ex ea commodo consequat. Dui',20,0.510359872,'GOOD',178)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('henderit in voluptate velit esse cillum dolore eu fugiat nulla ',33,0.233521024,'GOOD',156)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('t non proid',15,0.1051148864,'GOOD',153)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('iusmod tempor incididunt',67,0.120183552,'GOOD',164)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('abore et dolore magna aliqua. Ut',86,0.189343168,'GOOD',166)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('inim veniam, quis nostrud exercitatio',23,0.274340608,'GOOD',155)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('nsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugi',76,0.1503051264,'GOOD',135)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('r. Exc',35,0.761371328,'GOOD',140)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('nostrud exercitation ullamco laboris nisi ut aliquip ',72,0.306899968,'GOOD',179)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('itation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in repr',90,0.308154624,'GOOD',152)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('um',66,0.655297344,'GOOD',165)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('um',66,0.655297344,'GOOD',163)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('nostrud exercitation ullamco laboris nisi ut aliquip ',72,0.306899968,'GOOD',126)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('t non proid',15,0.1051148864,'GOOD',145)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('llamco laboris nisi ut aliquip ex ea commodo consequat. Dui',20,0.510359872,'GOOD',172)
INSERT INTO life_contract (beneficiary,secured_age,insured_value,medical_record,contract_id) VALUES ('r. Exc',35,0.761371328,'GOOD',154)


--MOBILE_CONTRACT
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (3,'XIAOMI','LAPTOP',144)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (2,'XIAOMI','MOBILE',127)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (4,'SAMSUNG','MOBILE',173)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (5,'SAMSUNG','MOBILE',138)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (8,'SAMSUNG','MOBILE',137)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (10,'DELL','LAPTOP',131)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (11,'APPLE','LAPTOP',130)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (12,'APPLE','MOBILE',162)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (13,'APPLE','MOBILE',160)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (14,'APPLE','MOBILE',141)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (15,'OTHER','MOBILE',169)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (16,'OTHER','MOBILE',174)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (17,'OTHER','MOBILE',168)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (18,'OTHER','MOBILE',123)
INSERT INTO mobile_contract (imei,device_model,device_type,contract_id) VALUES (19,'APPLE','MOBILE',177)
;

--PROPERTY_CONTRACT
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (1,0.1336324736,1983,161)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (5,0.711162176,1983,167)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (7,0.94931672,1967,122)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (8,0.1348241024,1967,146)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (10,0.1028578,2000,121)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (11,0.146450432,2000,159)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES(12,0.14712864,2000,125)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES(13,0.398445248,2005,142)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES(14,0.1089001856,2005,170)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES(15,0.316676224,2005,151)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES(16,0.316676224,2007,150)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (18,0.94931672,1967,157)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (19,0.1028578,2000,149)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES(20,0.1089001856,2005,171)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (1,0.1336324736,1983,132)
INSERT INTO property_contract (national_registry_number,objective_value,construction_year,contract_id) VALUES (21, 0.94931672,1967,133)


--VEHICLE_CONTRACT
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (1,'ABC-1234',0.1189090048,1985,158)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (2,'ABC-1234',0.459163712,1985,147)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (5,'ABC-1234',0.1409983488,1985,139)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (8,'ABC-1234',0.22041264,1985,176)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (9,'ABC-1234',0.19858718,1985,180)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (4,'ABC-1234',0.108468608,1985,134)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (5,'ABC-1234',0.980519488,1985,175)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (7,'ABC-1234',0.50264336,1985,148)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (2,'ABC-1234',0.452830276,1985,128)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (2,'ABC-1234',0.452830176,1985,129)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (1,'ABC-1234',0.452830176,1982,136)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (5,'ABC-1234',0.108468608,1985,143)
INSERT INTO vehicle_contract (bonus_malus,plate_number,vehicle_value,first_registration_year,contract_id) VALUES (3,'ABC-1234',0.125468608,1985,124)

