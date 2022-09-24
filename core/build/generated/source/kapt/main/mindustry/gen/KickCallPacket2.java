package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.net.Packets;

public class KickCallPacket2 extends Packet {
  private byte[] DATA = NODATA;

  public Packets.KickReason reason;

  @Override
  public int getPriority() {
    return 2;
  }

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeKick(WRITE, reason);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    reason = mindustry.io.TypeIO.readKick(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.kick(reason);
  }
}
