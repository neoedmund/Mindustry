package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.world.blocks.power.PowerGraph;

/**
 * Interface for {@link mindustry.entities.comp.PowerGraphUpdaterComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface PowerGraphUpdaterc extends Entityc {
  PowerGraph graph();

  void graph(PowerGraph graph);

  void update();
}
