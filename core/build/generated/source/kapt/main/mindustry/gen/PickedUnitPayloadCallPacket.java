package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class PickedUnitPayloadCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  public Unit target;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
    mindustry.io.TypeIO.writeUnit(WRITE, target);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
    target = mindustry.io.TypeIO.readUnit(READ);
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.pickedUnitPayload(unit, target);
  }
}
