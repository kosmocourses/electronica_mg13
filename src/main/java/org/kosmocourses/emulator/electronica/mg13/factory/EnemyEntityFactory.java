package org.kosmocourses.emulator.electronica.mg13.factory;

import com.almasb.fxgl.entity.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EnemyEntityFactory implements EntityFactory {

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        String enemyTexture = "enemy-rd.png";
        boolean isRight = data.getX() > 300;
        boolean isDown = data.getY() > 175;

        if (!isRight && !isDown) {
            // LEFT UP Position
            enemyTexture = "enemy-lu.png";
        } else if (!isRight && isDown) {
            // LEFT DOWN Position
            enemyTexture = "enemy-ld.png";
        } else if (isRight && !isDown) {
            // RIGHT UP Position
            enemyTexture = "enemy-ru.png";
        } else {
            // RIGHT DOWN Position
            enemyTexture = "enemy-rd.png";
        }

        return Entities.builder()
                .from(data)
                .viewFromTexture(enemyTexture)
                .renderLayer(RenderLayer.TOP)
                .build();
    }
}
