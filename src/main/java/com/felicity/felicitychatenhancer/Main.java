package com.felicity.felicitychatenhancer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    Tools t = new Tools();
    private static Main inst;

    public Main() {
        inst = this;
    }

    public static Main getInst() {
        return inst;
    }


    @Override
    public void onEnable() {
        FileManager.checkFiles();
        this.saveDefaultConfig();
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new ListenerClass(), this);
    }

    @Override
    public void onDisable() {
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        boolean isPlayer = (sender instanceof Player);
        if (isPlayer) {
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("reload")) {
                if (!player.hasPermission("filter.reload")) {
                    t.sendMsg(player, "output.no-permission");
                    return true;
                } else {
                    this.reloadConfig();
                    FileManager.checkFiles();
                    t.sendMsg(player, "output.command.reload");
                    return true;
                }
            }
        }

        return false;
    }
}