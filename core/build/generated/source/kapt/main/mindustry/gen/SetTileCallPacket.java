package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;
import mindustry.world.Block;
import mindustry.world.Tile;

public class SetTileCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Tile tile;

  public Block block;

  public Team team;

  public int rotation;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTile(WRITE, tile);
    mindustry.io.TypeIO.writeBlock(WRITE, block);
    mindustry.io.TypeIO.writeTeam(WRITE, team);
    WRITE.i(rotation);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    tile = mindustry.io.TypeIO.readTile(READ);
    block = mindustry.io.TypeIO.readBlock(READ);
    team = mindustry.io.TypeIO.readTeam(READ);
    rotation = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.world.Tile.setTile(tile, block, team, rotation);
  }
}
