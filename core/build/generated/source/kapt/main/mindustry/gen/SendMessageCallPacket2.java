package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class SendMessageCallPacket2 extends Packet {
  private byte[] DATA = NODATA;

  public String message;

  public String unformatted;

  public Player playersender;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeString(WRITE, message);
    mindustry.io.TypeIO.writeString(WRITE, unformatted);
    mindustry.io.TypeIO.writeEntity(WRITE, playersender);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    message = mindustry.io.TypeIO.readString(READ);
    unformatted = mindustry.io.TypeIO.readString(READ);
    playersender = mindustry.io.TypeIO.readEntity(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.sendMessage(message, unformatted, playersender);
  }
}
