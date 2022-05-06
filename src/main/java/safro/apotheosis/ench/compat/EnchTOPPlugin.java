package safro.apotheosis.ench.compat;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import safro.apotheosis.ench.anvil.AnvilTile;

public class EnchTOPPlugin {

    public static void addProbeInfo(ProbeMode mode, IProbeInfo info, Player player, Level level, BlockState state, IProbeHitData hitData) {
        if (level.getBlockEntity(hitData.getPos()) instanceof AnvilTile anvil) {
            Object2IntMap<Enchantment> enchants = anvil.getEnchantments();
            for (Object2IntMap.Entry<Enchantment> e : enchants.object2IntEntrySet()) {
                info.text(e.getKey().getFullname(e.getIntValue()));
            }
        }
    }
}
