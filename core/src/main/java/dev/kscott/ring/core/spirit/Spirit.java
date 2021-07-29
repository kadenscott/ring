package dev.kscott.ring.core.spirit;

import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * Represents entities such as users or terminals.
 */
public interface Spirit extends Audience {

    /**
     * The UUID of this Spirit.
     * <p>
     * The UUID of '0' is reserved for console or application outputs.
     *
     * @return the UUID
     */
    @NonNull UUID uuid();

}
