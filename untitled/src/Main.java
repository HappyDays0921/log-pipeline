import java.util.Random;

public class Main{
    public static void main(String[] args) throws Exception {
    Random random = new Random();
    //서비스 로그 표현

    //유저의 접속 로그를 담는 배열
    String[] LoginLogArr = new String[30];
    //유저의 구매 로그를 담는 배열
    String[] PurchaseLogArr = new String[30];
    //유저의 에러제보 로그를 담는 배열
    String[] UserErrorLogArr = new String[30];


    int n=0;
    //로그인 로그 생성
    for(int i=0;i<30;i++){
        LoginLogArr[i] = Event.UserLoginData(random.nextInt(1,4));
    };
    //구매품목 로그 생성
    for(int i=0;i<30;i++){
        PurchaseLogArr[i] = Event.UserPurchaseData(random.nextInt(1,4));
    };
    //사용자 오류제보 로그 생성
    for(int i=0;i<30;i++){
        UserErrorLogArr[i] = Event.UserErrorData(random.nextInt(1,4));
    };

    //db서버에 올리기 위해
    for(String log : LoginLogArr) {
        //System.out.println(log);
        SendLog.sendLoginLog(log);
    }
    for(String log : PurchaseLogArr)
        SendLog.sendPurchaseLog(log);

    for(String log : UserErrorLogArr)
        SendLog.sendUserErrorLog(log);

    //
    EventCount ev = new EventCount();
    //ev.UserLoginByTime();
    //ev.PurchaseByTime();
    //ev.PurchaseByCategory();

    Chart chart = new Chart();
    chart.UserLoginTime();
    chart.PurchaseTime();
    chart.PurchaseCategory();
    }
}
