package mindustry.gen;

import arc.audio.Sound;
import arc.graphics.Color;
import arc.math.geom.Vec2;
import arc.struct.IntSeq;
import arc.struct.Queue;
import java.lang.Object;
import java.lang.String;
import mindustry.ai.UnitCommand;
import mindustry.ctype.Content;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.units.BuildPlan;
import mindustry.game.MapObjectives;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.net.Administration;
import mindustry.net.NetConnection;
import mindustry.net.Packets;
import mindustry.type.Item;
import mindustry.type.UnitType;
import mindustry.type.Weather;
import mindustry.world.Block;
import mindustry.world.Tile;

public class Call {
  public static void adminRequest(Player other, Packets.AdminAction action) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetServer.adminRequest(mindustry.Vars.player, other, action);
    }
    if(mindustry.Vars.net.client()) {
      AdminRequestCallPacket packet = new AdminRequestCallPacket();
      packet.other = other;
      packet.action = action;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void announce(String message) {
    if(mindustry.Vars.net.server()) {
      AnnounceCallPacket packet = new AnnounceCallPacket();
      packet.message = message;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void announce(NetConnection playerConnection, String message) {
    if(mindustry.Vars.net.server()) {
      AnnounceCallPacket packet = new AnnounceCallPacket();
      packet.message = message;
      playerConnection.send(packet, true);
    }
  }

  public static void assemblerDroneSpawned(Tile tile, int id) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.units.UnitAssembler.assemblerDroneSpawned(tile, id);
    }
    if(mindustry.Vars.net.server()) {
      AssemblerDroneSpawnedCallPacket packet = new AssemblerDroneSpawnedCallPacket();
      packet.tile = tile;
      packet.id = id;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void assemblerUnitSpawned(Tile tile) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.units.UnitAssembler.assemblerUnitSpawned(tile);
    }
    if(mindustry.Vars.net.server()) {
      AssemblerUnitSpawnedCallPacket packet = new AssemblerUnitSpawnedCallPacket();
      packet.tile = tile;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void autoDoorToggle(Tile tile, boolean open) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.defense.AutoDoor.autoDoorToggle(tile, open);
    }
    if(mindustry.Vars.net.server()) {
      AutoDoorToggleCallPacket packet = new AutoDoorToggleCallPacket();
      packet.tile = tile;
      packet.open = open;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void beginBreak(Unit unit, Team team, int x, int y) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Build.beginBreak(unit, team, x, y);
    }
    if(mindustry.Vars.net.server()) {
      BeginBreakCallPacket packet = new BeginBreakCallPacket();
      packet.unit = unit;
      packet.team = team;
      packet.x = x;
      packet.y = y;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void beginPlace(Unit unit, Block result, Team team, int x, int y, int rotation) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Build.beginPlace(unit, result, team, x, y, rotation);
    }
    if(mindustry.Vars.net.server()) {
      BeginPlaceCallPacket packet = new BeginPlaceCallPacket();
      packet.unit = unit;
      packet.result = result;
      packet.team = team;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void blockSnapshot(short amount, byte[] data) {
    if(mindustry.Vars.net.server()) {
      BlockSnapshotCallPacket packet = new BlockSnapshotCallPacket();
      packet.amount = amount;
      packet.data = data;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void blockSnapshot(NetConnection playerConnection, short amount, byte[] data) {
    if(mindustry.Vars.net.server()) {
      BlockSnapshotCallPacket packet = new BlockSnapshotCallPacket();
      packet.amount = amount;
      packet.data = data;
      playerConnection.send(packet, false);
    }
  }

  public static void buildDestroyed(Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Tile.buildDestroyed(build);
    }
    if(mindustry.Vars.net.server()) {
      BuildDestroyedCallPacket packet = new BuildDestroyedCallPacket();
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void buildHealthUpdate(IntSeq buildings) {
    if(mindustry.Vars.net.server()) {
      BuildHealthUpdateCallPacket packet = new BuildHealthUpdateCallPacket();
      packet.buildings = buildings;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void buildingControlSelect(Player player, Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.buildingControlSelect(player, build);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      BuildingControlSelectCallPacket packet = new BuildingControlSelectCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void buildingControlSelect__forward(NetConnection exceptConnection, Player player,
      Building build) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      BuildingControlSelectCallPacket packet = new BuildingControlSelectCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void cargoLoaderDroneSpawned(Tile tile, int id) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.units.UnitCargoLoader.cargoLoaderDroneSpawned(tile, id);
    }
    if(mindustry.Vars.net.server()) {
      CargoLoaderDroneSpawnedCallPacket packet = new CargoLoaderDroneSpawnedCallPacket();
      packet.tile = tile;
      packet.id = id;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void clearItems(Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.clearItems(build);
    }
    if(mindustry.Vars.net.server()) {
      ClearItemsCallPacket packet = new ClearItemsCallPacket();
      packet.build = build;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void clientPacketReliable(String type, String contents) {
    if(mindustry.Vars.net.server()) {
      ClientPacketReliableCallPacket packet = new ClientPacketReliableCallPacket();
      packet.type = type;
      packet.contents = contents;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void clientPacketReliable(NetConnection playerConnection, String type,
      String contents) {
    if(mindustry.Vars.net.server()) {
      ClientPacketReliableCallPacket packet = new ClientPacketReliableCallPacket();
      packet.type = type;
      packet.contents = contents;
      playerConnection.send(packet, true);
    }
  }

  public static void clientPacketUnreliable(String type, String contents) {
    if(mindustry.Vars.net.server()) {
      ClientPacketUnreliableCallPacket packet = new ClientPacketUnreliableCallPacket();
      packet.type = type;
      packet.contents = contents;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void clientPacketUnreliable(NetConnection playerConnection, String type,
      String contents) {
    if(mindustry.Vars.net.server()) {
      ClientPacketUnreliableCallPacket packet = new ClientPacketUnreliableCallPacket();
      packet.type = type;
      packet.contents = contents;
      playerConnection.send(packet, false);
    }
  }

  public static void clientSnapshot(int snapshotID, int unitID, boolean dead, float x, float y,
      float pointerX, float pointerY, float rotation, float baseRotation, float xVelocity,
      float yVelocity, Tile mining, boolean boosting, boolean shooting, boolean chatting,
      boolean building, Queue<BuildPlan> plans, float viewX, float viewY, float viewWidth,
      float viewHeight) {
    if(mindustry.Vars.net.client()) {
      ClientSnapshotCallPacket packet = new ClientSnapshotCallPacket();
      packet.snapshotID = snapshotID;
      packet.unitID = unitID;
      packet.dead = dead;
      packet.x = x;
      packet.y = y;
      packet.pointerX = pointerX;
      packet.pointerY = pointerY;
      packet.rotation = rotation;
      packet.baseRotation = baseRotation;
      packet.xVelocity = xVelocity;
      packet.yVelocity = yVelocity;
      packet.mining = mining;
      packet.boosting = boosting;
      packet.shooting = shooting;
      packet.chatting = chatting;
      packet.building = building;
      packet.plans = plans;
      packet.viewX = viewX;
      packet.viewY = viewY;
      packet.viewWidth = viewWidth;
      packet.viewHeight = viewHeight;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void commandBuilding(Player player, Building build, Vec2 target) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.commandBuilding(player, build, target);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      CommandBuildingCallPacket packet = new CommandBuildingCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.target = target;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void commandBuilding__forward(NetConnection exceptConnection, Player player,
      Building build, Vec2 target) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      CommandBuildingCallPacket packet = new CommandBuildingCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.target = target;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void commandUnits(Player player, int[] unitIds, Building buildTarget,
      Unit unitTarget, Vec2 posTarget) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.commandUnits(player, unitIds, buildTarget, unitTarget, posTarget);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      CommandUnitsCallPacket packet = new CommandUnitsCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.unitIds = unitIds;
      packet.buildTarget = buildTarget;
      packet.unitTarget = unitTarget;
      packet.posTarget = posTarget;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void commandUnits__forward(NetConnection exceptConnection, Player player, int[] unitIds,
      Building buildTarget, Unit unitTarget, Vec2 posTarget) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      CommandUnitsCallPacket packet = new CommandUnitsCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.unitIds = unitIds;
      packet.buildTarget = buildTarget;
      packet.unitTarget = unitTarget;
      packet.posTarget = posTarget;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void connect(NetConnection playerConnection, String ip, int port) {
    if(mindustry.Vars.net.client() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.connect(ip, port);
    }
    if(mindustry.Vars.net.server()) {
      ConnectCallPacket packet = new ConnectCallPacket();
      packet.ip = ip;
      packet.port = port;
      playerConnection.send(packet, true);
    }
  }

  public static void connectConfirm() {
    if(mindustry.Vars.net.client()) {
      ConnectConfirmCallPacket packet = new ConnectConfirmCallPacket();
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void constructFinish(Tile tile, Block block, Unit builder, byte rotation, Team team,
      Object config) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.ConstructBlock.constructFinish(tile, block, builder, rotation, team, config);
    }
    if(mindustry.Vars.net.server()) {
      ConstructFinishCallPacket packet = new ConstructFinishCallPacket();
      packet.tile = tile;
      packet.block = block;
      packet.builder = builder;
      packet.rotation = rotation;
      packet.team = team;
      packet.config = config;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void createBullet(BulletType type, Team team, float x, float y, float angle,
      float damage, float velocityScl, float lifetimeScl) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.entities.bullet.BulletType.createBullet(type, team, x, y, angle, damage, velocityScl, lifetimeScl);
    }
    if(mindustry.Vars.net.server()) {
      CreateBulletCallPacket packet = new CreateBulletCallPacket();
      packet.type = type;
      packet.team = team;
      packet.x = x;
      packet.y = y;
      packet.angle = angle;
      packet.damage = damage;
      packet.velocityScl = velocityScl;
      packet.lifetimeScl = lifetimeScl;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void createWeather(Weather weather, float intensity, float duration, float windX,
      float windY) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.type.Weather.createWeather(weather, intensity, duration, windX, windY);
    }
    if(mindustry.Vars.net.server()) {
      CreateWeatherCallPacket packet = new CreateWeatherCallPacket();
      packet.weather = weather;
      packet.intensity = intensity;
      packet.duration = duration;
      packet.windX = windX;
      packet.windY = windY;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void debugStatusClient(int value, int lastClientSnapshot, int snapshotsSent) {
    if(mindustry.Vars.net.server()) {
      DebugStatusClientCallPacket packet = new DebugStatusClientCallPacket();
      packet.value = value;
      packet.lastClientSnapshot = lastClientSnapshot;
      packet.snapshotsSent = snapshotsSent;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void debugStatusClient(NetConnection playerConnection, int value,
      int lastClientSnapshot, int snapshotsSent) {
    if(mindustry.Vars.net.server()) {
      DebugStatusClientCallPacket packet = new DebugStatusClientCallPacket();
      packet.value = value;
      packet.lastClientSnapshot = lastClientSnapshot;
      packet.snapshotsSent = snapshotsSent;
      playerConnection.send(packet, true);
    }
  }

  public static void debugStatusClientUnreliable(int value, int lastClientSnapshot,
      int snapshotsSent) {
    if(mindustry.Vars.net.server()) {
      DebugStatusClientUnreliableCallPacket packet = new DebugStatusClientUnreliableCallPacket();
      packet.value = value;
      packet.lastClientSnapshot = lastClientSnapshot;
      packet.snapshotsSent = snapshotsSent;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void debugStatusClientUnreliable(NetConnection playerConnection, int value,
      int lastClientSnapshot, int snapshotsSent) {
    if(mindustry.Vars.net.server()) {
      DebugStatusClientUnreliableCallPacket packet = new DebugStatusClientUnreliableCallPacket();
      packet.value = value;
      packet.lastClientSnapshot = lastClientSnapshot;
      packet.snapshotsSent = snapshotsSent;
      playerConnection.send(packet, false);
    }
  }

  public static void deconstructFinish(Tile tile, Block block, Unit builder) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.ConstructBlock.deconstructFinish(tile, block, builder);
    }
    if(mindustry.Vars.net.server()) {
      DeconstructFinishCallPacket packet = new DeconstructFinishCallPacket();
      packet.tile = tile;
      packet.block = block;
      packet.builder = builder;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void deletePlans(Player player, int[] positions) {
    mindustry.input.InputHandler.deletePlans(player, positions);
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      DeletePlansCallPacket packet = new DeletePlansCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.positions = positions;
      mindustry.Vars.net.send(packet, false);
    }
  }

  static void deletePlans__forward(NetConnection exceptConnection, Player player, int[] positions) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      DeletePlansCallPacket packet = new DeletePlansCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.positions = positions;
      mindustry.Vars.net.sendExcept(exceptConnection, packet, false);
    }
  }

  public static void dropItem(float angle) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.dropItem(mindustry.Vars.player, angle);
    }
    if(mindustry.Vars.net.client()) {
      DropItemCallPacket packet = new DropItemCallPacket();
      packet.angle = angle;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void effect(Effect effect, float x, float y, float rotation, Color color) {
    if(mindustry.Vars.net.server()) {
      EffectCallPacket packet = new EffectCallPacket();
      packet.effect = effect;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.color = color;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void effect(NetConnection playerConnection, Effect effect, float x, float y,
      float rotation, Color color) {
    if(mindustry.Vars.net.server()) {
      EffectCallPacket packet = new EffectCallPacket();
      packet.effect = effect;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.color = color;
      playerConnection.send(packet, false);
    }
  }

  public static void effect(Effect effect, float x, float y, float rotation, Color color,
      Object data) {
    if(mindustry.Vars.net.server()) {
      EffectCallPacket2 packet = new EffectCallPacket2();
      packet.effect = effect;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.color = color;
      packet.data = data;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void effect(NetConnection playerConnection, Effect effect, float x, float y,
      float rotation, Color color, Object data) {
    if(mindustry.Vars.net.server()) {
      EffectCallPacket2 packet = new EffectCallPacket2();
      packet.effect = effect;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.color = color;
      packet.data = data;
      playerConnection.send(packet, false);
    }
  }

  public static void effectReliable(Effect effect, float x, float y, float rotation, Color color) {
    if(mindustry.Vars.net.server()) {
      EffectReliableCallPacket packet = new EffectReliableCallPacket();
      packet.effect = effect;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.color = color;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void effectReliable(NetConnection playerConnection, Effect effect, float x, float y,
      float rotation, Color color) {
    if(mindustry.Vars.net.server()) {
      EffectReliableCallPacket packet = new EffectReliableCallPacket();
      packet.effect = effect;
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.color = color;
      playerConnection.send(packet, true);
    }
  }

  public static void entitySnapshot(NetConnection playerConnection, short amount, byte[] data) {
    if(mindustry.Vars.net.server()) {
      EntitySnapshotCallPacket packet = new EntitySnapshotCallPacket();
      packet.amount = amount;
      packet.data = data;
      playerConnection.send(packet, false);
    }
  }

  public static void gameOver(Team winner) {
    mindustry.core.Logic.gameOver(winner);
    if(mindustry.Vars.net.server()) {
      GameOverCallPacket packet = new GameOverCallPacket();
      packet.winner = winner;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void hiddenSnapshot(NetConnection playerConnection, IntSeq ids) {
    if(mindustry.Vars.net.server()) {
      HiddenSnapshotCallPacket packet = new HiddenSnapshotCallPacket();
      packet.ids = ids;
      playerConnection.send(packet, false);
    }
  }

  public static void hideHudText() {
    if(mindustry.Vars.net.server()) {
      HideHudTextCallPacket packet = new HideHudTextCallPacket();
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void hideHudText(NetConnection playerConnection) {
    if(mindustry.Vars.net.server()) {
      HideHudTextCallPacket packet = new HideHudTextCallPacket();
      playerConnection.send(packet, true);
    }
  }

  public static void infoMessage(String message) {
    if(mindustry.Vars.net.server()) {
      InfoMessageCallPacket packet = new InfoMessageCallPacket();
      packet.message = message;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void infoMessage(NetConnection playerConnection, String message) {
    if(mindustry.Vars.net.server()) {
      InfoMessageCallPacket packet = new InfoMessageCallPacket();
      packet.message = message;
      playerConnection.send(packet, true);
    }
  }

  public static void infoPopup(String message, float duration, int align, int top, int left,
      int bottom, int right) {
    if(mindustry.Vars.net.server()) {
      InfoPopupCallPacket packet = new InfoPopupCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.align = align;
      packet.top = top;
      packet.left = left;
      packet.bottom = bottom;
      packet.right = right;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void infoPopup(NetConnection playerConnection, String message, float duration,
      int align, int top, int left, int bottom, int right) {
    if(mindustry.Vars.net.server()) {
      InfoPopupCallPacket packet = new InfoPopupCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.align = align;
      packet.top = top;
      packet.left = left;
      packet.bottom = bottom;
      packet.right = right;
      playerConnection.send(packet, false);
    }
  }

  public static void infoPopupReliable(String message, float duration, int align, int top, int left,
      int bottom, int right) {
    if(mindustry.Vars.net.server()) {
      InfoPopupReliableCallPacket packet = new InfoPopupReliableCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.align = align;
      packet.top = top;
      packet.left = left;
      packet.bottom = bottom;
      packet.right = right;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void infoPopupReliable(NetConnection playerConnection, String message,
      float duration, int align, int top, int left, int bottom, int right) {
    if(mindustry.Vars.net.server()) {
      InfoPopupReliableCallPacket packet = new InfoPopupReliableCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.align = align;
      packet.top = top;
      packet.left = left;
      packet.bottom = bottom;
      packet.right = right;
      playerConnection.send(packet, true);
    }
  }

  public static void infoToast(String message, float duration) {
    if(mindustry.Vars.net.server()) {
      InfoToastCallPacket packet = new InfoToastCallPacket();
      packet.message = message;
      packet.duration = duration;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void infoToast(NetConnection playerConnection, String message, float duration) {
    if(mindustry.Vars.net.server()) {
      InfoToastCallPacket packet = new InfoToastCallPacket();
      packet.message = message;
      packet.duration = duration;
      playerConnection.send(packet, true);
    }
  }

  public static void kick(NetConnection playerConnection, String reason) {
    if(mindustry.Vars.net.server()) {
      KickCallPacket packet = new KickCallPacket();
      packet.reason = reason;
      playerConnection.send(packet, true);
    }
  }

  public static void kick(NetConnection playerConnection, Packets.KickReason reason) {
    if(mindustry.Vars.net.server()) {
      KickCallPacket2 packet = new KickCallPacket2();
      packet.reason = reason;
      playerConnection.send(packet, true);
    }
  }

  public static void label(String message, float duration, float worldx, float worldy) {
    if(mindustry.Vars.net.server()) {
      LabelCallPacket packet = new LabelCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.worldx = worldx;
      packet.worldy = worldy;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void label(NetConnection playerConnection, String message, float duration,
      float worldx, float worldy) {
    if(mindustry.Vars.net.server()) {
      LabelCallPacket packet = new LabelCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.worldx = worldx;
      packet.worldy = worldy;
      playerConnection.send(packet, false);
    }
  }

  public static void labelReliable(String message, float duration, float worldx, float worldy) {
    if(mindustry.Vars.net.server()) {
      LabelReliableCallPacket packet = new LabelReliableCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.worldx = worldx;
      packet.worldy = worldy;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void labelReliable(NetConnection playerConnection, String message, float duration,
      float worldx, float worldy) {
    if(mindustry.Vars.net.server()) {
      LabelReliableCallPacket packet = new LabelReliableCallPacket();
      packet.message = message;
      packet.duration = duration;
      packet.worldx = worldx;
      packet.worldy = worldy;
      playerConnection.send(packet, true);
    }
  }

  public static void logicExplosion(Team team, float x, float y, float radius, float damage,
      boolean air, boolean ground, boolean pierce) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.logic.LExecutor.logicExplosion(team, x, y, radius, damage, air, ground, pierce);
    }
    if(mindustry.Vars.net.server()) {
      LogicExplosionCallPacket packet = new LogicExplosionCallPacket();
      packet.team = team;
      packet.x = x;
      packet.y = y;
      packet.radius = radius;
      packet.damage = damage;
      packet.air = air;
      packet.ground = ground;
      packet.pierce = pierce;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void menu(int menuId, String title, String message, String[][] options) {
    if(mindustry.Vars.net.server()) {
      MenuCallPacket packet = new MenuCallPacket();
      packet.menuId = menuId;
      packet.title = title;
      packet.message = message;
      packet.options = options;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void menu(NetConnection playerConnection, int menuId, String title, String message,
      String[][] options) {
    if(mindustry.Vars.net.server()) {
      MenuCallPacket packet = new MenuCallPacket();
      packet.menuId = menuId;
      packet.title = title;
      packet.message = message;
      packet.options = options;
      playerConnection.send(packet, true);
    }
  }

  public static void menuChoose(Player player, int menuId, int option) {
    mindustry.ui.Menus.menuChoose(player, menuId, option);
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      MenuChooseCallPacket packet = new MenuChooseCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.menuId = menuId;
      packet.option = option;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void openURI(String uri) {
    if(mindustry.Vars.net.server()) {
      OpenURICallPacket packet = new OpenURICallPacket();
      packet.uri = uri;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void openURI(NetConnection playerConnection, String uri) {
    if(mindustry.Vars.net.server()) {
      OpenURICallPacket packet = new OpenURICallPacket();
      packet.uri = uri;
      playerConnection.send(packet, true);
    }
  }

  public static void payloadDropped(Unit unit, float x, float y) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.payloadDropped(unit, x, y);
    }
    if(mindustry.Vars.net.server()) {
      PayloadDroppedCallPacket packet = new PayloadDroppedCallPacket();
      packet.unit = unit;
      packet.x = x;
      packet.y = y;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void pickedBuildPayload(Unit unit, Building build, boolean onGround) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.pickedBuildPayload(unit, build, onGround);
    }
    if(mindustry.Vars.net.server()) {
      PickedBuildPayloadCallPacket packet = new PickedBuildPayloadCallPacket();
      packet.unit = unit;
      packet.build = build;
      packet.onGround = onGround;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void pickedUnitPayload(Unit unit, Unit target) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.pickedUnitPayload(unit, target);
    }
    if(mindustry.Vars.net.server()) {
      PickedUnitPayloadCallPacket packet = new PickedUnitPayloadCallPacket();
      packet.unit = unit;
      packet.target = target;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void ping(long time) {
    if(mindustry.Vars.net.client()) {
      PingCallPacket packet = new PingCallPacket();
      packet.time = time;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void pingResponse(NetConnection playerConnection, long time) {
    if(mindustry.Vars.net.server()) {
      PingResponseCallPacket packet = new PingResponseCallPacket();
      packet.time = time;
      playerConnection.send(packet, true);
    }
  }

  public static void playerDisconnect(int playerid) {
    if(mindustry.Vars.net.server()) {
      PlayerDisconnectCallPacket packet = new PlayerDisconnectCallPacket();
      packet.playerid = playerid;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void playerSpawn(Tile tile, Player player) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.storage.CoreBlock.playerSpawn(tile, player);
    }
    if(mindustry.Vars.net.server()) {
      PlayerSpawnCallPacket packet = new PlayerSpawnCallPacket();
      packet.tile = tile;
      packet.player = player;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void removeQueueBlock(NetConnection playerConnection, int x, int y,
      boolean breaking) {
    if(mindustry.Vars.net.server()) {
      RemoveQueueBlockCallPacket packet = new RemoveQueueBlockCallPacket();
      packet.x = x;
      packet.y = y;
      packet.breaking = breaking;
      playerConnection.send(packet, true);
    }
  }

  public static void removeTile(Tile tile) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Tile.removeTile(tile);
    }
    if(mindustry.Vars.net.server()) {
      RemoveTileCallPacket packet = new RemoveTileCallPacket();
      packet.tile = tile;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void removeWorldLabel(int id) {
    if(mindustry.Vars.net.server()) {
      RemoveWorldLabelCallPacket packet = new RemoveWorldLabelCallPacket();
      packet.id = id;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void requestBuildPayload(Player player, Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.requestBuildPayload(player, build);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RequestBuildPayloadCallPacket packet = new RequestBuildPayloadCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void requestDebugStatus() {
    if(mindustry.Vars.net.client()) {
      RequestDebugStatusCallPacket packet = new RequestDebugStatusCallPacket();
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void requestDropPayload(Player player, float x, float y) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.requestDropPayload(player, x, y);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RequestDropPayloadCallPacket packet = new RequestDropPayloadCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.x = x;
      packet.y = y;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void requestItem(Player player, Building build, Item item, int amount) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.requestItem(player, build, item, amount);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RequestItemCallPacket packet = new RequestItemCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.item = item;
      packet.amount = amount;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void requestItem__forward(NetConnection exceptConnection, Player player, Building build,
      Item item, int amount) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RequestItemCallPacket packet = new RequestItemCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.item = item;
      packet.amount = amount;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void requestUnitPayload(Player player, Unit target) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.requestUnitPayload(player, target);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RequestUnitPayloadCallPacket packet = new RequestUnitPayloadCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.target = target;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void researched(Content content) {
    if(mindustry.Vars.net.server()) {
      ResearchedCallPacket packet = new ResearchedCallPacket();
      packet.content = content;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void rotateBlock(Player player, Building build, boolean direction) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.rotateBlock(player, build, direction);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RotateBlockCallPacket packet = new RotateBlockCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.direction = direction;
      mindustry.Vars.net.send(packet, false);
    }
  }

  static void rotateBlock__forward(NetConnection exceptConnection, Player player, Building build,
      boolean direction) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      RotateBlockCallPacket packet = new RotateBlockCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.direction = direction;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void sectorCapture() {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.Logic.sectorCapture();
    }
    if(mindustry.Vars.net.server()) {
      SectorCaptureCallPacket packet = new SectorCaptureCallPacket();
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void sectorProduced(int[] amounts) {
    if(mindustry.Vars.net.server()) {
      SectorProducedCallPacket packet = new SectorProducedCallPacket();
      packet.amounts = amounts;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void sendChatMessage(String message) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.sendChatMessage(mindustry.Vars.player, message);
    }
    if(mindustry.Vars.net.client()) {
      SendChatMessageCallPacket packet = new SendChatMessageCallPacket();
      packet.message = message;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void sendMessage(String message) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.sendMessage(message);
    }
    if(mindustry.Vars.net.server()) {
      SendMessageCallPacket packet = new SendMessageCallPacket();
      packet.message = message;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void sendMessage(String message, String unformatted, Player playersender) {
    if(mindustry.Vars.net.server()) {
      SendMessageCallPacket2 packet = new SendMessageCallPacket2();
      packet.message = message;
      packet.unformatted = unformatted;
      packet.playersender = playersender;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void sendMessage(NetConnection playerConnection, String message, String unformatted,
      Player playersender) {
    if(mindustry.Vars.net.server()) {
      SendMessageCallPacket2 packet = new SendMessageCallPacket2();
      packet.message = message;
      packet.unformatted = unformatted;
      packet.playersender = playersender;
      playerConnection.send(packet, true);
    }
  }

  public static void serverPacketReliable(String type, String contents) {
    if(mindustry.Vars.net.client()) {
      ServerPacketReliableCallPacket packet = new ServerPacketReliableCallPacket();
      packet.type = type;
      packet.contents = contents;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void serverPacketUnreliable(String type, String contents) {
    if(mindustry.Vars.net.client()) {
      ServerPacketUnreliableCallPacket packet = new ServerPacketUnreliableCallPacket();
      packet.type = type;
      packet.contents = contents;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void setCameraPosition(float x, float y) {
    if(mindustry.Vars.net.server()) {
      SetCameraPositionCallPacket packet = new SetCameraPositionCallPacket();
      packet.x = x;
      packet.y = y;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void setCameraPosition(NetConnection playerConnection, float x, float y) {
    if(mindustry.Vars.net.server()) {
      SetCameraPositionCallPacket packet = new SetCameraPositionCallPacket();
      packet.x = x;
      packet.y = y;
      playerConnection.send(packet, false);
    }
  }

  public static void setFloor(Tile tile, Block floor, Block overlay) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Tile.setFloor(tile, floor, overlay);
    }
    if(mindustry.Vars.net.server()) {
      SetFloorCallPacket packet = new SetFloorCallPacket();
      packet.tile = tile;
      packet.floor = floor;
      packet.overlay = overlay;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setHudText(String message) {
    if(mindustry.Vars.net.server()) {
      SetHudTextCallPacket packet = new SetHudTextCallPacket();
      packet.message = message;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void setHudText(NetConnection playerConnection, String message) {
    if(mindustry.Vars.net.server()) {
      SetHudTextCallPacket packet = new SetHudTextCallPacket();
      packet.message = message;
      playerConnection.send(packet, false);
    }
  }

  public static void setHudTextReliable(String message) {
    if(mindustry.Vars.net.server()) {
      SetHudTextReliableCallPacket packet = new SetHudTextReliableCallPacket();
      packet.message = message;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setHudTextReliable(NetConnection playerConnection, String message) {
    if(mindustry.Vars.net.server()) {
      SetHudTextReliableCallPacket packet = new SetHudTextReliableCallPacket();
      packet.message = message;
      playerConnection.send(packet, true);
    }
  }

  public static void setItem(Building build, Item item, int amount) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.setItem(build, item, amount);
    }
    if(mindustry.Vars.net.server()) {
      SetItemCallPacket packet = new SetItemCallPacket();
      packet.build = build;
      packet.item = item;
      packet.amount = amount;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void setMapArea(int x, int y, int w, int h) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.logic.LExecutor.setMapArea(x, y, w, h);
    }
    if(mindustry.Vars.net.server()) {
      SetMapAreaCallPacket packet = new SetMapAreaCallPacket();
      packet.x = x;
      packet.y = y;
      packet.w = w;
      packet.h = h;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setObjectives(MapObjectives executor) {
    if(mindustry.Vars.net.server()) {
      SetObjectivesCallPacket packet = new SetObjectivesCallPacket();
      packet.executor = executor;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setObjectives(NetConnection playerConnection, MapObjectives executor) {
    if(mindustry.Vars.net.server()) {
      SetObjectivesCallPacket packet = new SetObjectivesCallPacket();
      packet.executor = executor;
      playerConnection.send(packet, true);
    }
  }

  public static void setOverlay(Tile tile, Block overlay) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Tile.setOverlay(tile, overlay);
    }
    if(mindustry.Vars.net.server()) {
      SetOverlayCallPacket packet = new SetOverlayCallPacket();
      packet.tile = tile;
      packet.overlay = overlay;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setPlayerTeamEditor(Player player, Team team) {
    mindustry.ui.fragments.HudFragment.setPlayerTeamEditor(player, team);
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      SetPlayerTeamEditorCallPacket packet = new SetPlayerTeamEditorCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.team = team;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void setPlayerTeamEditor__forward(NetConnection exceptConnection, Player player,
      Team team) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      SetPlayerTeamEditorCallPacket packet = new SetPlayerTeamEditorCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.team = team;
      mindustry.Vars.net.sendExcept(exceptConnection, packet, true);
    }
  }

  public static void setPosition(NetConnection playerConnection, float x, float y) {
    if(mindustry.Vars.net.server()) {
      SetPositionCallPacket packet = new SetPositionCallPacket();
      packet.x = x;
      packet.y = y;
      playerConnection.send(packet, true);
    }
  }

  public static void setRules(Rules rules) {
    if(mindustry.Vars.net.server()) {
      SetRulesCallPacket packet = new SetRulesCallPacket();
      packet.rules = rules;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setRules(NetConnection playerConnection, Rules rules) {
    if(mindustry.Vars.net.server()) {
      SetRulesCallPacket packet = new SetRulesCallPacket();
      packet.rules = rules;
      playerConnection.send(packet, true);
    }
  }

  public static void setTeam(Building build, Team team) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Tile.setTeam(build, team);
    }
    if(mindustry.Vars.net.server()) {
      SetTeamCallPacket packet = new SetTeamCallPacket();
      packet.build = build;
      packet.team = team;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setTile(Tile tile, Block block, Team team, int rotation) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.Tile.setTile(tile, block, team, rotation);
    }
    if(mindustry.Vars.net.server()) {
      SetTileCallPacket packet = new SetTileCallPacket();
      packet.tile = tile;
      packet.block = block;
      packet.team = team;
      packet.rotation = rotation;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void setUnitCommand(Player player, int[] unitIds, UnitCommand command) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.setUnitCommand(player, unitIds, command);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      SetUnitCommandCallPacket packet = new SetUnitCommandCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.unitIds = unitIds;
      packet.command = command;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void setUnitCommand__forward(NetConnection exceptConnection, Player player, int[] unitIds,
      UnitCommand command) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      SetUnitCommandCallPacket packet = new SetUnitCommandCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.unitIds = unitIds;
      packet.command = command;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void sound(Sound sound, float volume, float pitch, float pan) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.sound(sound, volume, pitch, pan);
    }
    if(mindustry.Vars.net.server()) {
      SoundCallPacket packet = new SoundCallPacket();
      packet.sound = sound;
      packet.volume = volume;
      packet.pitch = pitch;
      packet.pan = pan;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void sound(NetConnection playerConnection, Sound sound, float volume, float pitch,
      float pan) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.sound(sound, volume, pitch, pan);
    }
    if(mindustry.Vars.net.server()) {
      SoundCallPacket packet = new SoundCallPacket();
      packet.sound = sound;
      packet.volume = volume;
      packet.pitch = pitch;
      packet.pan = pan;
      playerConnection.send(packet, false);
    }
  }

  public static void soundAt(Sound sound, float x, float y, float volume, float pitch) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.soundAt(sound, x, y, volume, pitch);
    }
    if(mindustry.Vars.net.server()) {
      SoundAtCallPacket packet = new SoundAtCallPacket();
      packet.sound = sound;
      packet.x = x;
      packet.y = y;
      packet.volume = volume;
      packet.pitch = pitch;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void soundAt(NetConnection playerConnection, Sound sound, float x, float y,
      float volume, float pitch) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.core.NetClient.soundAt(sound, x, y, volume, pitch);
    }
    if(mindustry.Vars.net.server()) {
      SoundAtCallPacket packet = new SoundAtCallPacket();
      packet.sound = sound;
      packet.x = x;
      packet.y = y;
      packet.volume = volume;
      packet.pitch = pitch;
      playerConnection.send(packet, false);
    }
  }

  public static void spawnEffect(float x, float y, float rotation, UnitType u) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.ai.WaveSpawner.spawnEffect(x, y, rotation, u);
    }
    if(mindustry.Vars.net.server()) {
      SpawnEffectCallPacket packet = new SpawnEffectCallPacket();
      packet.x = x;
      packet.y = y;
      packet.rotation = rotation;
      packet.u = u;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void stateSnapshot(NetConnection playerConnection, float waveTime, int wave,
      int enemies, boolean paused, boolean gameOver, int timeData, byte tps, long rand0, long rand1,
      byte[] coreData) {
    if(mindustry.Vars.net.server()) {
      StateSnapshotCallPacket packet = new StateSnapshotCallPacket();
      packet.waveTime = waveTime;
      packet.wave = wave;
      packet.enemies = enemies;
      packet.paused = paused;
      packet.gameOver = gameOver;
      packet.timeData = timeData;
      packet.tps = tps;
      packet.rand0 = rand0;
      packet.rand1 = rand1;
      packet.coreData = coreData;
      playerConnection.send(packet, false);
    }
  }

  public static void takeItems(Building build, Item item, int amount, Unit to) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.takeItems(build, item, amount, to);
    }
    if(mindustry.Vars.net.server()) {
      TakeItemsCallPacket packet = new TakeItemsCallPacket();
      packet.build = build;
      packet.item = item;
      packet.amount = amount;
      packet.to = to;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void tileConfig(Player player, Building build, Object value) {
    mindustry.input.InputHandler.tileConfig(player, build, value);
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      TileConfigCallPacket packet = new TileConfigCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.value = value;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void tileConfig__forward(NetConnection exceptConnection, Player player, Building build,
      Object value) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      TileConfigCallPacket packet = new TileConfigCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      packet.value = value;
      mindustry.Vars.net.sendExcept(exceptConnection, packet, true);
    }
  }

  public static void tileTap(Player player, Tile tile) {
    mindustry.input.InputHandler.tileTap(player, tile);
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      TileTapCallPacket packet = new TileTapCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.tile = tile;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void traceInfo(NetConnection playerConnection, Player player,
      Administration.TraceInfo info) {
    if(mindustry.Vars.net.server()) {
      TraceInfoCallPacket packet = new TraceInfoCallPacket();
      packet.player = player;
      packet.info = info;
      playerConnection.send(packet, true);
    }
  }

  public static void transferInventory(Player player, Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.transferInventory(player, build);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      TransferInventoryCallPacket packet = new TransferInventoryCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void transferInventory__forward(NetConnection exceptConnection, Player player,
      Building build) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      TransferInventoryCallPacket packet = new TransferInventoryCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void transferItemEffect(Item item, float x, float y, Itemsc to) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.transferItemEffect(item, x, y, to);
    }
    if(mindustry.Vars.net.server()) {
      TransferItemEffectCallPacket packet = new TransferItemEffectCallPacket();
      packet.item = item;
      packet.x = x;
      packet.y = y;
      packet.to = to;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void transferItemTo(Unit unit, Item item, int amount, float x, float y,
      Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.transferItemTo(unit, item, amount, x, y, build);
    }
    if(mindustry.Vars.net.server()) {
      TransferItemToCallPacket packet = new TransferItemToCallPacket();
      packet.unit = unit;
      packet.item = item;
      packet.amount = amount;
      packet.x = x;
      packet.y = y;
      packet.build = build;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void transferItemToUnit(Item item, float x, float y, Itemsc to) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.transferItemToUnit(item, x, y, to);
    }
    if(mindustry.Vars.net.server()) {
      TransferItemToUnitCallPacket packet = new TransferItemToUnitCallPacket();
      packet.item = item;
      packet.x = x;
      packet.y = y;
      packet.to = to;
      mindustry.Vars.net.send(packet, false);
    }
  }

  public static void unitBlockSpawn(Tile tile) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.world.blocks.units.UnitBlock.unitBlockSpawn(tile);
    }
    if(mindustry.Vars.net.server()) {
      UnitBlockSpawnCallPacket packet = new UnitBlockSpawnCallPacket();
      packet.tile = tile;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitBuildingControlSelect(Unit unit, Building build) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.unitBuildingControlSelect(unit, build);
    }
    if(mindustry.Vars.net.server()) {
      UnitBuildingControlSelectCallPacket packet = new UnitBuildingControlSelectCallPacket();
      packet.unit = unit;
      packet.build = build;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitCapDeath(Unit unit) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.entities.Units.unitCapDeath(unit);
    }
    if(mindustry.Vars.net.server()) {
      UnitCapDeathCallPacket packet = new UnitCapDeathCallPacket();
      packet.unit = unit;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitClear(Player player) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.input.InputHandler.unitClear(player);
    }
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      UnitClearCallPacket packet = new UnitClearCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void unitClear__forward(NetConnection exceptConnection, Player player) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      UnitClearCallPacket packet = new UnitClearCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitControl(Player player, Unit unit) {
    mindustry.input.InputHandler.unitControl(player, unit);
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      UnitControlCallPacket packet = new UnitControlCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.unit = unit;
      mindustry.Vars.net.send(packet, true);
    }
  }

  static void unitControl__forward(NetConnection exceptConnection, Player player, Unit unit) {
    if(mindustry.Vars.net.server() || mindustry.Vars.net.client()) {
      UnitControlCallPacket packet = new UnitControlCallPacket();
      if(mindustry.Vars.net.server()) {
        packet.player = player;
      }
      packet.unit = unit;
      mindustry.Vars.net.sendExcept(exceptConnection, packet, true);
    }
  }

  public static void unitDeath(int uid) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.entities.Units.unitDeath(uid);
    }
    if(mindustry.Vars.net.server()) {
      UnitDeathCallPacket packet = new UnitDeathCallPacket();
      packet.uid = uid;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitDespawn(Unit unit) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.entities.Units.unitDespawn(unit);
    }
    if(mindustry.Vars.net.server()) {
      UnitDespawnCallPacket packet = new UnitDespawnCallPacket();
      packet.unit = unit;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitDestroy(int uid) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.entities.Units.unitDestroy(uid);
    }
    if(mindustry.Vars.net.server()) {
      UnitDestroyCallPacket packet = new UnitDestroyCallPacket();
      packet.uid = uid;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void unitEnvDeath(Unit unit) {
    if(mindustry.Vars.net.server() || !mindustry.Vars.net.active()) {
      mindustry.entities.Units.unitEnvDeath(unit);
    }
    if(mindustry.Vars.net.server()) {
      UnitEnvDeathCallPacket packet = new UnitEnvDeathCallPacket();
      packet.unit = unit;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void updateGameOver(Team winner) {
    mindustry.core.Logic.updateGameOver(winner);
    if(mindustry.Vars.net.server()) {
      UpdateGameOverCallPacket packet = new UpdateGameOverCallPacket();
      packet.winner = winner;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void warningToast(int unicode, String text) {
    if(mindustry.Vars.net.server()) {
      WarningToastCallPacket packet = new WarningToastCallPacket();
      packet.unicode = unicode;
      packet.text = text;
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void warningToast(NetConnection playerConnection, int unicode, String text) {
    if(mindustry.Vars.net.server()) {
      WarningToastCallPacket packet = new WarningToastCallPacket();
      packet.unicode = unicode;
      packet.text = text;
      playerConnection.send(packet, true);
    }
  }

  public static void worldDataBegin() {
    if(mindustry.Vars.net.server()) {
      WorldDataBeginCallPacket packet = new WorldDataBeginCallPacket();
      mindustry.Vars.net.send(packet, true);
    }
  }

  public static void worldDataBegin(NetConnection playerConnection) {
    if(mindustry.Vars.net.server()) {
      WorldDataBeginCallPacket packet = new WorldDataBeginCallPacket();
      playerConnection.send(packet, true);
    }
  }

  public static void registerPackets() {
    mindustry.net.Net.registerPacket(mindustry.gen.AdminRequestCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.AnnounceCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.AssemblerDroneSpawnedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.AssemblerUnitSpawnedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.AutoDoorToggleCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.BeginBreakCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.BeginPlaceCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.BlockSnapshotCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.BuildDestroyedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.BuildHealthUpdateCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.BuildingControlSelectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.CargoLoaderDroneSpawnedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ClearItemsCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ClientPacketReliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ClientPacketUnreliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ClientSnapshotCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.CommandBuildingCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.CommandUnitsCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ConnectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ConnectConfirmCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ConstructFinishCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.CreateBulletCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.CreateWeatherCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.DebugStatusClientCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.DebugStatusClientUnreliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.DeconstructFinishCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.DeletePlansCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.DropItemCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.EffectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.EffectCallPacket2::new);
    mindustry.net.Net.registerPacket(mindustry.gen.EffectReliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.EntitySnapshotCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.GameOverCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.HiddenSnapshotCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.HideHudTextCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.InfoMessageCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.InfoPopupCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.InfoPopupReliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.InfoToastCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.KickCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.KickCallPacket2::new);
    mindustry.net.Net.registerPacket(mindustry.gen.LabelCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.LabelReliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.LogicExplosionCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.MenuCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.MenuChooseCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.OpenURICallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PayloadDroppedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PickedBuildPayloadCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PickedUnitPayloadCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PingCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PingResponseCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PlayerDisconnectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.PlayerSpawnCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RemoveQueueBlockCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RemoveTileCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RemoveWorldLabelCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RequestBuildPayloadCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RequestDebugStatusCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RequestDropPayloadCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RequestItemCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RequestUnitPayloadCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ResearchedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.RotateBlockCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SectorCaptureCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SectorProducedCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SendChatMessageCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SendMessageCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SendMessageCallPacket2::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ServerPacketReliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.ServerPacketUnreliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetCameraPositionCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetFloorCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetHudTextCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetHudTextReliableCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetItemCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetMapAreaCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetObjectivesCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetOverlayCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetPlayerTeamEditorCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetPositionCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetRulesCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetTeamCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetTileCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SetUnitCommandCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SoundCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SoundAtCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.SpawnEffectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.StateSnapshotCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TakeItemsCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TileConfigCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TileTapCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TraceInfoCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TransferInventoryCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TransferItemEffectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TransferItemToCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.TransferItemToUnitCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitBlockSpawnCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitBuildingControlSelectCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitCapDeathCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitClearCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitControlCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitDeathCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitDespawnCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitDestroyCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UnitEnvDeathCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.UpdateGameOverCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.WarningToastCallPacket::new);
    mindustry.net.Net.registerPacket(mindustry.gen.WorldDataBeginCallPacket::new);
  }
}
