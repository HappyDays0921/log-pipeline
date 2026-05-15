import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendLog {
    public static void sendLoginLog(String log) throws Exception{
        URL url = new URL("http://localhost:8080/DBLoginLogInsert.php");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");

        //헤더를 설정 (json형식으로)
        conn.setRequestProperty("Content-Type","application/json");
        conn.setDoOutput(true); //이거는 OutputStream을 사용을 하기위한 설정

        //로그 데이터를 전송하고 스트림을 닫는 부분
        OutputStream os = conn.getOutputStream();
        //문자열을 바이트 배열로 바꿔서
        //출력스트림에 작성
        os.write(log.getBytes());
        //버퍼에 남아있는 데이터를 강제전송
        //close()내부에서 보통 flush()를 수행하고 close를 하지만
        //close 안할경우에는 flush()가 중요
        os.flush();
        //스트림을 닫기, close 이후 os.write() 동작 x
        os.close();


        int responseCode = conn.getResponseCode();
        //System.out.println(responseCode);
        conn.disconnect();

    }
    static void sendPurchaseLog(String log) throws Exception{
        URL url = new URL("http://localhost:8080/DBPurchaseInsert.php");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");

        conn.setRequestProperty("Content-Type","application/json");
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        os.write(log.getBytes());
        os.close();
        int responseCode = conn.getResponseCode();
        conn.disconnect();

    }
    static void sendUserErrorLog(String log)throws Exception{
        URL url = new URL("http://localhost:8080/DBUserErrorInsert.php");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");

        con.setRequestProperty("Content-Type","application/json");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        os.write(log.getBytes());
        os.close();
        int responseCode = con.getResponseCode();
        con.disconnect();
    }



}
