package org.kosmocourses.emulator.electronica.mg13.model;

import com.almasb.fxgl.entity.Entity;

public class EnemySpacecraft extends GameObject {
    private AtackPosition atackPosition;
    private Entity entity;

    public EnemySpacecraft(Entity entity, AtackPosition atackPosition) {
        super(entity);
        this.atackPosition = atackPosition;
    }

    public AtackPosition getAtackPosition() {
        return atackPosition;
    }

    public void setAtackPosition(AtackPosition atackPosition) {
        this.atackPosition = atackPosition;
    }
}
