package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.NetConnection;
import mindustry.net.Packet;

public class TransferInventoryCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Player player;

  public Building build;

  @Override
  public void write(Writes WRITE) {
    if(mindustry.Vars.net.server()) {
      mindustry.io.TypeIO.writeEntity(WRITE, player);
    }
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    if(mindustry.Vars.net.client()) {
      player = mindustry.io.TypeIO.readEntity(READ);
    }
    build = mindustry.io.TypeIO.readBuilding(READ);
  }

  @Override
  public void handleServer(NetConnection con) {
    if(con.player == null || con.kicked) {
      return;
    }
    mindustry.gen.Player player = con.player;
    mindustry.input.InputHandler.transferInventory(player, build);
    mindustry.gen.Call.transferInventory__forward(con, player, build);
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.transferInventory(player, build);
  }
}
