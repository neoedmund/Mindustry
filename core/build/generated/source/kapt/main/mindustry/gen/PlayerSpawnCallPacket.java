package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.world.Tile;

public class PlayerSpawnCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Tile tile;

  public Player player;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTile(WRITE, tile);
    mindustry.io.TypeIO.writeEntity(WRITE, player);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    tile = mindustry.io.TypeIO.readTile(READ);
    player = mindustry.io.TypeIO.readEntity(READ);
  }

  @Override
  public void handleClient() {
    mindustry.world.blocks.storage.CoreBlock.playerSpawn(tile, player);
  }
}
