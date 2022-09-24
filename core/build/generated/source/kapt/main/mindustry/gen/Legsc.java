package mindustry.gen;

import arc.math.geom.Vec2;
import mindustry.annotations.Annotations;
import mindustry.entities.EntityCollisions;
import mindustry.entities.Leg;
import mindustry.world.blocks.environment.Floor;

/**
 * Interface for {@link mindustry.entities.comp.LegsComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Legsc extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  /**
   * @return outwards facing angle of leg at the specified index. 
   */
  float legAngle(int index);

  Vec2 curMoveOffset();

  Vec2 legOffset(Vec2 out, int index);

  float baseRotation();

  float defaultLegAngle(int index);

  float moveSpace();

  float totalLength();

  int pathType();

  EntityCollisions.SolidPred solidity();

  Leg[] legs();

  Floor drownFloor();

  Floor lastDeepFloor();

  void add();

  void baseRotation(float baseRotation);

  void curMoveOffset(Vec2 curMoveOffset);

  void destroy();

  void lastDeepFloor(Floor lastDeepFloor);

  void legs(Leg[] legs);

  void moveSpace(float moveSpace);

  void resetLegs();

  void resetLegs(float legLength);

  void totalLength(float totalLength);

  void unloaded();

  void update();
}
