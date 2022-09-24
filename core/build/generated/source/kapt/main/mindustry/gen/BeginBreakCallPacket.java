package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;

public class BeginBreakCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  public Team team;

  public int x;

  public int y;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
    mindustry.io.TypeIO.writeTeam(WRITE, team);
    WRITE.i(x);
    WRITE.i(y);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
    team = mindustry.io.TypeIO.readTeam(READ);
    x = READ.i();
    y = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.world.Build.beginBreak(unit, team, x, y);
  }
}
