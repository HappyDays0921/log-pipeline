<?php
$con = mysqli_connect("mysql","root","1234","log_pipeline");
mysqli_set_charset($con,"utf8");

$json = file_get_contents("php://input");
$data = json_decode($json,true);

$eventType = $data["eventType"];
$userId = $data["userId"];
$purchaseTime = $data["purchaseTime"];
$purchaseSubject = $data["purchaseSubject"];

$inputData = mysqli_prepare($con,"INSERT INTO PurchaseLog VALUES(?,?,?,?)");
mysqli_stmt_bind_param($inputData,"ssss",$eventType,$userId,$purchaseTime,$purchaseSubject);
mysqli_stmt_execute($inputData);

?>