create table cafe(
cafe_no number(30) primary key,
cafe_name varchar2(100) not null, 
location1 number(20) not null, --서울시 25개 구(0-전체/1-강남구,2-강동구~25까지) 
location2 varchar2(100) not null, --상세주소
cafe_tel varchar2(20), 
menu varchar2(1000), --메뉴
kidszone number(10), --0: 정보없음/ 1 : 키즈존(전문) /2: 노키즈존 / 3:캐어키즈존 
petzone number(10), --0:정보없음/ 1: 펫존(애견카페o) / 2:노펫존 / 3:펫허용(애견카페x)
use_time varchar2(30), --오전 ~~:~~ ~ 오후 ~~:~~ 까지 포맷으로
avg_star number(10,2), --평균 별점
logtime date default sysdate --등록일
);
					-- no,   name,  location1, location2, 			 tel,				menu,		   kid, pet, use_time,	avg_star, logtime
insert into cafe values(1, '강남구카페', 1, 'test 강남구 마들로 11길 25', '0507-1400-0809', '케익 30,000원', 0, 0, '09:00~20:00', 3.2,sysdate); 
insert into cafe values(2, '강동구카페',2, 'test 강동구 마들로 11길 25', '0507-1400-0809', '케익 30,000원', 0, 0, '09:00~20:00', 3.3,sysdate);
insert into cafe values(3, '강동구카페',3, 'test 강동구 마들로 11길 25', '0507-1400-0809', '케익 30,000원', 1, 2, '07:00~20:00', 5.0,sysdate);
insert into cafe values(4, '강동구카페',6, 'test 강동구 마들로 11길 25', '0507-1400-0809', '케익 30,000원', 0, 3, '07:00~20:00', 4.1,sysdate);



/*location1 참고용 테이블
drop table cafesearch;

	insert into cafesearch values(1,'강남구');
	insert into cafesearch values(2,'강동구');
	insert into cafesearch values(3,'강북구');
	insert into cafesearch values(4,'강서구');
	insert into cafesearch values(5,'관악구');
	insert into cafesearch values(6,'광진구');
	insert into cafesearch values(7,'구로구');
	insert into cafesearch values(8,'금천구');
	insert into cafesearch values(9,'노원구');
	insert into cafesearch values(10,'도봉구');
	insert into cafesearch values(11,'동대문구');
	insert into cafesearch values(12,'동작구');
	insert into cafesearch values(13,'마포구');
	insert into cafesearch values(14,'서대문구');
	insert into cafesearch values(15,'서초구');
	insert into cafesearch values(16,'성동구');
	insert into cafesearch values(17,'성북구');
	insert into cafesearch values(18,'송파구');
	insert into cafesearch values(19,'양천구');
	insert into cafesearch values(20,'영등포구');
	insert into cafesearch values(21,'용산구');
	insert into cafesearch values(22,'은평구');
	insert into cafesearch values(23,'종로구');
	insert into cafesearch values(24,'중구');
	insert into cafesearch values(25,'중랑구');


*/