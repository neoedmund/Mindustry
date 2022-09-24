package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.world.Tile;

/**
 * Interface for {@link mindustry.entities.comp.FireComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Firec extends Drawc, Entityc, Posc, Syncc, Timedc {
  float clipSize();

  Tile tile();

  void afterRead();

  void afterSync();

  void draw();

  void remove();

  void tile(Tile tile);

  void update();
}
