package de.sanandrew.core.manpack.mod.packet;

import io.netty.buffer.ByteBuf;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetHandlerPlayServer;

@Deprecated
public interface IPacket
{
    public void readBytes(ByteBuf bytes);
    public void writeBytes(ByteBuf bytes);
    public void handleClientSide(NetHandlerPlayClient nhClient);
    public void handleServerSide(NetHandlerPlayServer nhServer);
}
