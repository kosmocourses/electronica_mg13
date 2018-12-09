package org.kosmocourses.emulator.electronica.mg13;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.kosmocourses.emulator.electronica.mg13.model.AtackPosition;
import org.kosmocourses.emulator.electronica.mg13.model.GameObject;
import org.kosmocourses.emulator.electronica.mg13.model.PlayerSpacecraft;
import org.kosmocourses.emulator.electronica.mg13.plugin.IGameLogicPlugin;

import java.util.Map;
import java.util.Set;

public class Engine extends GameApplication {
    private static final Logger log = Logger.get(Engine.class);

    private static final String DEFAULT_PLUGIN_CLASS_NAME = "org.kosmocourses.emulator.electronica.mg13.plugin.GameLogicPlugin";
    private GameObject player;
    private Set<GameObject> emmies;
    private Set<GameObject> bullets;
    private IGameLogicPlugin logicPlugin;
    private Entity background;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setHeight(350);
        settings.setWidth(600);
        settings.setTitle("Электроника MG-13 'Space Explorer'");
        settings.setVersion("0.1");
    }

    @Override
    protected void initGame() {
        background = Entities.builder()
                .at(0,0)
                .viewFromTexture("device.png")
                .renderLayer(RenderLayer.BACKGROUND)
                .buildAndAttach();

        player = new PlayerSpacecraft(Entities.builder()
                .at(300, 200)
                .viewFromNode(new Rectangle(25, 25, Color.BLUE))
                .renderLayer(RenderLayer.TOP)
                .buildAndAttach());

        try {
            Class clazz = Class.forName(DEFAULT_PLUGIN_CLASS_NAME);
            logicPlugin = (IGameLogicPlugin) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new GameException(String.format("Can't find class: %s", DEFAULT_PLUGIN_CLASS_NAME), e);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new GameException(String.format("Can't instantiate class: %s", DEFAULT_PLUGIN_CLASS_NAME), e);
        }
    }

    @Override
    // Input control Q,A and O,K
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move shield to left up") {
            @Override
            protected void onAction() {
                log.debug("Set shield position to " + AtackPosition.LEFT_UP);
                ((PlayerSpacecraft) player).setShieldPosition(AtackPosition.LEFT_UP);
            }
        }, KeyCode.Q);

        input.addAction(new UserAction("Move shield to left down") {
            @Override
            protected void onAction() {
                log.debug("Set shield position to " + AtackPosition.LEFT_DOWN);
                ((PlayerSpacecraft) player).setShieldPosition(AtackPosition.LEFT_DOWN);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move shield to right up") {
            @Override
            protected void onAction() {
                log.debug("Set shield position to " + AtackPosition.RIGHT_UP);
                ((PlayerSpacecraft) player).setShieldPosition(AtackPosition.RIGHT_UP);
            }
        }, KeyCode.O);

        input.addAction(new UserAction("Move shield to right down") {
            @Override
            protected void onAction() {
                log.debug("Set shield position to " + AtackPosition.RIGHT_DOWN);
                ((PlayerSpacecraft) player).setShieldPosition(AtackPosition.RIGHT_DOWN);
//                player.translateY(5);
//                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.K);
    }

    @Override
    protected void initUI() {
//        Texture deviceTexture = getAssetLoader().loadTexture("device.png");
//        deviceTexture.setTranslateX(0);
//        deviceTexture.setTranslateY(0);
//        getGameScene().addUINode(deviceTexture);

        Text txtLife = new Text();
        txtLife.setFont(Font.font("Consolas", 30));
        txtLife.setTranslateX(320);
        txtLife.setTranslateY(150);
        getGameScene().addUINode(txtLife);
        txtLife.textProperty().bind(getGameState().stringProperty("life"));

        Text txtScope = new Text();
        txtScope.setFont(Font.font("Consolas", 35));
        txtScope.setTranslateX(385);
        txtScope.setTranslateY(120);
        getGameScene().addUINode(txtScope);
        txtScope.textProperty().bind(getGameState().intProperty("scope").asString());
    }

    @Override
    protected void onUpdate(double tpf) {
        if (logicPlugin != null) {
            logicPlugin.onUpdate(getGameWorld(), player, emmies, bullets);
        }
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("life", "* * *");
        vars.put("scope", 0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
