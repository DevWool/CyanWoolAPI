package net.cyanwool.api.command;

import net.cyanwool.api.CyanWool;
import net.cyanwool.api.Server;
import net.cyanwool.api.utils.ChatColor;

public class ConsoleCommandSender implements ICommandSender {

	@Override
	public void sendMessage(String message) {
		String mess = ChatColor.stripColor(message);
		getServer().getLogger().info(mess);
	}

	@Override
	public Server getServer() {
		return CyanWool.getServer();
	}

	@Override
	public String getName() {
		return "Console";
	}

	@Override
	public boolean isPlayer() {
		return false;
	}

	@Override
	public String getLangCode() {
		return "en_US";
	}
}
