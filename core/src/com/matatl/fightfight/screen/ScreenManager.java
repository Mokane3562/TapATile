package com.matatl.fightfight.screen;

import com.matatl.fightfight.MainGame;

public class ScreenManager {
    private static Screen currentScreen;
    public static void setScreen(Screen screen) {
        if (currentScreen != null)
            currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
        currentScreen.resize(MainGame.WIDTH, MainGame.HEIGHT);
    }
    public static Screen getCurrentScreen() {
        return currentScreen;
    }
}