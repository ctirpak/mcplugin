package com.github.ctirpak.mcplugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("explode").setExecutor(new TestPluginCommandExecutor(this));
		PluginManager pm = getServer().getPluginManager();
		TestPluginListener listener = new TestPluginListener(this);
		pm.registerEvents(listener, this);
		getLogger().info("TestPlugin has been enabled");
	}
	@Override
	public void onDisable() {
		getLogger().info("TestPlugin has been disabled");
	}
	

}
