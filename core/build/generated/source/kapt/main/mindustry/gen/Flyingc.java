package mindustry.gen;

import arc.math.geom.Vec2;
import arc.util.Nullable;
import mindustry.annotations.Annotations;
import mindustry.world.blocks.environment.Floor;

/**
 * Interface for {@link mindustry.entities.comp.FlyingComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Flyingc extends Entityc, Healthc, Hitboxc, Posc, Velc {
  @Nullable
  Floor lastDrownFloor();

  boolean canDrown();

  boolean checkTarget(boolean targetAir, boolean targetGround);

  boolean emitWalkSound();

  boolean hovering();

  boolean isFlying();

  boolean isGrounded();

  float drownTime();

  float elevation();

  float floorSpeedMultiplier();

  float splashTimer();

  Floor drownFloor();

  void drownTime(float drownTime);

  void elevation(float elevation);

  void hovering(boolean hovering);

  void landed();

  void lastDrownFloor(@Nullable Floor lastDrownFloor);

  void moveAt(Vec2 vector, float acceleration);

  void splashTimer(float splashTimer);

  void update();

  void updateDrowning();

  void wobble();
}
