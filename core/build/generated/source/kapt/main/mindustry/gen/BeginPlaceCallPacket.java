package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;
import mindustry.world.Block;

public class BeginPlaceCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  public Block result;

  public Team team;

  public int x;

  public int y;

  public int rotation;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
    mindustry.io.TypeIO.writeBlock(WRITE, result);
    mindustry.io.TypeIO.writeTeam(WRITE, team);
    WRITE.i(x);
    WRITE.i(y);
    WRITE.i(rotation);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
    result = mindustry.io.TypeIO.readBlock(READ);
    team = mindustry.io.TypeIO.readTeam(READ);
    x = READ.i();
    y = READ.i();
    rotation = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.world.Build.beginPlace(unit, result, team, x, y, rotation);
  }
}
