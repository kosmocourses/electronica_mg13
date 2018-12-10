package org.kosmocourses.emulator.electronica.mg13.plugin;

import com.almasb.fxgl.entity.GameWorld;
import org.kosmocourses.emulator.electronica.mg13.model.GameObject;

import java.util.Set;

public class GameLogicPlugin implements IGameLogicPlugin {
    @Override
    public void onUpdate(GameWorld gameWorld, GameObject player, Set<GameObject> emmies, Set<GameObject> bullets) {
        // Update current world
        calculateNewPositions(gameWorld, player, emmies, bullets);
        hitChecker(gameWorld, player, bullets);
        deadChecker(gameWorld, player, bullets);



//        // Make bullet
//        bullets.add(BulletFactory.newBullet(getGameWorld(), AttackPosition.LEFT_DOWN));
//        // Make enemy spacecraft
//        emmies.add(EnemyFactory.newEnemy(getGameWorld(), AttackPosition.LEFT_DOWN))
    }

    // Расчитать новые позиции всех объектов исходя из позиции атаки и скорости
    private void calculateNewPositions(GameWorld gameWorld, GameObject player, Set<GameObject> emmies, Set<GameObject> bullets) {

    }

    // Проверить уровень жизни и если он = 0, завершить игру и проиграть звук финала
    private boolean deadChecker(GameWorld gameWorld, GameObject player, Set<GameObject> bullets) {

        return false;
    }

    // Проверить что пули попали в корабл игрока, сократить его жизнь и добавить "*" в строке life,
    // если пуля попала в щит уничтожить пулю и прибавить одно очко.
    private void hitChecker(GameWorld gameWorld, GameObject player, Set<GameObject> bullets) {

    }
}
