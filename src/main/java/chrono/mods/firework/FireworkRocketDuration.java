/*
Copyright (C) 2021-2022 intact

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

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Fireworks;

public class FireworkRocketDuration implements ClientModInitializer {
	public static String MODID = "cr-firework-rocket-duration";

	@Override
	public void onInitializeClient() {
		ItemProperties.register(Items.FIREWORK_ROCKET, ResourceLocation.fromNamespaceAndPath(MODID, "flight"),
				(stack, world, entity, seed) -> {
					Fireworks fireworks = stack.get(DataComponents.FIREWORKS);
					int flight = fireworks != null ? fireworks.flightDuration() : 1;
					return Math.min(Math.max(flight - 1, 0), 2) / 2.0F;
				});
	}
}
