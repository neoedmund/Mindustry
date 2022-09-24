package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.MapObjectives;
import mindustry.net.Packet;

public class SetObjectivesCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public MapObjectives executor;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeObjectives(WRITE, executor);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    executor = mindustry.io.TypeIO.readObjectives(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.setObjectives(executor);
  }
}
