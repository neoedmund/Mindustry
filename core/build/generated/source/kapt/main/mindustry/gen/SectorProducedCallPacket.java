package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class SectorProducedCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int[] amounts;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeInts(WRITE, amounts);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    amounts = mindustry.io.TypeIO.readInts(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.Logic.sectorProduced(amounts);
  }
}
