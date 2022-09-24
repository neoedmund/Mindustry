package mindustry.gen;

import arc.math.geom.Vec2;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.NetConnection;
import mindustry.net.Packet;

public class CommandBuildingCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Player player;

  public Building build;

  public Vec2 target;

  @Override
  public void write(Writes WRITE) {
    if(mindustry.Vars.net.server()) {
      mindustry.io.TypeIO.writeEntity(WRITE, player);
    }
    mindustry.io.TypeIO.writeBuilding(WRITE, build);
    mindustry.io.TypeIO.writeVec2(WRITE, target);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    if(mindustry.Vars.net.client()) {
      player = mindustry.io.TypeIO.readEntity(READ);
    }
    build = mindustry.io.TypeIO.readBuilding(READ);
    target = mindustry.io.TypeIO.readVec2(READ);
  }

  @Override
  public void handleServer(NetConnection con) {
    if(con.player == null || con.kicked) {
      return;
    }
    mindustry.gen.Player player = con.player;
    mindustry.input.InputHandler.commandBuilding(player, build, target);
    mindustry.gen.Call.commandBuilding__forward(con, player, build, target);
  }

  @Override
  public void handleClient() {
    mindustry.input.InputHandler.commandBuilding(player, build, target);
  }
}
