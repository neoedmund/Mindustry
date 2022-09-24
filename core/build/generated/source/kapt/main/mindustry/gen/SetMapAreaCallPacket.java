package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class SetMapAreaCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int x;

  public int y;

  public int w;

  public int h;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(x);
    WRITE.i(y);
    WRITE.i(w);
    WRITE.i(h);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    x = READ.i();
    y = READ.i();
    w = READ.i();
    h = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.logic.LExecutor.setMapArea(x, y, w, h);
  }
}
