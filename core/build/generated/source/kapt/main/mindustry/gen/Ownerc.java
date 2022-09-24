package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.OwnerComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Ownerc extends Entityc {
  Entityc owner();

  void owner(Entityc owner);
}
