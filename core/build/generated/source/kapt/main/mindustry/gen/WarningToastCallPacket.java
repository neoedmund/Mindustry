package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class WarningToastCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int unicode;

  public String text;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(unicode);
    mindustry.io.TypeIO.writeString(WRITE, text);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unicode = READ.i();
    text = mindustry.io.TypeIO.readString(READ);
  }

  @Override
  public void handleClient() {
    mindustry.ui.Menus.warningToast(unicode, text);
  }
}
