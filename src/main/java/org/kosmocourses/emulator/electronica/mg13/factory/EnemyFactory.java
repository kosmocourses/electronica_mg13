package org.kosmocourses.emulator.electronica.mg13.factory;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import org.kosmocourses.emulator.electronica.mg13.model.AttackPosition;
import org.kosmocourses.emulator.electronica.mg13.model.Bullet;
import org.kosmocourses.emulator.electronica.mg13.model.EnemySpacecraft;
import org.kosmocourses.emulator.electronica.mg13.model.GameObject;

public class EnemyFactory {
    public static GameObject newEnemy(GameWorld world, AttackPosition position) {
        EnemySpacecraft enemySpacecraft;
        switch (position) {
            case LEFT_UP:
                enemySpacecraft = new EnemySpacecraft(world.spawn("enemy", 165, 90), position);
                break;
            case LEFT_DOWN:
                enemySpacecraft = new EnemySpacecraft(world.spawn("enemy", 165, 220), position);
                break;
            case RIGHT_UP:
                enemySpacecraft = new EnemySpacecraft(world.spawn("enemy", 385, 90), position);
                break;
            default:
                enemySpacecraft = new EnemySpacecraft(world.spawn("enemy", 385, 220), position);
        }
        return enemySpacecraft;
    }
}
