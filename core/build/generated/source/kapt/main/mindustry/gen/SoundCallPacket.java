package mindustry.gen;

import arc.audio.Sound;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class SoundCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Sound sound;

  public float volume;

  public float pitch;

  public float pan;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeSound(WRITE, sound);
    WRITE.f(volume);
    WRITE.f(pitch);
    WRITE.f(pan);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    sound = mindustry.io.TypeIO.readSound(READ);
    volume = READ.f();
    pitch = READ.f();
    pan = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.sound(sound, volume, pitch, pan);
  }
}
