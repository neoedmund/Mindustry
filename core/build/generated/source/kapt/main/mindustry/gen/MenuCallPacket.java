package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class MenuCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int menuId;

  public String title;

  public String message;

  public String[][] options;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(menuId);
    mindustry.io.TypeIO.writeString(WRITE, title);
    mindustry.io.TypeIO.writeString(WRITE, message);
    mindustry.io.TypeIO.writeStrings(WRITE, options);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    menuId = READ.i();
    title = mindustry.io.TypeIO.readString(READ);
    message = mindustry.io.TypeIO.readString(READ);
    options = mindustry.io.TypeIO.readStrings(READ);
  }

  @Override
  public void handleClient() {
    mindustry.ui.Menus.menu(menuId, title, message, options);
  }
}
