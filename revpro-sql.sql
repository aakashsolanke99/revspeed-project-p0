create database revpro;
drop database revpro;
use revpro ;

Drop table Users;
create table Users(
     user_id int primary key auto_increment,
     first_name varchar(30),
     last_name varchar(30),
     email varchar(30) unique NOT null,
     pass_word varchar(20) unique NOT NULL,
     phone_no bigint,
     address varchar(50)
     );

insert into Users values(1,"Aakash","solanke","email","Aakash@123",9325529741,"sunder nager");
insert into Users values(2,"swaraj","solanke","swaraj@gmail","swaraj@123",9325529741,"sunder nager");
select * from users;
drop table service;
create table service(
      service_id int primary key auto_increment,
      service_name varchar(20)
     
);

insert into service values(1,"broadband"),(2,"DTH");

select * from service;

Drop table Broadband_serice_plan;
create table Broadband_serice_plan(
      br_sr_pl_id int primary key ,
      plan  enum("MONTHOLY","QUATERLY","YEARLY"), 
      Plan_details varchar(30),
      price int,
      service_id int,
      ott_pl_id int,
      foreign key(service_id) references service(service_id),
	  foreign key(ott_pl_id) references ott_platform(ott_pl_id)
);

insert into Broadband_serice_plan values(1,"MONTHOLY","monthly based paln",300,1,1);
insert into Broadband_serice_plan values(2,"MONTHOLY","monthly based paln",350,1,1);
insert into Broadband_serice_plan values(3,"MONTHOLY","monthly based paln",450,1,1);
insert into Broadband_serice_plan values(4,"QUATERLY","QUATERLY based paln",800,1,2);
insert into Broadband_serice_plan values(5,"QUATERLY","QUATERLY based paln",900,1,2);
insert into Broadband_serice_plan values(6,"QUATERLY","QUATERLY based paln",1000,1,2);
insert into Broadband_serice_plan values(7,"YEARLY","YEARLY based paln",3000,1,3);
insert into Broadband_serice_plan values(8,"YEARLY","YEARLY based paln",3500,1,3);
insert into Broadband_serice_plan values(9,"YEARLY","YEARLY based paln",4000,1,3);



SELECT * FROM Broadband_serice_plan;

drop table ott_platform;
create table ott_platform ( 
    ott_pl_id int primary key,
	ott_p_name varchar(100)
);
insert into ott_platform values(
   1,"Amazon prime video")
   ,(2,"Amazon prime video,Hulu, IBM watson")
   ,(3,"IBM watson,Sling,netflix,Amazon prime video,Hulu,");



select * from ott_platform;


-- Table to track payments
-- CREATE TABLE payments (
--     payment_id INT PRIMARY KEY AUTO_INCREMENT,
--     user_ser_lin_id INT,
--     payment_date DATE,
--     amount DECIMAL(10, 2),
--     payment_type ENUM('Monthly', 'Quarterly', 'Annual'),
--     FOREIGN KEY (user_subscription_id) REFERENCES user_subscription(id)
-- );



------ this will give you which user using which plan and ott platform --------
SELECT
    U.user_id,
    U.first_name,
    U.last_name,
    S.service_name,
    B.plan AS broadband_plan,
    subscription_start_date,
    subscription_end_date,
    O.ott_p_name AS ott_platform
    
FROM
    Users U
JOIN
    user_service_link USL ON U.user_id = USL.user_id
JOIN
    Broadband_serice_plan B ON USL.br_sr_pl_id = B.br_sr_pl_id
JOIN
    service S ON B.service_id = S.service_id
LEFT JOIN
    ott_platform O ON B.ott_pl_id = O.ott_pl_id
WHERE
    U.user_id = 2;




---------------------------- DTH --------------

DROP TABLE Dth_service;
CREATE TABLE DTH_service (
    dth_sr_id INT PRIMARY KEY,
    service_id INT,
    dth_service_plans VARCHAR(50) UNIQUE,
    FOREIGN KEY (service_id) REFERENCES service(service_id)
);
 
INSERT INTO Dth_service (dth_sr_id, service_id, dth_service_plans) VALUES 
(1, 2, 'monthly'), 
(2, 2, 'quaterly'), 
(3, 2, 'yearly');
SELECT * FROM Dth_service;	
 
DROP TABLE Dth_service_plans;
CREATE TABLE Dth_service_plans (
    dth_sr_pl_id INT PRIMARY KEY,
    dth_sr_id INT,
    language VARCHAR(25),
    channel_category VARCHAR(25),
    price DECIMAL(10, 2),
    FOREIGN KEY (dth_sr_id) REFERENCES Dth_service(dth_sr_id)
);
 
-- Insert data into DTH_channels (Hindi channels)
INSERT INTO Dth_service_plans (dth_sr_pl_id, dth_sr_id, language, channel_category, price) VALUES
(1, 2, 'hindi', 'entertainment', 50),
(2, 2, 'hindi', 'sports', 50),
(3, 2, 'hindi', 'news', 50);
 
-- Insert data into DTH_channels (Tamil channels)
INSERT INTO Dth_service_plans (dth_sr_pl_id, dth_sr_id, language, channel_category, price) VALUES
(4, 2, 'marathi', 'entertainment', 60),
(5, 2, 'marathi', 'sports', 60),
(6, 2, 'marathi', 'news', 60);
 
-- Create DTH_channel_details table
DROP TABLE DTH_channel_details;
CREATE TABLE DTH_channel_details (
    dth_chnl_dt_id INT PRIMARY KEY,
    dth_chnl_id INT,
    channel_name VARCHAR(50),
    price DECIMAL(10, 2),
    FOREIGN KEY (dth_chnl_id) REFERENCES Dth_service_plans(dth_sr_pl_id)
);
 
-- Insert data into DTH_channel_details (Hindi entertainment channels)
INSERT INTO DTH_channel_details VALUES
(1, 1, 'Hindi_Entertainment_1', 5),
(2, 1, 'Hindi_Entertainment_2', 5),
(3, 1, 'Hindi_Entertainment_3', 5),
(4, 1, 'Hindi_Entertainment_4', 5);
 
-- Insert data into DTH_channel_details (Hindi sports channels)
INSERT INTO DTH_channel_details VALUES
(5, 2, 'Hindi_Sports_1', 8),
(6, 2, 'Hindi_Sports_2', 8),
(7, 2, 'Hindi_Sports_3', 8);
 
-- Insert data into DTH_channel_details (Hindi news channels)
INSERT INTO DTH_channel_details VALUES
(8, 3, 'Hindi_News_1', 3),
(9, 3, 'Hindi_News_2', 3);
 
-- Insert data into DTH_channel_details (Tamil entertainment channels)
INSERT INTO DTH_channel_details VALUES
(10, 4, 'Marathi_Entertainment_1', 4),
(11, 4, 'Marathi_Entertainment_2', 4);
 
-- Insert data into DTH_channel_details (Tamil sports channels)
INSERT INTO DTH_channel_details VALUES
(12, 5, 'Marathi_Sports_1', 6),
(13, 5, 'Marathi_Sports_2', 6),
(14, 5, 'Marathi_Sports_3', 6);
 
-- Insert data into DTH_channel_details (Tamil news channels)
INSERT INTO DTH_channel_details VALUES
(15, 6, 'Marathi_News_1', 2),
(16, 6, 'Marathi_News_2', 2);
 
 

 

 
 drop table user_service_link;
create table user_service_link(
      user_ser_lin_id int primary key,
      br_sr_pl_id int,
	  dth_sr_pl_id INT,
      user_id int ,
      subscription_start_date DATE,
	  subscription_end_date DATE,
	  is_active BOOLEAN DEFAULT 1,
      foreign key(br_sr_pl_id) references Broadband_serice_plan(br_sr_pl_id),
      foreign key(user_id) references Users(user_id),
        FOREIGN KEY (dth_sr_pl_id) REFERENCES Dth_service_plans(dth_sr_pl_id)
);

INSERT INTO user_service_link (user_ser_lin_id, br_sr_pl_id, dth_sr_pl_id, user_id, subscription_start_date, subscription_end_date, is_active)
VALUES
    (1, 1, 1, 1, '2022-04-02', '2022-05-01', 1),
    (2, 2, 2, 2, '2022-03-01', '2022-04-01', 1),
    (3, 3, 3, 2, '2022-11-03', '2022-12-02', 1);
    
    INSERT INTO user_service_link (user_ser_lin_id, br_sr_pl_id, dth_sr_pl_id, user_id, subscription_start_date, subscription_end_date, is_active)
VALUES(4, 4, 3, 2, '2022-11-03', '2022-12-02', 1);
select * from user_service_link;


I
 
select * from User_Service_Link;
 
-- ALL GET QUERIES
 
-- Querry to get user_name, phone_number, address, email_id, subscription_plan, subscription_start_date, subscription_end_date of perticular user
SELECT
    U.name AS user_name,
    U.phone_number,
    U.address,
    U.email_id,
    BSLD.plan_name AS subscription_plan,
    USL.subscription_start_date,
    USL.subscription_end_date
FROM
    User AS U
LEFT JOIN User_Service_Link AS USL ON U.id = USL.user_id
LEFT JOIN Broadband_service_plans_details AS BSLD ON USL.br_sr_dt_id = BSLD.br_sr_pl_dt_id
WHERE U.id = 1;
 
 
 
-- Querry to get OTT platform of perticular user
SELECT OP.platform_name
FROM User_Service_Link USL
JOIN Broadband_service_plans_details BSLD ON USL.br_sr_dt_id = BSLD.br_sr_pl_dt_id
JOIN Broadband_OTT_Mapping BOM ON BSLD.br_sr_id = BOM.br_sr_id
JOIN OTT_platform OP ON BOM.ott_platform_id = OP.ott_platform_id
WHERE USL.user_id = 1;
 
 
 
 