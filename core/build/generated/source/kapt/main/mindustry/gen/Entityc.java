package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.EntityComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Entityc {
  /**
   * Replaced with `this` after code generation. 
   */
  <T extends Entityc> T self();

  <T> T as();

  boolean isAdded();

  boolean isLocal();

  boolean isNull();

  boolean isRemote();

  boolean serialize();

  int classId();

  int id();

  void add();

  void afterRead();

  void id(int id);

  void read(Reads read);

  void remove();

  void update();

  void write(Writes write);
}
