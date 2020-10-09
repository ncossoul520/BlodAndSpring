import processing.core.PVector;

public class Spring {
    private float length;
    private float k = 0.005f;
    private Blob b1, b2;

    public Spring(float length, Blob b1, Blob b2) {
        this.length = length;
        this.b1 = b1;
        this.b2 = b2;
    }

    public void moveBlobs() {
        PVector F = PVector.sub(b2.getPos(), b1.getPos());
        float mag = k*(F.mag()-length);
        F.setMag(mag);

        b1.accelerate(F);
        F.mult(-1);
        b2.accelerate(F);
    }
}
