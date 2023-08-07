# spring-boot-cron-implementation
Spring Boot Schedular

#  Scheduling Cron Expression

# Spring Framework makes it simple by offering Spring Scheduler. Moreover, Cron Expressions are the most widely used approach to achieve scheduling. Cron Expressions are very popular in Unix/Linux OS for scheduling.Spring framework also incorporates the same concept internally. Spring Framework offers us an API where we can utilize Cron expression to get the task scheduled.

```
https://www.freeformatter.com/cron-expression-generator-quartz.html
```

What is a Cron Expression?
Cron is a typical Unix utility that is used to schedule a task for automatic execution of it at particular intervals. For example, you might have a task that generates a specific pdf report from your application and you want to generate this report weekly on Monday automatically at 9:00 AM. 

A cron expression is a string consisting of six or seven subexpressions (fields) that describe individual details of the schedule. These fields, separated by white space, can contain any of the allowed values with various combinations of the allowed characters for that field. Below picture shows the fields in the expected order and allowed values with characters.

Note: As per the Spring Framework’s documentation, the allowed values for the field ‘day of week’ are 0-7. Here ‘0’ or ‘7’ both represent ‘Sunday’. Hence, below listings shows the clear mapping of days with numbers.

0 = Sunday
1 = Monday
2 = Tuesday
3 = Wednesday
4 = Thursday
5 = Friday
6 = Saturday
7 = Sunday

Note: The previous versions and the latest Spring 6.0 supports six fields in the cron expression: second, minute, hour, day of month, month and day of week. The parse( ) method of CronExpression class provided by the Spring Framework says that if fields’ length is not equal to 6, you will face IllegalArgumentException. Below code snippet is from parse( ) method of CronExpression class. 

```

if (fields.length != 6) {
    throw new IllegalArgumentException(String.format(
         "Cron expression must consist of 6 fields (found %d in \"%s\")", fields.length, expression));
}

```

How To Write a Cron Expression?

1) There are 6 Asterisks (* * * * * *) by default as a placeholder in cron expression as shown in the picture above. Further, each asterisk represents a value. These values can be assigned as Seconds, Minutes, Hours, Day Of Month, Month, Day Of Week respectively in the sequence.
Allowed values at proper place are also given in the picture above.

2) A Cron Expression can accept symbols : *  –   ,   /   ?   L   W  #

3) Comma denotes possible values separated by comma
For example, the expression “0 0 4,14 * * *” denotes ‘4:00:00AM and 2:00:00 PM every day’.

4) Dash (-) denotes a range, which means, considering all possible values between the range. Ranges of numbers are expressed by two numbers separated with a hyphen. The specified range is inclusive.

For example, the expression ”0 0 2-4 * * *” just denotes ‘execute given task every day 2:00:00AM, 3:00:00AM and 4:00:00AM’.

5) Asterisk(*) denotes any/every/all value

For example, the expression “0 0 * * * *” denotes ‘the top of every hour of every day’ or in simple terms ‘hourly’.

6) Forward slash(/) denotes a period of time

For example, the expression “0 0/30 2-4 * * *” denotes ‘2:00, 2:30, 3:00, 3:30, 4:00 and 4:30AM every day’.

7) Question mark(?) denotes any value like *, but it can be used for the ‘day of the month’ or ‘day of the week’ fields instead of an asterisk.

8) English names can also be used for the month and the day-of-week fields. Use the first three letters of the particular day of week or month (case does not matter). While writing a Spring Scheduling Cron Expression, it is advisable to use English names for the ‘day-of-week’ and ‘months’ instead of numbers, as they are self explanatory and also eliminates the chances of making mistakes.

For example, 11 = NOV and 5 = FRI
9) L: The ‘day of month’ and ‘day of week’ fields can contain an ‘L’ character, which stands for ‘last’, and has a different meaning in each field. In the ‘day of month’ field, L stands for ‘the last day of the month’. If followed by a negative offset i.e. ‘L-n’, it means ‘nth-to-last day of the month’. For example, L-3 = third-to-last day of the month. If followed by W i.e. ‘LW’, it means ‘the last weekday of the month’.

In the ‘day of week’ field, L stands for ‘the last day of the week’. If prefixed by a number or three-letter name i.e. ‘nL’ or ‘DDDL’, it means “the last day of week ‘n’ or ‘DDD’ in the month” respectively.

For example, 5L = last Friday of the month. TUEL = last Tuesday of the month.

10) W: The character ‘W’ is applicable to the ‘day of month’ only. The ‘day of month’ field can be ‘nW’, which stands for ‘the nearest weekday to day of the month n’.

For example, ‘1W’ stands for the ‘first weekday of the month’. ‘4W’ stands for the ‘fourth weekday of the month’. ‘LW’ stands for the ‘last weekday of the month’.

If n falls on Saturday, this returns the Friday. On the other hand, if n falls on Sunday, this returns the Monday.

11) #: The character ‘#’ is applicable to the ‘day of week’ only. The ‘day of week’ field can be ‘d#n’ or ‘DDD#n’, which stands for ‘the n-th day of week d or DDD in the month’.

For example, 5#3 = the third Friday in the month. WED#1 = the first Wednesday in the month.

12) C: The ‘C’ character is shorthand for “calendar” and is only allowed for the day-of-month and day-of-week fields. This means values are calculated against the associated calendar, if any. If no calendar is associated, then it is equivalent to having an all-inclusive calendar.

For example, a value of ‘5C’ in the day-of-month field means ‘the first day included by the calendar on or after the 5th’. A value of  ‘1C’ in the day-of-week field means ‘the first day included by the calendar on or after Sunday’.

The character ‘C’ is very rarely used and even doesn’t exist in Spring 5.3 improvements. Moreover, the new CronExpression class provided by Spring 5.3 is based on ‘java.time’ APIs in contrast to CronSequesnce class in older versions which was based on ‘java.util.Calendar’ APIs.


# Code implementation 

<img width="490" alt="image" src="https://github.com/rakeshgowdan/spring-boot-cron-implementation/assets/41374671/82a182d9-f797-4589-921d-9dd74dc618f6">

<img width="477" alt="image" src="https://github.com/rakeshgowdan/spring-boot-cron-implementation/assets/41374671/874a3b0f-407b-4427-b3be-05de4c214601">


