package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.type.Liquid;
import mindustry.world.Tile;

/**
 * Interface for {@link mindustry.entities.comp.PuddleComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Puddlec extends Drawc, Entityc, Posc {
  float accepting();

  float amount();

  float clipSize();

  float effectTime();

  float getFlammability();

  float lastRipple();

  float updateTime();

  Liquid liquid();

  Tile tile();

  void accepting(float accepting);

  void afterRead();

  void amount(float amount);

  void draw();

  void effectTime(float effectTime);

  void lastRipple(float lastRipple);

  void liquid(Liquid liquid);

  void remove();

  void tile(Tile tile);

  void update();

  void updateTime(float updateTime);
}
