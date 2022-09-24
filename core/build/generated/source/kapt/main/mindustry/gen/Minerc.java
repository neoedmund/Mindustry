package mindustry.gen;

import arc.util.Nullable;
import mindustry.annotations.Annotations;
import mindustry.type.Item;
import mindustry.world.Tile;

/**
 * Interface for {@link mindustry.entities.comp.MinerComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Minerc extends Drawc, Entityc, Itemsc, Posc, Rotc, Teamc {
  @Nullable
  Tile mineTile();

  boolean canMine();

  boolean canMine(Item item);

  boolean mining();

  boolean offloadImmediately();

  boolean validMine(Tile tile);

  boolean validMine(Tile tile, boolean checkDst);

  float mineTimer();

  Item getMineResult(Tile tile);

  void draw();

  void mineTile(@Nullable Tile mineTile);

  void mineTimer(float mineTimer);

  void update();
}
