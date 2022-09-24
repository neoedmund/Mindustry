package mindustry.gen;

import arc.scene.ui.layout.Table;
import arc.struct.Seq;
import mindustry.annotations.Annotations;
import mindustry.world.blocks.payloads.BuildPayload;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.UnitPayload;

/**
 * Interface for {@link mindustry.entities.comp.PayloadComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Payloadc extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  /**
   * @return whether the tile has been successfully placed. 
   */
  boolean dropBlock(BuildPayload payload);

  Seq<Payload> payloads();

  boolean canPickup(Building build);

  boolean canPickup(Unit unit);

  boolean canPickupPayload(Payload pay);

  boolean dropLastPayload();

  boolean dropUnit(UnitPayload payload);

  boolean hasPayload();

  boolean tryDropPayload(Payload payload);

  float payloadUsed();

  void addPayload(Payload load);

  void contentInfo(Table table, float itemSize, float width);

  void payloads(Seq<Payload> payloads);

  void pickup(Building tile);

  void pickup(Unit unit);

  void update();
}
