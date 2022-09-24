package mindustry.gen;

import arc.util.Nullable;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.BuildingTetherComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface BuildingTetherc extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  @Nullable
  Building building();

  void building(@Nullable Building building);

  void update();
}
