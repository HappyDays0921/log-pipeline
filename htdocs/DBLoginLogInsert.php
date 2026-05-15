<?php
//root말고 user로 혹시 모르니까 수정 3개의 파일 전부
//비슷한 DBInsert파일 3개 말고 한 파일에서 각각의 테이블로
//들어갈 수 있게 처리하는게 php파일 수가 늘어났을때 용이?()
$con = mysqli_connect("mysql","root","1234","log_pipeline");
mysqli_set_charset($con,"utf8");

//해시맵으로 정리해서 주는게 받을때 더 편할거같아서
//성공 이후 수정 해볼필요
$json = file_get_contents("php://input");
$data = json_decode($json,true);

//여기랑 밑에 쿼리부분만 각각 login,purchase,error로 나눠서 처리하면 될것같음
$eventType = $data["eventType"];
$userId = $data["userId"];
$loginTime = $data["loginTime"];

//null값 들어가는 이유 찾아서 수정필요
$inputData = mysqli_prepare($con,"INSERT INTO LoginLog VALUES(?,?,?)");
mysqli_stmt_bind_param($inputData,"sss",$eventType,$userId,$loginTime);
mysqli_stmt_execute($inputData);

?>