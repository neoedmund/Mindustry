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

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.annotations.Annotations;

@SuppressWarnings("deprecation")
public class LegsUnitLegacyToxopid extends LegsUnit implements Boundedc, Builderc, Drawc, Entityc, Flyingc, Healthc, Hitboxc, Itemsc, Legsc, Minerc, Physicsc, Posc, Rotc, Shieldc, Statusc, Syncc, Teamc, Unitc, Velc, Weaponsc {
  protected LegsUnitLegacyToxopid() {
  }

  @Override
  public int classId() {
    return 33;
  }

  @Override
  public String toString() {
    return "LegsUnitLegacyToxopid#" + id;
  }

  @Annotations.CallSuper
  public void read(Reads read) {
    short REV = read.s();
    if(REV == 0) {
      this.ammo = read.f();
      read.f();
      this.controller = mindustry.io.TypeIO.readController(read, this.controller);
      this.elevation = read.f();
      this.flag = read.d();
      this.health = read.f();
      this.isShooting = read.bool();
      this.mineTile = mindustry.io.TypeIO.readTile(read);
      this.mounts = mindustry.io.TypeIO.readMounts(read, this.mounts);
      this.plans = mindustry.io.TypeIO.readPlansQueue(read);
      this.rotation = read.f();
      this.shield = read.f();
      this.spawnedByCore = read.bool();
      this.stack = mindustry.io.TypeIO.readItems(read, this.stack);
      int statuses_LENGTH = read.i();
      this.statuses.clear();
      for(int INDEX = 0; INDEX < statuses_LENGTH; INDEX ++) {
        mindustry.entities.units.StatusEntry statuses_ITEM = mindustry.io.TypeIO.readStatus(read);
        if(statuses_ITEM != null) this.statuses.add(statuses_ITEM);
      }
      this.team = mindustry.io.TypeIO.readTeam(read);
      this.type = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.unit, read.s());
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 1) {
      this.ammo = read.f();
      read.f();
      this.controller = mindustry.io.TypeIO.readController(read, this.controller);
      this.elevation = read.f();
      this.flag = read.d();
      this.health = read.f();
      this.isShooting = read.bool();
      this.mineTile = mindustry.io.TypeIO.readTile(read);
      this.mounts = mindustry.io.TypeIO.readMounts(read, this.mounts);
      this.plans = mindustry.io.TypeIO.readPlansQueue(read);
      this.rotation = read.f();
      this.shield = read.f();
      this.spawnedByCore = read.bool();
      this.stack = mindustry.io.TypeIO.readItems(read, this.stack);
      int statuses_LENGTH = read.i();
      this.statuses.clear();
      for(int INDEX = 0; INDEX < statuses_LENGTH; INDEX ++) {
        mindustry.entities.units.StatusEntry statuses_ITEM = mindustry.io.TypeIO.readStatus(read);
        if(statuses_ITEM != null) this.statuses.add(statuses_ITEM);
      }
      this.team = mindustry.io.TypeIO.readTeam(read);
      this.type = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.unit, read.s());
      this.updateBuilding = read.bool();
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 2) {
      this.ammo = read.f();
      this.controller = mindustry.io.TypeIO.readController(read, this.controller);
      this.elevation = read.f();
      this.flag = read.d();
      this.health = read.f();
      this.isShooting = read.bool();
      this.mineTile = mindustry.io.TypeIO.readTile(read);
      this.mounts = mindustry.io.TypeIO.readMounts(read, this.mounts);
      this.plans = mindustry.io.TypeIO.readPlansQueue(read);
      this.rotation = read.f();
      this.shield = read.f();
      this.spawnedByCore = read.bool();
      this.stack = mindustry.io.TypeIO.readItems(read, this.stack);
      int statuses_LENGTH = read.i();
      this.statuses.clear();
      for(int INDEX = 0; INDEX < statuses_LENGTH; INDEX ++) {
        mindustry.entities.units.StatusEntry statuses_ITEM = mindustry.io.TypeIO.readStatus(read);
        if(statuses_ITEM != null) this.statuses.add(statuses_ITEM);
      }
      this.team = mindustry.io.TypeIO.readTeam(read);
      this.type = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.unit, read.s());
      this.updateBuilding = read.bool();
      this.vel = mindustry.io.TypeIO.readVec2(read, this.vel);
      this.x = read.f();
      this.y = read.f();
    } else if(REV == 3) {
      this.abilities = mindustry.io.TypeIO.readAbilities(read, this.abilities);
      this.ammo = read.f();
      this.controller = mindustry.io.TypeIO.readController(read, this.controller);
      this.elevation = read.f();
      this.flag = read.d();
      this.health = read.f();
      this.isShooting = read.bool();
      this.mineTile = mindustry.io.TypeIO.readTile(read);
      this.mounts = mindustry.io.TypeIO.readMounts(read, this.mounts);
      this.plans = mindustry.io.TypeIO.readPlansQueue(read);
      this.rotation = read.f();
      this.shield = read.f();
      this.spawnedByCore = read.bool();
      this.stack = mindustry.io.TypeIO.readItems(read, this.stack);
      int statuses_LENGTH = read.i();
      this.statuses.clear();
      for(int INDEX = 0; INDEX < statuses_LENGTH; INDEX ++) {
        mindustry.entities.units.StatusEntry statuses_ITEM = mindustry.io.TypeIO.readStatus(read);
        if(statuses_ITEM != null) this.statuses.add(statuses_ITEM);
      }
      this.team = mindustry.io.TypeIO.readTeam(read);
      this.type = mindustry.Vars.content.getByID(mindustry.ctype.ContentType.unit, read.s());
      this.updateBuilding = read.bool();
      this.vel = mindustry.io.TypeIO.readVec2(read, this.vel);
      this.x = read.f();
      this.y = read.f();
    } else {
      throw new IllegalArgumentException("Unknown revision '" + REV + "' for entity type 'toxopid'");
    }
        afterRead();
  }

  @Annotations.CallSuper
  public void write(Writes write) {
    write.s(3);
    mindustry.io.TypeIO.writeAbilities(write, this.abilities);
    write.f(this.ammo);
    mindustry.io.TypeIO.writeController(write, this.controller);
    write.f(this.elevation);
    write.d(this.flag);
    write.f(this.health);
    write.bool(this.isShooting);
    mindustry.io.TypeIO.writeTile(write, this.mineTile);
    mindustry.io.TypeIO.writeMounts(write, this.mounts);
    write.i(this.plans.size);
    for(int INDEX = 0; INDEX < this.plans.size; INDEX ++) {
      mindustry.io.TypeIO.writePlan(write, this.plans.get(INDEX));
    }
    write.f(this.rotation);
    write.f(this.shield);
    write.bool(this.spawnedByCore);
    mindustry.io.TypeIO.writeItems(write, this.stack);
    write.i(this.statuses.size);
    for(int INDEX = 0; INDEX < this.statuses.size; INDEX ++) {
      mindustry.io.TypeIO.writeStatus(write, this.statuses.get(INDEX));
    }
    mindustry.io.TypeIO.writeTeam(write, this.team);
    write.s(this.type.id);
    write.bool(this.updateBuilding);
    mindustry.io.TypeIO.writeVec2(write, this.vel);
    write.f(this.x);
    write.f(this.y);
  }

  public boolean serialize() {
    return true;
  }

  public static LegsUnitLegacyToxopid create() {
    return new LegsUnitLegacyToxopid();
  }
}
