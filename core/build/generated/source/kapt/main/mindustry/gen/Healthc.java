package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.HealthComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Healthc extends Entityc, Posc {
  /**
   * Damage and pierce armor. 
   */
  void damagePierce(float amount);

  /**
   * Damage and pierce armor. 
   */
  void damagePierce(float amount, boolean withEffect);

  /**
   * Heals by a 0-1 fraction of max health. 
   */
  void healFract(float amount);

  /**
   * Heals by a flat amount. 
   */
  void heal(float amount);

  boolean damaged();

  boolean dead();

  boolean isValid();

  float health();

  float healthf();

  float hitTime();

  float maxHealth();

  void clampHealth();

  void damage(float amount);

  void damage(float amount, boolean withEffect);

  void damageContinuous(float amount);

  void damageContinuousPierce(float amount);

  void dead(boolean dead);

  void heal();

  void health(float health);

  void hitTime(float hitTime);

  void kill();

  void killed();

  void maxHealth(float maxHealth);

  void update();
}
