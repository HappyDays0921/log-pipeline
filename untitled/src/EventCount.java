
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class EventCount {
    public static String[] UserLoginByTime()throws Exception{
        URL url = new URL("http://localhost:8080/Count_UserLoginByTime.php");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        /*
        //문제가 json형태의 배열로 넘어오는데 하나만 읽음
        InputStream is = conn.getInputStream();
        is.read();
        is.close();
        */

        //바이트를 문자로 변환
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        //inputsteam은 1바이트씩, 결국 반복문 사용해서 eof까지 다 읽어와야함
        //버퍼에 받아서 가져오기위해 bufferedreader 사용
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String line;

        //php의 timeline을 읽다가 더이상 없을때까지
        while((line = br.readLine())!=null)
            sb.append(line);

        String json = sb.toString();

        String[] jsonarr = json.replaceAll("[\\[\\] ]","").split(",");
        System.out.println(json);
        for(int i=0;i<24;i++)
            System.out.println(i+"시 접속:"+jsonarr[i]+"명");

        return jsonarr;

    }

    public static String[] PurchaseByCategory()throws Exception{
        URL url = new URL("http://localhost:8080/Count_PurchaseCategory.php");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine())!=null)
            sb.append(line);

        String json = sb.toString();
        //System.out.println(json);

        //카테고리 + 숫자 배열
        String[] jsonarr =json.replaceAll("[{}\"]", "").split(",");

        for(int i=0;i<jsonarr.length;i++) {
            System.out.println(jsonarr[i]);
        }

        
        //차트 만들기 위한 숫자 배열
        String[] numArr = new String[5];
        for(int i=0;i<5;i++){
            numArr[i] = jsonarr[i].substring(3);
            //System.out.println(numArr[i]);
        }
        //차트 만들기 위한 문자배열
        String[] strArr = new String[5];
        for(int i=0;i<5;i++){
            strArr[i] = jsonarr[i].substring(0,2);
            //System.out.println(strArr[i]);
        }

        return jsonarr;





    }

    public static String[] PurchaseByTime() throws Exception{
        URL url = new URL("http://localhost:8080/Count_PurchaseByTime.php");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine())!=null)
            sb.append(line);

        String json = sb.toString();

        String[] jsonarr = json.replaceAll("[\\[\\] ]","").split(",");
        System.out.println(json);
        for(int i=0;i<24;i++)
            System.out.println(i+"시 접속:"+jsonarr[i]+"명");

        return jsonarr;

    }
}
