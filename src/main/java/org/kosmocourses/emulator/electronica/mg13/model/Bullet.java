package org.kosmocourses.emulator.electronica.mg13.model;

import com.almasb.fxgl.entity.Entity;

/**
 * Bullet fly to player spacecraft
 */
public class Bullet extends GameObject{
    private int speed;
    private AtackPosition atackPosition;


    public Bullet(Entity entity, int speed, AtackPosition atackPosition) {
        super(entity);
        this.speed = speed;
        this.atackPosition = atackPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public AtackPosition getAtackPosition() {
        return atackPosition;
    }

    public void setAtackPosition(AtackPosition atackPosition) {
        this.atackPosition = atackPosition;
    }
}
