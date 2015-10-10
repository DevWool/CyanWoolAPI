package net.cyanwool.api;

import org.apache.logging.log4j.Logger;

import net.cyanwool.api.command.ConsoleCommandSender;
import net.cyanwool.api.command.ICommandManager;
import net.cyanwool.api.entity.EntityManager;
import net.cyanwool.api.lang.ILanguageManager;
import net.cyanwool.api.management.OperatorsManager;
import net.cyanwool.api.management.PlayerManager;
import net.cyanwool.api.management.WhitelistManager;
import net.cyanwool.api.network.NetworkServer;
import net.cyanwool.api.plugins.IPluginManager;
import net.cyanwool.api.scheduler.Scheduler;
import net.cyanwool.api.utils.Registry;
import net.cyanwool.api.utils.ServerConfiguration;

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
		getServer().getLogger().info("Starting minecraft server " + getServer().getModName() + " (Minecraft Version: " + getServer().getMCVersion() + ")");
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
	 * Тип реализации (Например: Standalone или Platform)
	 * 
	 * @return String
	 */
	public static String getImplementationType() {
		return getServer().getImplementationType();
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
	public static ILanguageManager getLanguageManager() {
		return getServer().getLanguageManager();
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
	public static IPluginManager getPluginManager() {
		return getServer().getPluginManager();
	}

	/**
	 * Менеджер для регистрации/удаления команд
	 * 
	 * @return
	 */
	public ICommandManager getCommandManager() {
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
	 * Настройки сервера
	 */
	public ServerConfiguration getServerConfiguration() {
		return getServer().getServerConfiguration();
	}

	/**
	 * 
	 */
	public Scheduler getScheduler() {
		return getServer().getScheduler();
	}
}
