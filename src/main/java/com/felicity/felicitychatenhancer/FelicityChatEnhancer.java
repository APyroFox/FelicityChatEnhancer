package com.felicity.felicitychatenhancer;

import org.bukkit.plugin.java.JavaPlugin;


public final class FelicityChatEnhancer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("FelicityChatEnhancer has been initialized.");
        System.out.println("Developed by APyroFox for Felicity Server Network.");
        System.out.println("version: " + getDescription().getVersion());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("CAUTION: FelicityChatEnhancer has been halted.");
    }
}
