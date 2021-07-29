package dev.kscott.ring.paper.game;

import dev.kscott.ring.core.game.Game;
import dev.kscott.ring.core.game.GameState;
import dev.kscott.ring.core.game.GameType;
import dev.kscott.ring.core.service.Service;
import dev.kscott.ring.core.spirit.Spirit;
import dev.kscott.ring.core.text.Theme;
import dev.kscott.ring.paper.services.serverlist.ServerListService;
import dev.kscott.ring.paper.spirit.PaperSpirit;
import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.w3c.dom.ls.LSResourceResolver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * An instance of a Game on a Paper server.
 */
public class PaperGame implements Game {

    private final @NonNull JavaPlugin plugin;
    private final @NonNull GameType type;
    private final int maxPlayers;
    private final @NonNull List<PaperSpirit> players;
    private final @NonNull List<Service<PaperGame>> services;

    private @NonNull GameState state;

    /**
     * Constructs {@code PaperGame}.
     *
     * @param plugin the owning plugin
     * @param type the type
     * @param services the services to add to this game
     */
    protected PaperGame(final @NonNull JavaPlugin plugin,
                        final @NonNull GameType type,
                        final int maxPlayers,
                        final @NonNull List<Service<PaperGame>> services) {
        this.plugin = plugin;
        this.type = type;
        this.services = services;
        this.maxPlayers = maxPlayers;

        this.players = new ArrayList<>();
        this.state = GameState.DISABLED;
    }

    /**
     * Returns a new {@code PaperGame}.{@link Builder}.
     *
     * @param type the type of the {@link Game}
     * @return the builder
     */
    public static @NonNull Builder builder(final @NonNull GameType type) {
        return new Builder(type);
    }

    /**
     * Enables the game.
     *
     * @return true if success, false if failure
     */
    public boolean enable() {
        for (final @NonNull Service<PaperGame> service : this.services) {
            service.register(this);
            service.enable();
        }

        // End
        this.state = GameState.ENABLED;

        return true;
    }

    /**
     * Returns the plugin that created this .
     *
     * @return the plugin
     */
    public @NonNull JavaPlugin plugin() {
        return this.plugin;
    }

    /**
     * Returns the maximum amount of players allowed in this game.
     *
     * @return max players
     */
    public int maxPlayers() {
        return this.maxPlayers;
    }

    @Override
    public @NonNull GameState state() {
        return this.state;
    }

    @Override
    public @NonNull GameType type() {
        return this.type;
    }

    @Override
    public @NonNull List<Spirit> players() {
        return List.copyOf(this.players);
    }

    /**
     * A {@link PaperGame} builder.
     */
    public static class Builder {

        private final @NonNull GameType type;
        private final @NonNull List<Service<PaperGame>> services;
        private int maxPlayers;
        private boolean defaultsRegistered;

        /**
         * Constructs {@code Builder}.
         *
         * @param type the type
         * @see PaperGame#builder(GameType)
         */
        protected Builder(final @NonNull GameType type) {
            this.type = type;
            this.maxPlayers = 100;
            this.defaultsRegistered = false;
            this.services = new ArrayList<>();
        }

        public @NonNull Builder registerDefaults() {
            this.withService(new ServerListService(
                    Component.text()
                            .append(Component.text("A "))
                            .append(Theme.DEFAULT.serverName())
                            .append(Component.text(this.type.name()))
                            .append(Component.text(" server."))
                            .style(Theme.DEFAULT.main())
                            .build()
            ));

            this.defaultsRegistered = true;

            return this;
        }

        /**
         * Sets the maximum allowed number of players.
         *
         * @param maxPlayers the maximum amount of allowed players
         */
        public @NonNull Builder maxPlayers(final int maxPlayers) {
            this.maxPlayers = maxPlayers;
            return this;
        }

        /**
         * Adds a service to the game.
         * @param service the service
         * @return the game
         */
        public @NonNull Builder withService(final @NonNull Service<PaperGame> service) {
            this.services.add(service);
            return this;
        }

    }
}
