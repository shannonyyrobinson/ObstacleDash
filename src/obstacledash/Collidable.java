package obstacledash;


import java.awt.Color;
import java.awt.Graphics;

public interface Collidable {

    public abstract boolean didCollideRight(Object obj);

    public abstract boolean didCollideTop(Object obj);
}
