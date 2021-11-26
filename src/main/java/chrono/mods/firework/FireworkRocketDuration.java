/*
Copyright (C) 2021 intact

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package chrono.mods.firework;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class FireworkRocketDuration implements ClientModInitializer {
	public static String MODID = "cr-firework-rocket-duration";

	@Override
	public void onInitializeClient() {
		FabricModelPredicateProviderRegistry.register(Items.FIREWORK_ROCKET, new ResourceLocation(MODID, "flight"),
				(stack, world, entity, seed) -> {
					CompoundTag tags = stack.getTagElement("Fireworks");
					int flight = tags != null && tags.contains("Flight", 99) ? tags.getByte("Flight") : 1;
					return Math.min(Math.max(flight - 1, 0), 2) / 2.0F;
				});
	}
}
