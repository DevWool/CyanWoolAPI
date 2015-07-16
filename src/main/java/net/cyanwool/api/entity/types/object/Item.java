package net.cyanwool.api.entity.types.object;

import net.cyanwool.api.entity.Entity;
import net.cyanwool.api.inventory.item.ItemStack;

public interface Item extends Object {

	public ItemStack getItemStack(Entity entity);

	public void setItemStack(Entity entity, ItemStack item);

}