package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.DamageComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Damagec extends Entityc {
  float damage();

  void damage(float damage);
}
