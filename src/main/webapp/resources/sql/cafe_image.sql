create table cafe_image(
imgName varchar2(100) not null,
imgLocation varchar2(100) not null,
imgContent varchar2(300),
cafe_no number(30),
constraint cf_id foreign key(cafe_no) references cafe(cafe_no) on delete cascade
);
