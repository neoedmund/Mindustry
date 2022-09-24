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
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import java.nio.FloatBuffer;
import mindustry.annotations.Annotations;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

@SuppressWarnings("deprecation")
public class WorldLabel implements Drawc, Entityc, Posc, Syncc, WorldLabelc {
  public static final byte flagBackground = 1;

  public static final byte flagOutline = 2;

  protected transient boolean added;

  public byte flags = flagBackground | flagOutline;

  public float fontSize = 1.0F;

  public transient int id = EntityGroup.nextId();

  public transient long lastUpdated;

  public String text = "sample text";

  public transient long updateSpacing;

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

  public float z = Layer.playerName + 1;

  protected WorldLabel() {
  }

  @Override
  public byte flags() {
    return flags;
  }

  @Override
  public float fontSize() {
    return fontSize;
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
  public float z() {
    return z;
  }

  @Override
  public int classId() {
    return 35;
  }

  @Override
  public int id() {
    return id;
  }

  @Override
  public String text() {
    return text;
  }

  @Override
  public String toString() {
    return "WorldLabel#" + id;
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
  public void flags(byte flags) {
    this.flags = flags;
  }

  @Override
  public void fontSize(float fontSize) {
    this.fontSize = fontSize;
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
  public void text(String text) {
    this.text = text;
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

  @Override
  public void z(float z) {
    this.z = z;
  }

  @Annotations.CallSuper
  public void read(Reads read) {
    short REV = read.s();
    if(REV == 0) {
      this.flags = read.b();
      this.fontSize = read.f();
      this.text = mindustry.io.TypeIO.readString(read);
      this.x = read.f();
      this.y = read.f();
      this.z = read.f();
    } else {
      throw new IllegalArgumentException("Unknown revision '" + REV + "' for entity type 'WorldLabelComp'");
    }
        afterRead();
  }

  @Annotations.CallSuper
  public void write(Writes write) {
    write.s(0);
    write.b(this.flags);
    write.f(this.fontSize);
    mindustry.io.TypeIO.writeString(write, this.text);
    write.f(this.x);
    write.f(this.y);
    write.f(this.z);
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
    return false;
  }

  public float clipSize() {
        return text.length() * 10.0F * fontSize;
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

  public static WorldLabel create() {
    return new WorldLabel();
  }

  public static void drawAt(String text, float x, float y, float layer, int flags, float fontSize) {
        Draw.z(layer);
        float z = Drawf.text();
        Font font = (flags & flagOutline) != 0 ? Fonts.outline : Fonts.def;
        GlyphLayout layout = Pools.obtain(GlyphLayout.class, GlyphLayout::new);
        boolean ints = font.usesIntegerPositions();
        font.setUseIntegerPositions(false);
        font.getData().setScale(0.25F / Scl.scl(1.0F) * fontSize);
        layout.setText(font, text);
        if ((flags & flagBackground) != 0) {
            Draw.color(0.0F, 0.0F, 0.0F, 0.3F);
            Fill.rect(x, y - layout.height / 2, layout.width + 2, layout.height + 3);
            Draw.color();
        }
        font.setColor(Color.white);
        font.draw(text, x, y, 0, Align.center, false);
        Draw.reset();
        Pools.free(layout);
        font.getData().setScale(1.0F);
        font.setColor(Color.white);
        font.setUseIntegerPositions(ints);
        Draw.z(z);
  }

  public void add() {
    if(added == true) return;
    Groups.all.add(this);
    Groups.sync.add(this);
    Groups.draw.add(this);
    Groups.label.add(this);
        added = true;
  }

  public void afterRead() {
  }

  public void afterSync() {
  }

  public void draw() {
    worldlabel: {
        drawAt(text, x, y, z, flags, fontSize);
    }
  }

  public void handleSyncHidden() {
  }

  public void hide() {
        remove();
        Call.removeWorldLabel(id);
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
    this.flags = read.b();
    this.fontSize = read.f();
    this.text = mindustry.io.TypeIO.readString(read);
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
    this.z = read.f();
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
    Groups.label.remove(this);
    entity: {
        added = false;
    }
    sync: {
        if (Vars.net.client()) {
            Vars.netClient.addRemovedEntity(id());
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
  }

  public void writeSync(Writes write) {
    write.b(this.flags);
    write.f(this.fontSize);
    mindustry.io.TypeIO.writeString(write, this.text);
    write.f(this.x);
    write.f(this.y);
    write.f(this.z);
  }

  public void writeSyncManual(FloatBuffer buffer) {
    buffer.put(this.x);
    buffer.put(this.y);
  }
}
