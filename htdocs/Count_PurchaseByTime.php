<?php
//시간대별 구매 분석

$con = mysqli_connect("mysql","root","1234","log_pipeline");
mysqli_set_charset($con,"utf8");

$TimeLine = [];
for($i=0;$i<24;$i++){
    $countStmt = mysqli_prepare($con,
        "SELECT COUNT(*) FROM PurchaseLog where hour(purchaseTime) = $i");
    mysqli_stmt_execute($countStmt);

    mysqli_stmt_bind_result($countStmt,$count);
    mysqli_stmt_fetch($countStmt);
    $TimeLine[$i] = $count;
    mysqli_stmt_close($countStmt);
    
    
}
echo json_encode($TimeLine);

?>