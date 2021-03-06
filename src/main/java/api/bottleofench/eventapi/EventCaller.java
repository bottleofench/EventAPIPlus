package api.bottleofench.eventapi;

import api.bottleofench.eventapi.events.FarmlandTrampleEvent;
import api.bottleofench.eventapi.events.FrostWalkerUseEvent;
import api.bottleofench.eventapi.events.ItemFrameCreateEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import static org.bukkit.Material.FARMLAND;

public class EventCaller implements Listener {
    @EventHandler
    public void onFarmlandTrample(PlayerInteractEvent event) {
        if (!(event.getAction().equals(Action.PHYSICAL))) return;
        if (event.getClickedBlock() == null) return;
        if (!event.getClickedBlock().getType().equals(FARMLAND)) return;
        FarmlandTrampleEvent e = new FarmlandTrampleEvent(event.getPlayer(), event.getClickedBlock());
        Bukkit.getPluginManager().callEvent(e);
        if (e.isCancelled()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemFrameItemPlace(PlayerInteractEvent event) {
        if (!(event.getHand() == EquipmentSlot.HAND)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock() == null) return;
        if (event.getItem() == null) return;
        Location loc = event.getInteractionPoint();
        Bukkit.getScheduler().runTaskLater(EventAPIPlus.getInstance(), () -> {
            for (Entity entity : loc.getNearbyEntities(0.5, 0.5, 0.5)) {
                if (!(entity instanceof ItemFrame frame)) continue;
                ItemFrameCreateEvent e = new ItemFrameCreateEvent(event.getPlayer(), frame);
                Bukkit.getPluginManager().callEvent(e);
                if (e.isCancelled()) {
                    event.setCancelled(true);
                }
                return;
            }
        }, 2);
    }

    @EventHandler
    public void onFrostWalkerUse(EntityBlockFormEvent event) {
        if (!event.getNewState().getType().equals(Material.FROSTED_ICE)) return;
        if (!(event.getEntity() instanceof Player player)) return;
        FrostWalkerUseEvent e = new FrostWalkerUseEvent(player, event.getNewState().getBlock());
        Bukkit.getPluginManager().callEvent(e);
        if (e.isCancelled()) {
            event.setCancelled(true);
        }
    }
}
