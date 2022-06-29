create table member(
code number(10) not null, -- 0:관리자 계정 / 1:사용자계정
id varchar2(20) primary key,
pw varchar2(20) not null,
name varchar2(20) not null, 
gender varchar2(20) not null, --1 : 남자 / 2: 여자
addr varchar2(30),
phone number(10) not null, 
email varchar2(20),
domain varchar2(20),
birth varchar2(30), 
savedate date default Sysdate
);

--관리자 계정 생성
insert into member values(0, 'jimin','1234','유지민','woman','대한민국 어딘가','01051906160','claraj05','naver.com','1992-05-19',sysdate);