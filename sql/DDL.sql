CREATE USER PICTURE_DIARY IDENTIFIED BY PICTURE_DIARY;
GRANT CONNECT, RESOURCE, DBA TO PICTURE_DIARY;
COMMIT;

-- 계정 삭제 (잘못 생성한 경우 DROP하고 다시 생성)
-- DROP USER PICTURE_DIARY CASCADE;

CREATE TABLE USERS (
	user_id				NUMBER 			NOT NULL,
	email				VARCHAR2(100) 	NOT NULL,
	password			VARCHAR2(4000),
	nickname			VARCHAR2(50)	NOT NULL,
	sns_type			VARCHAR2(10),
	sns_id				VARCHAR2(255),
	sns_connect_date	DATE,
	create_date			DATE	DEFAULT SYSDATE,
	modify_date			DATE,
	CONSTRAINT pk_users  PRIMARY KEY (user_id)
);


CREATE TABLE LOGIN_LOG (
	user_id			NUMBER	NOT NULL,
	login_date		DATE	DEFAULT SYSDATE,
	login_status	VARCHAR2(5),
	CONSTRAINT pk_login_log  PRIMARY KEY (user_id, login_date),
	CONSTRAINT fk_login_log FOREIGN KEY (user_id) REFERENCES USERS (user_id)
	--CONSTRAINT ck_login_status CHECK (��in��, ��out��),
);

CREATE TABLE DIARY (
	diary_id	NUMBER			NOT NULL,
	user_id		NUMBER			NOT NULL,
	title		VARCHAR(255) 	NOT NULL,
	content		VARCHAR(4000),
	create_date	DATE			DEFAULT SYSDATE,
	diary_date	DATE,
	bookmark	CHAR(1),
	modify_date	DATE
	CONSTRAINT pk_diary PRIMARY KEY (diary_id),
	CONSTRAINT fk_diary FOREIGN KEY (user_id) REFERENCES USERS (user_id)
);


CREATE TABLE DIARY_IMAGE (
	diary_id	NUMBER		NOT NULL,
    create_date	DATE		DEFAULT SYSDATE,
	real_name	VARCHAR(255),
	file_name	VARCHAR(255),
	path		VARCHAR(255),
	CONSTRAINT pk_diary_image PRIMARY KEY (diary_id),
	CONSTRAINT fk_diary_image FOREIGN KEY (diary_id) REFERENCES DIARY (diary_id)
);

COMMIT;

-- 시퀀스 생성
CREATE SEQUENCE user_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
       
CREATE SEQUENCE diary_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
COMMIT;

-- TRIGGER 생성
CREATE OR REPLACE TRIGGER user_insert_trigger
AFTER INSERT ON users 
FOR EACH ROW
BEGIN
      INSERT INTO diary VALUES(diary_seq.NEXTVAL, :NEW.USER_ID, '환영합니다', '당신의 오늘을 기록해주세요', DEFAULT, SYSDATE ); 
      INSERT INTO diary_image VALUES(diary_seq.CURRVAL, DEFAULT, NULL, '환영합니다.jpg', 'D:\pictureDiary' );
END;

--CREATE TABLE LIKE_DIARY (
--	diary_id	NUMBER	NOT NULL,
--	user_id		NUMBER	NOT NULL,
--	create_date	DATE	DEFAULT SYSDATE,
--	CONSTRAINT pk_like_diary PRIMARY KEY (diary_id),
--	CONSTRAINT fk_like_diary FOREIGN KEY (diary_id) REFERENCES DIARY (diary_id),
--	CONSTRAINT fk_like_diary_user FOREIGN KEY (user_id) REFERENCES USERS (user_id);
--);

--alter table users modify (password varchar2(2000)) ;
--alter table diary_image drop primary key;
--alter table diary_image add constraint pk_diary_image primary key(diary_id);
--alter table diary drop column cteate_date;
--alter table diary_image drop column cteate_date;
--alter table diary_image modify (create_date default sysdate);
--alter table like_diary add user_id number not null;
--alter table like_diary add constraint fk_like_diary_user foreign key (user_id) references users (user_id);
--alter table diary add bookmark char(1);
--alter table diary add modify_date date;
