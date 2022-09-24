package mindustry.gen;

import arc.graphics.g2d.TextureRegion;
import arc.math.geom.Position;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Table;
import arc.util.Nullable;
import mindustry.ai.types.CommandAI;
import mindustry.annotations.Annotations;
import mindustry.ctype.Content;
import mindustry.entities.abilities.Ability;
import mindustry.entities.units.UnitController;
import mindustry.game.Team;
import mindustry.graphics.Trail;
import mindustry.logic.LAccess;
import mindustry.logic.Ranged;
import mindustry.logic.Senseable;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.ui.Displayable;

/**
 * Interface for {@link mindustry.entities.comp.UnitComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Unitc extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Velc, Weaponsc, Ranged, Senseable, Displayable {
  /**
   * @return a preview icon for this unit. 
   */
  TextureRegion icon();

  /**
   * @return approx. square size of the physical hitbox for physics 
   */
  float physicSize();

  /**
   * @return name of direct or indirect player controller. 
   */
  String getControllerName();

  /**
   * @return pathfinder path type for calculating costs 
   */
  int pathType();

  /**
   * @return speed with boost & floor multipliers factored in. 
   */
  float speed();

  /**
   * @return where the unit wants to look at. 
   */
  float prefRotation();

  /**
   * @return whether there is solid, un-occupied ground under this unit. 
   */
  boolean canLand();

  /**
   * Actually destroys the unit, removing it and creating explosions. 
   */
  void destroy();

  /**
   * Called when this unit was unloaded from a factory or spawn point. 
   */
  void unloaded();

  /**
   * Move based on preferred unit movement type. 
   */
  void movePref(Vec2 movement);

  @Nullable
  Trail trail();

  @Nullable
  UnitType dockedType();

  Player getPlayer();

  boolean canDrown();

  boolean canShoot();

  boolean collides(Hitboxc other);

  boolean hasWeapons();

  boolean hittable();

  boolean inFogTo(Team viewer);

  boolean inRange(Position other);

  boolean isAI();

  boolean isCommandable();

  boolean isEnemy();

  boolean isImmune(StatusEffect effect);

  boolean isPlayer();

  boolean isSyncHidden(Player player);

  boolean spawnedByCore();

  boolean targetable(Team targeter);

  double flag();

  double sense(Content content);

  double sense(LAccess sensor);

  float bounds();

  float clipSize();

  float healTime();

  float range();

  float shadowAlpha();

  int cap();

  int count();

  int itemCapacity();

  int lastFogPos();

  Object senseObject(LAccess sensor);

  String lastCommanded();

  CommandAI command();

  Ability[] abilities();

  UnitController controller();

  UnitType type();

  void abilities(Ability[] abilities);

  void add();

  void afterRead();

  void afterSync();

  void aimLook(Position pos);

  void aimLook(float x, float y);

  void approach(Vec2 vector);

  void collision(Hitboxc other, float x, float y);

  void controller(UnitController next);

  void display(Table table);

  void dockedType(@Nullable UnitType dockedType);

  void draw();

  void flag(double flag);

  void handleSyncHidden();

  void heal(float amount);

  void healTime(float healTime);

  void kill();

  void killed();

  void landed();

  void lastCommanded(String lastCommanded);

  void lastFogPos(int lastFogPos);

  void lookAt(Position pos);

  void lookAt(float angle);

  void lookAt(float x, float y);

  void moveAt(Vec2 vector);

  void remove();

  void resetController();

  void rotateMove(Vec2 vec);

  void set(UnitType def, UnitController controller);

  void setType(UnitType type);

  void shadowAlpha(float shadowAlpha);

  void spawnedByCore(boolean spawnedByCore);

  void trail(@Nullable Trail trail);

  void type(UnitType type);

  void update();
}
