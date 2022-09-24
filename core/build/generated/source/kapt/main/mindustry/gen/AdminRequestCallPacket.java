package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.NetConnection;
import mindustry.net.Packet;
import mindustry.net.Packets;

public class AdminRequestCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Player other;

  public Packets.AdminAction action;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeEntity(WRITE, other);
    mindustry.io.TypeIO.writeAction(WRITE, action);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    other = mindustry.io.TypeIO.readEntity(READ);
    action = mindustry.io.TypeIO.readAction(READ);
  }

  @Override
  public void handleServer(NetConnection con) {
    if(con.player == null || con.kicked) {
      return;
    }
    mindustry.gen.Player player = con.player;
    mindustry.core.NetServer.adminRequest(player, other, action);
  }
}
