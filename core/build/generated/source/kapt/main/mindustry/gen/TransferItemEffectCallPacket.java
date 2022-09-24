package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.type.Item;

public class TransferItemEffectCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Item item;

  public float x;

  public float y;

  public Itemsc to;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeItem(WRITE, item);
    WRITE.f(x);
    WRITE.f(y);
    mindustry.io.TypeIO.writeEntity(WRITE, to);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    item = mindustry.io.TypeIO.readItem(READ);
    x = READ.f();
    y = READ.f();
    to = mindustry.io.TypeIO.readEntity(READ);
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.transferItemEffect(item, x, y, to);
  }
}
