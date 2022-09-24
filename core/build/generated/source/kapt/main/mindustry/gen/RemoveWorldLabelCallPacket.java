package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class RemoveWorldLabelCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int id;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(id);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    id = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.ui.Menus.removeWorldLabel(id);
  }
}
