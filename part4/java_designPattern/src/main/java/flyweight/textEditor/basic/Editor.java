package flyweight.textEditor.basic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Character> characters = new ArrayList<>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, font, size, colorRGB);
        characters.add(character);
    }
}
