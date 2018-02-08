package com.ruge.时间_日期API;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/8
 * \* Time: 21:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TestLocalDateTime {
    /**
     * 1 LocalDate LocalTime LocalDateTime
     */
    @Test
    public void test1() {
        /**
         * 获取当前日期
         */
        LocalDate localDate = LocalDate.now();
        /**
         * 获取当前时间
         */
        LocalTime localTime = LocalTime.now();
        /**
         * 获取当前日期时间
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        /**
         * 自定义日期时间
         */
        LocalDateTime localDateTime1 = LocalDateTime.of(2018, 8, 8, 8, 8, 8);
        /**
         * 日期时间计算:增加一年
         */
        LocalDateTime localDateTime2 = localDateTime.plusYears(1);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    /**
     * 2 Instant 时间戳(以unix元年 1970年1月1日 00:00:00 到某个时间的毫米值)
     * 时间戳对应的是java.time.Instant
     */
    @Test
    public void test2() {
        /**
         * 默认获取 UTC 时区
         */
        Instant now = Instant.now();
        /**
         * 相差八个时区   就是中国的时间了
         */
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(now);
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime.toEpochSecond());
    }

    /**
     * java.time.Duration用于计算两个“时间”间隔
     * java.time.Period用于计算两个“日期”间隔
     */
    @Test
    public void test3() throws InterruptedException {
        /**
         * 获取当前时刻
         */
        Instant now = Instant.now();
        Thread.sleep(5000);
        Instant now1 = Instant.now();
        /**
         * 获取时刻的间隔
         */
        Duration between1 = Duration.between(now, now1);
        System.out.println(between1.toMillis());
        /**
         * 自定义当前日期时间
         */
        LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 1, 1, 1, 1);
        LocalDateTime localDateTime1 = LocalDateTime.of(2018, 2, 2, 2, 2, 2);
        /**
         * 计算时刻的间隔
         */
        long l = Duration.between(localDateTime, localDateTime1).toMillis();
        System.out.println(l);
        /**
         * 自定义两个日期
         */
        LocalDate localDate1 = LocalDate.of(2018, 1, 1);
        LocalDate localDate2 = LocalDate.of(2018, 8, 8);
        /**
         * 获取两个日期之间的间隔
         */
        Period between = Period.between(localDate1, localDate2);
        /**
         * Y代表年，M代表月，D代表日
         */
        System.out.println(between);
    }

    /**
     * TemporalAdjuster 时间矫正器
     */
    @Test
    public void test4() {
        /**
         * 获取当时日期时间
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(15);
        /**
         * 日期矫正器获取本月第一天
         */
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
        LocalDateTime with = localDateTime.with(temporalAdjuster);
        System.out.println(localDateTime1);
        System.out.println(with);
    }

    /**
     * DateTimeFormatter 时间日期格式化
     * 以前我们用的日期格式化的类是java.text.SimpleDateFormat
     * Java 8 提供的日期格式化类是java.time.format.DateTimeFormatter
     */
    @Test
    public void test5() {
        /**
         *获取预定义的格式，DateTimeFormatter类预定了很多种格式
         */
        DateTimeFormatter isoLocalTime = DateTimeFormatter.ISO_DATE_TIME;
        /**
         * 自定义时间格式
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        String format = isoLocalTime.format(LocalDateTime.now());
        String format1 = formatter.format(LocalDateTime.now());
        /**
         * 将字符串转换成日期时间
         */
        LocalDateTime parse = LocalDateTime.parse(format1, formatter);
        System.out.println(format);
        System.out.println(format1);
        System.out.println(parse);
    }

    /**
     * 时区
     * 带时区的日期时间是java.time.ZonedDateTime，我们可以通过java.time.ZoneId去查看支持的时区
     */
    @Test
    public void test6(){
        /**
         * 查看支持的时区
         */
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
        LocalDateTime japan = LocalDateTime.now(ZoneId.of("Japan"));
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(japan);
        System.out.println(now);
    }
}