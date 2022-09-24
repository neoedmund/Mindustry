package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.RotComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Rotc extends Entityc {
  float rotation();

  void rotation(float rotation);
}
