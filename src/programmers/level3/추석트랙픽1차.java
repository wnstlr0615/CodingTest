package programmers.level3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 추석트랙픽1차 {
    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        LocalDate localDate = LocalDate.of(2016, 9, 15);
        LocalDateTime a = LocalDateTime.of(localDate, LocalTime.of(1, 0, 2, 3));
        LocalDateTime b = LocalDateTime.of(localDate, LocalTime.of(1, 0, 4, 1));

        LocalDateTime start = LocalDateTime.of(localDate, LocalTime.of(1, 0, 4, 1));
        LocalDateTime end = LocalDateTime.of(localDate, LocalTime.of(1, 0, 5, 1));
        Data data = new Data(a, b);
        System.out.println(data.check(start, end));
        //System.out.println(solution(lines));
    }
    public static int solution(String[] lines) {
        ArrayList<Data> dataList = new ArrayList<Data>();
        ArrayList<LocalDateTime> totalDateTimes = transferToData(lines, dataList);
        ArrayList<Data> curData = new ArrayList<Data>();
        for (Data data : dataList) {
            System.out.println(data);
        }
        Collections.sort(totalDateTimes);
        int maxCnt = 1;

        int L = 0;
        int R = 0;
        System.out.println();
        for (LocalDateTime start : totalDateTimes) {
            LocalDateTime end = start.plusSeconds(1).minusNanos(1000000);

            System.out.println(start +" 부터");
            while(R < dataList.size() && dataList.get(R).check(start, end)){
                curData.add(dataList.get(R));
                System.out.println(dataList.get(R));
                R++;
            }
            System.out.println(curData.size());
            System.out.println(curData);
            maxCnt = Math.max(maxCnt, curData.size());
            while(L < dataList.size() && !dataList.get(L).check(start, end)){
                curData.remove(dataList.get(L));
                L++;
            }
            System.out.println(end +" 까지");
        }
        System.out.println(maxCnt);

        return maxCnt ;
    }

    private static ArrayList<LocalDateTime> transferToData(String[] lines, ArrayList<Data> data) {
        ArrayList<LocalDateTime> totalDateTime = new ArrayList<>();
        Arrays.stream(lines)
                .forEach(s -> {
                    String[] split = s.split(" ");
                    LocalDate localDate = LocalDate.parse(split[0]);
                    LocalTime localTime = LocalTime.parse(split[1]);
                    long millionSeconds = (int) (Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * 1000);
                    long nanoSeconds = (millionSeconds - 1) * 1000000;
                    LocalDateTime start = LocalDateTime.of(localDate, localTime.minusNanos(nanoSeconds));
                    LocalDateTime end = LocalDateTime.of(localDate, localTime);
                    data.add(new Data(start, end));
                    totalDateTime.add(start);
                    totalDateTime.add(end);
                });
        return totalDateTime;
    }
}
class Data{
    LocalDateTime start;
    LocalDateTime end;

    public Data(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }
    public boolean check(LocalDateTime L, LocalDateTime R){
        L = L.minusNanos(1);
        R = R.minusNanos(1);
        if(start.isAfter(L) && end.isBefore(R)){
            return true;
        }
        if(start.isBefore(L) && end.isAfter(L)){
            return true;
        }
        if(start.isBefore(R) && end.isAfter(R)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Data{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
