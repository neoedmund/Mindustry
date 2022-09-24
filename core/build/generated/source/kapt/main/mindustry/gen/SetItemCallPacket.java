package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.type.Item;

public class SetItemCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Building build;

  public Item item;

  public int amount;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
    mindustry.io.TypeIO.writeItem(WRITE, item);
    WRITE.i(amount);
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
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.setItem(build, item, amount);
  }
}
