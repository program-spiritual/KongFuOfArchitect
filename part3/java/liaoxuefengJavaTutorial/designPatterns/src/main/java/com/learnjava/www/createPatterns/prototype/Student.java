package com.learnjava.www.createPatterns.prototype;

public class Student implements Cloneable {

  private int id;
  private String name;
  private int score;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  // 复制新对象并返回:
  public Object clone() {
    Student std = new Student();
    std.id = this.id;
    std.name = this.name;
    std.score = this.score;
    return std;
  }

  public Student copy() {
    Student std = new Student();
    std.id = this.id;
    std.name = this.name;
    std.score = this.score;
    return std;
  }
}
