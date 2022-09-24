package mindustry.gen;

import arc.math.geom.Vec2;
import mindustry.annotations.Annotations;
import mindustry.world.blocks.environment.Floor;

/**
 * Interface for {@link mindustry.entities.comp.MechComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Mechc extends Boundedc, Builderc, Drawc, ElevationMovec, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  float baseRotation();

  float walkExtend(boolean scaled);

  float walkExtension();

  float walkTime();

  Floor drownFloor();

  void approach(Vec2 vector);

  void baseRotation(float baseRotation);

  void moveAt(Vec2 vector, float acceleration);

  void rotateMove(Vec2 vec);

  void update();

  void walkExtension(float walkExtension);

  void walkTime(float walkTime);
}
