package org.kosmocourses.emulator.electronica.mg13.model;

import com.almasb.fxgl.entity.Entity;

public class EnemySpacecraft extends GameObject {
    private AttackPosition attackPosition;
    private Entity entity;

    public EnemySpacecraft(Entity entity, AttackPosition attackPosition) {
        super(entity);
        this.attackPosition = attackPosition;
    }

    public AttackPosition getAttackPosition() {
        return attackPosition;
    }

    public void setAttackPosition(AttackPosition attackPosition) {
        this.attackPosition = attackPosition;
    }
}
