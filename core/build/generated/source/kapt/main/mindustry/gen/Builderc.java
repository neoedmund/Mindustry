package mindustry.gen;

import arc.struct.Queue;
import mindustry.annotations.Annotations;
import mindustry.entities.units.BuildPlan;

/**
 * Interface for {@link mindustry.entities.comp.BuilderComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Builderc extends Entityc, Flyingc, Healthc, Hitboxc, Posc, Rotc, Statusc, Teamc, Velc {
  /**
   * @return  the build plan currently active, or the one at the top of the queue.
   */
  BuildPlan buildPlan();

  /**
   * @return whether this plan should be skipped, in favor of the next one. 
   */
  boolean shouldSkip(BuildPlan plan, Building core);

  /**
   * Add another build plans to the queue, if it doesn't exist there yet. 
   */
  void addBuild(BuildPlan place, boolean tail);

  /**
   * Add another build plans to the tail of the queue, if it doesn't exist there yet. 
   */
  void addBuild(BuildPlan place);

  /**
   * Clears the placement queue. 
   */
  void clearBuilding();

  /**
   * Draw all current build plans. Does not draw the beam effect, only the positions. 
   */
  void drawBuildPlans();

  /**
   * Return whether this builder's place queue contains items. 
   */
  boolean isBuilding();

  Queue<BuildPlan> plans();

  boolean activelyBuilding();

  boolean canBuild();

  boolean updateBuilding();

  float buildAlpha();

  void buildAlpha(float buildAlpha);

  void draw();

  void drawBuilding();

  void drawBuildingBeam(float px, float py);

  void drawPlan(BuildPlan plan, float alpha);

  void drawPlanTop(BuildPlan plan, float alpha);

  void plans(Queue<BuildPlan> plans);

  void removeBuild(int x, int y, boolean breaking);

  void update();

  void updateBuildLogic();

  void updateBuilding(boolean updateBuilding);

  void validatePlans();
}
