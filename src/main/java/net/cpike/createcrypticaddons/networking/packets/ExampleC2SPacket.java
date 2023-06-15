package net.cpike.createcrypticaddons.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.function.Supplier;

public class ExampleC2SPacket {

    public ExampleC2SPacket(){

    }

    public ExampleC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(()->{
            // ON THE SERVER
            ServerPlayer player = context.getSender();

        });
        return true;
    }

}
