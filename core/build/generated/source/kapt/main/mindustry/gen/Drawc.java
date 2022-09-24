package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.DrawComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Drawc extends Entityc, Posc {
  float clipSize();

  void draw();
}
