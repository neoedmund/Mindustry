package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.type.Item;

public class TakeItemsCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Building build;

  public Item item;

  public int amount;

  public Unit to;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
    mindustry.io.TypeIO.writeItem(WRITE, item);
    WRITE.i(amount);
    mindustry.io.TypeIO.writeUnit(WRITE, to);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    build = mindustry.io.TypeIO.readBuilding(READ);
    item = mindustry.io.TypeIO.readItem(READ);
    amount = READ.i();
    to = mindustry.io.TypeIO.readUnit(READ);
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.takeItems(build, item, amount, to);
  }
}
