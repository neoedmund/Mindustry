package mindustry.gen;

import arc.*;
import arc.Graphics.*;
import arc.Graphics.Cursor.*;
import arc.audio.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.math.geom.QuadTree.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.struct.Queue;
import arc.util.*;
import arc.util.io.*;
import arc.util.noise.*;
import arc.util.pooling.*;
import java.nio.*;
import java.util.*;
import mindustry.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.annotations.Annotations.*;
import mindustry.async.PhysicsProcess.*;
import mindustry.audio.*;
import mindustry.content.*;
import mindustry.core.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.EntityCollisions.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import mindustry.game.Teams.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.input.*;
import mindustry.logic.*;
import mindustry.net.*;
import mindustry.net.Administration.*;
import mindustry.net.Packets.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.ConstructBlock.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.heat.HeatConductor.*;
import mindustry.world.blocks.logic.LogicBlock.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.storage.CoreBlock.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.modules.*;
import static mindustry.Vars.*;
import static mindustry.entities.Puddles.*;
import static mindustry.logic.GlobalVars.*;

import arc.math.geom.Vec2;
import arc.struct.Queue;
import arc.util.Nullable;
import mindustry.annotations.Annotations;
import mindustry.async.PhysicsProcess;
import mindustry.entities.abilities.Ability;
import mindustry.entities.units.BuildPlan;
import mindustry.entities.units.WeaponMount;
import mindustry.game.Team;
import mindustry.graphics.Trail;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

public abstract class Unit implements Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  public Ability[] abilities = {};

  public transient float aimX;

  public transient float aimY;

  public float ammo;

  public transient float armor;

  public transient float buildAlpha = 0.0F;

  public transient float buildSpeedMultiplier = 1;

  public transient float damageMultiplier = 1;

  public transient boolean dead;

  public transient float deltaX;

  public transient float deltaY;

  public transient boolean disarmed = false;

  @Nullable
  public transient UnitType dockedType;

  public transient float drag = 0.0F;

  public transient float dragMultiplier = 1;

  public transient float drownTime;

  @Annotations.SyncLocal
  public float elevation;

  public double flag;

  public transient float healTime;

  public float health;

  public transient float healthMultiplier = 1;

  public transient float hitSize;

  public transient float hitTime;

  public transient boolean hovering;

  public transient int id = EntityGroup.nextId();

  public boolean isShooting;

  public transient float itemTime;

  public transient String lastCommanded;

  @Nullable
  public transient Floor lastDrownFloor;

  public transient int lastFogPos;

  public transient long lastUpdated;

  public transient float lastX;

  public transient float lastY;

  public transient float maxHealth = 1.0F;

  @Nullable
  @Annotations.SyncLocal
  public Tile mineTile;

  public transient float mineTimer;

  @Annotations.SyncLocal
  public WeaponMount[] mounts = {};

  public transient PhysicsProcess.PhysicRef physref;

  @Annotations.SyncLocal
  public Queue<BuildPlan> plans = new Queue<>(1);

  public transient float reloadMultiplier = 1;

  @Annotations.SyncField(false)
  @Annotations.SyncLocal
  public float rotation;

  public transient float shadowAlpha = -1.0F;

  public float shield;

  public transient float shieldAlpha = 0.0F;

  public boolean spawnedByCore;

  public transient float speedMultiplier = 1;

  public transient float splashTimer;

  public ItemStack stack = new ItemStack();

  public Team team = Team.derelict;

  @Nullable
  public transient Trail trail;

  public UnitType type = UnitTypes.alpha;

  @Annotations.SyncLocal
  public boolean updateBuilding = true;

  public transient long updateSpacing;

  @Annotations.SyncLocal
  public Vec2 vel = new Vec2();

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float x;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float y;

  @Override
  public Vec2 vel() {
    return vel;
  }

  @Override
  public Queue<BuildPlan> plans() {
    return plans;
  }

  @Override
  public boolean dead() {
    return dead;
  }

  @Override
  public boolean disarmed() {
    return disarmed;
  }

  @Override
  public boolean hovering() {
    return hovering;
  }

  @Override
  public boolean isShooting() {
    return isShooting;
  }

  @Override
  public boolean spawnedByCore() {
    return spawnedByCore;
  }

  @Override
  public boolean updateBuilding() {
    return updateBuilding;
  }

  @Override
  public double flag() {
    return flag;
  }

  @Override
  public float aimX() {
    return aimX;
  }

  @Override
  public float aimY() {
    return aimY;
  }

  @Override
  public float ammo() {
    return ammo;
  }

  @Override
  public float armor() {
    return armor;
  }

  @Override
  public float buildAlpha() {
    return buildAlpha;
  }

  @Override
  public float buildSpeedMultiplier() {
    return buildSpeedMultiplier;
  }

  @Override
  public float damageMultiplier() {
    return damageMultiplier;
  }

  @Override
  public float deltaX() {
    return deltaX;
  }

  @Override
  public float deltaY() {
    return deltaY;
  }

  @Override
  public float drag() {
    return drag;
  }

  @Override
  public float dragMultiplier() {
    return dragMultiplier;
  }

  @Override
  public float drownTime() {
    return drownTime;
  }

  @Override
  public float elevation() {
    return elevation;
  }

  @Override
  public float healTime() {
    return healTime;
  }

  @Override
  public float health() {
    return health;
  }

  @Override
  public float healthMultiplier() {
    return healthMultiplier;
  }

  @Override
  public float hitTime() {
    return hitTime;
  }

  @Override
  public float itemTime() {
    return itemTime;
  }

  @Override
  public float lastX() {
    return lastX;
  }

  @Override
  public float lastY() {
    return lastY;
  }

  @Override
  public float maxHealth() {
    return maxHealth;
  }

  @Override
  public float mineTimer() {
    return mineTimer;
  }

  @Override
  public float reloadMultiplier() {
    return reloadMultiplier;
  }

  @Override
  public float rotation() {
    return rotation;
  }

  @Override
  public float shadowAlpha() {
    return shadowAlpha;
  }

  @Override
  public float shield() {
    return shield;
  }

  @Override
  public float shieldAlpha() {
    return shieldAlpha;
  }

  @Override
  public float speedMultiplier() {
    return speedMultiplier;
  }

  @Override
  public float splashTimer() {
    return splashTimer;
  }

  @Override
  public float x() {
    return x;
  }

  @Override
  public float y() {
    return y;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public int lastFogPos() {
    return lastFogPos;
  }

  @Override
  public String lastCommanded() {
    return lastCommanded;
  }

  @Override
  public long lastUpdated() {
    return lastUpdated;
  }

  @Override
  public long updateSpacing() {
    return updateSpacing;
  }

  @Override
  public PhysicsProcess.PhysicRef physref() {
    return physref;
  }

  @Override
  public Ability[] abilities() {
    return abilities;
  }

  @Override
  public WeaponMount[] mounts() {
    return mounts;
  }

  @Override
  public Team team() {
    return team;
  }

  @Override
  public Trail trail() {
    return trail;
  }

  @Override
  public ItemStack stack() {
    return stack;
  }

  @Override
  public UnitType dockedType() {
    return dockedType;
  }

  @Override
  public UnitType type() {
    return type;
  }

  @Override
  public Tile mineTile() {
    return mineTile;
  }

  @Override
  public Floor lastDrownFloor() {
    return lastDrownFloor;
  }

  @Override
  public void abilities(Ability[] abilities) {
    this.abilities = abilities;
  }

  @Override
  public void aimX(float aimX) {
    this.aimX = aimX;
  }

  @Override
  public void aimY(float aimY) {
    this.aimY = aimY;
  }

  @Override
  public void ammo(float ammo) {
    this.ammo = ammo;
  }

  @Override
  public void armor(float armor) {
    this.armor = armor;
  }

  @Override
  public void buildAlpha(float buildAlpha) {
    this.buildAlpha = buildAlpha;
  }

  @Override
  public void buildSpeedMultiplier(float buildSpeedMultiplier) {
    this.buildSpeedMultiplier = buildSpeedMultiplier;
  }

  @Override
  public void damageMultiplier(float damageMultiplier) {
    this.damageMultiplier = damageMultiplier;
  }

  @Override
  public void dead(boolean dead) {
    this.dead = dead;
  }

  @Override
  public void deltaX(float deltaX) {
    this.deltaX = deltaX;
  }

  @Override
  public void deltaY(float deltaY) {
    this.deltaY = deltaY;
  }

  @Override
  public void disarmed(boolean disarmed) {
    this.disarmed = disarmed;
  }

  @Override
  public void dockedType(UnitType dockedType) {
    this.dockedType = dockedType;
  }

  @Override
  public void drag(float drag) {
    this.drag = drag;
  }

  @Override
  public void dragMultiplier(float dragMultiplier) {
    this.dragMultiplier = dragMultiplier;
  }

  @Override
  public void drownTime(float drownTime) {
    this.drownTime = drownTime;
  }

  @Override
  public void elevation(float elevation) {
    this.elevation = elevation;
  }

  @Override
  public void flag(double flag) {
    this.flag = flag;
  }

  @Override
  public void healTime(float healTime) {
    this.healTime = healTime;
  }

  @Override
  public void health(float health) {
    this.health = health;
  }

  @Override
  public void healthMultiplier(float healthMultiplier) {
    this.healthMultiplier = healthMultiplier;
  }

  @Override
  public void hitSize(float hitSize) {
    this.hitSize = hitSize;
  }

  @Override
  public void hitTime(float hitTime) {
    this.hitTime = hitTime;
  }

  @Override
  public void hovering(boolean hovering) {
    this.hovering = hovering;
  }

  @Override
  public void id(int id) {
    this.id = id;
  }

  @Override
  public void isShooting(boolean isShooting) {
    this.isShooting = isShooting;
  }

  @Override
  public void itemTime(float itemTime) {
    this.itemTime = itemTime;
  }

  @Override
  public void lastCommanded(String lastCommanded) {
    this.lastCommanded = lastCommanded;
  }

  @Override
  public void lastDrownFloor(Floor lastDrownFloor) {
    this.lastDrownFloor = lastDrownFloor;
  }

  @Override
  public void lastFogPos(int lastFogPos) {
    this.lastFogPos = lastFogPos;
  }

  @Override
  public void lastUpdated(long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public void lastX(float lastX) {
    this.lastX = lastX;
  }

  @Override
  public void lastY(float lastY) {
    this.lastY = lastY;
  }

  @Override
  public void maxHealth(float maxHealth) {
    this.maxHealth = maxHealth;
  }

  @Override
  public void mineTile(Tile mineTile) {
    this.mineTile = mineTile;
  }

  @Override
  public void mineTimer(float mineTimer) {
    this.mineTimer = mineTimer;
  }

  @Override
  public void mounts(WeaponMount[] mounts) {
    this.mounts = mounts;
  }

  @Override
  public void physref(PhysicsProcess.PhysicRef physref) {
    this.physref = physref;
  }

  @Override
  public void plans(Queue<BuildPlan> plans) {
    this.plans = plans;
  }

  @Override
  public void reloadMultiplier(float reloadMultiplier) {
    this.reloadMultiplier = reloadMultiplier;
  }

  @Override
  public void rotation(float rotation) {
    this.rotation = rotation;
  }

  @Override
  public void shadowAlpha(float shadowAlpha) {
    this.shadowAlpha = shadowAlpha;
  }

  @Override
  public void shield(float shield) {
    this.shield = shield;
  }

  @Override
  public void shieldAlpha(float shieldAlpha) {
    this.shieldAlpha = shieldAlpha;
  }

  @Override
  public void spawnedByCore(boolean spawnedByCore) {
    this.spawnedByCore = spawnedByCore;
  }

  @Override
  public void speedMultiplier(float speedMultiplier) {
    this.speedMultiplier = speedMultiplier;
  }

  @Override
  public void splashTimer(float splashTimer) {
    this.splashTimer = splashTimer;
  }

  @Override
  public void stack(ItemStack stack) {
    this.stack = stack;
  }

  @Override
  public void team(Team team) {
    this.team = team;
  }

  @Override
  public void trail(Trail trail) {
    this.trail = trail;
  }

  @Override
  public void type(UnitType type) {
    this.type = type;
  }

  @Override
  public void updateBuilding(boolean updateBuilding) {
    this.updateBuilding = updateBuilding;
  }

  @Override
  public void updateSpacing(long updateSpacing) {
    this.updateSpacing = updateSpacing;
  }

  @Override
  public void vel(Vec2 vel) {
    this.vel = vel;
  }

  @Override
  public void x(float x) {
    this.x = x;
  }

  @Override
  public void y(float y) {
    this.y = y;
  }
}
