import java.util.Random;

public class Event {
    //로그인 이벤트 로그
    //유저ID와 접속 시간을 포함한 로그 반환 (eventType:LOGIN,userId,loginTime)
    public static String UserLoginData(int a){
        //사용자의 ID에 따른 무작위 접속시간 표시
        String userID = "user"+a;
        String loginTime = RandomTime.time_ddhhmmss();
        //LOGIN이라는 이벤트 표시와 함께 해당 유저의 아이디와 로그인 시간을 표시
        String UserLog = String.format(
                "{\"eventType\":\"LOGIN\",\"userId\":\"%s\",\"loginTime\":\"%s\"}",
                userID,loginTime
        );
        return UserLog;
    }

    //구매 로그
    //유저ID와 구매시간, 구매물품 카테고리를 반환 (eventType:PURCHASE,userId,purchaseTime,purchaseSubject)
    public static String UserPurchaseData(int a){
        //사용자가 로그인 한 시간 근처에서 구매를 한다고 가정하여 시간 설정
        //하려했지만 일단은 로그인 시간과 상관없이 서버에 넣을 로그 생성
        //이후 수정 필요
        Random random = new Random();

        String userId = "user"+a;
        String purchaseTime;
        String purchaseSubj;
/*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime randomTime = currentTime.plusHours(random.nextInt(24))
                .plusMinutes(random.nextInt(60))
                .plusSeconds(random.nextInt(60));
        purchaseTime = randomTime.format(formatter);
 */
        purchaseTime = RandomTime.time_ddhhmmss();//time_ddhhmmss();
        switch (random.nextInt(6)){
            case 1:
                purchaseSubj = "의류";
                break;
            case 2:
                purchaseSubj = "도서";
                break;
            case 3:
                purchaseSubj = "식품";
                break;
            case 4:
                purchaseSubj ="가전";
                break;
            default:
                purchaseSubj ="기타";
                break;
        }

        //PURCHASE라는 이벤트 표시와 함께 유저 아이디, 구매시간, 구매 항목 표시
        String userLog = String.format(
                "{\"eventType\":\"PURCHASE\",\"userId\":\"%s\",\"purchaseTime\":\"%s\",\"purchaseSubject\":\"%s\"}",
                userId,purchaseTime,purchaseSubj
        );
        return userLog;
    }

    //사용자 오류제보 로그
    //유저ID와 오류 제보시간, 오류 내용 반환(eventType:error_FromUser,userId,errorTime,errorCode)
    public static String UserErrorData(int a){
        Random random = new Random();
        //사진과 품목이 맞지않는등의 사용자 제보의 오류내용
        String userId = "user"+a;
        String errorTime = RandomTime.time_ddhhmmss();
        String errorCode;

        errorCode = switch (random.nextInt(5)){
            case 1 -> "상품예시 사진과 상품이 맞지 않습니다";
            case 2 -> "상품과 카테고리가 맞지 않습니다";
            case 3 -> "상품 재고 수량이 맞지 않습니다";
            case 4 -> "상품 가격 표기에 오류가 있습니다";
            default ->"기타";
        };

        String userLog = String.format(
                "{\"eventType\":\"error_FromUser\",\"userId\":\"%s\",\"errorTime\":\"%s\",\"errorCode\":\"%s\"}",
                userId,errorTime,errorCode
        );
        return userLog;

    }

    //오류 로그
    //
    public static void ErrorData(int a){};

}
