package dev.kscott.ring.core.game;

import dev.kscott.ring.core.service.Service;
import dev.kscott.ring.core.spirit.Spirit;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * Represents a game.
 */
public interface Game {

    /**
     * Returns the state of this game.
     *
     * @return the state
     */
    @NonNull GameState state();

    /**
     * Returns the type of this game.
     *
     * @return the game
     */
    @NonNull GameType type();

    /**
     * Returns the players.
     *
     * @return the players
     */
    @NonNull List<Spirit> players();

}
