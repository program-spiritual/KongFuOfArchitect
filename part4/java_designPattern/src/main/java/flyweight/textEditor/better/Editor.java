package flyweight.textEditor.better;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private final List<Character> chars = new ArrayList<>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
    public List<Character> getChars() {
        return chars;
    }
}
