# 플랫폼 / 데이터 엔지니어링 인턴 채용 과제
과제 - 간단한 이벤트 로그 파이프 라인 만들기

## 📌 필수과제
1. 이벤트 생성기 작성
   - 인터넷 쇼핑을 생각하고 만들었습니다
   - 로그인 이벤트에서 사용자가 서비스에 로그인 할 때 남는 사용자의 아이디와 접속시간을 기록합니다.
   - 구매 이벤트에서 사용자의 아이디와 구매시간, 구매 품목을 기록합니다.
   - 문제 보고 이벤트에서 문제 항목과 함께 문제접수 시간과 사용자의 아이디를 기록합니다.

   -로그인이벤트와 구매이벤트에서는 사용자가 몰리는 시간을 예측하고 대비하기 위해 시간을 기록합니다.
   
   -문제보고 이벤트에서는 문제 항목에 따라, 먼저 접수된 보고를 우선하기 위해 문제항목과 접수시간을 기록합니다. 
  
     
2. 로그 저장
   - 로그 한줄에 3개 이상의 항목이 있어 MYSQL 데이터베이스를 이용하여 로그를 관리해야한다고 생각했습니다.
     
   - 각 이벤트별 테이블을 작성하고 컬럼으로 로그 내용을 정리하면 조회 및 삽입시 용이하게 만들었습니다.

<img width="352" height="263" alt="LoginLog" src="https://github.com/user-attachments/assets/31e5be51-0984-4573-a68d-35e8c612749c" />

	-로그인로그 테이블

	CREATE TABLE LoginLog(
	eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
    loginTime varchar(20) NOT NULL
);



	-구매로그 테이블

	create table PurchaseLog(
    eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
	purchaseTime varchar(20) NOT NULL,
    purchaseSubject varchar(10) NOT NULL
);
<img width="366" height="320" alt="PurchaseLog" src="https://github.com/user-attachments/assets/19f88344-0cd2-44f5-a2c0-824e54f2e27c" />


	-문제보고로그 테이블

	create table UserErrorLog(
	eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
	errorTime varchar(20) NOT NULL,
    errorCode varchar(50) NOT NULL
);

<img width="392" height="326" alt="UserErrorLog" src="https://github.com/user-attachments/assets/8f905f42-a010-4b8a-b2cc-ffe0d680301e" />


     
3. 데이터 집계분석
4. Docker로 실행 가능하게 만들기
5. 결과 시각화

## 🛠️ 개발환경
스크립트 언어 : Java
IDE : IntelliJ, Visual Studio Code
데이터베이스 : Mysql
기타 : Docker, phpMyadmin


## 실행방법


## 스키마 설명


## 구현시 고민한점


