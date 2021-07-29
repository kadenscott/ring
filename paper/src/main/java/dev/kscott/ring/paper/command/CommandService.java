package dev.kscott.ring.paper.command;

import dev.kscott.ring.core.service.Service;
import dev.kscott.ring.paper.game.PaperGame;
import org.checkerframework.checker.nullness.qual.NonNull;

public class CommandService implements Service<PaperGame> {

    @Override
    public boolean register(@NonNull PaperGame game) {
        return false;
    }

    @Override
    public boolean enable() {
        return Service.super.enable();
    }

    @Override
    public boolean disable() {
        return Service.super.disable();
    }

    @Override
    public boolean unregister() {
        return Service.super.unregister();
    }
}
