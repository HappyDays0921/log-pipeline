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

<img width="366" height="320" alt="PurchaseLog" src="https://github.com/user-attachments/assets/19f88344-0cd2-44f5-a2c0-824e54f2e27c" />

	-구매로그 테이블

	create table PurchaseLog(
    eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
	purchaseTime varchar(20) NOT NULL,
    purchaseSubject varchar(10) NOT NULL
);

<img width="392" height="326" alt="UserErrorLog" src="https://github.com/user-attachments/assets/8f905f42-a010-4b8a-b2cc-ffe0d680301e" />

	-문제보고로그 테이블

	create table UserErrorLog(
	eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
	errorTime varchar(20) NOT NULL,
    errorCode varchar(50) NOT NULL
);




     
3. 데이터 집계분석
4. Docker로 실행 가능하게 만들기
5. 결과 시각화

## 🛠️ 개발환경
스크립트 언어 : Java
IDE : IntelliJ, Visual Studio Code
데이터베이스 : Mysql
기타 : Docker, phpMyadmin


## 실행방법
	- 본 과제는 Docker를 사용합니다
	1. cmd화면에서 docker-compose.yml이 있는 위치로 이동해 docker compose build 명령어를 실행합니다.
	2. 이후 docker compose up -d 명령어를 실행합니다.
	3. 이후 java의 Main.class를 컴파일하여 스크립트를 실행시키고 출력물과 untitled/output에 있는 차트와 비교하여봅니다


- 예시
  <img width="818" height="507" alt="userlogin" src="https://github.com/user-attachments/assets/683c762f-3424-4c07-a6df-5deaed14ea7f" />

  <img width="625" height="393" alt="purcahse2" src="https://github.com/user-attachments/assets/d4453ef7-ccdd-4c06-aa7f-0a8e1a68c565" />



## 구현시 고민한점


<img width="522" height="67" alt="캡처101" src="https://github.com/user-attachments/assets/79aa991e-771a-4b89-a6bd-490efe265612" />

- docker 파일로 프로그램 실행시 문제를 해결하는 과정에 있습니다. localhost:8080 -> web,


<img width="1432" height="1861" alt="123123123" src="https://github.com/user-attachments/assets/31ade070-c570-4aac-8b4d-307c8fc60232" />

- docker compose
  

- 데이터를 저장할때 txt파일형태로 로컬에 저장할까 했지만 결국 docker를 쓰기에 mysql 데이터베이스 서버를 사용하기로 하였습니다. 또한 php코드를 같이 작성하면서 데이터가 움직이는 것을 직접 확인해 볼 수 있을거라 생각했던것 같습니다.
- 한 유저의 로그인시간과 구매시간을 비슷하게 설정하여 로그인 이후에 구매 이벤트가 동작한다는 내용으로 스크립트를 만들어보려 했습니다. 그렇게 되면 LoginLog 테이블을 조회하여 해당 유저를 검색하고 조회되는 시간들에 랜덤으로 시간을 추가하여 PurchaseLog 테이블에 내용을 삽입해야 했습니다. 
- 데이터를 집계할때 gson을 사용하지 않고 패키지 다운로드 없이 최대한 과제를 해보려고하니 PurchaseLog에서 카테고리별 수량을 받아올때 문자열 + 숫자가 들어와서 곤란했습니다. 결국 카테고리는 2자리라고 가정하고 문자열을 자르는 방법으로 숫자와 문자를 구분지었습니다.
- Count_UserLoginByTime.php 코드에서 sql을 작성할때 for문의 반복으로 sql where를 사용했는데 group by를 사용했으면 간단하게 표현할 수 있었을거라 생각합니다.
 

## 📌 선택과제.B AWS기초 이해
1)AWS 아키텍쳐 설계


2)설계한 아키텍처에서 가장 고민한 부분
- 서비스에 사용자가 많이 몰리는 등의 이유로 트래픽이 증가 했을때의 대처를 가장 중요하게 생각했습니다. 

- AWS에 대해 경험이 한번도 없어서 이번 과제를 통해 공부하며 ESC에 대해 알아보았습니다.
 
- DOCKER를 사용하게 되면서 compose 파일에 컨테이너를 생성하고 build를 통해

