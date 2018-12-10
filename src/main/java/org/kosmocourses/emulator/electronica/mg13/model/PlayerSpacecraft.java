package org.kosmocourses.emulator.electronica.mg13.model;


import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.RenderLayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlayerSpacecraft extends GameObject{
    private AttackPosition shieldPosition;
    private Map<String, Entity> shields;
    private int life;

    public PlayerSpacecraft(Entity entity) {
        super(entity);
        this.life = 3;
        this.shieldPosition = AttackPosition.RIGHT_DOWN;
        this.shields = new HashMap<>();
    }

    public AttackPosition getShieldPosition() {
        return shieldPosition;
    }

    public void setShieldPosition(AttackPosition shieldPosition) {
        this.shieldPosition = shieldPosition;

        entity.getWorld().removeEntities(shields.values());
        shields.clear();

        entity.getWorld().addEntity(Objects.requireNonNull(shields.put("last", newShield(shieldPosition))));
    }

    public int getLife() {
        return life;
    }

    public void hit() {
        this.life--;
    }

    private Entity newShield(AttackPosition position){
        // Fixme: add change texture
        int x = 0;
        int y = 0;
        switch (position){
            case LEFT_UP:
                x = 330;
                y = 155;
                break;
            case LEFT_DOWN:
                x = 330;
                y = 195;
                break;
            case RIGHT_UP:
                x = 370;
                y = 155;
                break;
            case RIGHT_DOWN:
                x = 370;
                y = 195;
        }
        return Entities.builder()
                .at(x,y)
                .viewFromNode(new Rectangle(7, 30, Color.GOLD))
                .renderLayer(RenderLayer.TOP)
                .build();
    }
}
