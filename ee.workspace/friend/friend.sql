create table friend(
SEQ NUMBER PRIMARY KEY,
NAME VARCHAR2(15) NOT NULL,
TEL1 VARCHAR(5),
tel2 varchar(5),
tel3 varchar(5),
gender number,
read number default 0,
movie number default 0,
music number default 0,
game number default 0,
shopping number default 0);

create sequence seq_friend nocycle nocache;

select * from friend