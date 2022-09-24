package mindustry.gen;

import arc.struct.Seq;
import arc.util.Interval;
import mindustry.annotations.Annotations;
import mindustry.type.ItemStack;

/**
 * Interface for {@link mindustry.world.blocks.campaign.LaunchPad.LaunchPayloadComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface LaunchPayloadc extends Drawc, Entityc, Posc, Teamc, Timedc {
  Seq<ItemStack> stacks();

  Interval in();

  float cx();

  float cy();

  void draw();

  void in(Interval in);

  void remove();

  void stacks(Seq<ItemStack> stacks);

  void update();
}
