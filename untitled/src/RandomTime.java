import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomTime {
    public static String time_ddhhmmss(){
        //무작위 시간표시를 위해
        Random random = new Random();
        int randDay = random.nextInt(1,28);
        int randHour = random.nextInt(24);
        int randMin = random.nextInt(60);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentTime=LocalDateTime.now();
        LocalDateTime RandomTime = currentTime.plusDays(randDay).plusHours(randHour).plusMinutes(randMin).plusSeconds(randMin);
        String randomtime_ddhhmmss = RandomTime.format(formatter);

        return randomtime_ddhhmmss;
    }
}
