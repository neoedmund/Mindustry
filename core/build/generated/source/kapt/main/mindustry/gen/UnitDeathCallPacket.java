package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class UnitDeathCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int uid;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(uid);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    uid = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.entities.Units.unitDeath(uid);
  }
}
