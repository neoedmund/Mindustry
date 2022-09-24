package mindustry.gen;

import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.DecalComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Decalc extends Drawc, Entityc, Posc, Rotc, Timedc {
  Color color();

  TextureRegion region();

  float clipSize();

  void color(Color color);

  void draw();

  void region(TextureRegion region);
}
