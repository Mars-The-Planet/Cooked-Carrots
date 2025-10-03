package com.mars.cookedcarrots.platform.services;

public interface IPlatformHelper {
    String getPlatformName();

    boolean isModLoaded(String modId);
}
