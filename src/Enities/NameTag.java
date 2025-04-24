package Enities;

import java.awt.*;

public class NameTag {
    private String name;
    private int x;
    private int y;

    public NameTag(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 0));// color name tag
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(name, x, y - 10); // draw name up on object
    }

}
