package dev.kscott.ring.core.service;

import dev.kscott.ring.core.game.Game;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a service that adds some sort of functionality to a {@link Game}.
 *
 * @param <T> the game type
 */
public interface Service<T extends Game> {

    /**
     * Registers this service with the game.
     *
     * @return true if success, false if failure
     */
    boolean register(final @NonNull T game);

    /**
     * Enables this service.
     *
     * @return true if success, false if failure
     */
    default boolean enable() {
        return true;
    }

    /**
     * Disables this service.
     *
     * @return true if success, false if failure
     */
    default boolean disable() {
        return true;
    }

    /**
     * Unregisters this service with the game.
     *
     * @return true if success, false if failure
     */
    default boolean unregister() {
        return true;
    }

}
