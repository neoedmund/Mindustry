package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.entities.EntityCollisions;

/**
 * Interface for {@link mindustry.entities.comp.ElevationMoveComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface ElevationMovec extends Entityc, Flyingc, Healthc, Hitboxc, Posc, Velc {
  EntityCollisions.SolidPred solidity();
}
