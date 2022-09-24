package mindustry.gen;

import arc.math.geom.Position;
import mindustry.annotations.Annotations;
import mindustry.entities.units.WeaponMount;
import mindustry.type.UnitType;

/**
 * Interface for {@link mindustry.entities.comp.WeaponsComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Weaponsc extends Entityc, Flyingc, Healthc, Hitboxc, Posc, Rotc, Statusc, Teamc, Velc {
  /**
   * Aim at something. This will make all mounts point at it. 
   */
  void aim(float x, float y);

  /**
   * Update shooting and rotation for this unit. 
   */
  void update();

  /**
   * weapon mount array, never null 
   */
  WeaponMount[] mounts();

  /**
   * weapon mount array, never null 
   */
  void mounts(WeaponMount[] mounts);

  boolean canShoot();

  boolean isRotate();

  boolean isShooting();

  float aimX();

  float aimY();

  float ammo();

  float ammof();

  void aim(Position pos);

  void aimX(float aimX);

  void aimY(float aimY);

  void ammo(float ammo);

  void controlWeapons(boolean rotate, boolean shoot);

  void controlWeapons(boolean rotateShoot);

  void isShooting(boolean isShooting);

  void remove();

  void setWeaponRotation(float rotation);

  void setupWeapons(UnitType def);
}
