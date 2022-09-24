package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.world.Tile;

public class AutoDoorToggleCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Tile tile;

  public boolean open;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTile(WRITE, tile);
    WRITE.bool(open);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    tile = mindustry.io.TypeIO.readTile(READ);
    open = READ.bool();
  }

  @Override
  public void handleClient() {
    mindustry.world.blocks.defense.AutoDoor.autoDoorToggle(tile, open);
  }
}
