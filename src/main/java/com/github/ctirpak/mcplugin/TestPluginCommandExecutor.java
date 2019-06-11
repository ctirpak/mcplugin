package com.github.ctirpak.mcplugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

public class TestPluginCommandExecutor implements CommandExecutor {
	private final TestPlugin plugin;

	public TestPluginCommandExecutor(TestPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Location location = player.getEyeLocation();

			switch (command.getName().toLowerCase()) {
			case "explode":
				player.sendMessage("run...");
				// Multiply the direction from the location by 2 and store it as vector
				Vector v = location.getDirection().multiply(2);
				for(int x = 0; x < 17; x++) {
					
					TNTPrimed tnt = player.getWorld().spawn(player.getLocation(),TNTPrimed.class);
					v = location.getDirection().multiply(2);
					// Apply the vector to the primed tnt
					tnt.setVelocity(v);
				}
				return true;
			default: 
				break;
			}	
		} else {
			// It will send them this message.
			sender.sendMessage("You must be a player to use this command");
		}
		// And if all of this goes wrong, it will just return false (Do nothing)
		return false;
	}
}
