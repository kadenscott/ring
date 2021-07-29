package dev.kscott.ring.core.text;

import net.kyori.adventure.text.format.TextColor;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Colours {

    public static final @NonNull TextColor WHITE = TextColor.color(255, 255, 255);
    public static final @NonNull TextColor GRAY_LIGHT = TextColor.color(200, 200, 200);
    public static final @NonNull TextColor GRAY_DARK = TextColor.color(100, 100, 100);
    public static final @NonNull TextColor BLACK = TextColor.color(0, 0, 0);

    public static class Default {

        public static final @NonNull TextColor RED = TextColor.color(245, 66, 66);
        public static final @NonNull TextColor ORANGE = TextColor.color(245, 150, 66);
        public static final @NonNull TextColor YELLOW = TextColor.color(245, 209, 66);
        public static final @NonNull TextColor GREEN = TextColor.color(66, 245, 102);
        public static final @NonNull TextColor BLUE = TextColor.color(66, 215, 245);
        public static final @NonNull TextColor BLUE_DARK = TextColor.color(66, 150, 245);
        public static final @NonNull TextColor PURPLE = TextColor.color(197, 66, 245);
        public static final @NonNull TextColor PINK = TextColor.color(245, 66, 197);

    }

    public static class Pastel {

        public static final @NonNull TextColor RED = TextColor.color(237, 147, 147);
        public static final @NonNull TextColor ORANGE = TextColor.color(237, 192, 147);
        public static final @NonNull TextColor YELLOW = TextColor.color(237, 218, 147);
        public static final @NonNull TextColor GREEN = TextColor.color(164, 237, 147);
        public static final @NonNull TextColor BLUE = TextColor.color(147, 222, 237);
        public static final @NonNull TextColor BLUE_DARK = TextColor.color(147, 184, 237);
        public static final @NonNull TextColor PURPLE = TextColor.color(210, 147, 237);
        public static final @NonNull TextColor PINK = TextColor.color(237, 147, 218);

    }

}
