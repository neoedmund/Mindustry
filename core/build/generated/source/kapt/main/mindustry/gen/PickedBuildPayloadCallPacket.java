package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;

public class PickedBuildPayloadCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Unit unit;

  public Building build;

  public boolean onGround;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeUnit(WRITE, unit);
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
    WRITE.bool(onGround);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    unit = mindustry.io.TypeIO.readUnit(READ);
    build = mindustry.io.TypeIO.readBuilding(READ);
    onGround = READ.bool();
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.pickedBuildPayload(unit, build, onGround);
  }
}
