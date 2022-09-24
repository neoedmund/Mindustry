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
import arc.math.geom.Position;
import arc.math.geom.Rect;
import arc.util.io.Reads;
import arc.util.io.Writes;
import arc.util.pooling.Pool;
import mindustry.annotations.Annotations;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

@SuppressWarnings("deprecation")
public class Puddle implements Pool.Poolable, Drawc, Entityc, Posc, Puddlec {
  protected static Puddle paramPuddle;

  protected static final Rect rect = new Rect();

  protected static final Rect rect2 = new Rect();

  protected static Cons<Unit> unitCons = (unit)->{
      if (unit.isGrounded() && !unit.hovering) {
          unit.hitbox(rect2);
          if (rect.overlaps(rect2)) {
              unit.apply(paramPuddle.liquid.effect, 60 * 2);
              if (unit.vel.len2() > 0.1F * 0.1F) {
                  Fx.ripple.at(unit.x, unit.y, unit.type.rippleScale, paramPuddle.liquid.color);
              }
          }
      }
  };

  public transient float accepting;

  protected transient boolean added;

  public float amount;

  public transient float effectTime = Mathf.random(50.0F);

  public transient int id = EntityGroup.nextId();

  public transient float lastRipple = Time.time + Mathf.random(40.0F);

  public Liquid liquid;

  public Tile tile;

  public transient float updateTime;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float x;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float y;

  protected Puddle() {
  }

  @Override
  public float accepting() {
    return accepting;
  }

  @Override
  public float amount() {
    return amount;
  }

  @Override
  public float effectTime() {
    return effectTime;
  }

  @Override
  public float lastRipple() {
    return lastRipple;
  }

  @Override
  public float updateTime() {
    return updateTime;
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
    return 13;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public String toString() {
    return "Puddle#" + id;
  }

  @Override
  public Liquid liquid() {
    return liquid;
  }

  @Override
  public Tile tile() {
    return tile;
  }

  @Override
  public void accepting(float accepting) {
    this.accepting = accepting;
  }

  @Override
  public void amount(float amount) {
    this.amount = amount;
  }

  @Override
  public void effectTime(float effectTime) {
    this.effectTime = effectTime;
  }

  @Override
  public void id(int id) {
    this.id = id;
  }

  @Override
  public void lastRipple(float lastRipple) {
    this.lastRipple = lastRipple;
  }

  @Override
  public void liquid(Liquid liquid) {
    this.liquid = liquid;
  }

  @Override
  public void tile(Tile tile) {
    this.tile = tile;
  }

  @Override
  public void updateTime(float updateTime) {
    this.updateTime = updateTime;
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
      this.amount = read.f();
      read.i();
      this.liquid = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.liquid, read.s());
      this.tile = mindustry.io.TypeIO.readTile(read);
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 1) {
      this.amount = read.f();
      this.liquid = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.liquid, read.s());
      this.tile = mindustry.io.TypeIO.readTile(read);
      this.x = read.f();
      this.y = read.f();
    } else {
      throw new IllegalArgumentException("Unknown revision '" + REV + "' for entity type 'PuddleComp'");
    }
        afterRead();
  }

  @Annotations.CallSuper
  public void write(Writes write) {
    write.s(1);
    write.f(this.amount);
    write.s(this.liquid.id);
    mindustry.io.TypeIO.writeTile(write, this.tile);
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

  public boolean onSolid() {
        Tile tile = tileOn();
        return tile == null || tile.solid();
  }

  public boolean serialize() {
    return true;
  }

  public float clipSize() {
        return 20;
  }

  public float getFlammability() {
        return liquid.flammability * amount;
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

  public static Puddle create() {
    return Pools.obtain(Puddle.class, Puddle::new);
  }

  public void add() {
    if(added == true) return;
    Groups.all.add(this);
    Groups.draw.add(this);
    Groups.puddle.add(this);
        added = true;
  }

  public void afterRead() {
    puddle: {
        Puddles.register(this);
    }
  }

  public void draw() {
    puddle: {
        Draw.z(Layer.debris - 1);
        liquid.drawPuddle(this);
    }
  }

  public void remove() {
    if(added == false) return;
    Groups.all.remove(this);
    Groups.draw.remove(this);
    Groups.puddle.remove(this);
    entity: {
        added = false;
    }
    puddle: {
        Puddles.remove(tile);
    }
    mindustry.gen.Groups.queueFree((Pool.Poolable)this);
  }

  public void reset() {
    accepting = 0;
    added = false;
    amount = 0;
    effectTime = Mathf.random(50.0F);
    id = EntityGroup.nextId();
    lastRipple = Time.time + Mathf.random(40.0F);
    liquid = null;
    tile = null;
    updateTime = 0;
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

  public void trns(Position pos) {
        trns(pos.getX(), pos.getY());
  }

  public void trns(float x, float y) {
        set(this.x + x, this.y + y);
  }

  public void update() {
    puddle: {
        float addSpeed = accepting > 0 ? 3.0F : 0.0F;
        amount -= Time.delta * (1.0F - liquid.viscosity) / (5.0F + addSpeed);
        amount += accepting;
        accepting = 0.0F;
        if (amount >= maxLiquid / 1.5F) {
            float deposited = Math.min((amount - maxLiquid / 1.5F) / 4.0F, 0.3F * Time.delta);
            int targets = 0;
            for (Point2 point : Geometry.d4) {
                Tile other = world.tile(tile.x + point.x, tile.y + point.y);
                if (other != null && (other.block() == Blocks.air || liquid.moveThroughBlocks)) {
                    targets++;
                    Puddles.deposit(other, tile, liquid, deposited, false);
                }
            }
            amount -= deposited * targets;
        }
        if (liquid.capPuddles) {
            amount = Mathf.clamp(amount, 0, maxLiquid);
        }
        if (amount <= 0.0F) {
            remove();
            break puddle;
        }
        if (Puddles.get(tile) != this && added) {
            Groups.all.remove(this);
            Groups.draw.remove(this);
            Groups.puddle.remove(this);
            added = false;
            break puddle;
        }
        if (amount >= maxLiquid / 2.0F && updateTime <= 0.0F) {
            paramPuddle = this;
            Units.nearby(rect.setSize(Mathf.clamp(amount / (maxLiquid / 1.5F)) * 10.0F).setCenter(x, y), unitCons);
            if (liquid.temperature > 0.7F && tile.build != null && Mathf.chance(0.5)) {
                Fires.create(tile);
            }
            updateTime = 40.0F;
        }
        if (!headless && liquid.particleEffect != Fx.none) {
            if ((effectTime += Time.delta) >= liquid.particleSpacing) {
                float size = Mathf.clamp(amount / (maxLiquid / 1.5F)) * 4.0F;
                liquid.particleEffect.at(x + Mathf.range(size), y + Mathf.range(size));
                effectTime = 0.0F;
            }
        }
        updateTime -= Time.delta;
        liquid.update(this);
    }
  }
}
