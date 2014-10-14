package me.scottapple.ServerHelp;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ServerHelp extends JavaPlugin {

    //Allows other classes to use the methods in this class
    @Getter
    public static ServerHelp plugin;
    //config version
    int version = 1;

    @Override
    public void onEnable() {
        plugin = this;
        loadConfig();
    }
    public void loadConfig() {
        File file = new File(this.getDataFolder() + File.separator + "config.yml");

        if (!file.exists()) {
            this.saveDefaultConfig();
        } else {
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            if (config.contains("Version") || config.getInt("Version", version) == version) {
                file.delete();
                File tempfile = new File(this.getDataFolder() + File.separator + "oldconfig.yml");
                try {
                    config.save(tempfile);
                } catch (IOException e) {
                    getLogger().warning(getMessage("Something went wrong when creating the Config!"));
                }
                updateConfig();
            }
        }
    }
    //Updates config if the version number has been changed
    private void updateConfig() {
        File tempfile = new File(this.getDataFolder() + File.separator + "oldconfig.yml");

        FileConfiguration oldC = YamlConfiguration.loadConfiguration(tempfile);
        this.saveDefaultConfig();
        //copies defaults over
        this.getConfig().set("Messages.DonateMsg", oldC.getString("Messages.DonateMsg"));
        this.getConfig().set("Messages.YoutubeMsg", oldC.getString("Messages.YoutubeMsg"));
        this.getConfig().set("Messages.WebsiteMsg", oldC.getString("Messages.FlashlightOffMsg"));
        this.getConfig().set("Messages.FacebookMsg", oldC.getStringList("Messages.FacebookMsg"));
        this.getConfig().set("Messages.TwitterMsg", oldC.getString("Messages.TwitterMsg"));
        this.getConfig().set("Messages.CommandsMsg", oldC.getString("Messages.CommandsMsg"));
        this.getConfig().set("Messages.EmailMsg", oldC.getString("Messages.EmailMsg"));
        this.getConfig().set("Messages.StaffMsg", oldC.getString("Messages.StaffMsg"));
        this.saveConfig();
    }
    //Message configuration method
    public static String getMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', getPlugin().getConfig().getConfigurationSection("Messages").getString("Prefix") + message);
    }
}