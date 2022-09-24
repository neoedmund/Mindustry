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

import arc.graphics.Color;
import arc.math.geom.Position;
import arc.util.Nullable;
import arc.util.io.Reads;
import arc.util.io.Writes;
import arc.util.pooling.Pool;
import mindustry.annotations.Annotations;
import mindustry.entities.Effect;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

@SuppressWarnings("deprecation")
public class EffectState implements Pool.Poolable, Childc, Drawc, EffectStatec, Entityc, Posc, Rotc, Timedc {
  protected transient boolean added;

  public Color color = new Color(Color.white);

  public Object data;

  public Effect effect;

  public transient int id = EntityGroup.nextId();

  public float lifetime;

  public float offsetPos;

  public float offsetRot;

  public float offsetX;

  public float offsetY;

  @Nullable
  public Posc parent;

  public boolean rotWithParent;

  @Annotations.SyncField(false)
  @Annotations.SyncLocal
  public float rotation;

  public float time;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float x;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float y;

  protected EffectState() {
  }

  @Override
  public Color color() {
    return color;
  }

  @Override
  public boolean rotWithParent() {
    return rotWithParent;
  }

  @Override
  public float lifetime() {
    return lifetime;
  }

  @Override
  public float offsetPos() {
    return offsetPos;
  }

  @Override
  public float offsetRot() {
    return offsetRot;
  }

  @Override
  public float offsetX() {
    return offsetX;
  }

  @Override
  public float offsetY() {
    return offsetY;
  }

  @Override
  public float rotation() {
    return rotation;
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
    return 9;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public Object data() {
    return data;
  }

  @Override
  public String toString() {
    return "EffectState#" + id;
  }

  @Override
  public Effect effect() {
    return effect;
  }

  @Override
  public Posc parent() {
    return parent;
  }

  @Override
  public void color(Color color) {
    this.color = color;
  }

  @Override
  public void data(Object data) {
    this.data = data;
  }

  @Override
  public void effect(Effect effect) {
    this.effect = effect;
  }

  @Override
  public void id(int id) {
    this.id = id;
  }

  @Override
  public void lifetime(float lifetime) {
    this.lifetime = lifetime;
  }

  @Override
  public void offsetPos(float offsetPos) {
    this.offsetPos = offsetPos;
  }

  @Override
  public void offsetRot(float offsetRot) {
    this.offsetRot = offsetRot;
  }

  @Override
  public void offsetX(float offsetX) {
    this.offsetX = offsetX;
  }

  @Override
  public void offsetY(float offsetY) {
    this.offsetY = offsetY;
  }

  @Override
  public void parent(Posc parent) {
    this.parent = parent;
  }

  @Override
  public void rotWithParent(boolean rotWithParent) {
    this.rotWithParent = rotWithParent;
  }

  @Override
  public void rotation(float rotation) {
    this.rotation = rotation;
  }

  @Override
  public void time(float time) {
    this.time = time;
  }

  @Override
  public void x(float x) {
    this.x = x;
  }

  @Override
  public void y(float y) {
    this.y = y;
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
    return false;
  }

  public float clipSize() {
        return effect.clip;
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

  public static EffectState create() {
    return Pools.obtain(EffectState.class, EffectState::new);
  }

  public void add() {
    if(added == true) return;
    Groups.all.add(this);
    Groups.draw.add(this);
    child: {
        if (parent != null) {
            offsetX = x - parent.getX();
            offsetY = y - parent.getY();
            if (rotWithParent && parent instanceof Rotc r) {
                offsetPos = -r.rotation();
                offsetRot = rotation - r.rotation();
            }
        }
    }
    entity: {
        added = true;
    }
  }

  public void afterRead() {
  }

  public void draw() {
    effectstate: {
        lifetime = effect.render(id, color, time, lifetime, rotation, x, y, data);
    }
  }

  public void read(Reads read) {
        afterRead();
  }

  public void remove() {
    if(added == false) return;
    Groups.all.remove(this);
    Groups.draw.remove(this);
        added = false;
    mindustry.gen.Groups.queueFree((Pool.Poolable)this);
  }

  public void reset() {
    added = false;
    data = null;
    effect = null;
    id = EntityGroup.nextId();
    lifetime = 0;
    offsetPos = 0;
    offsetRot = 0;
    offsetX = 0;
    offsetY = 0;
    parent = null;
    rotWithParent = false;
    rotation = 0;
    time = 0;
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
    child: {
        if (parent != null) {
            if (rotWithParent && parent instanceof Rotc r) {
                x = parent.getX() + Angles.trnsx(r.rotation() + offsetPos, offsetX, offsetY);
                y = parent.getY() + Angles.trnsy(r.rotation() + offsetPos, offsetX, offsetY);
                rotation = r.rotation() + offsetRot;
            } else {
                x = parent.getX() + offsetX;
                y = parent.getY() + offsetY;
            }
        }
    }
    timed: {
        time = Math.min(time + Time.delta, lifetime);
        if (time >= lifetime) {
            remove();
        }
    }
  }

  public void write(Writes write) {
  }
}
