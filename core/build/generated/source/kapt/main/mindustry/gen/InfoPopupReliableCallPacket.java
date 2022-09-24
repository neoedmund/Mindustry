package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class InfoPopupReliableCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public String message;

  public float duration;

  public int align;

  public int top;

  public int left;

  public int bottom;

  public int right;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeString(WRITE, message);
    WRITE.f(duration);
    WRITE.i(align);
    WRITE.i(top);
    WRITE.i(left);
    WRITE.i(bottom);
    WRITE.i(right);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    message = mindustry.io.TypeIO.readString(READ);
    duration = READ.f();
    align = READ.i();
    top = READ.i();
    left = READ.i();
    bottom = READ.i();
    right = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.ui.Menus.infoPopupReliable(message, duration, align, top, left, bottom, right);
  }
}
