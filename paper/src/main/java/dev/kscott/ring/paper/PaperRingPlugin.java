package dev.kscott.ring.paper;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * The Ring plugin entrypoint.
 */
public class PaperRingPlugin extends JavaPlugin {

    private final @NonNull String version;

    /**
     * Constructs {@code PaperRingPlugin}.
     */
    public PaperRingPlugin() {
        this.version = this.getDescription().getVersion();
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Ring v"+version+" ready.");
    }

}
