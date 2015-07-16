package net.cyanwool.api;

import java.util.List;

import net.cyanwool.api.command.CommandManager;
import net.cyanwool.api.command.ConsoleCommandSender;
import net.cyanwool.api.entity.EntityManager;
import net.cyanwool.api.io.IOManager;
import net.cyanwool.api.lang.LanguageManager;
import net.cyanwool.api.management.OperatorsManager;
import net.cyanwool.api.management.PlayerManager;
import net.cyanwool.api.management.WhitelistManager;
import net.cyanwool.api.network.NetworkServer;
import net.cyanwool.api.packs.ServerPack;
import net.cyanwool.api.plugins.PluginManager;
import net.cyanwool.api.scheduler.Scheduler;
import net.cyanwool.api.utils.Registry;
import net.cyanwool.api.utils.ServerConfiguration;

import org.apache.logging.log4j.Logger;

public class CyanWool {

	private static Server server;

	/**
	 * 
	 * Инициализация сервера
	 * 
	 * @param init
	 *            - Сервер
	 */
	public static void initServer(Server init) {
		if (getServer() != null) {
			server.getLogger().warn("Cannot redefine singleton Server");
			return;
		}
		server = init;
		getServer().getLogger().info("#====#_CyanWool_#====#");
		getServer().getLogger().info("Mod Name: " + getServer().getModName());
		getServer().getLogger().info("Host Address: " + getServer().getNetworkServer().getHostAddress());
		getServer().getLogger().info("Port: " + getServer().getNetworkServer().getPort());
		getServer().getLogger().info("Minecraft Version: " + getServer().getMCVersion());
		getServer().start();
	}

	/**
	 * Возвращает сервер
	 * 
	 * @return Сервер
	 */
	public static Server getServer() {
		return server;
	}

	/**
	 * 
	 * Название реализационого сервера
	 * 
	 * @return Название
	 */
	public static String getModName() {
		return getServer().getModName();
	}

	/**
	 * Версия Minecraft
	 * 
	 * @return Версия
	 */
	public static String getMCVersion() {
		return getServer().getMCVersion();
	}

	/**
	 * Возвращает логгер
	 * 
	 * @return Логгер из org.apache.logging.log4j
	 */
	public static Logger getLogger() {
		return getServer().getLogger();
	}

	/**
	 * Менеджер белого списка
	 * 
	 * @return
	 */
	public static WhitelistManager getWhitelistManager() {
		return getServer().getWhitelistManager();
	}

	/**
	 * Менеджер операторов
	 * 
	 * @return
	 */
	public static OperatorsManager getOperatorsManager() {
		return getServer().getOperatorsManager();
	}

	/**
	 * Менеджер для создания класса игрока и его взаимнодействия. Например заход игрока на сервер.
	 * 
	 * @return
	 */
	public static PlayerManager getPlayerManager() {
		return getServer().getPlayerManager();
	}

	/**
	 * Сервер для обработки с пакетами.
	 * 
	 * @return
	 */
	public static NetworkServer getNetworkServer() {
		return getServer().getNetworkServer();
	}

	/**
	 * Менеджер для регистрации/удаления сущностей.
	 * 
	 * @return
	 */
	public static EntityManager getEntityManager() {
		return getServer().getEntityManager();
	}

	/**
	 * Отправить сообщение в глобальный чат (В том числе сервер).
	 * 
	 * @param message
	 *            - Сообщение
	 */
	public static void broadcastMessage(String message) {
		getServer().broadcastMessage(message);
	}

	/**
	 * Выключить сервер с сообщением
	 * 
	 * @param message
	 *            - Сообщение
	 */
	public static void shutdown(String message) {
		getServer().shutdown(message);
	}

	/**
	 * Менеджер языковых пакетов
	 */
	public static LanguageManager getLanguageManager() {
		return getServer().getLanguageManager();
	}

	/**
	 * Список разработчиков
	 * 
	 * @return
	 */
	public static List<String> getDevelopers() {
		return getServer().getDevelopers();
	}

	/**
	 * Регистратор блоков и предметов
	 */
	public static Registry getRegistry() {
		return getServer().getRegistry();
	}

	/**
	 * Менеджер для регистрации плагинов
	 */
	public static PluginManager getPluginManager() {
		return getServer().getPluginManager();
	}

	/**
	 * Менеджер для регистрации/удаления команд
	 * 
	 * @return
	 */
	public CommandManager getCommandManager() {
		return getServer().getCommandManager();
	}

	/**
	 * Консоль
	 * 
	 * @return
	 */
	public ConsoleCommandSender getConsoleCommandSender() {
		return getServer().getConsoleCommandSender();
	}

	/**
     * 
     */
	public ServerPack getServerPack() {
		return getServer().getServerPack();
	}

	/**
	 * Настройки сервера
	 */
	public ServerConfiguration getServerConfiguration() {
		return getServer().getServerConfiguration();
	}

	/**
	 * Менеджер для чтения/записи (Input/Output)
	 */
	public IOManager getIOManager() {
		return getServer().getIOManager();
	}

	/**
     * 
     */
	public Scheduler getScheduler() {
		return getServer().getScheduler();
	}
}
