package dev.kscott.ring.core.server;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * Represents the server.
 */
public interface Server {

    /**
     * Returns the UUID of this server.
     *
     * @return the uuid
     */
    @NonNull UUID uuid();

    /**
     * Returns the type of this server.
     *
     * @return the type
     */
    @NonNull ServerType type();

}
