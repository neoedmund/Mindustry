package mindustry.gen;

import arc.util.io.Reads;
import arc.util.io.Writes;
import java.nio.FloatBuffer;
import mindustry.annotations.Annotations;

/**
 * Interface for {@link mindustry.entities.comp.SyncComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Syncc extends Entityc {
  boolean isSyncHidden(Player player);

  long lastUpdated();

  long updateSpacing();

  void afterSync();

  void handleSyncHidden();

  void interpolate();

  void lastUpdated(long lastUpdated);

  void readSync(Reads read);

  void readSyncManual(FloatBuffer buffer);

  void remove();

  void snapInterpolation();

  void snapSync();

  void update();

  void updateSpacing(long updateSpacing);

  void writeSync(Writes write);

  void writeSyncManual(FloatBuffer buffer);
}
