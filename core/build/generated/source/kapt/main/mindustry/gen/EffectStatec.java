package mindustry.gen;

import arc.graphics.Color;
import mindustry.annotations.Annotations;
import mindustry.entities.Effect;

/**
 * Interface for {@link mindustry.entities.comp.EffectStateComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface EffectStatec extends Childc, Drawc, Entityc, Posc, Rotc, Timedc {
  Color color();

  float clipSize();

  Object data();

  Effect effect();

  void color(Color color);

  void data(Object data);

  void draw();

  void effect(Effect effect);
}
