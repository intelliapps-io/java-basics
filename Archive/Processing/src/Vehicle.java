import processing.core.PApplet;
import processing.core.PVector;

class Vehicle {
    private PApplet p;
    private float radius;
    private PVector mouse, location, velocity, acceleration;
    private float maxSpeed = (float) 3.0;
    private float maxForce = (float) 0.6;

    Vehicle(PApplet parent, float _radius) {
        p = parent;
        radius = _radius;
        mouse = new PVector(p.mouseX, p.mouseY);
        location = new PVector(0, 0);
        velocity = new PVector(0, -2);
        acceleration = new PVector(0, 0);
    }

    private void update() {
        mouse.x = p.mouseX;
        mouse.y = p.mouseY;
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        location.add(velocity);
        acceleration.mult(0);
    }

    private void applyForce(PVector force) {
        acceleration.add(force);
    }

    private void seek(PVector target) {
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
        float theta = velocity.heading() + p.PI / 2;
        p.fill(200, 200, 200);

        p.pushMatrix();
        p.translate(location.x,location.y);
        p.rotate(theta);
        p.beginShape();
        p.vertex(0, -radius*2);
        p.vertex(-radius, radius*2);
        p.vertex(radius, radius*2);
        p.endShape(p.CLOSE);
        p.popMatrix();
    }
}
