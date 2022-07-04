package api.bottleofench.eventapi.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FarmlandTrampleEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    private static boolean isCancelled;
    private static Player player;
    private static Block farmland;

    public FarmlandTrampleEvent(Player player, Block farmland) {
        FarmlandTrampleEvent.player = player;
        FarmlandTrampleEvent.farmland = farmland;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Block getFarmland() {
        return farmland;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param isCancelled true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean isCancelled) {
        FarmlandTrampleEvent.isCancelled = isCancelled;
    }
}
