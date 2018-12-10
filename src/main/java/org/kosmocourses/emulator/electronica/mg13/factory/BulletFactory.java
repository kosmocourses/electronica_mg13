package org.kosmocourses.emulator.electronica.mg13.factory;

import com.almasb.fxgl.entity.GameWorld;
import org.kosmocourses.emulator.electronica.mg13.model.AttackPosition;
import org.kosmocourses.emulator.electronica.mg13.model.Bullet;
import org.kosmocourses.emulator.electronica.mg13.model.GameObject;

public class BulletFactory {
    public static GameObject newBullet(GameWorld world, AttackPosition position) {
        return new Bullet(world.spawn("bullet", 10, 10), 10, position);
    }
}
