package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class PingResponseCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public long time;

  @Override
  public void write(Writes WRITE) {
    WRITE.l(time);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    time = READ.l();
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.pingResponse(time);
  }
}
