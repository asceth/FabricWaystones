package wraith.waystones.registries;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.waystones.util.Config;
import wraith.waystones.util.Utils;

import java.util.function.Supplier;

public final class CompatRegistry {

    private CompatRegistry() {
    }

    @SuppressWarnings("unchecked")
    public static void init() {
        Registry.REGISTRIES.getOrEmpty(new Identifier("repurposed_structures", "json_conditions"))
                .ifPresent(registry -> Registry.register(
                        (Registry<Supplier<Boolean>>) registry,
                        Utils.ID("config"),
                        () -> Config.getInstance().generateInVillages()
                ));
    }

}
