package mindustry.gen;

import arc.util.Nullable;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.ChildComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Childc extends Entityc, Posc, Rotc {
  @Nullable
  Posc parent();

  boolean rotWithParent();

  float offsetPos();

  float offsetRot();

  float offsetX();

  float offsetY();

  void add();

  void offsetPos(float offsetPos);

  void offsetRot(float offsetRot);

  void offsetX(float offsetX);

  void offsetY(float offsetY);

  void parent(@Nullable Posc parent);

  void rotWithParent(boolean rotWithParent);

  void update();
}
