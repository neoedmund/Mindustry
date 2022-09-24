package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.entities.bullet.BulletType;
import mindustry.game.Team;
import mindustry.net.Packet;

public class CreateBulletCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public BulletType type;

  public Team team;

  public float x;

  public float y;

  public float angle;

  public float damage;

  public float velocityScl;

  public float lifetimeScl;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeBulletType(WRITE, type);
    mindustry.io.TypeIO.writeTeam(WRITE, team);
    WRITE.f(x);
    WRITE.f(y);
    WRITE.f(angle);
    WRITE.f(damage);
    WRITE.f(velocityScl);
    WRITE.f(lifetimeScl);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    type = mindustry.io.TypeIO.readBulletType(READ);
    team = mindustry.io.TypeIO.readTeam(READ);
    x = READ.f();
    y = READ.f();
    angle = READ.f();
    damage = READ.f();
    velocityScl = READ.f();
    lifetimeScl = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.entities.bullet.BulletType.createBullet(type, team, x, y, angle, damage, velocityScl, lifetimeScl);
  }
}
