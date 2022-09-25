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
import arc.struct.Seq;
import arc.util.Interval;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.annotations.Annotations;
import mindustry.game.Team;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.storage.CoreBlock;

@SuppressWarnings("deprecation")
public class LaunchPayload implements Drawc, Entityc, LaunchPayloadc, Posc, Teamc, Timedc {
  protected transient boolean added;

  public transient int id = EntityGroup.nextId();

  public transient Interval in = new Interval();

  public float lifetime;

  public Seq<ItemStack> stacks = new Seq<>();

  public Team team = Team.derelict;

  public float time;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float x;

  @Annotations.SyncField(true)
  @Annotations.SyncLocal
  public float y;

  protected LaunchPayload() {
  }

  @Override
  public Seq<ItemStack> stacks() {
    return stacks;
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
    return 15;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public String toString() {
    return "LaunchPayload#" + id;
  }

  @Override
  public Team team() {
    return team;
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
  public void stacks(Seq<ItemStack> stacks) {
    this.stacks = stacks;
  }

  @Override
  public void team(Team team) {
    this.team = team;
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

  @Annotations.CallSuper
  public void read(Reads read) {
    short REV = read.s();
    if(REV == 0) {
      this.lifetime = read.f();
      int stacks_LENGTH = read.i();
      this.stacks.clear();
      for(int INDEX = 0; INDEX < stacks_LENGTH; INDEX ++) {
        mindustry.type.ItemStack stacks_ITEM = mindustry.io.TypeIO.readItems(read);
        if(stacks_ITEM != null) this.stacks.add(stacks_ITEM);
      }
      this.team = mindustry.io.TypeIO.readTeam(read);
      this.time = read.f();
      this.x = read.f();
      this.y = read.f();
    } else {
      throw new IllegalArgumentException("Unknown revision '" + REV + "' for entity type 'LaunchPayloadComp'");
    }
        afterRead();
  }

  @Annotations.CallSuper
  public void write(Writes write) {
    write.s(0);
    write.f(this.lifetime);
    write.i(this.stacks.size);
    for(int INDEX = 0; INDEX < this.stacks.size; INDEX ++) {
      mindustry.io.TypeIO.writeItems(write, this.stacks.get(INDEX));
    }
    mindustry.io.TypeIO.writeTeam(write, this.team);
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

  public boolean cheating() {
        return team.rules().cheat;
  }

  public boolean inFogTo(Team viewer) {
        return this.team != viewer && !fogControl.isVisible(viewer, x, y);
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

  public CoreBlock.CoreBuild closestCore() {
        return state.teams.closestCore(x, y, team);
  }

  public CoreBlock.CoreBuild closestEnemyCore() {
        return state.teams.closestEnemyCore(x, y, team);
  }

  public CoreBlock.CoreBuild core() {
        return team.core();
  }

  public static LaunchPayload create() {
    return new LaunchPayload();
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
    launchpayload: {
        float alpha = fout(Interp.pow5Out);
        float scale = (1.0F - alpha) * 1.3F + 1.0F;
        float cx = cx();
        float cy = cy();
        float rotation = fin() * (130.0F + Mathf.randomSeedRange(id(), 50.0F));
        Draw.z(Layer.effect + 0.001F);
        Draw.color(Pal.engine);
        float rad = 0.2F + fslope();
        Fill.light(cx, cy, 10, 25.0F * (rad + scale - 1.0F), Tmp.c2.set(Pal.engine).a(alpha), Tmp.c1.set(Pal.engine).a(0.0F));
        Draw.alpha(alpha);
        for (int i = 0; i < 4; i++) {
            Drawf.tri(cx, cy, 6.0F, 40.0F * (rad + scale - 1.0F), i * 90.0F + rotation);
        }
        Draw.color();
        Draw.z(Layer.weather - 1);
        TextureRegion region = blockOn() instanceof mindustry.world.blocks.campaign.LaunchPad p ? p.podRegion : Core.atlas.find("launchpod");
        scale *= region.scl();
        float rw = region.width * scale;
        float rh = region.height * scale;
        Draw.alpha(alpha);
        Draw.rect(region, cx, cy, rw, rh, rotation);
        Tmp.v1.trns(225.0F, fin(Interp.pow3In) * 250.0F);
        Draw.z(Layer.flyingUnit + 1);
        Draw.color(0, 0, 0, 0.22F * alpha);
        Draw.rect(region, cx + Tmp.v1.x, cy + Tmp.v1.y, rw, rh, rotation);
        Draw.reset();
    }
  }

  public void remove() {
    if(added == false) return;
    Groups.all.remove(this);
    Groups.draw.remove(this);
    entity: {
        added = false;
    }
    launchpayload: {
        if (!state.isCampaign()) break launchpayload;
        Sector destsec = state.rules.sector.info.getRealDestination();
        if (team() == state.rules.defaultTeam) {
            if (destsec != null && (destsec != state.rules.sector || net.client())) {
                ItemSeq dest = new ItemSeq();
                for (ItemStack stack : stacks) {
                    dest.add(stack);
                    state.rules.sector.info.handleItemExport(stack);
                    Events.fire(new LaunchItemEvent(stack));
                }
                if (!net.client()) {
                    destsec.addItems(dest);
                }
            }
        }
    }
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
    launchpayload: {
        float r = 3.0F;
        if (in.get(4.0F - fin() * 2.0F)) {
            Fx.rocketSmoke.at(cx() + Mathf.range(r), cy() + Mathf.range(r), fin());
        }
    }
    timed: {
        time = Math.min(time + Time.delta, lifetime);
        if (time >= lifetime) {
            remove();
        }
    }
  }
}
