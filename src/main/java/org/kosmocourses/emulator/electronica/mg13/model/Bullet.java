package org.kosmocourses.emulator.electronica.mg13.model;

import com.almasb.fxgl.entity.Entity;

/**
 * Bullet fly to player spacecraft
 */
public class Bullet extends GameObject{
    private int speed;
    private AttackPosition attackPosition;


    public Bullet(Entity entity, int speed, AttackPosition attackPosition) {
        super(entity);
        this.speed = speed;
        this.attackPosition = attackPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public AttackPosition getAttackPosition() {
        return attackPosition;
    }

    public void setAttackPosition(AttackPosition attackPosition) {
        this.attackPosition = attackPosition;
    }
}
