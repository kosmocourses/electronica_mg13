package org.kosmocourses.emulator.electronica.mg13.model;

import com.almasb.fxgl.entity.Entity;

public abstract class GameObject {
    protected Entity entity;

    protected GameObject(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
