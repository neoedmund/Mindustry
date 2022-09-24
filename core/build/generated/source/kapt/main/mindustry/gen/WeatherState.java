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

import arc.math.Mathf;
import arc.math.geom.Position;
import arc.math.geom.Vec2;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import arc.util.pooling.Pool;
import java.nio.FloatBuffer;
import mindustry.annotations.Annotations;
import mindustry.type.Weather;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

@SuppressWarnings("deprecation")
public class WeatherState implements Pool.Poolable, Drawc, Entityc, Posc, Syncc, WeatherStatec {
  protected static final float fadeTime = 60 * 4;

  protected transient boolean added;

  public float effectTimer;

  public transient int id = EntityGroup.nextId();

  public float intensity = 1.0F;

  public transient long lastUpdated;

  public float life;

  public float opacity = 0.0F;

  public transient long updateSpacing;

  public Weather weather;

  public Vec2 windVector = new Vec2().setToRandomDirection();

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

  protected WeatherState() {
  }

  @Override
  public Vec2 windVector() {
    return windVector;
  }

  @Override
  public float effectTimer() {
    return effectTimer;
  }

  @Override
  public float intensity() {
    return intensity;
  }

  @Override
  public float life() {
    return life;
  }

  @Override
  public float opacity() {
    return opacity;
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
    return 14;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public String toString() {
    return "WeatherState#" + id;
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
  public Weather weather() {
    return weather;
  }

  @Override
  public void effectTimer(float effectTimer) {
    this.effectTimer = effectTimer;
  }

  @Override
  public void id(int id) {
    this.id = id;
  }

  @Override
  public void intensity(float intensity) {
    this.intensity = intensity;
  }

  @Override
  public void lastUpdated(long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public void life(float life) {
    this.life = life;
  }

  @Override
  public void opacity(float opacity) {
    this.opacity = opacity;
  }

  @Override
  public void updateSpacing(long updateSpacing) {
    this.updateSpacing = updateSpacing;
  }

  @Override
  public void weather(Weather weather) {
    this.weather = weather;
  }

  @Override
  public void windVector(Vec2 windVector) {
    this.windVector = windVector;
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
      this.intensity = read.f();
      this.life = read.f();
      this.opacity = read.f();
      this.weather = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.weather, read.s());
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 1) {
      this.effectTimer = read.f();
      this.intensity = read.f();
      this.life = read.f();
      this.opacity = read.f();
      this.weather = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.weather, read.s());
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 2) {
      this.effectTimer = read.f();
      this.intensity = read.f();
      this.life = read.f();
      this.opacity = read.f();
      this.weather = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.weather, read.s());
      this.windVector = mindustry.io.TypeIO.readVec2(read, this.windVector);
      this.x = read.f();
      this.y = read.f();
    } else {
      throw new IllegalArgumentException("Unknown revision '" + REV + "' for entity type 'WeatherStateComp'");
    }
        afterRead();
  }

  @Annotations.CallSuper
  public void write(Writes write) {
    write.s(2);
    write.f(this.effectTimer);
    write.f(this.intensity);
    write.f(this.life);
    write.f(this.opacity);
    write.s(this.weather.id);
    mindustry.io.TypeIO.writeVec2(write, this.windVector);
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
        return Float.MAX_VALUE;
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

  public static WeatherState create() {
    return Pools.obtain(WeatherState.class, WeatherState::new);
  }

  public void add() {
    if(added == true) return;
    Groups.all.add(this);
    Groups.sync.add(this);
    Groups.draw.add(this);
    Groups.weather.add(this);
        added = true;
  }

  public void afterRead() {
  }

  public void afterSync() {
  }

  public void draw() {
    weatherstate: {
        if (renderer.weatherAlpha > 1.0E-4F && renderer.drawWeather && Core.settings.getBool("showweather")) {
            Draw.draw(Layer.weather, ()->{
                Draw.alpha(renderer.weatherAlpha * opacity * weather.opacityMultiplier);
                weather.drawOver(this);
                Draw.reset();
            });
            Draw.draw(Layer.debris, ()->{
                Draw.alpha(renderer.weatherAlpha * opacity * weather.opacityMultiplier);
                weather.drawUnder(this);
                Draw.reset();
            });
        }
    }
  }

  public void handleSyncHidden() {
  }

  public void init(Weather weather) {
        this.weather = weather;
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
    this.effectTimer = read.f();
    this.intensity = read.f();
    this.life = read.f();
    this.opacity = read.f();
    this.weather = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.weather, read.s());
    this.windVector = mindustry.io.TypeIO.readVec2(read, this.windVector);
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
    Groups.weather.remove(this);
    entity: {
        added = false;
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
    effectTimer = 0;
    id = EntityGroup.nextId();
    intensity = 1.0F;
    lastUpdated = 0;
    life = 0;
    opacity = 0.0F;
    updateSpacing = 0;
    weather = null;
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
    sync: {
        if ((Vars.net.client() && !isLocal()) || isRemote()) {
            interpolate();
        }
    }
    weatherstate: {
        if (life < fadeTime) {
            opacity = Math.min(life / fadeTime, opacity);
        } else {
            opacity = Mathf.lerpDelta(opacity, 1.0F, 0.004F);
        }
        life -= Time.delta;
        weather.update(this);
        weather.updateEffect(this);
        if (life < 0) {
            remove();
        }
    }
  }

  public void writeSync(Writes write) {
    write.f(this.effectTimer);
    write.f(this.intensity);
    write.f(this.life);
    write.f(this.opacity);
    write.s(this.weather.id);
    mindustry.io.TypeIO.writeVec2(write, this.windVector);
    write.f(this.x);
    write.f(this.y);
  }

  public void writeSyncManual(FloatBuffer buffer) {
    buffer.put(this.x);
    buffer.put(this.y);
  }
}
