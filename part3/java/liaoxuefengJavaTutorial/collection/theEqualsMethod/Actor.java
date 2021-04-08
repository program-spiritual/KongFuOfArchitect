package collection.theEqualsMethod;

import java.util.Objects;

public class Actor {

  String name;
  int age;

  public Actor(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Actor(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Actor)) return false;
    Actor actor = (Actor) o;
    return age == actor.age && name.equals(actor.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
