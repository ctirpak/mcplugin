package com.github.ctirpak.mcplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class TestPluginListener implements Listener {
	public TestPluginListener(TestPlugin plugin) {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		ItemStack item = new ItemStack(Material.DIAMOND_AXE,1);
		player.sendMessage("Welcome " + player.getName());
		
	}

}
