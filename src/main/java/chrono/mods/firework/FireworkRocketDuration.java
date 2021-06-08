package chrono.mods.firework;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;

import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class FireworkRocketDuration implements ClientModInitializer {
	public static String MODID = "cr-firework-rocket-duration";

	@Override
	public void onInitializeClient() {
		FabricModelPredicateProviderRegistry.register(Items.FIREWORK_ROCKET, new Identifier(MODID, "flight"),
				(stack, world, entity, seed) -> {
					NbtCompound tags = stack.getSubTag("Fireworks");
					int flight = tags != null && tags.contains("Flight", 99) ? tags.getByte("Flight") : 1;
					return Math.min(Math.max(flight - 1, 0), 2) / 2.0F;
				});
	}
}
