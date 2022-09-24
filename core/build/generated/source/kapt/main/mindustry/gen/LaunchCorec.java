package mindustry.gen;

import arc.util.Interval;
import mindustry.annotations.Annotations;
import mindustry.world.Block;

/**
 * Interface for {@link mindustry.entities.comp.LaunchCoreComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface LaunchCorec extends Drawc, Entityc, Posc, Timedc {
  Interval in();

  float cx();

  float cy();

  Block block();

  void block(Block block);

  void draw();

  void in(Interval in);

  void update();
}
