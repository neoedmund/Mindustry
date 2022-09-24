package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.NetConnection;
import mindustry.net.Packet;

public class ServerPacketReliableCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public String type;

  public String contents;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeString(WRITE, type);
    mindustry.io.TypeIO.writeString(WRITE, contents);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    type = mindustry.io.TypeIO.readString(READ);
    contents = mindustry.io.TypeIO.readString(READ);
  }

  @Override
  public void handleServer(NetConnection con) {
    if(con.player == null || con.kicked) {
      return;
    }
    mindustry.gen.Player player = con.player;
    mindustry.core.NetServer.serverPacketReliable(player, type, contents);
  }
}
