use classicmodels;
select * from customers;

select productCode ,productName,
productDescription
from products p inner join productlines l on p.productline=l.productline; 


select * from customers inner join orders on customers.customerNumber=orders.customerNumber;

DROP view viewforcustomerandorder;
create view viewforcustomerandorder as select * from customers where state="CA";
select * from viewforcustomerandorder;


create index myIndex on Customers(customerNumber);

select * from customers left join orders on customers.customerNumber=orders.customerNumber;

select * from customers right join employees on customers.salesRepEmployeeNumber=employees.employeeNumber where customerNumber is not null;



Delimiter &&
create procedure GetCustomer()
begin 

 select * from customers where city="Nantes";
 end&&
 delimiter ;
 
 
 call GetCustomer();
 
 
 Drop procedure GetCustomerByCity;
 delimiter &&
 create procedure GetCustomerByCity(In mycity varchar(20) )
 begin 
 select * from customers where city=mycity;
 end &&
 delimiter ;
 
 call GetCustomerByCity("Nantes");
 
 
 Drop procedure GetOrderCountByStatus;
 delimiter //
 create procedure GetOrderCountByStatus(In orderStatus varchar(30) , OUT total int)
 begin 
  select count(orderNumber) INTO total FROM orders where status=orderStatus;
  end //
  delimiter ;
  
  
  call GetOrderCountByStatus("shipped",@total);
  select @total;
  
  
  delimiter &&
  create procedure SetCounter(INOUT counter INT , IN inc INT)
  begin
     set counter =counter+inc;
  end &&
  delimiter ;
 
 set @counter=1;
 call setCounter(@counter,1);
 select @counter;
 call setCounter(@counter,1);
 select @counter;
 call setCounter(@counter,5);
 select @counter;
 
 
 Drop procedure GetTotalCustomer;
delimiter //
create procedure GetTotalCustomer(IN city varchar(30))
begin 
    
     declare totalCount int;
	 declare mycity varchar(30);
     set mycity=city;
     
     select count(customerNumber) into totalCount from Customers where city=mycity;
   
end //
delimiter ;

call GetTotalCustomer("Nantes");
select totalCount;


delimiter //
create procedure GetCustomerLevel(IN NewcustomerNumber int , OUT customerLevel varchar(40))
begin 

   declare credit Decimal(10,2) ;
   
   select creditLimit into credit from customers where customerNumber=NewcustomerNumber;
   
   if credit > 50000 then 
     set customerLevel="PLATINUM";
   END IF;
  end //
  delimiter ;
   

CALL GetCustomerLevel(112,@customerLevel);

select @customerLevel;

drop table employee_audits;
create table employee_audits(
    id int auto_increment  primary key ,
    employeeNumber int not null,
    lastName varchar(30),
    changeDate datetime Default null,
    action varchar(20) default null
    
);

drop trigger before_employee_update;

create trigger before_employee_update
before update
on employees
for each row 
insert into employee_audits 
set action ='update',
employeeNumber=OLD.employeeNumber,
lastName=OLD.lastname,
changeDate =NOW();

-------------- function ---------------


drop function countOfCustomer;
delimiter //
create function countOfCustomer(creadit DECIMAL(20,2))
returns VARCHAR(20) 
deterministic 
begin 
declare customerlevel varchar(30);

if creadit > 50000 then
   set customerlevel='PLATINUM';
ELSEIF (creadit >=50000) and (creadit<=10000) then 
   set customerlevel='GOLD';
ELSE
    SET customerlevel='SILVER';
END IF;
return customerlevel;
end //
delimiter ;


select customerName,countOfCustomer(creditLimit) from customers order by customerName;
