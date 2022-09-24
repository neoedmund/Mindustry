package mindustry.gen;

import arc.struct.IntSeq;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class BuildHealthUpdateCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public IntSeq buildings;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeIntSeq(WRITE, buildings);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    buildings = mindustry.io.TypeIO.readIntSeq(READ);
  }

  @Override
  public void handleClient() {
    mindustry.world.Tile.buildHealthUpdate(buildings);
  }
}
