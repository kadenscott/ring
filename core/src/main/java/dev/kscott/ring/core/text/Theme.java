package dev.kscott.ring.core.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.swing.text.html.MinimalHTMLWriter;

public class Theme {

    public static final @NonNull Theme DEFAULT = new Theme(
            Component.text("mc.ksc.sh"),
            // Main
            Style.style()
                    .decoration(TextDecoration.ITALIC, false)
                    .decoration(TextDecoration.BOLD, false)
                    .decoration(TextDecoration.STRIKETHROUGH, false)
                    .decoration(TextDecoration.OBFUSCATED, false)
                    .color(Colours.GRAY_LIGHT)
                    .build(),
            // Alt
            Style.style()
                    .decoration(TextDecoration.ITALIC, false)
                    .decoration(TextDecoration.BOLD, false)
                    .decoration(TextDecoration.STRIKETHROUGH, false)
                    .decoration(TextDecoration.OBFUSCATED, false)
                    .color(Colours.Pastel.BLUE)
                    .build(),
            // Emphasis
            Style.style()
                    .decoration(TextDecoration.ITALIC, false)
                    .decoration(TextDecoration.BOLD, false)
                    .decoration(TextDecoration.STRIKETHROUGH, false)
                    .decoration(TextDecoration.OBFUSCATED, false)
                    .color(Colours.Default.BLUE)
                    .build(),
            // Good
            Style.style()
                    .decoration(TextDecoration.ITALIC, false)
                    .decoration(TextDecoration.BOLD, false)
                    .decoration(TextDecoration.STRIKETHROUGH, false)
                    .decoration(TextDecoration.OBFUSCATED, false)
                    .color(Colours.Pastel.GREEN)
                    .build(),
            // Bad
            Style.style()
                    .decoration(TextDecoration.ITALIC, false)
                    .decoration(TextDecoration.BOLD, false)
                    .decoration(TextDecoration.STRIKETHROUGH, false)
                    .decoration(TextDecoration.OBFUSCATED, false)
                    .color(Colours.Pastel.RED)
                    .build()
    );

    private final @NonNull Component serverName;
    private final @NonNull Style main;
    private final @NonNull Style alt;
    private final @NonNull Style emphasis;
    private final @NonNull Style good;
    private final @NonNull Style bad;

    public Theme(final @NonNull Component serverName,
                 final @NonNull Style main,
                 final @NonNull Style alt,
                 final @NonNull Style emphasis,
                 final @NonNull Style good,
                 final @NonNull Style bad
    ) {
        this.serverName = serverName;
        this.main = main;
        this.alt = alt;
        this.emphasis = emphasis;
        this.good = good;
        this.bad = bad;
    }

    public @NonNull Component serverName() {
        return this.serverName;
    }

    public Style main() {
        return main;
    }

    public Style getAlalt() {
        return alt;
    }

    public Style emphasis() {
        return emphasis;
    }

    public Style good() {
        return good;
    }

    public Style bad() {
        return bad;
    }
}
