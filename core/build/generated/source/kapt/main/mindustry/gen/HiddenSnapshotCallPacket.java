package mindustry.gen;

import arc.struct.IntSeq;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class HiddenSnapshotCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public IntSeq ids;

  @Override
  public int getPriority() {
    return 0;
  }

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeIntSeq(WRITE, ids);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    ids = mindustry.io.TypeIO.readIntSeq(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.hiddenSnapshot(ids);
  }
}
