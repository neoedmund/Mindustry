package mindustry.gen;

import arc.Core;
import arc.audio.Sound;
import arc.struct.IntMap;
import arc.struct.ObjectIntMap;

public class Sounds {
  private static IntMap idToSound = new IntMap();

  private static ObjectIntMap soundToId = new ObjectIntMap();

  public static Sound artillery = new arc.audio.Sound();

  public static Sound back = new arc.audio.Sound();

  public static Sound bang = new arc.audio.Sound();

  public static Sound beam = new arc.audio.Sound();

  public static Sound bigshot = new arc.audio.Sound();

  public static Sound bioLoop = new arc.audio.Sound();

  public static Sound blaster = new arc.audio.Sound();

  public static Sound bolt = new arc.audio.Sound();

  public static Sound boom = new arc.audio.Sound();

  public static Sound breaks = new arc.audio.Sound();

  public static Sound build = new arc.audio.Sound();

  public static Sound buttonClick = new arc.audio.Sound();

  public static Sound cannon = new arc.audio.Sound();

  public static Sound chatMessage = new arc.audio.Sound();

  public static Sound click = new arc.audio.Sound();

  public static Sound combustion = new arc.audio.Sound();

  public static Sound conveyor = new arc.audio.Sound();

  public static Sound corexplode = new arc.audio.Sound();

  public static Sound cutter = new arc.audio.Sound();

  public static Sound door = new arc.audio.Sound();

  public static Sound drill = new arc.audio.Sound();

  public static Sound drillCharge = new arc.audio.Sound();

  public static Sound drillImpact = new arc.audio.Sound();

  public static Sound dullExplosion = new arc.audio.Sound();

  public static Sound electricHum = new arc.audio.Sound();

  public static Sound explosion = new arc.audio.Sound();

  public static Sound explosionbig = new arc.audio.Sound();

  public static Sound extractLoop = new arc.audio.Sound();

  public static Sound fire = new arc.audio.Sound();

  public static Sound flame = new arc.audio.Sound();

  public static Sound flame2 = new arc.audio.Sound();

  public static Sound flux = new arc.audio.Sound();

  public static Sound glow = new arc.audio.Sound();

  public static Sound grinding = new arc.audio.Sound();

  public static Sound hum = new arc.audio.Sound();

  public static Sound largeCannon = new arc.audio.Sound();

  public static Sound largeExplosion = new arc.audio.Sound();

  public static Sound laser = new arc.audio.Sound();

  public static Sound laserbeam = new arc.audio.Sound();

  public static Sound laserbig = new arc.audio.Sound();

  public static Sound laserblast = new arc.audio.Sound();

  public static Sound lasercharge = new arc.audio.Sound();

  public static Sound lasercharge2 = new arc.audio.Sound();

  public static Sound lasershoot = new arc.audio.Sound();

  public static Sound machine = new arc.audio.Sound();

  public static Sound malignShoot = new arc.audio.Sound();

  public static Sound mediumCannon = new arc.audio.Sound();

  public static Sound message = new arc.audio.Sound();

  public static Sound mineDeploy = new arc.audio.Sound();

  public static Sound minebeam = new arc.audio.Sound();

  public static Sound missile = new arc.audio.Sound();

  public static Sound missileLarge = new arc.audio.Sound();

  public static Sound missileLaunch = new arc.audio.Sound();

  public static Sound missileSmall = new arc.audio.Sound();

  public static Sound missileTrail = new arc.audio.Sound();

  public static Sound mud = new arc.audio.Sound();

  public static Sound noammo = new arc.audio.Sound();

  public static Sound pew = new arc.audio.Sound();

  public static Sound place = new arc.audio.Sound();

  public static Sound plantBreak = new arc.audio.Sound();

  public static Sound plasmaboom = new arc.audio.Sound();

  public static Sound plasmadrop = new arc.audio.Sound();

  public static Sound press = new arc.audio.Sound();

  public static Sound pulse = new arc.audio.Sound();

  public static Sound pulseBlast = new arc.audio.Sound();

  public static Sound railgun = new arc.audio.Sound();

  public static Sound rain = new arc.audio.Sound();

  public static Sound release = new arc.audio.Sound();

  public static Sound respawn = new arc.audio.Sound();

  public static Sound respawning = new arc.audio.Sound();

  public static Sound rockBreak = new arc.audio.Sound();

  public static Sound sap = new arc.audio.Sound();

  public static Sound shield = new arc.audio.Sound();

  public static Sound shockBlast = new arc.audio.Sound();

  public static Sound shoot = new arc.audio.Sound();

  public static Sound shootAlt = new arc.audio.Sound();

  public static Sound shootAltLong = new arc.audio.Sound();

  public static Sound shootBig = new arc.audio.Sound();

  public static Sound shootSmite = new arc.audio.Sound();

  public static Sound shootSnap = new arc.audio.Sound();

  public static Sound shotgun = new arc.audio.Sound();

  public static Sound smelter = new arc.audio.Sound();

  public static Sound spark = new arc.audio.Sound();

  public static Sound spellLoop = new arc.audio.Sound();

  public static Sound splash = new arc.audio.Sound();

  public static Sound spray = new arc.audio.Sound();

  public static Sound steam = new arc.audio.Sound();

  public static Sound swish = new arc.audio.Sound();

  public static Sound techloop = new arc.audio.Sound();

  public static Sound thruster = new arc.audio.Sound();

  public static Sound titanExplosion = new arc.audio.Sound();

  public static Sound torch = new arc.audio.Sound();

  public static Sound tractorbeam = new arc.audio.Sound();

  public static Sound unlock = new arc.audio.Sound();

  public static Sound wave = new arc.audio.Sound();

  public static Sound wind = new arc.audio.Sound();

  public static Sound wind2 = new arc.audio.Sound();

  public static Sound wind3 = new arc.audio.Sound();

  public static Sound windhowl = new arc.audio.Sound();

  public static Sound none = new arc.audio.Sound();

  static {
    soundToId.put(artillery, 0);
    soundToId.put(back, 1);
    soundToId.put(bang, 2);
    soundToId.put(beam, 3);
    soundToId.put(bigshot, 4);
    soundToId.put(bioLoop, 5);
    soundToId.put(blaster, 6);
    soundToId.put(bolt, 7);
    soundToId.put(boom, 8);
    soundToId.put(breaks, 9);
    soundToId.put(build, 10);
    soundToId.put(buttonClick, 11);
    soundToId.put(cannon, 12);
    soundToId.put(chatMessage, 13);
    soundToId.put(click, 14);
    soundToId.put(combustion, 15);
    soundToId.put(conveyor, 16);
    soundToId.put(corexplode, 17);
    soundToId.put(cutter, 18);
    soundToId.put(door, 19);
    soundToId.put(drill, 20);
    soundToId.put(drillCharge, 21);
    soundToId.put(drillImpact, 22);
    soundToId.put(dullExplosion, 23);
    soundToId.put(electricHum, 24);
    soundToId.put(explosion, 25);
    soundToId.put(explosionbig, 26);
    soundToId.put(extractLoop, 27);
    soundToId.put(fire, 28);
    soundToId.put(flame, 29);
    soundToId.put(flame2, 30);
    soundToId.put(flux, 31);
    soundToId.put(glow, 32);
    soundToId.put(grinding, 33);
    soundToId.put(hum, 34);
    soundToId.put(largeCannon, 35);
    soundToId.put(largeExplosion, 36);
    soundToId.put(laser, 37);
    soundToId.put(laserbeam, 38);
    soundToId.put(laserbig, 39);
    soundToId.put(laserblast, 40);
    soundToId.put(lasercharge, 41);
    soundToId.put(lasercharge2, 42);
    soundToId.put(lasershoot, 43);
    soundToId.put(machine, 44);
    soundToId.put(malignShoot, 45);
    soundToId.put(mediumCannon, 46);
    soundToId.put(message, 47);
    soundToId.put(mineDeploy, 48);
    soundToId.put(minebeam, 49);
    soundToId.put(missile, 50);
    soundToId.put(missileLarge, 51);
    soundToId.put(missileLaunch, 52);
    soundToId.put(missileSmall, 53);
    soundToId.put(missileTrail, 54);
    soundToId.put(mud, 55);
    soundToId.put(noammo, 56);
    soundToId.put(pew, 57);
    soundToId.put(place, 58);
    soundToId.put(plantBreak, 59);
    soundToId.put(plasmaboom, 60);
    soundToId.put(plasmadrop, 61);
    soundToId.put(press, 62);
    soundToId.put(pulse, 63);
    soundToId.put(pulseBlast, 64);
    soundToId.put(railgun, 65);
    soundToId.put(rain, 66);
    soundToId.put(release, 67);
    soundToId.put(respawn, 68);
    soundToId.put(respawning, 69);
    soundToId.put(rockBreak, 70);
    soundToId.put(sap, 71);
    soundToId.put(shield, 72);
    soundToId.put(shockBlast, 73);
    soundToId.put(shoot, 74);
    soundToId.put(shootAlt, 75);
    soundToId.put(shootAltLong, 76);
    soundToId.put(shootBig, 77);
    soundToId.put(shootSmite, 78);
    soundToId.put(shootSnap, 79);
    soundToId.put(shotgun, 80);
    soundToId.put(smelter, 81);
    soundToId.put(spark, 82);
    soundToId.put(spellLoop, 83);
    soundToId.put(splash, 84);
    soundToId.put(spray, 85);
    soundToId.put(steam, 86);
    soundToId.put(swish, 87);
    soundToId.put(techloop, 88);
    soundToId.put(thruster, 89);
    soundToId.put(titanExplosion, 90);
    soundToId.put(torch, 91);
    soundToId.put(tractorbeam, 92);
    soundToId.put(unlock, 93);
    soundToId.put(wave, 94);
    soundToId.put(wind, 95);
    soundToId.put(wind2, 96);
    soundToId.put(wind3, 97);
    soundToId.put(windhowl, 98);
  }

  public static int getSoundId(Sound sound) {
    return soundToId.get(sound, -1);
  }

  public static Sound getSound(int id) {
    return (Sound)idToSound.get(id, () -> Sounds.none);
  }

  public static void load() {
    Core.assets.load("sounds/artillery.ogg", arc.audio.Sound.class).loaded = a -> { artillery = (arc.audio.Sound)a; soundToId.put(a, 0); idToSound.put(0, a); };
    Core.assets.load("sounds/ui/back.ogg", arc.audio.Sound.class).loaded = a -> { back = (arc.audio.Sound)a; soundToId.put(a, 1); idToSound.put(1, a); };
    Core.assets.load("sounds/bang.ogg", arc.audio.Sound.class).loaded = a -> { bang = (arc.audio.Sound)a; soundToId.put(a, 2); idToSound.put(2, a); };
    Core.assets.load("sounds/beam.ogg", arc.audio.Sound.class).loaded = a -> { beam = (arc.audio.Sound)a; soundToId.put(a, 3); idToSound.put(3, a); };
    Core.assets.load("sounds/bigshot.ogg", arc.audio.Sound.class).loaded = a -> { bigshot = (arc.audio.Sound)a; soundToId.put(a, 4); idToSound.put(4, a); };
    Core.assets.load("sounds/bioLoop.ogg", arc.audio.Sound.class).loaded = a -> { bioLoop = (arc.audio.Sound)a; soundToId.put(a, 5); idToSound.put(5, a); };
    Core.assets.load("sounds/blaster.ogg", arc.audio.Sound.class).loaded = a -> { blaster = (arc.audio.Sound)a; soundToId.put(a, 6); idToSound.put(6, a); };
    Core.assets.load("sounds/bolt.ogg", arc.audio.Sound.class).loaded = a -> { bolt = (arc.audio.Sound)a; soundToId.put(a, 7); idToSound.put(7, a); };
    Core.assets.load("sounds/boom.ogg", arc.audio.Sound.class).loaded = a -> { boom = (arc.audio.Sound)a; soundToId.put(a, 8); idToSound.put(8, a); };
    Core.assets.load("sounds/break.ogg", arc.audio.Sound.class).loaded = a -> { breaks = (arc.audio.Sound)a; soundToId.put(a, 9); idToSound.put(9, a); };
    Core.assets.load("sounds/build.ogg", arc.audio.Sound.class).loaded = a -> { build = (arc.audio.Sound)a; soundToId.put(a, 10); idToSound.put(10, a); };
    Core.assets.load("sounds/buttonClick.ogg", arc.audio.Sound.class).loaded = a -> { buttonClick = (arc.audio.Sound)a; soundToId.put(a, 11); idToSound.put(11, a); };
    Core.assets.load("sounds/cannon.ogg", arc.audio.Sound.class).loaded = a -> { cannon = (arc.audio.Sound)a; soundToId.put(a, 12); idToSound.put(12, a); };
    Core.assets.load("sounds/ui/chatMessage.ogg", arc.audio.Sound.class).loaded = a -> { chatMessage = (arc.audio.Sound)a; soundToId.put(a, 13); idToSound.put(13, a); };
    Core.assets.load("sounds/click.ogg", arc.audio.Sound.class).loaded = a -> { click = (arc.audio.Sound)a; soundToId.put(a, 14); idToSound.put(14, a); };
    Core.assets.load("sounds/combustion.ogg", arc.audio.Sound.class).loaded = a -> { combustion = (arc.audio.Sound)a; soundToId.put(a, 15); idToSound.put(15, a); };
    Core.assets.load("sounds/conveyor.ogg", arc.audio.Sound.class).loaded = a -> { conveyor = (arc.audio.Sound)a; soundToId.put(a, 16); idToSound.put(16, a); };
    Core.assets.load("sounds/corexplode.ogg", arc.audio.Sound.class).loaded = a -> { corexplode = (arc.audio.Sound)a; soundToId.put(a, 17); idToSound.put(17, a); };
    Core.assets.load("sounds/cutter.ogg", arc.audio.Sound.class).loaded = a -> { cutter = (arc.audio.Sound)a; soundToId.put(a, 18); idToSound.put(18, a); };
    Core.assets.load("sounds/door.ogg", arc.audio.Sound.class).loaded = a -> { door = (arc.audio.Sound)a; soundToId.put(a, 19); idToSound.put(19, a); };
    Core.assets.load("sounds/drill.ogg", arc.audio.Sound.class).loaded = a -> { drill = (arc.audio.Sound)a; soundToId.put(a, 20); idToSound.put(20, a); };
    Core.assets.load("sounds/drillCharge.ogg", arc.audio.Sound.class).loaded = a -> { drillCharge = (arc.audio.Sound)a; soundToId.put(a, 21); idToSound.put(21, a); };
    Core.assets.load("sounds/drillImpact.ogg", arc.audio.Sound.class).loaded = a -> { drillImpact = (arc.audio.Sound)a; soundToId.put(a, 22); idToSound.put(22, a); };
    Core.assets.load("sounds/dullExplosion.ogg", arc.audio.Sound.class).loaded = a -> { dullExplosion = (arc.audio.Sound)a; soundToId.put(a, 23); idToSound.put(23, a); };
    Core.assets.load("sounds/electricHum.ogg", arc.audio.Sound.class).loaded = a -> { electricHum = (arc.audio.Sound)a; soundToId.put(a, 24); idToSound.put(24, a); };
    Core.assets.load("sounds/explosion.ogg", arc.audio.Sound.class).loaded = a -> { explosion = (arc.audio.Sound)a; soundToId.put(a, 25); idToSound.put(25, a); };
    Core.assets.load("sounds/explosionbig.ogg", arc.audio.Sound.class).loaded = a -> { explosionbig = (arc.audio.Sound)a; soundToId.put(a, 26); idToSound.put(26, a); };
    Core.assets.load("sounds/extractLoop.ogg", arc.audio.Sound.class).loaded = a -> { extractLoop = (arc.audio.Sound)a; soundToId.put(a, 27); idToSound.put(27, a); };
    Core.assets.load("sounds/fire.ogg", arc.audio.Sound.class).loaded = a -> { fire = (arc.audio.Sound)a; soundToId.put(a, 28); idToSound.put(28, a); };
    Core.assets.load("sounds/flame.ogg", arc.audio.Sound.class).loaded = a -> { flame = (arc.audio.Sound)a; soundToId.put(a, 29); idToSound.put(29, a); };
    Core.assets.load("sounds/flame2.ogg", arc.audio.Sound.class).loaded = a -> { flame2 = (arc.audio.Sound)a; soundToId.put(a, 30); idToSound.put(30, a); };
    Core.assets.load("sounds/flux.ogg", arc.audio.Sound.class).loaded = a -> { flux = (arc.audio.Sound)a; soundToId.put(a, 31); idToSound.put(31, a); };
    Core.assets.load("sounds/glow.ogg", arc.audio.Sound.class).loaded = a -> { glow = (arc.audio.Sound)a; soundToId.put(a, 32); idToSound.put(32, a); };
    Core.assets.load("sounds/grinding.ogg", arc.audio.Sound.class).loaded = a -> { grinding = (arc.audio.Sound)a; soundToId.put(a, 33); idToSound.put(33, a); };
    Core.assets.load("sounds/hum.ogg", arc.audio.Sound.class).loaded = a -> { hum = (arc.audio.Sound)a; soundToId.put(a, 34); idToSound.put(34, a); };
    Core.assets.load("sounds/largeCannon.ogg", arc.audio.Sound.class).loaded = a -> { largeCannon = (arc.audio.Sound)a; soundToId.put(a, 35); idToSound.put(35, a); };
    Core.assets.load("sounds/largeExplosion.ogg", arc.audio.Sound.class).loaded = a -> { largeExplosion = (arc.audio.Sound)a; soundToId.put(a, 36); idToSound.put(36, a); };
    Core.assets.load("sounds/laser.ogg", arc.audio.Sound.class).loaded = a -> { laser = (arc.audio.Sound)a; soundToId.put(a, 37); idToSound.put(37, a); };
    Core.assets.load("sounds/laserbeam.ogg", arc.audio.Sound.class).loaded = a -> { laserbeam = (arc.audio.Sound)a; soundToId.put(a, 38); idToSound.put(38, a); };
    Core.assets.load("sounds/laserbig.ogg", arc.audio.Sound.class).loaded = a -> { laserbig = (arc.audio.Sound)a; soundToId.put(a, 39); idToSound.put(39, a); };
    Core.assets.load("sounds/laserblast.ogg", arc.audio.Sound.class).loaded = a -> { laserblast = (arc.audio.Sound)a; soundToId.put(a, 40); idToSound.put(40, a); };
    Core.assets.load("sounds/lasercharge.ogg", arc.audio.Sound.class).loaded = a -> { lasercharge = (arc.audio.Sound)a; soundToId.put(a, 41); idToSound.put(41, a); };
    Core.assets.load("sounds/lasercharge2.ogg", arc.audio.Sound.class).loaded = a -> { lasercharge2 = (arc.audio.Sound)a; soundToId.put(a, 42); idToSound.put(42, a); };
    Core.assets.load("sounds/lasershoot.ogg", arc.audio.Sound.class).loaded = a -> { lasershoot = (arc.audio.Sound)a; soundToId.put(a, 43); idToSound.put(43, a); };
    Core.assets.load("sounds/machine.ogg", arc.audio.Sound.class).loaded = a -> { machine = (arc.audio.Sound)a; soundToId.put(a, 44); idToSound.put(44, a); };
    Core.assets.load("sounds/malignShoot.ogg", arc.audio.Sound.class).loaded = a -> { malignShoot = (arc.audio.Sound)a; soundToId.put(a, 45); idToSound.put(45, a); };
    Core.assets.load("sounds/mediumCannon.ogg", arc.audio.Sound.class).loaded = a -> { mediumCannon = (arc.audio.Sound)a; soundToId.put(a, 46); idToSound.put(46, a); };
    Core.assets.load("sounds/ui/message.ogg", arc.audio.Sound.class).loaded = a -> { message = (arc.audio.Sound)a; soundToId.put(a, 47); idToSound.put(47, a); };
    Core.assets.load("sounds/mineDeploy.ogg", arc.audio.Sound.class).loaded = a -> { mineDeploy = (arc.audio.Sound)a; soundToId.put(a, 48); idToSound.put(48, a); };
    Core.assets.load("sounds/minebeam.ogg", arc.audio.Sound.class).loaded = a -> { minebeam = (arc.audio.Sound)a; soundToId.put(a, 49); idToSound.put(49, a); };
    Core.assets.load("sounds/missile.ogg", arc.audio.Sound.class).loaded = a -> { missile = (arc.audio.Sound)a; soundToId.put(a, 50); idToSound.put(50, a); };
    Core.assets.load("sounds/missileLarge.ogg", arc.audio.Sound.class).loaded = a -> { missileLarge = (arc.audio.Sound)a; soundToId.put(a, 51); idToSound.put(51, a); };
    Core.assets.load("sounds/missileLaunch.ogg", arc.audio.Sound.class).loaded = a -> { missileLaunch = (arc.audio.Sound)a; soundToId.put(a, 52); idToSound.put(52, a); };
    Core.assets.load("sounds/missileSmall.ogg", arc.audio.Sound.class).loaded = a -> { missileSmall = (arc.audio.Sound)a; soundToId.put(a, 53); idToSound.put(53, a); };
    Core.assets.load("sounds/missileTrail.ogg", arc.audio.Sound.class).loaded = a -> { missileTrail = (arc.audio.Sound)a; soundToId.put(a, 54); idToSound.put(54, a); };
    Core.assets.load("sounds/mud.ogg", arc.audio.Sound.class).loaded = a -> { mud = (arc.audio.Sound)a; soundToId.put(a, 55); idToSound.put(55, a); };
    Core.assets.load("sounds/noammo.ogg", arc.audio.Sound.class).loaded = a -> { noammo = (arc.audio.Sound)a; soundToId.put(a, 56); idToSound.put(56, a); };
    Core.assets.load("sounds/pew.ogg", arc.audio.Sound.class).loaded = a -> { pew = (arc.audio.Sound)a; soundToId.put(a, 57); idToSound.put(57, a); };
    Core.assets.load("sounds/place.ogg", arc.audio.Sound.class).loaded = a -> { place = (arc.audio.Sound)a; soundToId.put(a, 58); idToSound.put(58, a); };
    Core.assets.load("sounds/plantBreak.ogg", arc.audio.Sound.class).loaded = a -> { plantBreak = (arc.audio.Sound)a; soundToId.put(a, 59); idToSound.put(59, a); };
    Core.assets.load("sounds/plasmaboom.ogg", arc.audio.Sound.class).loaded = a -> { plasmaboom = (arc.audio.Sound)a; soundToId.put(a, 60); idToSound.put(60, a); };
    Core.assets.load("sounds/plasmadrop.ogg", arc.audio.Sound.class).loaded = a -> { plasmadrop = (arc.audio.Sound)a; soundToId.put(a, 61); idToSound.put(61, a); };
    Core.assets.load("sounds/ui/press.ogg", arc.audio.Sound.class).loaded = a -> { press = (arc.audio.Sound)a; soundToId.put(a, 62); idToSound.put(62, a); };
    Core.assets.load("sounds/pulse.ogg", arc.audio.Sound.class).loaded = a -> { pulse = (arc.audio.Sound)a; soundToId.put(a, 63); idToSound.put(63, a); };
    Core.assets.load("sounds/pulseBlast.ogg", arc.audio.Sound.class).loaded = a -> { pulseBlast = (arc.audio.Sound)a; soundToId.put(a, 64); idToSound.put(64, a); };
    Core.assets.load("sounds/railgun.ogg", arc.audio.Sound.class).loaded = a -> { railgun = (arc.audio.Sound)a; soundToId.put(a, 65); idToSound.put(65, a); };
    Core.assets.load("sounds/rain.ogg", arc.audio.Sound.class).loaded = a -> { rain = (arc.audio.Sound)a; soundToId.put(a, 66); idToSound.put(66, a); };
    Core.assets.load("sounds/release.ogg", arc.audio.Sound.class).loaded = a -> { release = (arc.audio.Sound)a; soundToId.put(a, 67); idToSound.put(67, a); };
    Core.assets.load("sounds/respawn.ogg", arc.audio.Sound.class).loaded = a -> { respawn = (arc.audio.Sound)a; soundToId.put(a, 68); idToSound.put(68, a); };
    Core.assets.load("sounds/respawning.ogg", arc.audio.Sound.class).loaded = a -> { respawning = (arc.audio.Sound)a; soundToId.put(a, 69); idToSound.put(69, a); };
    Core.assets.load("sounds/rockBreak.ogg", arc.audio.Sound.class).loaded = a -> { rockBreak = (arc.audio.Sound)a; soundToId.put(a, 70); idToSound.put(70, a); };
    Core.assets.load("sounds/sap.ogg", arc.audio.Sound.class).loaded = a -> { sap = (arc.audio.Sound)a; soundToId.put(a, 71); idToSound.put(71, a); };
    Core.assets.load("sounds/shield.ogg", arc.audio.Sound.class).loaded = a -> { shield = (arc.audio.Sound)a; soundToId.put(a, 72); idToSound.put(72, a); };
    Core.assets.load("sounds/shockBlast.ogg", arc.audio.Sound.class).loaded = a -> { shockBlast = (arc.audio.Sound)a; soundToId.put(a, 73); idToSound.put(73, a); };
    Core.assets.load("sounds/shoot.ogg", arc.audio.Sound.class).loaded = a -> { shoot = (arc.audio.Sound)a; soundToId.put(a, 74); idToSound.put(74, a); };
    Core.assets.load("sounds/shootAlt.ogg", arc.audio.Sound.class).loaded = a -> { shootAlt = (arc.audio.Sound)a; soundToId.put(a, 75); idToSound.put(75, a); };
    Core.assets.load("sounds/shootAltLong.ogg", arc.audio.Sound.class).loaded = a -> { shootAltLong = (arc.audio.Sound)a; soundToId.put(a, 76); idToSound.put(76, a); };
    Core.assets.load("sounds/shootBig.ogg", arc.audio.Sound.class).loaded = a -> { shootBig = (arc.audio.Sound)a; soundToId.put(a, 77); idToSound.put(77, a); };
    Core.assets.load("sounds/shootSmite.ogg", arc.audio.Sound.class).loaded = a -> { shootSmite = (arc.audio.Sound)a; soundToId.put(a, 78); idToSound.put(78, a); };
    Core.assets.load("sounds/shootSnap.ogg", arc.audio.Sound.class).loaded = a -> { shootSnap = (arc.audio.Sound)a; soundToId.put(a, 79); idToSound.put(79, a); };
    Core.assets.load("sounds/shotgun.ogg", arc.audio.Sound.class).loaded = a -> { shotgun = (arc.audio.Sound)a; soundToId.put(a, 80); idToSound.put(80, a); };
    Core.assets.load("sounds/smelter.ogg", arc.audio.Sound.class).loaded = a -> { smelter = (arc.audio.Sound)a; soundToId.put(a, 81); idToSound.put(81, a); };
    Core.assets.load("sounds/spark.ogg", arc.audio.Sound.class).loaded = a -> { spark = (arc.audio.Sound)a; soundToId.put(a, 82); idToSound.put(82, a); };
    Core.assets.load("sounds/spellLoop.ogg", arc.audio.Sound.class).loaded = a -> { spellLoop = (arc.audio.Sound)a; soundToId.put(a, 83); idToSound.put(83, a); };
    Core.assets.load("sounds/splash.ogg", arc.audio.Sound.class).loaded = a -> { splash = (arc.audio.Sound)a; soundToId.put(a, 84); idToSound.put(84, a); };
    Core.assets.load("sounds/spray.ogg", arc.audio.Sound.class).loaded = a -> { spray = (arc.audio.Sound)a; soundToId.put(a, 85); idToSound.put(85, a); };
    Core.assets.load("sounds/steam.ogg", arc.audio.Sound.class).loaded = a -> { steam = (arc.audio.Sound)a; soundToId.put(a, 86); idToSound.put(86, a); };
    Core.assets.load("sounds/swish.ogg", arc.audio.Sound.class).loaded = a -> { swish = (arc.audio.Sound)a; soundToId.put(a, 87); idToSound.put(87, a); };
    Core.assets.load("sounds/techloop.ogg", arc.audio.Sound.class).loaded = a -> { techloop = (arc.audio.Sound)a; soundToId.put(a, 88); idToSound.put(88, a); };
    Core.assets.load("sounds/thruster.ogg", arc.audio.Sound.class).loaded = a -> { thruster = (arc.audio.Sound)a; soundToId.put(a, 89); idToSound.put(89, a); };
    Core.assets.load("sounds/titanExplosion.ogg", arc.audio.Sound.class).loaded = a -> { titanExplosion = (arc.audio.Sound)a; soundToId.put(a, 90); idToSound.put(90, a); };
    Core.assets.load("sounds/torch.ogg", arc.audio.Sound.class).loaded = a -> { torch = (arc.audio.Sound)a; soundToId.put(a, 91); idToSound.put(91, a); };
    Core.assets.load("sounds/tractorbeam.ogg", arc.audio.Sound.class).loaded = a -> { tractorbeam = (arc.audio.Sound)a; soundToId.put(a, 92); idToSound.put(92, a); };
    Core.assets.load("sounds/ui/unlock.ogg", arc.audio.Sound.class).loaded = a -> { unlock = (arc.audio.Sound)a; soundToId.put(a, 93); idToSound.put(93, a); };
    Core.assets.load("sounds/wave.ogg", arc.audio.Sound.class).loaded = a -> { wave = (arc.audio.Sound)a; soundToId.put(a, 94); idToSound.put(94, a); };
    Core.assets.load("sounds/wind.ogg", arc.audio.Sound.class).loaded = a -> { wind = (arc.audio.Sound)a; soundToId.put(a, 95); idToSound.put(95, a); };
    Core.assets.load("sounds/wind2.ogg", arc.audio.Sound.class).loaded = a -> { wind2 = (arc.audio.Sound)a; soundToId.put(a, 96); idToSound.put(96, a); };
    Core.assets.load("sounds/wind3.ogg", arc.audio.Sound.class).loaded = a -> { wind3 = (arc.audio.Sound)a; soundToId.put(a, 97); idToSound.put(97, a); };
    Core.assets.load("sounds/windhowl.ogg", arc.audio.Sound.class).loaded = a -> { windhowl = (arc.audio.Sound)a; soundToId.put(a, 98); idToSound.put(98, a); };
  }
}
