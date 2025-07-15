package moe.takochan.takotech.common.event;

import static moe.takochan.takotech.client.settings.GameSettings.selectTool;

import java.util.List;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.items.MetaGeneratedTool;
import moe.takochan.takotech.constants.NBTConstants;
import moe.takochan.takotech.constants.NameConstants;
import moe.takochan.takotech.utils.CommonUtils;
import moe.takochan.takotech.utils.I18nUtils;

public class ItemTooltipHandler {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.itemStack;
        List<String> toolTip = event.toolTip;

        if (itemStack.getItem() instanceof MetaGeneratedTool) {
            NBTTagCompound nbt = CommonUtils.openNbtData(itemStack);

            if (!nbt.hasKey(NBTConstants.TOOLBOX_DATA) || !nbt.hasKey(NBTConstants.TOOLBOX_SLOT)) return;

            toolTip.add("");
            toolTip.add(
                I18nUtils.tooltip(
                    NameConstants.ITEM_TOOLBOX_PLUS_DESC,
                    GameSettings.getKeyDisplayString(selectTool.getKeyCode())));
        }
    }
}
