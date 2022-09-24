package mindustry.gen;

import arc.math.Scaled;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.TimedComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Timedc extends Scaled, Entityc {
  float fin();

  float lifetime();

  float time();

  void lifetime(float lifetime);

  void time(float time);

  void update();
}
