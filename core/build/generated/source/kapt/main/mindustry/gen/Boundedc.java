package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.BoundedComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Boundedc extends Entityc, Flyingc, Healthc, Hitboxc, Posc, Velc {
  void update();
}
