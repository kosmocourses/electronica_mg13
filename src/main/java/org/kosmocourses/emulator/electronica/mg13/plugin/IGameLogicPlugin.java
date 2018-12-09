package org.kosmocourses.emulator.electronica.mg13.plugin;

import com.almasb.fxgl.entity.GameWorld;
import org.kosmocourses.emulator.electronica.mg13.model.GameObject;

import java.util.Set;

public interface IGameLogicPlugin {
    void onUpdate(GameWorld gw, GameObject player, Set<GameObject> emmies, Set<GameObject> bullets) throws GamePluginException;
}
