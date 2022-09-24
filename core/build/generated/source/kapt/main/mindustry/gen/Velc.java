package mindustry.gen;

import arc.math.geom.Vec2;
import mindustry.annotations.Annotations;
import mindustry.entities.EntityCollisions;

/**
 * Interface for {@link mindustry.entities.comp.VelComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Velc extends Entityc, Posc {
  /**
   * @return function to use for check solid state. if null, no checking is done. 
   */
  EntityCollisions.SolidPred solidity();

  /**
   * @return whether this entity can exist on its current location
   */
  boolean canPassOn();

  /**
   * @return whether this entity can move through a location
   */
  boolean canPass(int tileX, int tileY);

  Vec2 vel();

  boolean moving();

  float drag();

  void drag(float drag);

  void move(Vec2 v);

  void move(float cx, float cy);

  void update();

  void vel(Vec2 vel);

  void velAddNet(Vec2 v);

  void velAddNet(float vx, float vy);
}
