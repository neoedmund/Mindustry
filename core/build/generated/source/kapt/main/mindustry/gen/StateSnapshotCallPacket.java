package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class StateSnapshotCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public float waveTime;

  public int wave;

  public int enemies;

  public boolean paused;

  public boolean gameOver;

  public int timeData;

  public byte tps;

  public long rand0;

  public long rand1;

  public byte[] coreData;

  @Override
  public int getPriority() {
    return 0;
  }

  @Override
  public void write(Writes WRITE) {
    WRITE.f(waveTime);
    WRITE.i(wave);
    WRITE.i(enemies);
    WRITE.bool(paused);
    WRITE.bool(gameOver);
    WRITE.i(timeData);
    WRITE.b(tps);
    WRITE.l(rand0);
    WRITE.l(rand1);
    mindustry.io.TypeIO.writeBytes(WRITE, coreData);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    waveTime = READ.f();
    wave = READ.i();
    enemies = READ.i();
    paused = READ.bool();
    gameOver = READ.bool();
    timeData = READ.i();
    tps = READ.b();
    rand0 = READ.l();
    rand1 = READ.l();
    coreData = mindustry.io.TypeIO.readBytes(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.stateSnapshot(waveTime, wave, enemies, paused, gameOver, timeData, tps, rand0, rand1, coreData);
  }
}
