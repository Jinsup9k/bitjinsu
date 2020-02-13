--------------------------------------------------------
--  파일이 생성됨 - 금요일-2월-07-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "C##JAVA"."BOARD" 
   (	"SEQ" NUMBER, 
	"ID" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(40 BYTE), 
	"EMAIL" VARCHAR2(40 BYTE), 
	"SUBJECT" VARCHAR2(255 BYTE), 
	"CONTENT" VARCHAR2(4000 BYTE), 
	"REF" NUMBER, 
	"LEV" NUMBER DEFAULT 0, 
	"STEP" NUMBER DEFAULT 0, 
	"PSEQ" NUMBER DEFAULT 0, 
	"REPLY" NUMBER DEFAULT 0, 
	"HIT" NUMBER DEFAULT 0, 
	"LOGTIME" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##JAVA.BOARD
SET DEFINE OFF;
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (1,'test','test','test@gmail.com','ㅎㅇㅎㅇ','하이루',1,0,0,0,0,0,to_date('20/02/05','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (6,'앙기모띠','안기모','gimoti12@gmail.com','횐님덜 앙 기모띠!','앙 앙 기모띠~',6,0,0,0,0,0,to_date('20/02/06','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (7,'앙기모띠','안기모','gimoti12@gmail.com','배고픈데 점심 시간 언젠지 아는사람','ㅈㄱㄴ',7,0,0,0,0,0,to_date('20/02/07','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (8,'머머리','머머리','murymury@gmail.com','형님들 ㅎㅇ요','ㅎㅇㅎㅇ',8,0,0,0,0,0,to_date('20/02/07','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (2,'test','test','test@gmail.com','한번에 된 내 자신 칭찬해','칭찬 마니마니해~',2,0,0,0,0,0,to_date('20/02/05','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (3,'test','test','test','test','test',3,0,0,0,0,0,to_date('20/02/06','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (4,'test','test','test','test','test',4,0,0,0,0,0,to_date('20/02/06','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (5,'test','test','test@gmail.com','이젠 잘 되니?','잘 지내..',5,0,0,0,0,0,to_date('20/02/06','RR/MM/DD'));
Insert into C##JAVA.BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF,LEV,STEP,PSEQ,REPLY,HIT,LOGTIME) values (9,'창렬','김창렬','@','님덜아 요즘 창렬하지 않음?','ㅋㅋㅈㄱㄴ
',9,0,0,0,0,0,to_date('20/02/07','RR/MM/DD'));
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("SEQ" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("SUBJECT" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("REF" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("LEV" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("STEP" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("PSEQ" NOT NULL ENABLE);
  ALTER TABLE "C##JAVA"."BOARD" MODIFY ("REPLY" NOT NULL ENABLE);
