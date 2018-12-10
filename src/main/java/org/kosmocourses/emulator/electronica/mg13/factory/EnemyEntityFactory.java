package org.kosmocourses.emulator.electronica.mg13.factory;

import com.almasb.fxgl.entity.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EnemyEntityFactory implements EntityFactory {

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        // Fixme: add change texture
        return Entities.builder()
                .from(data)
                .viewFromNode(new Rectangle(70, 70, Color.BLACK))
                .renderLayer(RenderLayer.TOP)
                .build();
    }
}
