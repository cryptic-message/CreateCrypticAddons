package net.cpike.createcrypticaddons.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.checkerframework.checker.units.qual.K;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CATEGORY_TESTINGMOD = "key.category.createcrypticaddons.testing";
    public static final String KEY_THRUST = "key.createcrypticaddons.jetpack_thrust";
    public static final String KEY_BOOST = "key.createcrypticaddons.jetpack_boost";

    public static final KeyMapping THRUSTING_KEY = new KeyMapping(KEY_THRUST, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_SPACE, KEY_CATEGORY_TESTINGMOD);
    public static final KeyMapping BOOSTING_KEY = new KeyMapping(KEY_BOOST, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_W, KEY_CATEGORY_TESTINGMOD);

}
