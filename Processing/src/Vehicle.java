import processing.core.PApplet;
import processing.core.PVector;

class Vehicle  {
    private PApplet p;
    private float radius;
    private PVector mouse, location, velocity, acceleration;
    private float maxSpeed = (float) 3.0;
    private float maxForce = (float) 0.6;

    Vehicle(PApplet parent, float _radius) {
        p = parent;
        radius = _radius;
        mouse = new PVector(p.mouseX, p.mouseY);
        location = new PVector(0, 0);;
        velocity = new PVector(0,-2);
        acceleration = new PVector(0, 0);
    }

    void update() {
        mouse.x = p.mouseX; mouse.y = p.mouseY;
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        location.add(velocity);
        acceleration.mult(0);
    }

    void applyForce(PVector force) {
        acceleration.add(force);
    }

    void seek(PVector target) {
        PVector desired = PVector.sub(target, location);
        desired.normalize();
        desired.mult(maxSpeed);
        PVector steer = PVector.sub(desired, velocity);
        steer.limit(maxForce);
        applyForce(steer);
    }

    void draw() {
        update();
        seek(mouse);
        p.fill(200, 200, 200);
        p.ellipse(location.x, location.y, radius, radius);
    }
}
