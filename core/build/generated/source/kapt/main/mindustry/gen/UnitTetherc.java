package mindustry.gen;

import arc.util.Nullable;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.UnitTetherComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface UnitTetherc extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  @Nullable
  Unit spawner();

  int spawnerUnitId();

  void afterRead();

  void afterSync();

  void spawner(@Nullable Unit spawner);

  void spawnerUnitId(int spawnerUnitId);

  void update();
}
