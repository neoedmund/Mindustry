package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.type.Item;

public class TransferItemToCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  public Item item;

  public int amount;

  public float x;

  public float y;

  public Building build;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
    mindustry.io.TypeIO.writeItem(WRITE, item);
    WRITE.i(amount);
    WRITE.f(x);
    WRITE.f(y);
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
    item = mindustry.io.TypeIO.readItem(READ);
    amount = READ.i();
    x = READ.f();
    y = READ.f();
    build = mindustry.io.TypeIO.readBuilding(READ);
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.transferItemTo(unit, item, amount, x, y, build);
  }
}
