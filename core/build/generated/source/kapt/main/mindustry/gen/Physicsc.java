package mindustry.gen;

import arc.math.geom.Vec2;
import mindustry.annotations.Annotations;
import mindustry.async.PhysicsProcess;

/**
 * Interface for {@link mindustry.entities.comp.PhysicsComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Physicsc extends Entityc, Flyingc, Healthc, Hitboxc, Posc, Velc {
  float mass();

  PhysicsProcess.PhysicRef physref();

  void impulse(Vec2 v);

  void impulse(float x, float y);

  void impulseNet(Vec2 v);

  void physref(PhysicsProcess.PhysicRef physref);
}
