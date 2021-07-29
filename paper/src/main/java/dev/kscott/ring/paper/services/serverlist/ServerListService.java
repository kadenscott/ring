package dev.kscott.ring.paper.services.serverlist;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import dev.kscott.ring.core.service.Service;
import dev.kscott.ring.paper.game.PaperGame;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ServerListService implements Service<PaperGame>, Listener {

    private final @NonNull Component motd;

    private @MonotonicNonNull PaperGame game;

    public ServerListService(final @NonNull Component motd) {
        this.motd = motd;
    }

    @Override
    public boolean register(@NonNull PaperGame game) {
        this.game = game;

        this.game.plugin().getServer().getPluginManager().registerEvents(this, this.game.plugin());

        return true;
    }

    @EventHandler
    private void handleServerListPingEvent(final @NonNull PaperServerListPingEvent event) {
        event.setMaxPlayers(game.maxPlayers());
        event.setNumPlayers(game.players().size());

        event.motd(this.motd);
    }
}
