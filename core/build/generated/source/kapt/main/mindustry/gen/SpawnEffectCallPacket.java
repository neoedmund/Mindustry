package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.type.UnitType;

public class SpawnEffectCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public float x;

  public float y;

  public float rotation;

  public UnitType u;

  @Override
  public void write(Writes WRITE) {
    WRITE.f(x);
    WRITE.f(y);
    WRITE.f(rotation);
    mindustry.io.TypeIO.writeUnitType(WRITE, u);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    x = READ.f();
    y = READ.f();
    rotation = READ.f();
    u = mindustry.io.TypeIO.readUnitType(READ);
  }

  @Override
  public void handleClient() {
    mindustry.ai.WaveSpawner.spawnEffect(x, y, rotation, u);
  }
}
