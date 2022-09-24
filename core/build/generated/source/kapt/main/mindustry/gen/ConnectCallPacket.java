package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import java.lang.String;
import mindustry.net.Packet;

public class ConnectCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public String ip;

  public int port;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeString(WRITE, ip);
    WRITE.i(port);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    ip = mindustry.io.TypeIO.readString(READ);
    port = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.connect(ip, port);
  }
}
