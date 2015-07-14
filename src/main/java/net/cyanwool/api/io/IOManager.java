package net.cyanwool.api.io;

import net.cyanwool.api.world.World;
import net.cyanwool.api.world.chunk.Chunk;

public interface IOManager {

	public Chunk readChunk(int x, int z);

	public void saveChunk(Chunk chunk);

	public World readWorld(String name);

	public void saveWorld(World world);

	public void addIORequest(IORequest request);

	public void initIOTask();

	public void shutdownIOTask();

	public boolean isRunning();

	// todo

}
