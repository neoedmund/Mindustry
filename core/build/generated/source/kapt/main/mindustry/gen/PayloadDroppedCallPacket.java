package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class PayloadDroppedCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  public float x;

  public float y;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
    WRITE.f(x);
    WRITE.f(y);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
    x = READ.f();
    y = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.payloadDropped(unit, x, y);
  }
}
