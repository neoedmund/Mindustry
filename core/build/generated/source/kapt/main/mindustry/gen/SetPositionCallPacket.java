package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class SetPositionCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public float x;

  public float y;

  @Override
  public void write(Writes WRITE) {
    WRITE.f(x);
    WRITE.f(y);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    x = READ.f();
    y = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.setPosition(x, y);
  }
}
