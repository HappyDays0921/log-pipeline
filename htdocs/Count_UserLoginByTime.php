
<?php
//요일에 상관없이 0시부터 23시까지 시간에 따라 사용자의 로그인 추이 분석

$con = mysqli_connect("mysql","root","1234","log_pipeline");
mysqli_set_charset($con,"utf8");
/*
$counting = mysqli_prepare($con
,"SELECT COUNT(*) FROM LoginLog WHERE loginTime LIKE '% 00:%' ");
*/


$sum=0;
$TimeLine = [];
for($i=0;$i<24;$i++){
    $countStmt = mysqli_prepare($con,
        "SELECT COUNT(*) FROM LoginLog where hour(loginTime) = $i");
    mysqli_stmt_execute($countStmt);

    mysqli_stmt_bind_result($countStmt,$count);
    mysqli_stmt_fetch($countStmt);
    $TimeLine[$i] = $count;
    mysqli_stmt_close($countStmt);
    //echo "<br>".$i."시:".$count;
    //echo " TimeLine[".$i."]:".$TimeLine[$i];
    $sum +=$count;
    
}
//echo"<br>".$sum;
echo json_encode($TimeLine);

?>