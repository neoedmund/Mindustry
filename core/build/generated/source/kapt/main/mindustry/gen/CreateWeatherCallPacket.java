package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.lang.Override;
import mindustry.net.Packet;
import mindustry.type.Weather;

public class CreateWeatherCallPacket extends Packet {
  private byte[] DATA = NODATA;

  public Weather weather;

  public float intensity;

  public float duration;

  public float windX;

  public float windY;

  @Override
  public void write(Writes WRITE) {
    mindustry.io.TypeIO.writeWeather(WRITE, weather);
    WRITE.f(intensity);
    WRITE.f(duration);
    WRITE.f(windX);
    WRITE.f(windY);
  }

  @Override
  public void read(Reads READ, int LENGTH) {
    DATA = READ.b(LENGTH);
  }

  @Override
  public void handled() {
    BAIS.setBytes(DATA);
    weather = mindustry.io.TypeIO.readWeather(READ);
    intensity = READ.f();
    duration = READ.f();
    windX = READ.f();
    windY = READ.f();
  }

  @Override
  public void handleClient() {
    mindustry.type.Weather.createWeather(weather, intensity, duration, windX, windY);
  }
}
