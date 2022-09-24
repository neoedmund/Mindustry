package mindustry.gen;

import arc.math.geom.Vec2;
import mindustry.annotations.Annotations;
import mindustry.type.Weather;

/**
 * Interface for {@link mindustry.type.Weather.WeatherStateComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface WeatherStatec extends Drawc, Entityc, Posc, Syncc {
  Vec2 windVector();

  float effectTimer();

  float intensity();

  float life();

  float opacity();

  Weather weather();

  void draw();

  void effectTimer(float effectTimer);

  void init(Weather weather);

  void intensity(float intensity);

  void life(float life);

  void opacity(float opacity);

  void update();

  void weather(Weather weather);

  void windVector(Vec2 windVector);
}
