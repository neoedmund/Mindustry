package mindustry.gen;

import arc.func.Cons;
import arc.math.geom.QuadTree;
import arc.math.geom.QuadTree.QuadTreeObject;
import arc.math.geom.Rect;
import mindustry.annotations.Annotations;
import mindustry.entities.Sized;

/**
 * Interface for {@link mindustry.entities.comp.HitboxComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Hitboxc extends QuadTreeObject, Sized, Entityc, Posc {
  boolean collides(Hitboxc other);

  float deltaAngle();

  float deltaLen();

  float deltaX();

  float deltaY();

  float hitSize();

  float lastX();

  float lastY();

  void add();

  void afterRead();

  void collision(Hitboxc other, float x, float y);

  void deltaX(float deltaX);

  void deltaY(float deltaY);

  void getCollisions(Cons<QuadTree> consumer);

  void hitSize(float hitSize);

  void hitbox(Rect rect);

  void hitboxTile(Rect rect);

  void lastX(float lastX);

  void lastY(float lastY);

  void update();

  void updateLastPosition();
}
