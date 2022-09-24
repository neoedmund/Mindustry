package mindustry.gen;

import arc.util.Interval;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.TimerComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Timerc extends Entityc {
  Interval timer();

  boolean timer(int index, float time);

  void timer(Interval timer);
}
