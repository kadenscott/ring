package dev.kscott.ring.paper.spirit;

import dev.kscott.ring.core.spirit.Spirit;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * The spirit of a Paper player.
 */
public class PaperSpirit implements Spirit {

    private final @NonNull Player player;

    public PaperSpirit(final @NonNull Player player) {
        this.player = player;
    }

    public @NonNull Player player() {
        return this.player;
    }

    @Override
    public @NonNull UUID uuid() {
        return this.player.getUniqueId();
    }
}
