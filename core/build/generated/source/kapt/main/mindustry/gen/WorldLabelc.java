package mindustry.gen;

import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.WorldLabelComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface WorldLabelc extends Drawc, Entityc, Posc, Syncc {
  /**
   * Flags are packed into a byte for sync efficiency; see the flag static values. 
   */
  byte flags();

  /**
   * Flags are packed into a byte for sync efficiency; see the flag static values. 
   */
  void flags(byte flags);

  /**
   * This MUST be called instead of remove()! 
   */
  void hide();

  float clipSize();

  float fontSize();

  float z();

  String text();

  void draw();

  void fontSize(float fontSize);

  void text(String text);

  void z(float z);
}
