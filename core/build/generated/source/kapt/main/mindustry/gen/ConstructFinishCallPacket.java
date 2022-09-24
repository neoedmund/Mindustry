package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Object;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;
import mindustry.world.Block;
import mindustry.world.Tile;

public class ConstructFinishCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Tile tile;

  public Block block;

  public Unit builder;

  public byte rotation;

  public Team team;

  public Object config;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTile(WRITE, tile);
    mindustry.io.TypeIO.writeBlock(WRITE, block);
    mindustry.io.TypeIO.writeUnit(WRITE, builder);
    WRITE.b(rotation);
    mindustry.io.TypeIO.writeTeam(WRITE, team);
    mindustry.io.TypeIO.writeObject(WRITE, config);
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
    builder = mindustry.io.TypeIO.readUnit(READ);
    rotation = READ.b();
    team = mindustry.io.TypeIO.readTeam(READ);
    config = mindustry.io.TypeIO.readObject(READ);
  }

  @Override
  public void handleClient() {
    mindustry.world.blocks.ConstructBlock.constructFinish(tile, block, builder, rotation, team, config);
  }
}
