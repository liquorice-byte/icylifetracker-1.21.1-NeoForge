package it.liquorice.icylifetracker;

import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue WARNING_THRESHOLD = BUILDER
            .comment("Trigger warning when the health is less than or equal to this value")
            .defineInRange("warningThreshold", 20, 1, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();
}
