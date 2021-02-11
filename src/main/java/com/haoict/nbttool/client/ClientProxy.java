package com.haoict.nbttool.client;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy {
  public ClientProxy() {
    MinecraftForge.EVENT_BUS.register(TooltipInjector.class);
  }
}
