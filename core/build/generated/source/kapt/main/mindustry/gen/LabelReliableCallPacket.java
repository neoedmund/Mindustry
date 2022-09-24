package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class LabelReliableCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public String message;

  public float duration;

  public float worldx;

  public float worldy;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeString(WRITE, message);
    WRITE.f(duration);
    WRITE.f(worldx);
    WRITE.f(worldy);
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
    worldx = READ.f();
    worldy = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.ui.Menus.labelReliable(message, duration, worldx, worldy);
  }
}
