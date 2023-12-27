create database revpro2;
drop database revpro2;
use revpro2 ;

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

insert into Users values(1,"Aakash","solanke","Aakash@gmail.com","Aakash@123",9325529741,"sunder nager");
insert into Users values(2,"swaraj","solanke","swaraj@gmail","Swaraj@123",9325529741,"sunder nager");
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
      br_sr_pl_id int primary key auto_increment,
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
    ott_pl_id int primary key auto_increment,
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

-- DROP TABLE Dth_service;
-- CREATE TABLE DTH_service (
--     dth_sr_id INT PRIMARY KEY auto_increment,
--     service_id INT,
--     dth_service_plans VARCHAR(50) UNIQUE,
--     FOREIGN KEY (service_id) REFERENCES service(service_id)
-- );
 
-- INSERT INTO Dth_service (dth_sr_id, service_id, dth_service_plans) VALUES 
-- (1, 2, 'monthly'), 
-- (2, 2, 'quaterly'), 
-- (3, 2, 'yearly');
-- SELECT * FROM Dth_service;	
 
DROP TABLE Dth_service_plans;
CREATE TABLE Dth_service_plans (
    dth_sr_pl_id INT PRIMARY KEY auto_increment,
   --  dth_sr_id INT,-- 
    plan  enum("MONTHOLY","QUATERLY"), 
    language VARCHAR(25),
    channel_category VARCHAR(25),
    price DECIMAL(10, 2),
     service_id int,
	dth_chnl_dt_id int,
	foreign key(service_id) references service(service_id),
    foreign key(dth_chnl_dt_id) references DTH_channel_details(dth_chnl_dt_id)
   
);
select * from Dth_service_plans;
INSERT INTO Dth_service_plans ( plan, language, channel_category, price,service_id,dth_chnl_dt_id) VALUES
( "MONTHOLY", 'hindi', 'entertainment', 50,2,1),
( "MONTHOLY", 'hindi', 'sports', 50,2,2),
("MONTHOLY", 'hindi', 'news', 50,2,3);

 INSERT INTO Dth_service_plans ( plan, language, channel_category, price,service_id,dth_chnl_dt_id) VALUES
( "QUATERLY", 'hindi', 'entertainment', 50,2,1),
( "QUATERLY", 'hindi', 'sports', 50,2,2),
("QUATERLY", 'hindi', 'news', 50,2,3);



 -- Insert data into DTH_channels (marathi channels)
INSERT INTO Dth_service_plans ( plan, language, channel_category, price,service_id,dth_chnl_dt_id) VALUES
("MONTHOLY", 'marathi', 'entertainment', 60,2,1),
("MONTHOLY", 'marathi', 'sports', 60,2,2),
("MONTHOLY", 'marathi', 'news', 60,2,3);

INSERT INTO Dth_service_plans ( plan, language, channel_category, price,service_id,dth_chnl_dt_id) VALUES
("QUATERLY", 'marathi', 'entertainment', 60,2,1),
("QUATERLY", 'marathi', 'sports', 60,2,2),
("QUATERLY", 'marathi', 'news', 60,2,3);


select * from Dth_service_plans;

 

-- Create DTH_channel_details table
DROP TABLE DTH_channel_details;
CREATE TABLE DTH_channel_details (
    dth_chnl_dt_id INT PRIMARY KEY auto_increment,
    channel_name VARCHAR(100)
);
 
-- Insert data into DTH_channel_details (Hindi entertainment channels)
INSERT INTO DTH_channel_details(channel_name) VALUES
(  'chanal-1.chanal,2,chanal-3'),
(  'chanal-1.chanal,2,chanal-3,chanal-4,chanal-5'),
('chanal-1.chanal,2,chanal-3,chanal-4,chanal-5,chanal-6,chanal-7');


 

select * from dth_channel_details;


 
 drop table user_service_link;
create table user_service_link(
      user_ser_lin_id int primary key auto_increment,
      br_sr_pl_id int default 0,
	  dth_sr_pl_id INT default 0,
      user_id int ,
      subscription_start_date DATE,
	  subscription_end_date DATE,
	  Broad_is_active BOOLEAN DEFAULT 1,
      Dth_is_active BOOLEAN DEFAULT 1,
      foreign key(br_sr_pl_id) references Broadband_serice_plan(br_sr_pl_id),
      foreign key(user_id) references Users(user_id),
        FOREIGN KEY (dth_sr_pl_id) REFERENCES Dth_service_plans(dth_sr_pl_id)
);

INSERT INTO user_service_link (user_ser_lin_id, br_sr_pl_id, dth_sr_pl_id, user_id, subscription_start_date, subscription_end_date, Broad_is_active,Dth_is_active)
VALUES
    (1, 1, 1, 1, '2022-04-02', '2022-05-01', 1,1),
    (2, 2, 2, 2, '2022-03-01', '2022-04-01', 1,1),
    (3, 3, 3, 2, '2022-11-03', '2022-12-02', 1,1),
    (4, 4, 3, 2, '2022-11-03', '2022-12-02', 1,1);
    
    INSERT INTO user_service_link (user_ser_lin_id, br_sr_pl_id, dth_sr_pl_id, user_id, subscription_start_date, subscription_end_date, is_active)
VALUES(4, 4, 3, 2, '2022-11-03', '2022-12-02', 1,1);
select * from user_service_link;



 
select * from User_Service_Link;
 
-- ALL GET QUERIES
 -----------  query for all plans details ------------ 
 
 delimiter //
 create procedure getAllPlansDetails()
 begin
  SELECT
    bsp.br_sr_pl_id AS broadband_plan_id,
    bsp.plan AS broadband_plan,
    bsp.Plan_details AS broadband_plan_details,
    bsp.price AS broadband_price,
--     s.service_id AS service_id,
    s.service_name AS service_name,
   --  op.ott_pl_id AS ott_platform_id,
   ott_p_name
FROM
    Broadband_serice_plan bsp
JOIN
    service s ON bsp.service_id = s.service_id
JOIN
    ott_platform op ON bsp.ott_pl_id = op.ott_pl_id;

end //
delimiter ;
 
 delimiter //
 create procedure GetPlansByMonthQuaterlyYearly(IN str varchar(20))
 begin
  SELECT
    bsp.br_sr_pl_id AS broadband_plan_id,
    bsp.plan AS broadband_plan,
    bsp.Plan_details AS broadband_plan_details,
    bsp.price AS broadband_price,
--     s.service_id AS service_id,
    s.service_name AS service_name,
   --  op.ott_pl_id AS ott_platform_id,
   ott_p_name
FROM
    Broadband_serice_plan bsp
JOIN
    service s ON bsp.service_id = s.service_id
JOIN
    ott_platform op ON bsp.ott_pl_id = op.ott_pl_id
WHERE bsp.plan  = str;

end //
delimiter ;
 
 call GetPlansByMonthQuaterlyYearly("yearly");
 
 use revpro;

SELECT
    Dth_service.dth_service_plans,
    Dth_service_plans.language,
    Dth_service_plans.channel_category,
    DTH_channel_details.channel_name,
    DTH_channel_details.price
FROM
    Dth_service
JOIN
    Dth_service_plans ON Dth_service.dth_sr_id = Dth_service_plans.dth_sr_id
JOIN
    DTH_channel_details ON Dth_service_plans.dth_sr_pl_id = DTH_channel_details.dth_chnl_id
JOIN
    user_service_link ON Dth_service_plans.dth_sr_id = user_service_link.dth_sr_pl_id
WHERE
    user_service_link.is_active = 1;
    
    
    
 
                    
                    
                    
                    
                    
---------------------------------------------------------

-- Retrieve monthly plans and associated DTH channels


drop procedure getPlansBasedOnMQ;
delimiter //
create procedure getPlansBasedOnMQ(IN str varchar(20))
begin 
SELECT
    dsp.dth_sr_pl_id,
    dsp.plan,
    dsp.language,
    dsp.channel_category,
    dsp.price,
    dcd.channel_name
FROM
    Dth_service_plans dsp
JOIN
    DTH_channel_details dcd ON dsp.dth_chnl_dt_id = dcd.dth_chnl_dt_id
WHERE
    dsp.plan = str;
end//
delimiter ;

call getPlansBasedOnMQ("montholy");




------- user service link ----
use revpro2;
SELECT
    U.user_id,
   --  U.first_name,
   --  U.last_name,
    S.service_name,
    B.plan AS broadband_plan,
    B.Plan_details AS broadband_plan_details,
    B.price AS broadband_price,
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
    U.user_id = 2
    AND USL.Broad_is_active = 1;
    

drop procedure getsubscribePlanForBroadBand;
delimiter //
create procedure getsubscribePlanForBroadBand(In Id int)
begin
SELECT
    U.user_id,
   --  U.first_name,
   --  U.last_name,
    S.service_name,
    B.plan AS broadband_plan,
    B.Plan_details AS broadband_plan_details,
    B.price AS broadband_price,
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
  USL.Broad_is_active = 1
   AND  U.user_id =Id;
end //
delimiter ;

call getsubscribePlanForBroadBand(2);


Drop procedure getsubscribePlanForDTH;
delimiter //
create procedure getsubscribePlanForDTH(In Id INT)
begin
SELECT
    U.user_id,
    S.service_name,
    D.plan AS dth_plan,
    D.language AS dth_language,
    D.channel_category AS dth_channel_category,
    D.price AS dth_price,
    subscription_start_date,
    subscription_end_date
FROM
    Users U
JOIN
    user_service_link USL ON U.user_id = USL.user_id
JOIN
    Dth_service_plans D ON USL.dth_sr_pl_id = D.dth_sr_pl_id
JOIN
    service S ON D.service_id = S.service_id
WHERE
  USL.Dth_is_active = 1
    AND U.user_id = Id;
END //
delimiter ;

call getsubscribePlanForDTH(2)