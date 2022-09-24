package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.entities.EntityCollisions;

/**
 * Interface for {@link mindustry.entities.comp.WaterMoveComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface WaterMovec extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  boolean emitWalkSound();

  boolean onLiquid();

  boolean onSolid();

  float floorSpeedMultiplier();

  int pathType();

  EntityCollisions.SolidPred solidity();

  void add();

  void draw();

  void update();
}
