package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class KickCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public String reason;

  @Override
  public int getPriority() {
    return 2;
  }

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeString(WRITE, reason);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    reason = mindustry.io.TypeIO.readString(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.kick(reason);
  }
}
