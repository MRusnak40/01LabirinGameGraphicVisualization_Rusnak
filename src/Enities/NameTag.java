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
        g.setColor(Color.WHITE); // Barva jmenovky
        g.drawString(name, x, y - 10); // Vykreslení jmenovky nad objektem
    }

}
