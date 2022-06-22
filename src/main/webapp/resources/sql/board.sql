create table board(
write_no number(10) primary key,
title varchar2(100) not null,
content varchar2(300) not null,
savedate date default sysdate,
hit number(10) default 0,
like_count number(30) default 0,
id varchar2(20) not null
);

create sequence board_seq nocache nocycle; 

create table board_image(
write_no number(10) constraint board_image_fk references board(write_no) on delete cascade, 
imageFileName1 varchar2(100),
imageFileName2 varchar2(100),
imageFileName3 varchar2(100)
);

create table board_like(    
write_no number(10) constraint board_like_fk references board(write_no) on delete cascade,
id varchar2(20) not null
);

select * from board;
select * from board_image;
select * from board_like;

drop table board;
drop table board_image;
drop sequence board_seq;
drop table board_like;
         




        