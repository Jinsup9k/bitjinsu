create table bookshop (
    isbn varchar2(10) constraint PISBN PRIMARY KEY,
    title varchar2(50) constraint CTIT not null,
    author varchar2(50),
    price number,
    company varchar2(30));
    
insert into bookshop(isbn,title,author,price,company) values('is001','자바3일완성','김자바',25000,'야메루출판사');
insert into bookshop(isbn,title,author,price,company) values('pa002','JSP달인되기','이달인',28000,'공갈닷컴');
insert into bookshop(isbn,title,author,price,company) values('or003','오라클무작정따라하기','박따라',23500,'야메루출판사');

commit;

create table bookorder (
    idx number primary key,
    isbn varchar2(10),
    qty number,
    constraint FKISBN foreign key (isbn) REFERENCES bookshop(isbn));
    
create sequence idx_seq 
    increment by 1
    start WITH 1
    nocache
    nocycle;

select * from bookorder;
    
insert into bookorder(idx,isbn,qty) values(idx_seq.nextval,'is001',2);
insert into bookorder(idx,isbn,qty) values(idx_seq.nextval,'or003',3);
insert into bookorder(idx,isbn,qty) values(idx_seq.nextval,'pa002',5);
insert into bookorder(idx,isbn,qty) values(idx_seq.nextval,'is001',3);
insert into bookorder(idx,isbn,qty) values(idx_seq.nextval,'or003',10);

create or replace view bs_view
    as select title 책제목, author 저자, qty*price 총판매금액
    from bookshop
    join bookorder using(isbn) 
    with read only;
    
    select * from bs_view;
    
-- ex5
create or replace view v_view7("부서ID","부서평균")
    as select nvl(department_id,5000),
            round(avg(salary),-3)
            from employees
            group by department_id
            order by department_id asc;

select * from v_view7;

-- 문제5
select 이름,부서명,최대급여
from (select last_name 이름,
            department_name 부서명,
            salary 최대급여
        from employees
        join departments using(department_id)
        where (department_id, salary) 
            in(select department_id , max(salary) from employees group by department_id))
order by 3 desc;




























