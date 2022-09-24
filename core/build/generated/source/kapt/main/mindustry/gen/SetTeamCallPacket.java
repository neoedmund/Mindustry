package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;

public class SetTeamCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Building build;

  public Team team;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
    mindustry.io.TypeIO.writeTeam(WRITE, team);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    build = mindustry.io.TypeIO.readBuilding(READ);
    team = mindustry.io.TypeIO.readTeam(READ);
  }

  @Override
  public void handleClient() {
    mindustry.world.Tile.setTeam(build, team);
  }
}
