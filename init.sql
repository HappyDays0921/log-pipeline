CREATE TABLE LoginLog(
	eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
    loginTime varchar(20) NOT NULL
);
create table PurchaseLog(
    eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
	purchaseTime varchar(20) NOT NULL,
    purchaseSubject varchar(10) NOT NULL
);

create table UserErrorLog(
	eventType varchar(20) NOT NULL,
    userId varchar(50) NOT NULL,
	errorTime varchar(20) NOT NULL,
    errorCode varchar(50) NOT NULL
);
