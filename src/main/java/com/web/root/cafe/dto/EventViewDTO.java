package com.web.root.cafe.dto;
/*create table event_view(
cafe_no number(20), 
constraint fk_no foreign key(cafe_no) references cafe(cafe_no) on delete cascade,
cafe_name varchar(50) not null,
event_no number(20) primary key, --페이지에 4개만 넣으니까 이벤트는 항상 네개까지만 넣기(우선^^;)
event_type varchar2(30) not null, --'할인' / '서비스'
event_content varchar2(200), --ex) SNS에 카페 태그 시 아메리카노 2500원->2000원! 
event_time varchar2(100) --ex) 2022.06.24~2022.06.30
);

desc event_view;
*/
public class EventViewDTO {
	private int cafe_no;
	private String cafe_name;
	private int event_no;
	private String event_type;
	private String event_content;
	private String event_time;
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public int getEvent_no() {
		return event_no;
	}
	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	
	
}
