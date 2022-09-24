package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.world.Tile;

public class AssemblerDroneSpawnedCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Tile tile;

  public int id;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTile(WRITE, tile);
    WRITE.i(id);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    tile = mindustry.io.TypeIO.readTile(READ);
    id = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.world.blocks.units.UnitAssembler.assemblerDroneSpawned(tile, id);
  }
}
