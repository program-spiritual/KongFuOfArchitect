package collection.theEqualsMethod;

import java.util.List;

public class ActorEquals {
    public static void main(String[] args) {
        List<Actor> list = List.of(
                new Actor("Xiao Ming"),
                new Actor("Xiao Hong"),
                new Actor("Bob")
        );
        System.out.println(list.contains(new Actor("Bob"))); // false
    }
}

