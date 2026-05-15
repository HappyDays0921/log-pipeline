import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Chart {
    public static void UserLoginTime() throws Exception {
        EventCount ev = new EventCount();

        //막대그래프 라벨 이름 설정
        String[] labels = new String[24];
        for(int i=0;i<24;i++){
            labels[i] = i+"";
        }
        //막대그래프 수치
        String[] arr = ev.UserLoginByTime();
        int[] values = new int[24];
        for(int i=0; i<24; i++)
            values[i] = Integer.parseInt(arr[i]);

        //이미지 크기
        int width = 1500;
        int height = 800;

        BufferedImage image = new BufferedImage(
                width,height,BufferedImage.TYPE_INT_RGB
        );

        Graphics2D grapic = image.createGraphics();

        //차트 배경
        grapic.setColor(Color.WHITE);
        grapic.fillRect(0,0,width,height);

        //차트 제목
        grapic.setColor(Color.BLACK);
        grapic.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
        grapic.drawString("유저별 로그인 시간 추이",280,50);

        //막대그래프 설정
        int barWidth = 20;
        int startX =120;
        int baseY = 500;
        int scale = 4;

        for(int i=0;i<values.length;i++){
            int barHeight = values[i] * scale;
            //막대 색
            grapic.setColor(Color.gray);

            grapic.fillRect(startX+i*50, baseY-barHeight,barWidth,barHeight);
            //값 표시
            grapic.setColor(Color.BLACK);

            grapic.drawString(String.valueOf(values[i]),
                    startX+i*50,
                    baseY - barHeight-5 );

            //
            grapic.drawString(labels[i],
                    startX+i*50,
                    baseY+20);
        }

        //세로축
        grapic.drawLine(80,50,80,500);
        //가로축
        grapic.drawLine(80,500,1300,500);

        grapic.dispose();

        try{
            File dir = new File("output");
            if (!dir.exists())
                dir.mkdirs();
            ImageIO.write(image, "png", new File("output/UserLoginTimeChart.png")
            );
            System.out.println("생성 성공");
        }
        catch(Exception e){
            e.printStackTrace();
        }




    }

    public static void PurchaseTime() throws Exception {
        EventCount ev = new EventCount();

        //막대그래프 라벨이름 설정
        String[] labels = new String[24];
        for(int i=0;i<24;i++){
            labels[i] = i+"";
        }
        //막대그래프 수치
        String[] arr = ev.PurchaseByTime();
        int[] values = new int[24];
        for(int i=0; i<24; i++)
            values[i] = Integer.parseInt(arr[i]);

        //이미지 크기
        int width = 1500;
        int height = 800;

        BufferedImage image = new BufferedImage(
                width,height,BufferedImage.TYPE_INT_RGB
        );

        Graphics2D grapic = image.createGraphics();

        //차트 배경
        grapic.setColor(Color.WHITE);
        grapic.fillRect(0,0,width,height);

        //차트 제목
        grapic.setColor(Color.BLACK);
        grapic.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
        grapic.drawString("서비스 결제 시간 추이",280,50);

        //막대그래프 설정
        int barWidth = 20;
        int startX =120;
        int baseY = 500;
        int scale = 4;

        for(int i=0;i<values.length;i++){
            int barHeight = values[i] * scale;
            //막대 색
            grapic.setColor(Color.gray);

            grapic.fillRect(startX+i*50, baseY-barHeight,barWidth,barHeight);
            //값 표시
            grapic.setColor(Color.BLACK);

            grapic.drawString(String.valueOf(values[i]),
                    startX+i*50,
                    baseY - barHeight-5 );

            //
            grapic.drawString(labels[i],
                    startX+i*50,
                    baseY+20);
        }

        //세로축
        grapic.drawLine(80,50,80,500);
        //가로축
        grapic.drawLine(80,500,1300,500);

        grapic.dispose();

        try{
            File dir = new File("output");
            if (!dir.exists())
                dir.mkdirs();
            ImageIO.write(image, "png", new File("output/PurchaseTimeChart.png")
            );
            System.out.println("생성 성공");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void PurchaseCategory() throws Exception {
        EventCount ev = new EventCount();
        String[] jsonarr = ev.PurchaseByCategory();

        //numArr, strArr는 gson을 사용하지않았기에 문자와 숫자를 분리하기 위해서 선언
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

        //막대그래프 라벨 이름 설정
        String[] labels = new String[5];
        for(int i=0;i<5;i++)
            labels[i] = strArr[i];
        //막대그래프 수치
        int[] values = new int[5];
        for(int i=0;i<5;i++)
            values[i] = Integer.parseInt(numArr[i]);

        //이미지 크기
        int width = 800;
        int height = 800;

        BufferedImage image = new BufferedImage(
                width,height,BufferedImage.TYPE_INT_RGB
        );

        Graphics2D grapic = image.createGraphics();

        grapic.setColor(Color.WHITE);
        grapic.fillRect(0,0,width,height);

        grapic.setColor(Color.BLACK);
        grapic.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
        grapic.drawString("구매항목에 따른 추이",280,50);

        //막대그래프 설정
        int barWidth =10;
        int startX = 120;
        int baseY = 600;


        // 최대값 구하기
        int max = 0;
        for (int v : values) {
            if (v > max) max = v;
        }

        int maxBarHeight = 400;
        double scale = (double) maxBarHeight / max;


// 막대 그리기
        for(int i=0;i<values.length;i++){

            int barHeight = (int)(values[i] * scale);

            grapic.setColor(Color.lightGray);
            grapic.fillRect(startX+i*50, baseY-barHeight, barWidth, barHeight);

            grapic.setColor(Color.BLACK);
            grapic.drawString(String.valueOf(values[i]),
                    startX+i*50,
                    baseY-barHeight-5);
            grapic.drawString(labels[i],
                    startX+i*50,
                    baseY+20);
        }
        //세로축
        grapic.drawLine(80,100,80,600);
        //가로축
        grapic.drawLine(80,600,500,600);
        grapic.dispose();

        try{
            File dir = new File("output");
            if (!dir.exists())
                dir.mkdirs();
            ImageIO.write(image, "png", new File("output/PurchaseCategoryChart.png")
            );
            System.out.println("생성 성공");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
