DROP TABLE MEMBER;
DROP TABLE RELATIONSHIP;

CREATE TABLE MEMBER(
	EMAIL	VARCHAR2(100)	NOT NULL,
	NAME	VARCHAR2(100)	NOT NULL,
	PASSWORD	VARCHAR2(100)	NOT NULL,
	SCHOOL	VARCHAR2(100),
	MAJOR	VARCHAR2(100),
	CONSTRAINT	MEMBER_PK_EMAIL1	PRIMARY KEY	(EMAIL)
);

CREATE TABLE RELATIONSHIP(
	EMAIL1	VARCHAR2(50)	NOT NULL,
	EMAIL2	VARCHAR2(50)	NOT NULL,
	GROUPID	VARCHAR2(20),
	HIDDEN	INTEGER	DEFAULT 0,
	CONSTRAINT	RELATIONSHIP_PK_EMAIL12	PRIMARY KEY(EMAIL1,EMAIL2),
	CONSTRAINT	RELATIONSHIP_FK_EMAIL1	FOREIGN KEY (EMAIL1)	REFERENCES MEMBER(EMAIL),
	CONSTRAINT	RELATIONSHIP_FK_EMAIL2	FOREIGN KEY (EMAIL2)	REFERENCES MEMBER(EMAIL)
);

INSERT INTO MEMBER(EMAIL,NAME,PASSWORD,SCHOOL,MAJOR) VALUES (?,?,?,?,?);
DELETE	FROM MEMBER WHERE EMAIL = ?;
UPDATE	MEMBER	SET	SCHOOL = ?, MAJOR = ? WHERE EMAIL = ?;

INSERT INTO RELATIONSHIP(EMAIL1, EMAIL2, GROUPID, HIDDEN) VALUES (?,?,?,?);
DELETE FROM RELATIONSHIP WHERE EMAIL1 = ? AND WHERE EMAIL2 = ?;
UPDATE	RELATIONSHIP SET GROUPID = ? WHERE EMAIL1 = ? AND EMAIL2 = ?;
UPDATE	RELATIONSHIP SET HIDDEN = ?	WHERE EMAIL1 = ? AND EMAIL2 = ?; 