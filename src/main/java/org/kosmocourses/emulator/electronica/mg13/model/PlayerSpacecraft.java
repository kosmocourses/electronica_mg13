package org.kosmocourses.emulator.electronica.mg13.model;


import com.almasb.fxgl.entity.Entity;

public class PlayerSpacecraft extends GameObject{
    private AtackPosition shieldPosition;
    private int life;

    public PlayerSpacecraft(Entity entity) {
        super(entity);
        this.life = 4;
        this.shieldPosition = AtackPosition.RIGHT_DOWN;
    }

    public AtackPosition getShieldPosition() {
        return shieldPosition;
    }

    public void setShieldPosition(AtackPosition shieldPosition) {
        this.shieldPosition = shieldPosition;
    }

    public int getLife() {
        return life;
    }

    public void hit() {
        this.life--;
    }
}
