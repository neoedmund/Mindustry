package mindustry.gen;

import arc.graphics.Color;
import arc.struct.Bits;
import mindustry.annotations.Annotations;
import mindustry.type.StatusEffect;

/**
 * Interface for {@link mindustry.entities.comp.StatusComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Statusc extends Entityc, Flyingc, Healthc, Hitboxc, Posc, Velc {
  /**
   * Adds a status effect to this unit. 
   */
  void apply(StatusEffect effect, float duration);

  /**
   * Apply a status effect for 1 tick (for permanent effects) 
   */
  void apply(StatusEffect effect);

  /**
   * Removes a status effect. 
   */
  void unapply(StatusEffect effect);

  Color statusColor();

  Bits statusBits();

  boolean disarmed();

  boolean hasEffect(StatusEffect effect);

  boolean isBoss();

  boolean isImmune(StatusEffect effect);

  float buildSpeedMultiplier();

  float damageMultiplier();

  float dragMultiplier();

  float getDuration(StatusEffect effect);

  float healthMultiplier();

  float reloadMultiplier();

  float speedMultiplier();

  void buildSpeedMultiplier(float buildSpeedMultiplier);

  void clearStatuses();

  void damageMultiplier(float damageMultiplier);

  void disarmed(boolean disarmed);

  void dragMultiplier(float dragMultiplier);

  void draw();

  void healthMultiplier(float healthMultiplier);

  void reloadMultiplier(float reloadMultiplier);

  void speedMultiplier(float speedMultiplier);

  void update();
}
