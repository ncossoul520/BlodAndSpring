import processing.core.PApplet;
import processing.core.PVector;

public class Blob {
    private static final float MAX_SPEED = 5;
    private static final float DRAG = 0.98f;
    private PVector pos, vel, acc;
    private int size;

    public Blob(PVector pos, int size) {
        this.size = size;
        this.pos = pos;
        this.vel = new PVector(0, 0);
        this.acc = new PVector(0, 0);
    }

    public void accelerate(PVector f) {
        this.acc.add(f);
    }

    public void updatePosition() {
        vel.add(acc);
        vel.mult(DRAG);
        if (vel.mag() > MAX_SPEED) {
            vel.setMag(MAX_SPEED);
        }
        pos.add(vel);
        acc.set(0, 0);
    }

    public void draw(PApplet window) {
        window.ellipse(pos.x, pos.y, size, size);
        window.fill(0);
    }

    public PVector getPos() {
        return pos;
    }
}
