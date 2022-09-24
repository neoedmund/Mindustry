package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class UnitEnvDeathCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
  }

  @Override
  public void handleClient() {
    mindustry.entities.Units.unitEnvDeath(unit);
  }
}
