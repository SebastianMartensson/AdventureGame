package controller;

import java.io.Serializable;

public enum State implements Serializable {
    StartMenu,
    MainMenu,
    InGameMenu,
    NewPlayer,
    LoginPlayer,
    SaveGame,
    LoadGame,
    Settings,
    Help,
    LogOut,
    LoadingGame,
    Adventuring,
    Fighting,
    Quit
}
