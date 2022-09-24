package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.ShieldComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Shieldc extends Entityc, Healthc, Posc {
  /**
   * Absorbs health damage. 
   */
  float shield();

  /**
   * Absorbs health damage. 
   */
  void shield(float shield);

  /**
   * Shield opacity. 
   */
  float shieldAlpha();

  /**
   * Shield opacity. 
   */
  void shieldAlpha(float shieldAlpha);

  /**
   * Subtracts an amount from damage. No need to save. 
   */
  float armor();

  /**
   * Subtracts an amount from damage. No need to save. 
   */
  void armor(float armor);

  void damage(float amount);

  void damagePierce(float amount, boolean withEffect);

  void update();
}
