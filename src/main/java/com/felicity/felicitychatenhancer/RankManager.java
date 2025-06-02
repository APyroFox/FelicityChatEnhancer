package com.felicity.felicitychatenhancer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.List;

public class RankManager {
    private final FileConfiguration config;

    public RankManager(FileConfiguration config) {
        this.config = config;
    }

    public String getRank(Player player) {
        String name = player.getName();
        if (config.isSet("ranks." + name)) {
            return config.getString("ranks." + name);
        }
        return "Member";
    }

    public String getRankFormat(String rank) {
        return config.getString("rank-formats." + rank, "&7[Member]");
    }

    public List<String> getRankPermissions(String rank) {
        return config.getStringList("rank-permissions." + rank);
    }

    public List<String> getAllowedCommands(String rank) {
        return config.getStringList("rank-commands." + rank);
    }
}
