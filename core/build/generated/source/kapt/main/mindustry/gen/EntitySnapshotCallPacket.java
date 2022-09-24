package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class EntitySnapshotCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public short amount;

  public byte[] data;

  @Override
  public int getPriority() {
    return 0;
  }

  @Override
  public void write(Writes WRITE) {
    WRITE.s(amount);
    mindustry.io.TypeIO.writeBytes(WRITE, data);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    amount = READ.s();
    data = mindustry.io.TypeIO.readBytes(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.entitySnapshot(amount, data);
  }
}
