<?php
//순서대로 의류, 도서, 식품, 가전, 기타 총 5가지 항목에 따라 분류
$con = mysqli_connect("mysql","root","1234","log_pipeline");
mysqli_set_charset($con,"utf8");

$result = [];
$countStmt = mysqli_prepare($con,
"SELECT purchaseSubject as Category, COUNT(*) AS cnt FROM PurchaseLog GROUP BY purchaseSubject");
mysqli_stmt_execute($countStmt);

mysqli_stmt_bind_result($countStmt,$Category,$cnt);
/*
for($i=0;$i<6;$i++){
    mysqli_stmt_fetch($countStmt)
    $result[$i] = $cnt;
   
}
    */

while(mysqli_stmt_fetch($countStmt))
    $result[$Category] = $cnt;

 mysqli_stmt_close($countStmt);

echo json_encode($result,JSON_UNESCAPED_UNICODE);
?>