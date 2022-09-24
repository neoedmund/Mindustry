package mindustry.gen;

import arc.struct.Queue;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.entities.units.BuildPlan;
import mindustry.net.NetConnection;
import mindustry.net.Packet;
import mindustry.world.Tile;

public class ClientSnapshotCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public int snapshotID;

  public int unitID;

  public boolean dead;

  public float x;

  public float y;

  public float pointerX;

  public float pointerY;

  public float rotation;

  public float baseRotation;

  public float xVelocity;

  public float yVelocity;

  public Tile mining;

  public boolean boosting;

  public boolean shooting;

  public boolean chatting;

  public boolean building;

  public Queue<BuildPlan> plans;

  public float viewX;

  public float viewY;

  public float viewWidth;

  public float viewHeight;

  @Override
  public void write(Writes WRITE) {
    WRITE.i(snapshotID);
    WRITE.i(unitID);
    WRITE.bool(dead);
    WRITE.f(x);
    WRITE.f(y);
    WRITE.f(pointerX);
    WRITE.f(pointerY);
    WRITE.f(rotation);
    WRITE.f(baseRotation);
    WRITE.f(xVelocity);
    WRITE.f(yVelocity);
    mindustry.io.TypeIO.writeTile(WRITE, mining);
    WRITE.bool(boosting);
    WRITE.bool(shooting);
    WRITE.bool(chatting);
    WRITE.bool(building);
    mindustry.io.TypeIO.writePlansQueueNet(WRITE, plans);
    WRITE.f(viewX);
    WRITE.f(viewY);
    WRITE.f(viewWidth);
    WRITE.f(viewHeight);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    snapshotID = READ.i();
    unitID = READ.i();
    dead = READ.bool();
    x = READ.f();
    y = READ.f();
    pointerX = READ.f();
    pointerY = READ.f();
    rotation = READ.f();
    baseRotation = READ.f();
    xVelocity = READ.f();
    yVelocity = READ.f();
    mining = mindustry.io.TypeIO.readTile(READ);
    boosting = READ.bool();
    shooting = READ.bool();
    chatting = READ.bool();
    building = READ.bool();
    plans = mindustry.io.TypeIO.readPlansQueue(READ);
    viewX = READ.f();
    viewY = READ.f();
    viewWidth = READ.f();
    viewHeight = READ.f();
  }

  @Override
  public void handleServer(NetConnection con) {
    if(con.player == null || con.kicked) {
      return;
    }
    mindustry.gen.Player player = con.player;
    mindustry.core.NetServer.clientSnapshot(player, snapshotID, unitID, dead, x, y, pointerX, pointerY, rotation, baseRotation, xVelocity, yVelocity, mining, boosting, shooting, chatting, building, plans, viewX, viewY, viewWidth, viewHeight);
  }
}
