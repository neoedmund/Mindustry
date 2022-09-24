package mindustry.gen;

import mindustry.annotations.Annotations;
import mindustry.entities.EntityCollisions;
import mindustry.world.blocks.environment.Floor;

/**
 * Interface for {@link mindustry.entities.comp.CrawlComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Crawlc extends Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  float crawlTime();

  float floorSpeedMultiplier();

  float lastCrawlSlowdown();

  float segmentRot();

  int pathType();

  EntityCollisions.SolidPred solidity();

  Floor drownFloor();

  Floor lastDeepFloor();

  void add();

  void crawlTime(float crawlTime);

  void lastCrawlSlowdown(float lastCrawlSlowdown);

  void lastDeepFloor(Floor lastDeepFloor);

  void segmentRot(float segmentRot);

  void update();
}
