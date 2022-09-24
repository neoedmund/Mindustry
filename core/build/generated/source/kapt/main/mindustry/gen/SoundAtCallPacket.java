package mindustry.gen;

import arc.audio.Sound;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class SoundAtCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Sound sound;

  public float x;

  public float y;

  public float volume;

  public float pitch;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeSound(WRITE, sound);
    WRITE.f(x);
    WRITE.f(y);
    WRITE.f(volume);
    WRITE.f(pitch);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    sound = mindustry.io.TypeIO.readSound(READ);
    x = READ.f();
    y = READ.f();
    volume = READ.f();
    pitch = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.soundAt(sound, x, y, volume, pitch);
  }
}
