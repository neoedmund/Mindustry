package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class RemoveQueueBlockCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int x;

  public int y;

  public boolean breaking;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(x);
    WRITE.i(y);
    WRITE.bool(breaking);
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
    breaking = READ.bool();
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.removeQueueBlock(x, y, breaking);
  }
}
