import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<Blob> blobs;
    ArrayList<Spring> springs;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        frameRate(30);
        blobs = makeBlobList(100);
        springs = makeSpringFor(blobs, 200);
    }

    public void draw() {
        background(255);
        moveBlobs();
        drawBlobs();
    }

    private ArrayList<Blob> makeBlobList(int numBlobs) {
        ArrayList<Blob> out = new ArrayList<>();

        for (int i = 0; i < numBlobs; i++) {
            Blob b = new Blob((int)(100+Math.random()*600), (int)(100+Math.random()*600), 10);
            out.add(b);
        }
        return out;
    }

    private ArrayList<Spring> makeSpringFor(ArrayList<Blob> blobs, int restingLength) {
        ArrayList<Spring> springs = new ArrayList<>();

        for (int i = 0; i < blobs.size(); i++) {
            for (int j = i+1; j < blobs.size(); j++) {
                Blob b1 = blobs.get(i);
                Blob b2 = blobs.get(j);

                Spring s = new Spring(restingLength, b1, b2);
                springs.add(s);
            }
        }
        return springs;
    }

    private void moveBlobs() {
        for (Spring s : springs) {
            s.moveBlobs();
        }

        for (Blob b: blobs) {
            b.updatePosition();
        }
    }

    private void drawBlobs() {
        for (Blob b: blobs) {
            b.draw(this);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
