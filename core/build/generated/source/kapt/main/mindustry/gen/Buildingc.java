package mindustry.gen;

import arc.Graphics;
import arc.func.Boolf;
import arc.func.Cons;
import arc.graphics.g2d.TextureRegion;
import arc.math.geom.Position;
import arc.math.geom.QuadTree.QuadTreeObject;
import arc.math.geom.Rect;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Table;
import arc.struct.IntSet;
import arc.struct.Seq;
import arc.util.Nullable;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.annotations.Annotations;
import mindustry.ctype.Content;
import mindustry.entities.Sized;
import mindustry.game.Team;
import mindustry.logic.Controllable;
import mindustry.logic.LAccess;
import mindustry.logic.Senseable;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.type.PayloadSeq;
import mindustry.ui.Displayable;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.meta.BlockStatus;
import mindustry.world.modules.ItemModule;
import mindustry.world.modules.LiquidModule;
import mindustry.world.modules.PowerModule;

/**
 * Interface for {@link mindustry.entities.comp.BuildingComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Buildingc extends QuadTreeObject, Sized, Entityc, Healthc, Posc, Teamc, Timerc, Controllable, Senseable, Displayable {
  /**
   *  @return the building's 'warmup', a smooth value from 0 to 1.
   *  usually used for crafters and things that need to spin up before reaching full efficiency.
   *  many blocks will just return 0.
   *  
   */
  float warmup();

  /**
   *  Called when a block is placed over some other blocks. This seq will always have at least one item.
   *  Should load some previous state, if necessary. 
   */
  void overwrote(Seq<Building> previous);

  /**
   *  Called when a position is tapped while this building is selected.
   *
   *  @return whether the tap event is consumed - if true, the player will not start shooting or interact with things under the cursor.
   *  
   */
  boolean onConfigureTapped(float x, float y);

  /**
   *  Called when another tile is tapped while this building is selected.
   *  @return whether this block should be deselected.
   */
  boolean onConfigureBuildTapped(Building other);

  /**
   *  Called when this block's config menu is closed.
   */
  void onConfigureClosed();

  /**
   *  Tries dumping a payload to any adjacent block.
   *  @param todump payload to dump.
   *  @return whether the payload was moved successfully
   */
  boolean dumpPayload(Payload todump);

  /**
   *  Tries moving a payload forwards.
   *  @param todump payload to dump.
   *  @return whether the payload was moved successfully
   */
  boolean movePayload(Payload todump);

  /**
   *  Tries to put this item into a nearby container, if there are no available
   *  containers, it gets added to the block's inventory.
   */
  void offload(Item item);

  /**
   *  Tries to put this item into a nearby container. Returns success. Unlike #offload(), this method does not change the block inventory.
   */
  boolean put(Item item);

  /**
   *  Try dumping a specific item near the building.
   *  @param todump Item to dump. Can be null to dump anything.
   */
  boolean dump(Item todump);

  /**
   * @param outputDir output liquid direction relative to rotation, or -1 to use any direction. 
   */
  void dumpLiquid(Liquid liquid, float scaling, int outputDir);

  /**
   * @return ambient sound volume scale. 
   */
  float ambientVolume();

  /**
   * @return preferred rotation of main texture region to be drawn 
   */
  float drawrot();

  /**
   * @return the cap for item amount calculations, used when this block explodes. 
   */
  int explosionItemCap();

  /**
   * @return the item module to use for flow rate calculations 
   */
  ItemModule flowItems();

  /**
   * @return the position that this block points to for commands, or null. 
   */
  Vec2 getCommandPosition();

  /**
   * @return total time this block has been producing something; non-crafter blocks usually return Time.time. 
   */
  float totalProgress();

  /**
   * @return volume cale of active sound. 
   */
  float activeSoundVolume();

  /**
   * @return whether a building has regen/healing suppressed; if so, spawns particles on it. 
   */
  boolean checkSuppression();

  /**
   * @return whether the player can select (but not actually control) this building. 
   */
  boolean canControlSelect(Unit player);

  /**
   * @return whether this block is allowed to update based on team/environment 
   */
  boolean allowUpdate();

  /**
   * @return whether this block is currently "active" and should be consuming requirements. 
   */
  boolean shouldConsume();

  /**
   * @return whether this block should play its active sound.
   */
  boolean shouldActiveSound();

  /**
   * @return whether this block should play its idle sound.
   */
  boolean shouldAmbientSound();

  /**
   * @return whether this building is currently "burning" a trigger consumer (an item) - if true, valid() on those will return true. 
   */
  boolean consumeTriggerValid();

  /**
   * @return whether this building is in a payload 
   */
  boolean isPayload();

  /**
   * Any class that overrides this method and changes the value must call Vars.fogControl.forceUpdate(team). 
   */
  float fogRadius();

  /**
   * Base efficiency. Takes the minimum value of all consumers. 
   */
  float efficiency();

  /**
   * Base efficiency. Takes the minimum value of all consumers. 
   */
  void efficiency(float efficiency);

  /**
   * Calculate your own efficiency multiplier. By default, this is applied in updateEfficiencyMultiplier. 
   */
  float efficiencyScale();

  /**
   * Call when nothing is happening to the entity. This increments the internal sleep timer. 
   */
  void sleep();

  /**
   * Call when this entity is updating. This wakes it up. 
   */
  void noSleep();

  /**
   * Called *after* the tile has been removed. 
   */
  void afterDestroyed();

  /**
   * Called after efficiency is updated but before consumers are updated. Use to apply your own multiplier. 
   */
  void updateEfficiencyMultiplier();

  /**
   * Called after the block is placed by anyone. 
   */
  void placed();

  /**
   * Called after the block is placed by this client. 
   */
  void playerPlaced(Object config);

  /**
   * Called after this building is created in the world. May be called multiple times, or when adjacent buildings change. 
   */
  void onProximityAdded();

  /**
   * Called clientside when the client taps a block to config.
   *  @return whether the configuration UI should be shown. 
   */
  boolean configTapped();

  /**
   * Called every frame a unit is on this  
   */
  void unitOn(Unit unit);

  /**
   * Called right after this building is picked up. 
   */
  void afterPickedUp();

  /**
   * Called right before this building is picked up. 
   */
  void pickedUp();

  /**
   * Called shortly before this building is removed. 
   */
  void onProximityRemoved();

  /**
   * Called when a player control-selects this building - not called for ControlBlock subclasses. 
   */
  void onControlSelect(Unit player);

  /**
   * Called when a unit that spawned at this tile is removed. 
   */
  void unitRemoved(Unit unit);

  /**
   * Called when an unloader takes an item. 
   */
  void itemTaken(Item item);

  /**
   * Called when anything adjacent to this building is placed/removed, including itself. 
   */
  void onProximityUpdate();

  /**
   * Called when arbitrary configuration is applied to a tile. 
   */
  void configured(Unit builder, Object value);

  /**
   * Called when the block is destroyed. The tile is still intact at this stage. 
   */
  void onDestroyed();

  /**
   * Called when the block is tapped by the local player. 
   */
  void tapped();

  /**
   * Called when this block is dropped as a payload. 
   */
  void dropped();

  /**
   * Called when this block is tapped to build a UI on the table.
   *  configurable must be true for this to be called.
   */
  void buildConfiguration(Table table);

  /**
   * Called when this building receives a position command. Requires a commandable block. 
   */
  void onCommand(Vec2 target);

  /**
   * Changes this building's team in a safe manner. 
   */
  void changeTeam(Team next);

  /**
   * Configure from a server. 
   */
  void configureAny(Object value);

  /**
   * Configure with the current, local player. 
   */
  void configure(Object value);

  /**
   * Deselect this tile from configuration. 
   */
  void deselect();

  /**
   * Draw the block overlay that is shown when a cursor is over the block. 
   */
  void drawSelect();

  /**
   * Dumps any item with an accumulator. May dump multiple times per frame. Use with care. 
   */
  boolean dumpAccumulate();

  /**
   * Dumps any item with an accumulator. May dump multiple times per frame. Use with care. 
   */
  boolean dumpAccumulate(Item item);

  /**
   * Efficiency * delta. 
   */
  float edelta();

  /**
   * Handle a bullet collision.
   *  @return whether the bullet should be removed. 
   */
  boolean collision(Bullet other);

  /**
   * Handle a stack input. 
   */
  void handleStack(Item item, int amount, Teamc source);

  /**
   * Handles splash damage with a bullet source. 
   */
  void damage(Bullet bullet, Team source, float damage);

  /**
   * Multiblock back. 
   */
  Building back();

  /**
   * Multiblock front. 
   */
  Building front();

  /**
   * Multiblock left. 
   */
  Building left();

  /**
   * Multiblock right. 
   */
  Building right();

  /**
   * Remove a stack from this inventory, and return the amount removed. 
   */
  int removeStack(Item item, int amount);

  /**
   * Returns offset for stack placement. 
   */
  void getStackOffset(Item item, Vec2 trns);

  /**
   * Returns the amount of items this block can accept. 
   */
  int acceptStack(Item item, int amount, Teamc source);

  /**
   * Returns the version of this Building IO code.
   */
  byte version();

  /**
   * Returns whether a hand cursor should be shown over this block. 
   */
  Graphics.Cursor getCursor();

  /**
   * Returns whether this config menu should show when the specified player taps it. 
   */
  boolean shouldShowConfigure(Player player);

  /**
   * Same as efficiency, but for optional consumers only. 
   */
  float optionalEfficiency();

  /**
   * Same as efficiency, but for optional consumers only. 
   */
  void optionalEfficiency(float optionalEfficiency);

  /**
   * Scaled delta. 
   */
  float delta();

  /**
   * Sets this tile entity data to this and adds it if necessary. 
   */
  Building init(Tile tile, Team team, boolean shouldAdd, int rotation);

  /**
   * Sets up all the necessary variables, but does not add this entity anywhere. 
   */
  Building create(Block block, Team team);

  /**
   * TODO Each bit corresponds to a team ID. Only 64 are supported. Does not work on servers. 
   */
  long visibleFlags();

  /**
   * TODO Each bit corresponds to a team ID. Only 64 are supported. Does not work on servers. 
   */
  void visibleFlags(long visibleFlags);

  /**
   * The efficiency this block *would* have if shouldConsume() returned true. 
   */
  float potentialEfficiency();

  /**
   * The efficiency this block *would* have if shouldConsume() returned true. 
   */
  void potentialEfficiency(float potentialEfficiency);

  /**
   * This is for logic blocks. 
   */
  void handleString(Object value);

  /**
   * Tile configuration. Defaults to null. Used for block rebuilding. 
   */
  Object config();

  /**
   * Tries to take the payload. Returns null if no payload is present. 
   */
  Payload takePayload();

  /**
   * Try dumping any item near the building. 
   */
  boolean dump();

  /**
   * Try offloading an item to a nearby container in its facing direction. Returns true if success. 
   */
  boolean moveForward(Item item);

  /**
   * Update table alignment after configuring.
   */
  void updateTableAlign(Table table);

  /**
   * Used for dumping items. 
   */
  boolean canDump(Building to, Item item);

  /**
   * Used to handle damage from splash damage for certain types of blocks. 
   */
  void damage(Team source, float damage);

  /**
   * Whether this configuration should be hidden now. Called every frame the config is open. 
   */
  boolean shouldHideConfigure(Player player);

  @Nullable
  Building lastDisabler();

  @Nullable
  ItemModule items();

  @Nullable
  LiquidModule liquids();

  @Nullable
  PowerModule power();

  Building getLiquidDestination(Building from, Liquid liquid);

  Building nearby(int dx, int dy);

  Building nearby(int rotation);

  TextureRegion getDisplayIcon();

  Seq<Building> getPowerConnections(Seq<Building> out);

  Seq<Building> proximity();

  boolean absorbLasers();

  boolean acceptItem(Building source, Item item);

  boolean acceptLiquid(Building source, Liquid liquid);

  boolean acceptPayload(Building source, Payload payload);

  boolean canConsume();

  boolean canDumpLiquid(Building to, Liquid liquid);

  boolean canPickup();

  boolean canResupply();

  boolean canUnload();

  boolean canWithdraw();

  boolean checkSolid();

  boolean collide(Bullet other);

  boolean conductsTo(Building other);

  boolean enabled();

  boolean inFogTo(Team viewer);

  boolean interactable(Team team);

  boolean isHealSuppressed();

  boolean isInsulated();

  boolean isValid();

  boolean payloadCheck(int conveyorRotation);

  boolean productionValid();

  boolean wasDamaged();

  boolean wasRecentlyDamaged();

  boolean wasRecentlyHealed(float duration);

  boolean wasVisible();

  byte relativeTo(Building build);

  byte relativeTo(int cx, int cy);

  byte relativeTo(Tile tile);

  byte relativeToEdge(Tile other);

  double sense(Content content);

  double sense(LAccess sensor);

  float calculateHeat(float[] sideHeat);

  float calculateHeat(float[] sideHeat, IntSet cameFrom);

  float getDisplayEfficiency();

  float getPowerProduction();

  float getProgressIncrease(float baseTime);

  float handleDamage(float amount);

  float healSuppressionTime();

  float hitSize();

  float lastHealTime();

  float moveLiquid(Building next, Liquid liquid);

  float moveLiquidForward(boolean leaks, Liquid liquid);

  float payloadRotation();

  float progress();

  float rotdeg();

  float timeScale();

  float visualLiquid();

  int cdump();

  int getMaximumAccepted(Item item);

  int moduleBitmask();

  int pos();

  int rotation();

  int tileX();

  int tileY();

  Object senseObject(LAccess sensor);

  String getDisplayName();

  String lastAccessed();

  PayloadSeq getPayloads();

  Block block();

  Tile findClosestEdge(Position to, Boolf<Tile> solid);

  Tile tile();

  Floor floor();

  Payload getPayload();

  BlockStatus status();

  void add();

  void addPlan(boolean checkPrevious);

  void addPlan(boolean checkPrevious, boolean ignoreConditions);

  void applyBoost(float intensity, float duration);

  void applyHealSuppression(float amount);

  void applySlowdown(float intensity, float duration);

  void block(Block block);

  void cdump(int cdump);

  void consume();

  void control(LAccess type, double p1, double p2, double p3, double p4);

  void control(LAccess type, Object p1, double p2, double p3, double p4);

  void created();

  void damage(float damage);

  void display(Table table);

  void displayBars(Table table);

  void displayConsumption(Table table);

  void draw();

  void drawConfigure();

  void drawCracks();

  void drawDisabled();

  void drawLight();

  void drawLiquidLight(Liquid liquid, float amount);

  void drawStatus();

  void drawTeam();

  void drawTeamTop();

  void dumpLiquid(Liquid liquid);

  void dumpLiquid(Liquid liquid, float scaling);

  void enabled(boolean enabled);

  void handleItem(Building source, Item item);

  void handleLiquid(Building source, Liquid liquid, float amount);

  void handlePayload(Building source, Payload payload);

  void handleUnitPayload(Unit unit, Cons<Payload> grabber);

  void heal();

  void heal(float amount);

  void healSuppressionTime(float healSuppressionTime);

  void healthChanged();

  void hitbox(Rect out);

  void incrementDump(int prox);

  void items(@Nullable ItemModule items);

  void kill();

  void killed();

  void lastAccessed(String lastAccessed);

  void lastDisabler(@Nullable Building lastDisabler);

  void lastHealTime(float lastHealTime);

  void liquids(@Nullable LiquidModule liquids);

  void onRemoved();

  void payloadDraw();

  void payloadRotation(float payloadRotation);

  void power(@Nullable PowerModule power);

  void powerGraphRemoved();

  void produced(Item item);

  void produced(Item item, int amount);

  void proximity(Seq<Building> proximity);

  void read(Reads read, byte revision);

  void readAll(Reads read, byte revision);

  void readBase(Reads read);

  void recentlyHealed();

  void remove();

  void removeFromProximity();

  void rotation(int rotation);

  void tile(Tile tile);

  void transferLiquid(Building next, float amount, Liquid liquid);

  void update();

  void updateConsumption();

  void updatePayload(Unit unitHolder, Building buildingHolder);

  void updatePowerGraph();

  void updateProximity();

  void updateTile();

  void visualLiquid(float visualLiquid);

  void wasDamaged(boolean wasDamaged);

  void wasVisible(boolean wasVisible);

  void write(Writes write);

  void writeAll(Writes write);

  void writeBase(Writes write);
}
