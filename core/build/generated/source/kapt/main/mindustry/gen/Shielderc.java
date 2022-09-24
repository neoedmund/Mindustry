package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.ShielderComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Shielderc extends Damagec, Entityc, Posc, Teamc {
  void absorb();
}
