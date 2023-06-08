package org.example.mode.method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Statistics {
    /**
     * 根据createTime计算一天每小时新增
     * @param createTime  根据sql查询获得
     * WHERE create_time BETWEEN #{t1} AND #{t2}
     * @return List
     */
    private List<Integer> hourlyIncrement(List<Date> createTime) {
        List<Integer> hourlyUserCount = new ArrayList<>(24);
        for (int i = 0; i < 24; i++) {
            hourlyUserCount.add(0);
        }
        for (Date createDate : createTime) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(createDate);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            // add one to the number of hours
            hourlyUserCount.set(hour, hourlyUserCount.get(hour) + 1);
        }
        return hourlyUserCount;
    }

    /**
     * 计算过去每天新增数据
     * @param days 过去几天
     * @param startDate 过去开始时间
     * @param createTime 根据sql查询获得
     * WHERE create_time BETWEEN #{t1} AND #{t2}
     * @return List 根据days决定size
     * @throws ParseException
     */
    private List<Integer> countDaysAgo(int days, String startDate, List<Date> createTime)
            throws ParseException {
        List<Integer> pastList = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            pastList.add(0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateFormat = sdf.parse(startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDateFormat);
        for (Date date : createTime) {
            calendar.setTime(date);
            // calculate time difference
            long diff = TimeUnit.DAYS.convert(date.getTime() - startDateFormat.getTime(),
                    TimeUnit.MILLISECONDS);
            int day = (int) diff;
            if (day < pastList.size()) {
                pastList.set(day, pastList.get(day) + 1);
            }
        }
        return pastList;
    }
}
