package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class DebugStatusClientCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int value;

  public int lastClientSnapshot;

  public int snapshotsSent;

  @Override
  public int getPriority() {
    return 2;
  }

  @Override
  public void write(Writes WRITE) {
    WRITE.i(value);
    WRITE.i(lastClientSnapshot);
    WRITE.i(snapshotsSent);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    value = READ.i();
    lastClientSnapshot = READ.i();
    snapshotsSent = READ.i();
  }

  @Override
  public void handleClient() {
    mindustry.core.NetServer.debugStatusClient(value, lastClientSnapshot, snapshotsSent);
  }
}
