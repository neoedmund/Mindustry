package mindustry.gen;

import arc.math.Scaled;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.TimedKillComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface TimedKillc extends Scaled, Entityc, Healthc, Posc {
  float fin();

  float lifetime();

  float time();

  void lifetime(float lifetime);

  void time(float time);

  void update();
}
