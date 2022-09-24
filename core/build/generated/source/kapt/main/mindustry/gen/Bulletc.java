package mindustry.gen;

import arc.func.Cons;
import arc.math.geom.QuadTree;
import arc.struct.IntSeq;
import arc.util.Nullable;
import mindustry.annotations.Annotations;
import mindustry.entities.Mover;
import mindustry.entities.bullet.BulletType;
import mindustry.graphics.Trail;
import mindustry.world.Tile;

/**
 * Interface for {@link mindustry.entities.comp.BulletComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Bulletc extends Damagec, Drawc, Entityc, Hitboxc, Ownerc, Posc, Shielderc, Teamc, Timedc, Timerc, Velc {
  /**
   * @return the bullet's rotation. 
   */
  float rotation();

  /**
   * Sets the bullet's rotation in degrees. 
   */
  void rotation(float angle);

  @Nullable
  Mover mover();

  @Nullable
  Trail trail();

  @Nullable
  Tile aimTile();

  IntSeq collided();

  boolean absorbed();

  boolean checkUnderBuild(Building build, float x, float y);

  boolean collides(Hitboxc other);

  boolean hasCollided(int id);

  boolean hit();

  boolean isLocal();

  boolean keepAlive();

  float aimX();

  float aimY();

  float clipSize();

  float damageMultiplier();

  float fdata();

  float originX();

  float originY();

  Object data();

  BulletType type();

  void absorb();

  void absorbed(boolean absorbed);

  void add();

  void aimTile(@Nullable Tile aimTile);

  void aimX(float aimX);

  void aimY(float aimY);

  void collided(IntSeq collided);

  void collision(Hitboxc other, float x, float y);

  void data(Object data);

  void draw();

  void fdata(float fdata);

  void getCollisions(Cons<QuadTree> consumer);

  void hit(boolean hit);

  void initVel(float angle, float amount);

  void keepAlive(boolean keepAlive);

  void moveRelative(float x, float y);

  void mover(@Nullable Mover mover);

  void originX(float originX);

  void originY(float originY);

  void remove();

  void tileRaycast(int x1, int y1, int x2, int y2);

  void trail(@Nullable Trail trail);

  void turn(float x, float y);

  void type(BulletType type);

  void update();
}
