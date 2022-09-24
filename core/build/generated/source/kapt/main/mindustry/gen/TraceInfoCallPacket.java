package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Administration;
import mindustry.net.Packet;

public class TraceInfoCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Player player;

  public Administration.TraceInfo info;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeEntity(WRITE, player);
    mindustry.io.TypeIO.writeTraceInfo(WRITE, info);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    player = mindustry.io.TypeIO.readEntity(READ);
    info = mindustry.io.TypeIO.readTraceInfo(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.traceInfo(player, info);
  }
}
