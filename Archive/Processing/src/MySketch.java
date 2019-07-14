import processing.core.PApplet;

class MySketch extends PApplet {
    private Vehicle myVehicle;
    private float radius = 15; //pixels

    public static void main(String[] args) {
        String[] processingArgs = { "MySketch" };
        MySketch mySketch = new MySketch();
        PApplet.runSketch(processingArgs, mySketch);
    }

    public void settings() {
        size(500, 500);
        myVehicle = new Vehicle(this, radius);
    }

    public void draw() {
        background(0);
        fill(250, 250, 250, 150);
        ellipse(mouseX, mouseY, radius * 2, radius * 2);
        myVehicle.draw();
    }
}

