package com.mateeus.mining.controller;

public class PluginController {

    private static boolean plugin = false;

    public static void enablePlugin(){
        plugin = true;
    }

    public static void disablePlugin(){
        plugin = false;
    }

    public static boolean isEnabled(){
        return plugin;
    }

}
