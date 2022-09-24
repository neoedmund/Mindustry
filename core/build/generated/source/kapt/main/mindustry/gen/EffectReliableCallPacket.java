package mindustry.gen;

import arc.graphics.Color;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.entities.Effect;
import mindustry.net.Packet;

public class EffectReliableCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Effect effect;

  public float x;

  public float y;

  public float rotation;

  public Color color;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeEffect(WRITE, effect);
    WRITE.f(x);
    WRITE.f(y);
    WRITE.f(rotation);
    mindustry.io.TypeIO.writeColor(WRITE, color);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    effect = mindustry.io.TypeIO.readEffect(READ);
    x = READ.f();
    y = READ.f();
    rotation = READ.f();
    color = mindustry.io.TypeIO.readColor(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.effectReliable(effect, x, y, rotation, color);
  }
}
