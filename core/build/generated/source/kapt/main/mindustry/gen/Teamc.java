package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.game.Team;
import mindustry.world.blocks.storage.CoreBlock;

/**
 * Interface for {@link mindustry.entities.comp.TeamComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Teamc extends Entityc, Posc {
  /**
   * @return whether the center of this entity is visible to the viewing team. 
   */
  boolean inFogTo(Team viewer);

  boolean cheating();

  Team team();

  CoreBlock.CoreBuild closestCore();

  CoreBlock.CoreBuild closestEnemyCore();

  CoreBlock.CoreBuild core();

  void team(Team team);
}
