package com.examle.demo.sheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


@Configuration // или @Component для регистрации расписания
@EnableScheduling

//public class MyScheduling {
//
//    @Scheduled(fixedRate = 5000) //каждые 5 секунд
//    public void test(){
//        System.out.println("MyScheduling test");
//    }
//}
//public class MyScheduling {
//
//    @Scheduled(fixedDelay = 5000, initialDelay = 15000) // через 5 секунд после завершения этого же метода и через 15 секунд после запуска приложения
//    public void test(){
//        System.out.println("MyScheduling test");
//    }
//}

public class MyScheduling {
// * секунды 0-59
// * минуты 0-59
// * часы 0-23
// * дни месяца 1-31
// * месяц 1-12
// * день недели 0-7 (где 0 и 7 это воскресенье)
    // если написать L это последние значение (к примеру последний день месяца)
    // если написать W это близжайший рабочий день
    // так же к буквам можно применять математику
    // вместо значений можно или даже нужно ставить тег, а в application.properties записать нужнужные значения в этот тег

    // все значения ставить не обязательно, но нужно понимать что будет работать пока условие истинно
//    @Scheduled(cron ="5 * * * * *") //каждую минуту на 5-й секунде
    //  @Scheduled(cron ="*/5 * * * * *")
    // @Scheduled(cron ="*/5 * * * * MON-SAT")// каждые 5 секунд с понедельника по субботу
//      @Scheduled(cron ="${my.task.cron}")
//    public void test(){
//        System.out.println("MyScheduling test");
//    }
//



    @Scheduled(fixedRate = 5000)
    public void printHello() {
        System.out.println("Привет!");
    }


    @Scheduled(fixedRate = 15000, initialDelay = 10000)
    public void printHelloWithDelay() {
        System.out.println("Привет  с задержкой!");
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void printDate() {
        System.out.println(LocalDateTime.now());
    }


    @Scheduled(cron = "0 */30 9-18 * * MON-FRI")
    public void printWorkTime() {
        System.out.println("Рабочее время");
    }


    @Scheduled(cron = " 0 0 */1 * * MON-FRI")
    public void printWorkDay() {
        System.out.println("Сегодня рабочий день");
    }


    @Scheduled(fixedDelay = 3 * (60 * 1000))
    public void printTimeStartAndEnd() {
        System.out.println("Время старта метода " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());
        for (int i = 0; i <= 5; i++) ;
        System.out.println("Время окончания метода " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());

    }


    @Scheduled(cron = "${my.task.cron}")
    public void tryCron() {
        System.out.println("Крон задача активирована");
    }


    @Scheduled(cron = "0 0 6 * * * ")
    public void checkListName() {
        List<String> names = new ArrayList<>();
        names.add("john");
        names.add("Will");
        names.add("Ron");
        names.add("Ray");
        for (String name : names) {
            System.out.println("Доброе утро " + name);
        }

    }


    @Scheduled(cron = "0 0 4 * * 6")
    public void sumNumbersWeekly() {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            sum += i;
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Сумма: " + sum + ", время вычисления: " + duration + " мс");
    }




    @Scheduled(fixedRate = 10000)
    public void printRandomNumber() {
        Random rand = new Random();
        int num = rand.nextInt(101);
        System.out.println("Случайное число: " + num);
    }


    @Scheduled(cron = "0 59 23 * * *")
    public void secondsSinceStartOfDay() {
        LocalTime now = LocalTime.now();
        int seconds = now.toSecondOfDay();
        System.out.println("Прошло секунд с начала дня: " + seconds);
    }


    @Scheduled(fixedRate = 20000)
    public void checkEvenMinute() {
        int minute = LocalTime.now().getMinute();
        if (minute % 2 == 0) {
            System.out.println("Чётная минута");
        }
    }



    boolean toggle;

    @Scheduled(fixedRate = 300000)
    public void toggleFlag() {
        toggle = !toggle;
        System.out.println("Текущее состояние: " + toggle);
    }


    List<LocalDateTime> timesList = new ArrayList<>();

    @Scheduled(fixedRate = 10000)
    public void accumulateTimes() {
        LocalDateTime now = LocalDateTime.now();
        timesList.add(now);
        // через минуту очищать
        if (timesList.size() >= 6) {
            timesList.clear();
            System.out.println("Список очищен");
        }
        System.out.println("Добавлено время: " + now);
    }



    private List<String> tasks = Arrays.asList("Задача1", "Задача2", "Задача3", "Задача4", "Задача5");

    @Scheduled(cron = "0 0 10 * * *")
    public void executeTasks() {
        for (String task : tasks) {
            System.out.println("Выполняется задача: " + task);
        }
    }


    @Scheduled(cron = "*/30 * * * * *")
    public void printActiveThreads() {
        System.out.println("Активных потоков: " + Thread.activeCount());
    }


    @Scheduled(cron = "0 0 * * * *")
    public void secondsUntilEndOfDay() {
        LocalTime now = LocalTime.now();
        int secondsPassed = now.toSecondOfDay();
        int totalSeconds = 24 * 3600;
        int remaining = totalSeconds - secondsPassed;
        System.out.println("Осталось секунд до конца дня: " + remaining);
    }


    @Scheduled(cron = "0 0-59 12 * * *")
    public void printTimeInRange() {
        LocalTime now = LocalTime.now();
        System.out.println("Сейчас: " + LocalDateTime.now());
    }



    private List<String> names = Arrays.asList("Алексей", "Мария", "Иван", "Светлана", "Дмитрий");
    @Scheduled(cron = "0 0/2 * * * *")
    public void checkNamesLength() {
        for (String name : names) {
            if (name.length() > 5) {
                System.out.println("Имя с длиной > 5: " + name);
            }
        }
    }
}