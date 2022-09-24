package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class SectorCaptureCallPacket extends Packet {
  private byte[] DATA = NODATA;

  @Override
  public void write(Writes WRITE) {
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
  }

  @Override
  public void handleClient() {
    mindustry.core.Logic.sectorCapture();
  }
}
