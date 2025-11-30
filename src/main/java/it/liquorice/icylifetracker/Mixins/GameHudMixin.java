package it.liquorice.icylifetracker.Mixins;

import it.liquorice.icylifetracker.Config;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import it.liquorice.icylifetracker.IcyLifeTracker;

@Mixin(Gui.class)
public class GameHudMixin {
    @Inject(method = "renderHearts", at = @At("HEAD"))
    private void RenderHeartsInject(GuiGraphics guiGraphics, Player player, int x, int y, int height, int offsetHeartIndex, float maxHealth, int currentHealth, int displayHealth, int absorptionAmount, boolean renderHighlight, CallbackInfo ci) {
        if (currentHealth <= Config.WARNING_THRESHOLD.get()) {
            ResourceLocation TEXTURE;
            int times = 1;
            if (Config.ICON_SIZE.get() == 1) {
                TEXTURE = ResourceLocation.fromNamespaceAndPath("icylifetracker", "textures/gui/warning.png");
            } else {
                TEXTURE = ResourceLocation.fromNamespaceAndPath("icylifetracker", "textures/gui/warning32x.png");
                times = 2;
            }
            guiGraphics.blit(TEXTURE, 5, 5, 0, 0, 16 * times, 16 * times, 16 * times, 16 * times);
        }
    }
}
