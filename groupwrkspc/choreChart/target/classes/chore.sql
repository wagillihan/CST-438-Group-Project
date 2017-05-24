# schema and test data for group project CST438

drop table child;
drop table parent;

create table parent (
parentId int primary key auto_increment, 
parentName varchar(50) not null,
email varchar(50) not null, 
password varchar(50) not null
);

create table child (
childId int primary key auto_increment,
childName varchar(50) not null,
childUsername varchar(50) not null,
birthDate date not null,
childPassword varchar(50) not null,
currentBalance double,
parentId int,
foreign key (parentId) references parent(parentId) on delete cascade
);

insert into parent (parentName, email, password) values 
('John Doe', 'jd@email.com', 'hJu7L021'), 
('Jane Smith', 'js@hotmail.com', '754269ot'),
('Mary Jones', 'mj@outlook.com', 'DYTRF888b');

insert into child (childName, childUsername, birthDate, childPassword, currentBalance, parentId) values 
('Bobby Doe', 'bboy2', date'2010-11-09', '1cur12', 8.75, 1), 
('Sally Doe', 'ddgurl', date'2011-12-05', 'brby1', 10.95, 1),
('Shirly Smith', 'ssrdrgrl', date'2006-07-24', 'bdth456', 16.25, 2), 
('Monique Jones', 'mdoll', date'2005-04-12', '56fgthgg', 24.50, 3);