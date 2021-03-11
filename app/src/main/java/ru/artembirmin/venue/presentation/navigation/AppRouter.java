package ru.artembirmin.venue.presentation.navigation;

import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;
import ru.terrakok.cicerone.commands.Forward;

public class AppRouter extends Router {

    public void navigateWithMessage(Screen screen, String message) {
        executeCommands(new Forward(screen));

    }
}
