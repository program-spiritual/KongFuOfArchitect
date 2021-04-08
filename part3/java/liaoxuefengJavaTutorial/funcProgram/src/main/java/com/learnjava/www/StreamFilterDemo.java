package com.learnjava.www;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFilterDemo {

  public static void main(String[] args) {
    filterDate();
  }

  static void filterNum() {
    IntStream
      .of(1, 2, 3, 4, 5, 6, 7, 8, 9)
      .filter(n -> n % 2 != 0)
      .forEach(System.out::println);
  }

  static void filterDate() {
    Stream
      .generate(new LocalDateSupplier())
      .limit(31)
      .filter(
        ldt ->
          ldt.getDayOfWeek() == DayOfWeek.SATURDAY ||
          ldt.getDayOfWeek() == DayOfWeek.SUNDAY
      )
      .forEach(System.out::println);
  }
}

class LocalDateSupplier implements Supplier<LocalDate> {

  LocalDate start = LocalDate.of(2020, 1, 1);
  int n = -1;

  public LocalDate get() {
    n++;
    return start.plusDays(n);
  }
}
