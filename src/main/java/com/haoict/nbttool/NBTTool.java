package com.haoict.nbttool;

import com.haoict.nbttool.client.ClientProxy;
import com.haoict.nbttool.client.TooltipInjector;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Config.MOD_ID)
public class NBTTool {
  private static final Logger LOGGER = LogManager.getLogger();

  public NBTTool() {
    MinecraftForge.EVENT_BUS.register(this);

    DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    MinecraftForge.EVENT_BUS.register(CommandEventRegistryHandler.class);
  }
}
