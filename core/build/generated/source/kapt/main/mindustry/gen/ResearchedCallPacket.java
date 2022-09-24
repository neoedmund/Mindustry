package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.ctype.Content;
import mindustry.net.Packet;

public class ResearchedCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Content content;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeContent(WRITE, content);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    content = mindustry.io.TypeIO.readContent(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.Logic.researched(content);
  }
}
