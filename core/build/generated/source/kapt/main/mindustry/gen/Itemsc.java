package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.type.Item;
import mindustry.type.ItemStack;

/**
 * Interface for {@link mindustry.entities.comp.ItemsComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Itemsc extends Entityc, Posc {
  boolean acceptsItem(Item item);

  boolean hasItem();

  float itemTime();

  int itemCapacity();

  int maxAccepted(Item item);

  Item item();

  ItemStack stack();

  void addItem(Item item);

  void addItem(Item item, int amount);

  void clearItem();

  void itemTime(float itemTime);

  void stack(ItemStack stack);

  void update();
}
