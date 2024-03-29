package me.samipourquoi.mixin;

import me.samipourquoi.gui.BookScreenRescaler;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GameRenderer.class)
public class MixinGameRender {
	@ModifyVariable(
			method = "render",
			at = @At(
					value = "INVOKE",
					target = "Lcom/mojang/blaze3d/systems/RenderSystem;viewport(IIII)V"
			),
			index = 5
	)
	private int mapMouseX(int mouseX) {
		return BookScreenRescaler.mapMouseX(mouseX);
	}

	@ModifyVariable(
			method = "render",
			at = @At(
					value = "INVOKE",
					target = "Lcom/mojang/blaze3d/systems/RenderSystem;viewport(IIII)V"
			),
			index = 6
	)
	private int mapMouseY(int mouseY) {
		return BookScreenRescaler.mapMouseY(mouseY);
	}
}
