CREATE REVIEW_SEQ INCREMENT BY 1 START WITH 1;
CREATE REVIEW_IMG INCREMENT BY 1 START WITH 1;

create table review(
cafe_no number(20),
constraint fk_cafe foreign key(cafe_no) references cafe(cafe_no) on delete cascade,
review_no number(30) not null,  --카페 별 번호를 매겨 총 리뷰 수 카운트 할 방법 필요 
review_content varchar2(100) not null, 
id varchar2(20), 
constraint fk_id foreign key(id) references member(id) on delete cascade,
review_savedate date default sysdate,
--imageFileName varchar2(100), --이미지 파일명
grade number(10) --1~5까지 매기기
);

create table review_img(
cafe_no number(20),
review_no number(30),
id varchar2(20),
imageFileName varchar2(100) not null,
imageLocation varchar2(100) not null
);