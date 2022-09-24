package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.world.Block;
import mindustry.world.Tile;

public class SetFloorCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Tile tile;

  public Block floor;

  public Block overlay;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTile(WRITE, tile);
    mindustry.io.TypeIO.writeBlock(WRITE, floor);
    mindustry.io.TypeIO.writeBlock(WRITE, overlay);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    tile = mindustry.io.TypeIO.readTile(READ);
    floor = mindustry.io.TypeIO.readBlock(READ);
    overlay = mindustry.io.TypeIO.readBlock(READ);
  }

  @Override
  public void handleClient() {
    mindustry.world.Tile.setFloor(tile, floor, overlay);
  }
}
