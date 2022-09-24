package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.game.Rules;
import mindustry.net.Packet;

public class SetRulesCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Rules rules;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeRules(WRITE, rules);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    rules = mindustry.io.TypeIO.readRules(READ);
  }

  @Override
  public void handleClient() {
    mindustry.core.NetClient.setRules(rules);
  }
}
