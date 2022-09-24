package mindustry.gen;

import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.util.Nullable;
import mindustry.annotations.Annotations;
import mindustry.entities.units.UnitController;
import mindustry.game.Team;
import mindustry.net.Administration;
import mindustry.net.NetConnection;
import mindustry.net.Packets;
import mindustry.world.blocks.storage.CoreBlock;

/**
 * Interface for {@link mindustry.entities.comp.PlayerComp}
 */
@Annotations.EntityInterface
@SuppressWarnings("deprecation")
public interface Playerc extends UnitController, Drawc, Entityc, Posc, Syncc, Timerc {
  /**
   * @return largest/closest core, with largest cores getting priority 
   */
  CoreBlock.CoreBuild bestCore();

  /**
   * @return name with a markup color prefix 
   */
  String coloredName();

  @Nullable
  Unit justSwitchFrom();

  @Nullable
  Unit justSwitchTo();

  @Nullable
  NetConnection con();

  Unit unit();

  Color color();

  TextureRegion icon();

  boolean admin();

  boolean boosting();

  boolean dead();

  boolean displayAmmo();

  boolean isBuilder();

  boolean isValidController();

  boolean shooting();

  boolean typing();

  float clipSize();

  float deathTimer();

  float mouseX();

  float mouseY();

  float textFadeTime();

  String ip();

  String lastText();

  String locale();

  String name();

  String plainName();

  String usid();

  String uuid();

  Team team();

  Administration.PlayerInfo getInfo();

  CoreBlock.CoreBuild closestCore();

  CoreBlock.CoreBuild core();

  void admin(boolean admin);

  void afterSync();

  void boosting(boolean boosting);

  void checkSpawn();

  void clearUnit();

  void color(Color color);

  void con(@Nullable NetConnection con);

  void deathTimer(float deathTimer);

  void draw();

  void justSwitchFrom(@Nullable Unit justSwitchFrom);

  void justSwitchTo(@Nullable Unit justSwitchTo);

  void kick(String reason);

  void kick(String reason, long duration);

  void kick(Packets.KickReason reason);

  void kick(Packets.KickReason reason, long duration);

  void lastText(String lastText);

  void locale(String locale);

  void mouseX(float mouseX);

  void mouseY(float mouseY);

  void name(String name);

  void remove();

  void reset();

  void sendMessage(String text);

  void sendMessage(String text, Player from);

  void sendMessage(String text, Player from, String unformatted);

  void shooting(boolean shooting);

  void team(Team team);

  void textFadeTime(float textFadeTime);

  void typing(boolean typing);

  void unit(Unit unit);

  void update();
}
