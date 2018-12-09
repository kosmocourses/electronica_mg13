package org.kosmocourses.emulator.electronica.mg13.plugin;

import org.kosmocourses.emulator.electronica.mg13.GameException;

public class GamePluginException extends GameException {

    public GamePluginException(String message) {
        super(message);
    }

    public GamePluginException(String message, Throwable cause) {
        super(message, cause);
    }
}
