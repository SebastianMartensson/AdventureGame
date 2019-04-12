package controller.world;


import controller.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Keybind implements Serializable {
    private String northKey;
    private String southKey;
    private String westKey;
    private String eastKey;
    private String openInventory;
    private String openHeroStatus;
    private String openMap;
    private String openMenu;
    private String openDevelopmentMap;
    private ArrayList<String> keybinds;
                
    public Keybind() {
        keybinds = new ArrayList<>();
        northKey = "W";
        southKey = "S";
        westKey = "A";
        eastKey = "D";
        openInventory = "I";
        openHeroStatus = "H";
        openMap = "M";
        openMenu = "P";
        openDevelopmentMap = "U";
        addKeyBinds();
    }
    
    private void addKeyBinds(){
        keybinds.add(northKey);
        keybinds.add(southKey);
        keybinds.add(westKey);
        keybinds.add(eastKey);
        keybinds.add(openInventory);
        keybinds.add(openHeroStatus);
        keybinds.add(openMap);
        keybinds.add(openMenu);
        keybinds.add(openDevelopmentMap);
    }

    public String getNorthKey() {
        return northKey;
    }

    public String getSouthKey() {
        return southKey;
    }

    public String getWestKey() {
        return westKey;
    }

    public String getEastKey() {
        return eastKey;
    }

    public String getOpenInventory() {
        return openInventory;
    }

    public String getOpenHeroStatus() {
        return openHeroStatus;
    }

    public String getOpenMap() {
        return openMap;
    }

    public String getOpenMenu() {
        return openMenu;
    }

    public void setNorthKey(String northKey) {
        this.northKey = northKey;
        keybinds.set(0, getNorthKey());
    }

    public void setSouthKey(String southKey) {
        this.southKey = southKey;
        keybinds.set(1, getSouthKey());
    }

    public void setWestKey(String westKey) {
        this.westKey = westKey;
        keybinds.set(2, getWestKey());
    }

    public void setEastKey(String eastKey) {
        this.eastKey = eastKey;
        keybinds.set(3, getEastKey());
    }

    public void setOpenInventory(String openInventory) {
        this.openInventory = openInventory;
        keybinds.set(4, getOpenInventory());
    }

    public void setOpenMap(String openMap) {
        this.openMap = openMap;
    }

    public void setOpenMenu(String openMenu) {
        this.openMenu = openMenu;
    }

    public String getOpenDevelopmentMap() {
        return openDevelopmentMap;
    }

    public ArrayList<String> getKeybinds() {
        return keybinds;
    }
}


