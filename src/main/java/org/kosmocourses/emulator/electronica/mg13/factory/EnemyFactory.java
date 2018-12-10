package org.kosmocourses.emulator.electronica.mg13.factory;

import com.almasb.fxgl.entity.GameWorld;
import org.kosmocourses.emulator.electronica.mg13.model.AttackPosition;
import org.kosmocourses.emulator.electronica.mg13.model.Bullet;
import org.kosmocourses.emulator.electronica.mg13.model.EnemySpacecraft;
import org.kosmocourses.emulator.electronica.mg13.model.GameObject;

public class EnemyFactory {
    public static GameObject newEnemy(GameWorld world, AttackPosition position) {
        return new EnemySpacecraft(world.spawn("enemy", 10, 10), position);
    }
}
