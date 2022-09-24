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

import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.math.geom.Position;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import arc.util.pooling.Pool;
import java.nio.FloatBuffer;
import mindustry.annotations.Annotations;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

@SuppressWarnings("deprecation")
public class Fire implements Pool.Poolable, Drawc, Entityc, Firec, Posc, Syncc, Timedc {
  protected static final float damageDelay = 40.0F;

  public static final int duration = 90;

  protected static final float fireballDelay = 40.0F;

  public static final int frames = 40;

  public static final TextureRegion[] regions = new TextureRegion[frames];

  protected static final float spreadDelay = 22.0F;

  protected static final float ticksPerFrame = (float)duration / frames;

  protected static final float tileDamage = 1.8F;

  protected static final float unitDamage = 3.0F;

  protected static final float warmupDuration = 20.0F;

  protected transient boolean added;

  protected transient float animation = Mathf.random(frames - 1);

  protected transient float baseFlammability = -1;

  protected transient Block block;

  protected transient float damageTimer = Mathf.random(40.0F);

  protected transient float fireballTimer = Mathf.random(fireballDelay);

  public transient int id = EntityGroup.nextId();

  public transient long lastUpdated;

  public float lifetime;

  protected transient float puddleFlammability;

  protected transient float spreadTimer = Mathf.random(spreadDelay);

  public Tile tile;

  public float time;

  public transient long updateSpacing;

  protected transient float warmup = 0.0F;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float x;

  private transient float x_LAST_;

  private transient float x_TARGET_;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float y;

  private transient float y_LAST_;

  private transient float y_TARGET_;

  protected Fire() {
  }

  @Override
  public float lifetime() {
    return lifetime;
  }

  @Override
  public float time() {
    return time;
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
  public int classId() {
    return 10;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public String toString() {
    return "Fire#" + id;
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
  public Tile tile() {
    return tile;
  }

  @Override
  public void id(int id) {
    this.id = id;
  }

  @Override
  public void lastUpdated(long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public void lifetime(float lifetime) {
    this.lifetime = lifetime;
  }

  @Override
  public void tile(Tile tile) {
    this.tile = tile;
  }

  @Override
  public void time(float time) {
    this.time = time;
  }

  @Override
  public void updateSpacing(long updateSpacing) {
    this.updateSpacing = updateSpacing;
  }

  @Override
  public void x(float x) {
    this.x = x;
  }

  @Override
  public void y(float y) {
    this.y = y;
  }

  @Annotations.CallSuper
  public void read(Reads read) {
    short REV = read.s();
    if(REV == 0) {
      read.f();
      mindustry.Vars.content.getByID(mindustry.ctype.ContentType.block, read.s());
      this.lifetime = read.f();
      read.f();
      this.tile = mindustry.io.TypeIO.readTile(read);
      this.time = read.f();
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 1) {
      this.lifetime = read.f();
      this.tile = mindustry.io.TypeIO.readTile(read);
      this.time = read.f();
      this.x = read.f();
      this.y = read.f();
    } else {
      throw new IllegalArgumentException("Unknown revision '" + REV + "' for entity type 'FireComp'");
    }
        afterRead();
  }

  @Annotations.CallSuper
  public void write(Writes write) {
    write.s(1);
    write.f(this.lifetime);
    mindustry.io.TypeIO.writeTile(write, this.tile);
    write.f(this.time);
    write.f(this.x);
    write.f(this.y);
  }

  public <T extends Entityc> T self() {
        return (T)this;
  }

  public <T> T as() {
        return (T)this;
  }

  public Building buildOn() {
        return world.buildWorld(x, y);
  }

  public boolean isAdded() {
        return added;
  }

  public boolean isLocal() {
        return ((Object)this) == player || ((Object)this) instanceof Unitc u && u.controller() == player;
  }

  public boolean isNull() {
        return false;
  }

  public boolean isRemote() {
        return ((Object)this) instanceof Unitc u && u.isPlayer() && !isLocal();
  }

  public boolean isSyncHidden(Player player) {
        return false;
  }

  public boolean onSolid() {
        Tile tile = tileOn();
        return tile == null || tile.solid();
  }

  public boolean serialize() {
    return true;
  }

  public float clipSize() {
        return 25;
  }

  public float fin() {
        return time / lifetime;
  }

  public float getX() {
        return x;
  }

  public float getY() {
        return y;
  }

  public int tileX() {
        return World.toTile(x);
  }

  public int tileY() {
        return World.toTile(y);
  }

  public Block blockOn() {
        Tile tile = tileOn();
        return tile == null ? Blocks.air : tile.block();
  }

  public Tile tileOn() {
        return world.tileWorld(x, y);
  }

  public Floor floorOn() {
        Tile tile = tileOn();
        return tile == null || tile.block() != Blocks.air ? (Floor)Blocks.air : tile.floor();
  }

  public static Fire create() {
    return Pools.obtain(Fire.class, Fire::new);
  }

  public void add() {
    if(added == true) return;
    Groups.all.add(this);
    Groups.sync.add(this);
    Groups.draw.add(this);
    Groups.fire.add(this);
        added = true;
  }

  public void afterRead() {
    fire: {
        Fires.register(this);
    }
  }

  public void afterSync() {
    fire: {
        Fires.register(this);
    }
  }

  public void draw() {
    fire: {
        if (regions[0] == null) {
            for (int i = 0; i < frames; i++) {
                regions[i] = Core.atlas.find("fire" + i);
            }
        }
        Draw.color(1.0F, 1.0F, 1.0F, Mathf.clamp(warmup / warmupDuration));
        Draw.z(Layer.effect);
        Draw.rect(regions[Math.min((int)animation, regions.length - 1)], x + Mathf.randomSeedRange((int)y, 2), y + Mathf.randomSeedRange((int)x, 2));
        Draw.reset();
        Drawf.light(x, y, 50.0F + Mathf.absin(5.0F, 5.0F), Pal.lightFlame, 0.6F * Mathf.clamp(warmup / warmupDuration));
    }
  }

  public void handleSyncHidden() {
  }

  public void interpolate() {
    if(lastUpdated != 0 && updateSpacing != 0) {
      float timeSinceUpdate = Time.timeSinceMillis(lastUpdated);
      float alpha = Math.min(timeSinceUpdate / updateSpacing, 2f);
      x = (Mathf.lerp(x_LAST_, x_TARGET_, alpha));
      y = (Mathf.lerp(y_LAST_, y_TARGET_, alpha));
    } else if(lastUpdated != 0) {
      x = x_TARGET_;
      y = y_TARGET_;
    }
  }

  public void readSync(Reads read) {
    if(lastUpdated != 0) updateSpacing = Time.timeSinceMillis(lastUpdated);
    lastUpdated = Time.millis();
    boolean islocal = isLocal();
    this.lifetime = read.f();
    this.tile = mindustry.io.TypeIO.readTile(read);
    this.time = read.f();
    if(!islocal) {
      x_LAST_ = this.x;
      this.x_TARGET_ = read.f();
    } else {
      read.f();
      x_LAST_ = this.x;
      x_TARGET_ = this.x;
    }
    if(!islocal) {
      y_LAST_ = this.y;
      this.y_TARGET_ = read.f();
    } else {
      read.f();
      y_LAST_ = this.y;
      y_TARGET_ = this.y;
    }
    afterSync();
  }

  public void readSyncManual(FloatBuffer buffer) {
    if(lastUpdated != 0) updateSpacing = Time.timeSinceMillis(lastUpdated);
    lastUpdated = Time.millis();
    this.x_LAST_ = this.x;
    this.x_TARGET_ = buffer.get();
    this.y_LAST_ = this.y;
    this.y_TARGET_ = buffer.get();
  }

  public void remove() {
    if(added == false) return;
    Groups.all.remove(this);
    Groups.sync.remove(this);
    Groups.draw.remove(this);
    Groups.fire.remove(this);
    entity: {
        added = false;
    }
    fire: {
        Fx.fireRemove.at(x, y, animation);
        Fires.remove(tile);
    }
    sync: {
        if (Vars.net.client()) {
            Vars.netClient.addRemovedEntity(id());
        }
    }
    mindustry.gen.Groups.queueFree((Pool.Poolable)this);
  }

  public void reset() {
    added = false;
    animation = Mathf.random(frames - 1);
    baseFlammability = -1;
    block = null;
    damageTimer = Mathf.random(40.0F);
    fireballTimer = Mathf.random(fireballDelay);
    id = EntityGroup.nextId();
    lastUpdated = 0;
    lifetime = 0;
    puddleFlammability = 0;
    spreadTimer = Mathf.random(spreadDelay);
    tile = null;
    time = 0;
    updateSpacing = 0;
    warmup = 0.0F;
    x = 0;
    y = 0;
  }

  public void set(Position pos) {
        set(pos.getX(), pos.getY());
  }

  public void set(float x, float y) {
        this.x = x;
        this.y = y;
  }

  public void snapInterpolation() {
    updateSpacing = 16;
    lastUpdated = Time.millis();
    x_LAST_ = x;
    x_TARGET_ = x;
    y_LAST_ = y;
    y_TARGET_ = y;
  }

  public void snapSync() {
    updateSpacing = 16;
    lastUpdated = Time.millis();
    x_LAST_ = x_TARGET_;
    x = x_TARGET_;
    y_LAST_ = y_TARGET_;
    y = y_TARGET_;
  }

  public void trns(Position pos) {
        trns(pos.getX(), pos.getY());
  }

  public void trns(float x, float y) {
        set(this.x + x, this.y + y);
  }

  public void update() {
    fire: {
        animation += Time.delta / ticksPerFrame;
        warmup += Time.delta;
        animation %= frames;
        if (!headless) {
            control.sound.loop(Sounds.fire, this, 0.07F);
        }
        float speedMultiplier = 1.0F + Math.max(state.envAttrs.get(Attribute.water) * 10.0F, 0);
        time = Mathf.clamp(time + Time.delta * speedMultiplier, 0, lifetime);
        if (Vars.net.client()) {
            break fire;
        }
        if (time >= lifetime || tile == null || Float.isNaN(lifetime)) {
            remove();
            break fire;
        }
        Building entity = tile.build;
        boolean damage = entity != null;
        if (baseFlammability < 0 || block != tile.block()) {
            baseFlammability = tile.getFlammability();
            block = tile.block();
        }
        float flammability = baseFlammability + puddleFlammability;
        if (!damage && flammability <= 0) {
            time += Time.delta * 8;
        }
        if (damage) {
            lifetime += Mathf.clamp(flammability / 8.0F, 0.0F, 0.6F) * Time.delta;
        }
        if (flammability > 1.0F && (spreadTimer += Time.delta * Mathf.clamp(flammability / 5.0F, 0.3F, 2.0F)) >= spreadDelay) {
            spreadTimer = 0.0F;
            Point2 p = Geometry.d4[Mathf.random(3)];
            Tile other = world.tile(tile.x + p.x, tile.y + p.y);
            Fires.create(other);
        }
        if (flammability > 0 && (fireballTimer += Time.delta * Mathf.clamp(flammability / 10.0F, 0.0F, 0.5F)) >= fireballDelay) {
            fireballTimer = 0.0F;
            Bullets.fireball.createNet(Team.derelict, x, y, Mathf.random(360.0F), -1.0F, 1, 1);
        }
        if ((damageTimer += Time.delta) >= damageDelay) {
            damageTimer = 0.0F;
            Puddlec p = Puddles.get(tile);
            puddleFlammability = p != null ? p.getFlammability() / 3.0F : 0;
            if (damage) {
                entity.damage(tileDamage);
            }
            Damage.damageUnits(null, tile.worldx(), tile.worldy(), tilesize, unitDamage, (unit)->!unit.isFlying() && !unit.isImmune(StatusEffects.burning), (unit)->unit.apply(StatusEffects.burning, 60 * 5));
        }
    }
    sync: {
        if ((Vars.net.client() && !isLocal()) || isRemote()) {
            interpolate();
        }
    }
    timed: {
        time = Math.min(time + Time.delta, lifetime);
        if (time >= lifetime) {
            remove();
        }
    }
  }

  public void writeSync(Writes write) {
    write.f(this.lifetime);
    mindustry.io.TypeIO.writeTile(write, this.tile);
    write.f(this.time);
    write.f(this.x);
    write.f(this.y);
  }

  public void writeSyncManual(FloatBuffer buffer) {
    buffer.put(this.x);
    buffer.put(this.y);
  }
}
