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

import arc.func.Cons;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.math.geom.Position;
import arc.math.geom.QuadTree;
import arc.math.geom.Rect;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Table;
import arc.struct.Bits;
import arc.struct.Queue;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.nio.FloatBuffer;
import mindustry.ai.types.CommandAI;
import mindustry.annotations.Annotations;
import mindustry.async.PhysicsProcess;
import mindustry.ctype.Content;
import mindustry.entities.EntityCollisions;
import mindustry.entities.abilities.Ability;
import mindustry.entities.units.BuildPlan;
import mindustry.entities.units.UnitController;
import mindustry.entities.units.WeaponMount;
import mindustry.game.Team;
import mindustry.graphics.Trail;
import mindustry.logic.LAccess;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.storage.CoreBlock;

@SuppressWarnings("deprecation")
final class NullUnit extends Unit implements Unitc {
  @Override
  @Annotations.OverrideCallSuper
  public final <T extends Entityc> T self() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final <T> T as() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Building buildOn() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Player getPlayer() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Color statusColor() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final TextureRegion icon() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Vec2 vel() {
    return new Vec2();
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Bits statusBits() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Queue<BuildPlan> plans() {
    return new Queue<>(1);
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean acceptsItem(Item arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean activelyBuilding() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canBuild() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canDrown() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canLand() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canMine() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canMine(Item arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canPass(int arg0, int arg1) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canPassOn() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean canShoot() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean cheating() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean checkTarget(boolean arg0, boolean arg1) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean collides(Hitboxc arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean damaged() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean dead() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean disarmed() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean displayable() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean emitWalkSound() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean hasEffect(StatusEffect arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean hasItem() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean hasWeapons() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean hittable() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean hovering() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean inFogTo(Team arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean inRange(Position arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isAI() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isAdded() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isBoss() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isBuilding() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isCommandable() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isEnemy() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isFlying() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isGrounded() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isImmune(StatusEffect arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isLocal() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isNull() {
    return true;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isPlayer() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isRemote() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isRotate() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isShooting() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isSyncHidden(Player arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean isValid() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean mining() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean moving() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean offloadImmediately() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean onSolid() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean serialize() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean shouldSkip(BuildPlan arg0, Building arg1) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean spawnedByCore() {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean targetable(Team arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean updateBuilding() {
    return true;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean validMine(Tile arg0) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean validMine(Tile arg0, boolean arg1) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean within(Position arg0, float arg1) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final boolean within(float arg0, float arg1, float arg2) {
    return false;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final double flag() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final double sense(Content arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final double sense(LAccess arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float aimX() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float aimY() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float ammo() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float ammof() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float angleTo(Position arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float angleTo(float arg0, float arg1) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float armor() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float bounds() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float buildAlpha() {
    return 0.0F;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float buildSpeedMultiplier() {
    return 1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float clipSize() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float damageMultiplier() {
    return 1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float deltaAngle() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float deltaLen() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float deltaX() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float deltaY() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float drag() {
    return 0.0F;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float dragMultiplier() {
    return 1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float drownTime() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float dst(Position arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float dst(float arg0, float arg1) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float dst2(Position arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float dst2(float arg0, float arg1) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float elevation() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float floorSpeedMultiplier() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float getDuration(StatusEffect arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float getX() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float getY() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float healTime() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float health() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float healthMultiplier() {
    return 1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float healthf() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float hitSize() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float hitTime() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float itemTime() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float lastX() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float lastY() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float mass() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float maxHealth() {
    return 1.0F;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float mineTimer() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float physicSize() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float prefRotation() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float range() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float reloadMultiplier() {
    return 1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float rotation() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float shadowAlpha() {
    return -1.0F;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float shield() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float shieldAlpha() {
    return 0.0F;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float speed() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float speedMultiplier() {
    return 1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float splashTimer() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float x() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final float y() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int cap() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int classId() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int count() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int id() {
    return -1;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int itemCapacity() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int lastFogPos() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int maxAccepted(Item arg0) {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int pathType() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int tileX() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final int tileY() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Object senseObject(LAccess arg0) {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final String getControllerName() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final String lastCommanded() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final long lastUpdated() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final long updateSpacing() {
    return 0;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final CommandAI command() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final PhysicsProcess.PhysicRef physref() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final EntityCollisions.SolidPred solidity() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Ability[] abilities() {
    return new mindustry.entities.abilities.Ability[]{};
  }

  @Override
  @Annotations.OverrideCallSuper
  public final BuildPlan buildPlan() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final UnitController controller() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final WeaponMount[] mounts() {
    return new mindustry.entities.units.WeaponMount[]{};
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Team team() {
    return Team.derelict;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Trail trail() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Item getMineResult(Tile arg0) {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Item item() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final ItemStack stack() {
    return new ItemStack();
  }

  @Override
  @Annotations.OverrideCallSuper
  public final UnitType dockedType() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final UnitType type() {
    return UnitTypes.alpha;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Block blockOn() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Tile mineTile() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Tile tileOn() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Floor drownFloor() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Floor floorOn() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final Floor lastDrownFloor() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final CoreBlock.CoreBuild closestCore() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final CoreBlock.CoreBuild closestEnemyCore() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final CoreBlock.CoreBuild core() {
    return null;
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void abilities(Ability[] arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void add() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void addBuild(BuildPlan arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void addBuild(BuildPlan arg0, boolean arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void addItem(Item arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void addItem(Item arg0, int arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void afterRead() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void afterSync() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void aim(Position arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void aim(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void aimLook(Position arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void aimLook(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void aimX(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void aimY(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void ammo(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void apply(StatusEffect arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void apply(StatusEffect arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void approach(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void armor(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void buildAlpha(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void buildSpeedMultiplier(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void clampHealth() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void clearBuilding() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void clearItem() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void clearStatuses() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void collision(Hitboxc arg0, float arg1, float arg2) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void controlWeapons(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void controlWeapons(boolean arg0, boolean arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void controller(UnitController arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damage(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damage(float arg0, boolean arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damageContinuous(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damageContinuousPierce(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damageMultiplier(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damagePierce(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void damagePierce(float arg0, boolean arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void dead(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void deltaX(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void deltaY(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void destroy() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void disarmed(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void display(Table arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void dockedType(UnitType arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drag(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void dragMultiplier(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void draw() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drawBuildPlans() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drawBuilding() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drawBuildingBeam(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drawPlan(BuildPlan arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drawPlanTop(BuildPlan arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void drownTime(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void elevation(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void flag(double arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void getCollisions(Cons<QuadTree> arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void handleSyncHidden() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void heal() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void heal(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void healFract(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void healTime(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void health(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void healthMultiplier(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void hitSize(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void hitTime(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void hitbox(Rect arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void hitboxTile(Rect arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void hovering(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void id(int arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void impulse(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void impulse(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void impulseNet(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void interpolate() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void isShooting(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void itemTime(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void kill() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void killed() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void landed() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lastCommanded(String arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lastDrownFloor(Floor arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lastFogPos(int arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lastUpdated(long arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lastX(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lastY(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lookAt(Position arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lookAt(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void lookAt(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void maxHealth(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void mineTile(Tile arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void mineTimer(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void mounts(WeaponMount[] arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void move(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void move(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void moveAt(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void moveAt(Vec2 arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void movePref(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void physref(PhysicsProcess.PhysicRef arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void plans(Queue<BuildPlan> arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void read(Reads arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void readSync(Reads arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void readSyncManual(FloatBuffer arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void reloadMultiplier(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void remove() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void removeBuild(int arg0, int arg1, boolean arg2) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void resetController() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void rotateMove(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void rotation(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void set(Position arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void set(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void set(UnitType arg0, UnitController arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void setType(UnitType arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void setWeaponRotation(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void setupWeapons(UnitType arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void shadowAlpha(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void shield(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void shieldAlpha(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void snapInterpolation() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void snapSync() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void spawnedByCore(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void speedMultiplier(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void splashTimer(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void stack(ItemStack arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void team(Team arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void trail(Trail arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void trns(Position arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void trns(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void type(UnitType arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void unapply(StatusEffect arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void unloaded() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void update() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void updateBoosting(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void updateBuildLogic() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void updateBuilding(boolean arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void updateDrowning() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void updateLastPosition() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void updateSpacing(long arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void validatePlans() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void vel(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void velAddNet(Vec2 arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void velAddNet(float arg0, float arg1) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void wobble() {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void write(Writes arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void writeSync(Writes arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void writeSyncManual(FloatBuffer arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void x(float arg0) {
  }

  @Override
  @Annotations.OverrideCallSuper
  public final void y(float arg0) {
  }
}
