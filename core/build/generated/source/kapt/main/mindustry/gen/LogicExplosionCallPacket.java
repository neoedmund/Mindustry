package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;

public class LogicExplosionCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Team team;

  public float x;

  public float y;

  public float radius;

  public float damage;

  public boolean air;

  public boolean ground;

  public boolean pierce;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTeam(WRITE, team);
    WRITE.f(x);
    WRITE.f(y);
    WRITE.f(radius);
    WRITE.f(damage);
    WRITE.bool(air);
    WRITE.bool(ground);
    WRITE.bool(pierce);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    team = mindustry.io.TypeIO.readTeam(READ);
    x = READ.f();
    y = READ.f();
    radius = READ.f();
    damage = READ.f();
    air = READ.bool();
    ground = READ.bool();
    pierce = READ.bool();
  }

  @Override
  public void handleClient() {
    mindustry.logic.LExecutor.logicExplosion(team, x, y, radius, damage, air, ground, pierce);
  }
}
