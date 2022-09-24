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

import arc.math.geom.Position;
import arc.util.Interval;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.annotations.Annotations;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

@SuppressWarnings("deprecation")
public class LaunchCore implements Drawc, Entityc, LaunchCorec, Posc, Timedc {
  protected transient boolean added;

  public Block block;

  public transient int id = EntityGroup.nextId();

  public transient Interval in = new Interval();

  public float lifetime;

  public float time;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float x;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float y;

  protected LaunchCore() {
  }

  @Override
  public Interval in() {
    return in;
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
    return 11;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public String toString() {
    return "LaunchCore#" + id;
  }

  @Override
  public Block block() {
    return block;
  }

  @Override
  public void block(Block block) {
    this.block = block;
  }

  @Override
  public void id(int id) {
    this.id = id;
  }

  @Override
  public void in(Interval in) {
    this.in = in;
  }

  @Override
  public void lifetime(float lifetime) {
    this.lifetime = lifetime;
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
        return Float.MAX_VALUE;
  }

  public float cx() {
        return x + fin(Interp.pow2In) * (12.0F + Mathf.randomSeedRange(id() + 3, 4.0F));
  }

  public float cy() {
        return y + fin(Interp.pow5In) * (100.0F + Mathf.randomSeedRange(id() + 2, 30.0F));
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

  public static LaunchCore create() {
    return new LaunchCore();
  }

  public void add() {
    if(added == true) return;
    Groups.all.add(this);
    Groups.draw.add(this);
        added = true;
  }

  public void afterRead() {
  }

  public void draw() {
    launchcore: {
        float alpha = fout(Interp.pow5Out);
        float scale = (1.0F - alpha) * 1.4F + 1.0F;
        float cx = cx();
        float cy = cy();
        float rotation = fin() * (140.0F + Mathf.randomSeedRange(id(), 50.0F));
        Draw.z(Layer.effect + 0.001F);
        Draw.color(Pal.engine);
        float rad = 0.2F + fslope();
        float rscl = (block.size - 1) * 0.85F;
        Fill.light(cx, cy, 10, 25.0F * (rad + scale - 1.0F) * rscl, Tmp.c2.set(Pal.engine).a(alpha), Tmp.c1.set(Pal.engine).a(0.0F));
        Draw.alpha(alpha);
        for (int i = 0; i < 4; i++) {
            Drawf.tri(cx, cy, 6.0F * rscl, 40.0F * (rad + scale - 1.0F) * rscl, i * 90.0F + rotation);
        }
        Draw.color();
        Draw.z(Layer.weather - 1);
        TextureRegion region = block.fullIcon;
        float rw = region.width * Draw.scl * scale;
        float rh = region.height * Draw.scl * scale;
        Draw.alpha(alpha);
        Draw.rect(region, cx, cy, rw, rh, rotation - 45);
        Tmp.v1.trns(225.0F, fin(Interp.pow3In) * 250.0F);
        Draw.z(Layer.flyingUnit + 1);
        Draw.color(0, 0, 0, 0.22F * alpha);
        Draw.rect(region, cx + Tmp.v1.x, cy + Tmp.v1.y, rw, rh, rotation - 45);
        Draw.reset();
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
    launchcore: {
        float r = 4.0F;
        if (in.get(3.0F - fin() * 2.0F)) {
            Fx.rocketSmokeLarge.at(cx() + Mathf.range(r), cy() + Mathf.range(r), fin());
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
