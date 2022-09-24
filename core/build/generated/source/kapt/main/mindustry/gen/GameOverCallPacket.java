package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Team;
import mindustry.net.Packet;

public class GameOverCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Team winner;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeTeam(WRITE, winner);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    winner = mindustry.io.TypeIO.readTeam(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.Logic.gameOver(winner);
  }
}
