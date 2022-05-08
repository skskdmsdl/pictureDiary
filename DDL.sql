CREATE TABLE `USERS` (
	`user_id`	NUMBER¡¡ NOT¡¡NULL,
	`email`	VARCHAR2(100) NOT¡¡NULL,
	`password`	VARCHAR2(50)	NOT NULL,
	`nickname`	VARCHAR2(50)	NOT NULL,
	`sns_type`	VARCHAR2(10),
	`sns_id`		VARCHAR2(255),
	`sns_connect_date`	VARCHAR2(255),
	`create_date`	DATE	DEFAULT SYSDATE,
	`modify_date`	DATE,
	CONSTRAINT pk_user  PRIMARY KEY (id)
);


CREATE TABLE `LOGIN_LOG` (
	`user_id`	NUMBER¡¡ NOT¡¡NULL,
	`login_date`	DATE	 DEFAULT SYSDATE,
	`login_status`	VARCHAR2(5),
	CONSTRAINT pk_login_log  PRIMARY KEY (user_id, login_date),
	CONSTRAINT fk_login_log FOREIGN KEY (user_id) REFERENCES USERS (user_id)
	--CONSTRAINT ck_login_status CHECK (¡®in¡¯, ¡®out¡¯),
);

CREATE TABLE `DIARY` (
	`diary_id`	NUMBER	NOT NULL,
	`user_id`	NUMBER	NOT NULL,
	`title`	VARCHAR(255) NOT NULL,
	`content`	VARCHAR(4000)	,
	`create_date`	DATE	DEFAULT SYSDATE,
	`diary_date`	DATE,
	CONSTRAINT pk_diary PRIMARY KEY (diary_id, user_id),
	CONSTRAINT fk_diary FOREIGN KEY (user_id) REFERENCES USERS (user_id)
);

CREATE TABLE `DIARY_IMAGE` (
	`diary_id`	NUMBER	NOT NULL,
	`real_name`	VARCHAR(255),
	`file_name`	VARCHAR(255),
	`path`	VARCHAR(255),
	`create_date`	DATE	DEFAULT SYSDATE,
	CONSTRAINT pk_like PRIMARY KEY (diary_id),
	CONSTRAINT fk_like FOREIGN KEY (diary_id) REFERENCES DIARY (diary_id)
);

CREATE TABLE `LIKE` (
	`diary_id`	NUMBER	NOT NULL,
	`create_date`	DATE	DEFAULT SYSDATE,
	CONSTRAINT pk_like PRIMARY KEY (diary_id),
	CONSTRAINT fk_like FOREIGN KEY (diary_id) REFERENCES DIARY (diary_ids)
);