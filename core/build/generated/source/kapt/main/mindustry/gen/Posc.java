package mindustry.gen;

import arc.math.geom.Position;
import mindustry.annotations.Annotations;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

/**
 * Interface for {@link mindustry.entities.comp.PosComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Posc extends Position, Entityc {
  /**
   * Returns air if this unit is on a non-air top block. 
   */
  Floor floorOn();

  Building buildOn();

  boolean onSolid();

  float getX();

  float getY();

  float x();

  float y();

  int tileX();

  int tileY();

  Block blockOn();

  Tile tileOn();

  void set(Position pos);

  void set(float x, float y);

  void trns(Position pos);

  void trns(float x, float y);

  void x(float x);

  void y(float y);
}
