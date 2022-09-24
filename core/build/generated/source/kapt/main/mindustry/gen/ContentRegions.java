package mindustry.gen;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import mindustry.ctype.MappableContent;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.environment.Cliff;
import mindustry.world.blocks.liquid.Conduit;

@SuppressWarnings("deprecation")
public class ContentRegions {
  public static void loadRegions(MappableContent content) {
    if(content instanceof mindustry.world.blocks.campaign.Accelerator) {
      ((mindustry.world.blocks.campaign.Accelerator)content).arrowRegion = Core.atlas.find("launch-arrow");
    }
    if(content instanceof mindustry.world.blocks.defense.AutoDoor) {
      ((mindustry.world.blocks.defense.AutoDoor)content).openRegion = Core.atlas.find("" + content.name + "-open");
    }
    if(content instanceof mindustry.world.blocks.power.Battery) {
      ((mindustry.world.blocks.power.Battery)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.production.BeamDrill) {
      ((mindustry.world.blocks.production.BeamDrill)content).glowRegion = Core.atlas.find("" + content.name + "-glow");
      ((mindustry.world.blocks.production.BeamDrill)content).laser = Core.atlas.find("drill-laser");
      ((mindustry.world.blocks.production.BeamDrill)content).laserBoost = Core.atlas.find("drill-laser-boost");
      ((mindustry.world.blocks.production.BeamDrill)content).laserCenter = Core.atlas.find("drill-laser-center");
      ((mindustry.world.blocks.production.BeamDrill)content).laserCenterBoost = Core.atlas.find("drill-laser-boost-center");
      ((mindustry.world.blocks.production.BeamDrill)content).laserEnd = Core.atlas.find("drill-laser-end");
      ((mindustry.world.blocks.production.BeamDrill)content).laserEndBoost = Core.atlas.find("drill-laser-boost-end");
      ((mindustry.world.blocks.production.BeamDrill)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.power.BeamNode) {
      ((mindustry.world.blocks.power.BeamNode)content).laser = Core.atlas.find("power-beam");
      ((mindustry.world.blocks.power.BeamNode)content).laserEnd = Core.atlas.find("power-beam-end");
    }
    if(content instanceof mindustry.world.Block) {
      ((mindustry.world.Block)content).customShadowRegion = Core.atlas.find("" + content.name + "-shadow");
      ((mindustry.world.Block)content).teamRegion = Core.atlas.find("" + content.name + "-team");
    }
    if(content instanceof mindustry.world.blocks.defense.BuildTurret) {
      ((mindustry.world.blocks.defense.BuildTurret)content).baseRegion = Core.atlas.find("" + content.name + "-base", "block-" + ((mindustry.world.Block)content).size + "");
      ((mindustry.world.blocks.defense.BuildTurret)content).glowRegion = Core.atlas.find("" + content.name + "-glow");
    }
    if(content instanceof mindustry.world.blocks.production.BurstDrill) {
      ((mindustry.world.blocks.production.BurstDrill)content).arrowBlurRegion = Core.atlas.find("" + content.name + "-arrow-blur");
      ((mindustry.world.blocks.production.BurstDrill)content).arrowRegion = Core.atlas.find("" + content.name + "-arrow");
      ((mindustry.world.blocks.production.BurstDrill)content).glowRegion = Core.atlas.find("" + content.name + "-glow");
      ((mindustry.world.blocks.production.BurstDrill)content).topInvertRegion = Core.atlas.find("" + content.name + "-top-invert");
    }
    if(content instanceof mindustry.world.blocks.environment.Cliff) {
      ((Cliff)content).cliffs = new TextureRegion[256];
      for(int INDEX0 = 0; INDEX0 < 256; INDEX0 ++) {
        ((Cliff)content).cliffs[INDEX0] = Core.atlas.find("cliffmask" + INDEX0 + "");
      }
      ((Cliff)content).editorCliffs = new TextureRegion[256];
      for(int INDEX0 = 0; INDEX0 < 256; INDEX0 ++) {
        ((Cliff)content).editorCliffs[INDEX0] = Core.atlas.find("editor-cliffmask" + INDEX0 + "");
      }
    }
    if(content instanceof mindustry.world.blocks.liquid.Conduit) {
      ((Conduit)content).botRegions = new TextureRegion[5];
      for(int INDEX0 = 0; INDEX0 < 5; INDEX0 ++) {
        ((Conduit)content).botRegions[INDEX0] = Core.atlas.find("" + content.name + "-bottom-" + INDEX0 + "", "conduit-bottom-" + INDEX0 + "");
      }
      ((mindustry.world.blocks.liquid.Conduit)content).capRegion = Core.atlas.find("" + content.name + "-cap");
      ((Conduit)content).topRegions = new TextureRegion[5];
      for(int INDEX0 = 0; INDEX0 < 5; INDEX0 ++) {
        ((Conduit)content).topRegions[INDEX0] = Core.atlas.find("" + content.name + "-top-" + INDEX0 + "");
      }
    }
    if(content instanceof mindustry.world.blocks.distribution.Conveyor) {
      ((Conveyor)content).regions = new TextureRegion[7][4];
      for(int INDEX0 = 0; INDEX0 < 7; INDEX0 ++) {
        for(int INDEX1 = 0; INDEX1 < 4; INDEX1 ++) {
          ((Conveyor)content).regions[INDEX0][INDEX1] = Core.atlas.find("" + content.name + "-" + INDEX0 + "-" + INDEX1 + "");
        }
      }
    }
    if(content instanceof mindustry.world.blocks.storage.CoreBlock) {
      ((mindustry.world.blocks.storage.CoreBlock)content).thruster1 = Core.atlas.find("" + content.name + "-thruster1", "clear-effect");
      ((mindustry.world.blocks.storage.CoreBlock)content).thruster2 = Core.atlas.find("" + content.name + "-thruster2", "clear-effect");
    }
    if(content instanceof mindustry.world.blocks.distribution.DirectionBridge) {
      ((mindustry.world.blocks.distribution.DirectionBridge)content).arrowRegion = Core.atlas.find("" + content.name + "-arrow");
      ((mindustry.world.blocks.distribution.DirectionBridge)content).bridgeBotRegion = Core.atlas.find("" + content.name + "-bridge-bottom");
      ((mindustry.world.blocks.distribution.DirectionBridge)content).bridgeLiquidRegion = Core.atlas.find("" + content.name + "-bridge-liquid");
      ((mindustry.world.blocks.distribution.DirectionBridge)content).bridgeRegion = Core.atlas.find("" + content.name + "-bridge");
      ((mindustry.world.blocks.distribution.DirectionBridge)content).dirRegion = Core.atlas.find("" + content.name + "-dir");
    }
    if(content instanceof mindustry.world.blocks.distribution.DirectionLiquidBridge) {
      ((mindustry.world.blocks.distribution.DirectionLiquidBridge)content).bottomRegion = Core.atlas.find("" + content.name + "-bottom");
    }
    if(content instanceof mindustry.world.blocks.defense.DirectionalForceProjector) {
      ((mindustry.world.blocks.defense.DirectionalForceProjector)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.distribution.DirectionalUnloader) {
      ((mindustry.world.blocks.distribution.DirectionalUnloader)content).arrowRegion = Core.atlas.find("" + content.name + "-arrow");
      ((mindustry.world.blocks.distribution.DirectionalUnloader)content).centerRegion = Core.atlas.find("" + content.name + "-center", "unloader-center");
      ((mindustry.world.blocks.distribution.DirectionalUnloader)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.defense.Door) {
      ((mindustry.world.blocks.defense.Door)content).openRegion = Core.atlas.find("" + content.name + "-open");
    }
    if(content instanceof mindustry.world.blocks.production.Drill) {
      ((mindustry.world.blocks.production.Drill)content).itemRegion = Core.atlas.find("" + content.name + "-item", "drill-item-" + ((mindustry.world.Block)content).size + "");
      ((mindustry.world.blocks.production.Drill)content).rimRegion = Core.atlas.find("" + content.name + "-rim");
      ((mindustry.world.blocks.production.Drill)content).rotatorRegion = Core.atlas.find("" + content.name + "-rotator");
      ((mindustry.world.blocks.production.Drill)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.distribution.Duct) {
      ((Duct)content).botRegions = new TextureRegion[5];
      for(int INDEX0 = 0; INDEX0 < 5; INDEX0 ++) {
        ((Duct)content).botRegions[INDEX0] = Core.atlas.find("" + content.name + "-bottom-" + INDEX0 + "", "duct-bottom-" + INDEX0 + "");
      }
      ((Duct)content).topRegions = new TextureRegion[5];
      for(int INDEX0 = 0; INDEX0 < 5; INDEX0 ++) {
        ((Duct)content).topRegions[INDEX0] = Core.atlas.find("" + content.name + "-top-" + INDEX0 + "");
      }
    }
    if(content instanceof mindustry.world.blocks.distribution.DuctRouter) {
      ((mindustry.world.blocks.distribution.DuctRouter)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.defense.ForceProjector) {
      ((mindustry.world.blocks.defense.ForceProjector)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.distribution.ItemBridge) {
      ((mindustry.world.blocks.distribution.ItemBridge)content).arrowRegion = Core.atlas.find("" + content.name + "-arrow");
      ((mindustry.world.blocks.distribution.ItemBridge)content).bridgeRegion = Core.atlas.find("" + content.name + "-bridge");
      ((mindustry.world.blocks.distribution.ItemBridge)content).endRegion = Core.atlas.find("" + content.name + "-end");
    }
    if(content instanceof mindustry.world.blocks.production.ItemIncinerator) {
      ((mindustry.world.blocks.production.ItemIncinerator)content).liquidRegion = Core.atlas.find("" + content.name + "-liquid");
      ((mindustry.world.blocks.production.ItemIncinerator)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.campaign.LaunchPad) {
      ((mindustry.world.blocks.campaign.LaunchPad)content).lightRegion = Core.atlas.find("" + content.name + "-light");
      ((mindustry.world.blocks.campaign.LaunchPad)content).podRegion = Core.atlas.find("" + content.name + "-pod", "launchpod");
    }
    if(content instanceof mindustry.world.blocks.power.LightBlock) {
      ((mindustry.world.blocks.power.LightBlock)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.liquid.LiquidBlock) {
      ((mindustry.world.blocks.liquid.LiquidBlock)content).bottomRegion = Core.atlas.find("" + content.name + "-bottom");
      ((mindustry.world.blocks.liquid.LiquidBlock)content).liquidRegion = Core.atlas.find("" + content.name + "-liquid");
      ((mindustry.world.blocks.liquid.LiquidBlock)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.sandbox.LiquidSource) {
      ((mindustry.world.blocks.sandbox.LiquidSource)content).bottomRegion = Core.atlas.find("source-bottom");
      ((mindustry.world.blocks.sandbox.LiquidSource)content).crossRegion = Core.atlas.find("cross");
    }
    if(content instanceof mindustry.world.blocks.power.LongPowerNode) {
      ((mindustry.world.blocks.power.LongPowerNode)content).glow = Core.atlas.find("" + content.name + "-glow");
    }
    if(content instanceof mindustry.world.blocks.distribution.MassDriver) {
      ((mindustry.world.blocks.distribution.MassDriver)content).baseRegion = Core.atlas.find("" + content.name + "-base");
    }
    if(content instanceof mindustry.world.blocks.defense.MendProjector) {
      ((mindustry.world.blocks.defense.MendProjector)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.power.NuclearReactor) {
      ((mindustry.world.blocks.power.NuclearReactor)content).lightsRegion = Core.atlas.find("" + content.name + "-lights");
      ((mindustry.world.blocks.power.NuclearReactor)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.defense.OverdriveProjector) {
      ((mindustry.world.blocks.defense.OverdriveProjector)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.distribution.OverflowDuct) {
      ((mindustry.world.blocks.distribution.OverflowDuct)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.payloads.PayloadConveyor) {
      ((mindustry.world.blocks.payloads.PayloadConveyor)content).edgeRegion = Core.atlas.find("" + content.name + "-edge");
      ((mindustry.world.blocks.payloads.PayloadConveyor)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.payloads.PayloadMassDriver) {
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).arrow = Core.atlas.find("bridge-arrow");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).baseRegion = Core.atlas.find("" + content.name + "-base");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).capOutlineRegion = Core.atlas.find("" + content.name + "-cap-outline");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).capRegion = Core.atlas.find("" + content.name + "-cap");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).leftOutlineRegion = Core.atlas.find("" + content.name + "-left-outline");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).leftRegion = Core.atlas.find("" + content.name + "-left");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).rightOutlineRegion = Core.atlas.find("" + content.name + "-right-outline");
      ((mindustry.world.blocks.payloads.PayloadMassDriver)content).rightRegion = Core.atlas.find("" + content.name + "-right");
    }
    if(content instanceof mindustry.world.blocks.payloads.PayloadRouter) {
      ((mindustry.world.blocks.payloads.PayloadRouter)content).overRegion = Core.atlas.find("" + content.name + "-over");
    }
    if(content instanceof mindustry.world.blocks.defense.turrets.PointDefenseTurret) {
      ((mindustry.world.blocks.defense.turrets.PointDefenseTurret)content).baseRegion = Core.atlas.find("" + content.name + "-base", "block-" + ((mindustry.world.Block)content).size + "");
    }
    if(content instanceof mindustry.world.blocks.power.PowerDiode) {
      ((mindustry.world.blocks.power.PowerDiode)content).arrow = Core.atlas.find("" + content.name + "-arrow");
    }
    if(content instanceof mindustry.world.blocks.power.PowerNode) {
      ((mindustry.world.blocks.power.PowerNode)content).laser = Core.atlas.find("laser");
      ((mindustry.world.blocks.power.PowerNode)content).laserEnd = Core.atlas.find("laser-end");
    }
    if(content instanceof mindustry.world.blocks.defense.Radar) {
      ((mindustry.world.blocks.defense.Radar)content).baseRegion = Core.atlas.find("" + content.name + "-base");
      ((mindustry.world.blocks.defense.Radar)content).glowRegion = Core.atlas.find("" + content.name + "-glow");
    }
    if(content instanceof mindustry.world.blocks.units.RepairTower) {
      ((mindustry.world.blocks.units.RepairTower)content).glow = Core.atlas.find("" + content.name + "-glow");
    }
    if(content instanceof mindustry.world.blocks.units.RepairTurret) {
      ((mindustry.world.blocks.units.RepairTurret)content).baseRegion = Core.atlas.find("" + content.name + "-base", "block-" + ((mindustry.world.Block)content).size + "");
      ((mindustry.world.blocks.units.RepairTurret)content).laser = Core.atlas.find("laser-white");
      ((mindustry.world.blocks.units.RepairTurret)content).laserEnd = Core.atlas.find("laser-white-end");
      ((mindustry.world.blocks.units.RepairTurret)content).laserTop = Core.atlas.find("laser-top");
      ((mindustry.world.blocks.units.RepairTurret)content).laserTopEnd = Core.atlas.find("laser-top-end");
    }
    if(content instanceof mindustry.world.blocks.environment.SeaBush) {
      ((mindustry.world.blocks.environment.SeaBush)content).botRegion = Core.atlas.find("" + content.name + "-bot", "" + content.name + "");
      ((mindustry.world.blocks.environment.SeaBush)content).centerRegion = Core.atlas.find("" + content.name + "-center");
    }
    if(content instanceof mindustry.world.blocks.production.Separator) {
      ((mindustry.world.blocks.production.Separator)content).liquidRegion = Core.atlas.find("" + content.name + "-liquid");
      ((mindustry.world.blocks.production.Separator)content).spinnerRegion = Core.atlas.find("" + content.name + "-spinner");
    }
    if(content instanceof mindustry.world.blocks.defense.ShieldWall) {
      ((mindustry.world.blocks.defense.ShieldWall)content).glowRegion = Core.atlas.find("" + content.name + "-glow");
    }
    if(content instanceof mindustry.world.blocks.defense.ShockMine) {
      ((mindustry.world.blocks.defense.ShockMine)content).teamRegion = Core.atlas.find("" + content.name + "-team-top");
    }
    if(content instanceof mindustry.world.blocks.defense.ShockwaveTower) {
      ((mindustry.world.blocks.defense.ShockwaveTower)content).heatRegion = Core.atlas.find("" + content.name + "-heat");
    }
    if(content instanceof mindustry.world.blocks.production.SolidPump) {
      ((mindustry.world.blocks.production.SolidPump)content).rotatorRegion = Core.atlas.find("" + content.name + "-rotator");
    }
    if(content instanceof mindustry.world.blocks.distribution.StackConveyor) {
      ((mindustry.world.blocks.distribution.StackConveyor)content).edgeRegion = Core.atlas.find("" + content.name + "-edge");
      ((mindustry.world.blocks.distribution.StackConveyor)content).glowRegion = Core.atlas.find("" + content.name + "-glow");
      ((StackConveyor)content).regions = new TextureRegion[3];
      for(int INDEX0 = 0; INDEX0 < 3; INDEX0 ++) {
        ((StackConveyor)content).regions[INDEX0] = Core.atlas.find("" + content.name + "-" + INDEX0 + "");
      }
      ((mindustry.world.blocks.distribution.StackConveyor)content).stackRegion = Core.atlas.find("" + content.name + "-stack");
    }
    if(content instanceof mindustry.world.blocks.distribution.StackRouter) {
      ((mindustry.world.blocks.distribution.StackRouter)content).glowRegion = Core.atlas.find("" + content.name + "-glow", "arrow-glow");
    }
    if(content instanceof mindustry.world.blocks.environment.StaticWall) {
      ((mindustry.world.blocks.environment.StaticWall)content).large = Core.atlas.find("" + content.name + "-large");
    }
    if(content instanceof mindustry.world.blocks.logic.SwitchBlock) {
      ((mindustry.world.blocks.logic.SwitchBlock)content).onRegion = Core.atlas.find("" + content.name + "-on");
    }
    if(content instanceof mindustry.world.blocks.defense.Thruster) {
      ((mindustry.world.blocks.defense.Thruster)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.defense.turrets.TractorBeamTurret) {
      ((mindustry.world.blocks.defense.turrets.TractorBeamTurret)content).baseRegion = Core.atlas.find("" + content.name + "-base", "block-" + ((mindustry.world.Block)content).size + "");
      ((mindustry.world.blocks.defense.turrets.TractorBeamTurret)content).laser = Core.atlas.find("" + content.name + "-laser");
      ((mindustry.world.blocks.defense.turrets.TractorBeamTurret)content).laserEnd = Core.atlas.find("" + content.name + "-laser-end");
      ((mindustry.world.blocks.defense.turrets.TractorBeamTurret)content).laserStart = Core.atlas.find("" + content.name + "-laser-start", "" + content.name + "-laser-end");
    }
    if(content instanceof mindustry.world.blocks.environment.TreeBlock) {
      ((mindustry.world.blocks.environment.TreeBlock)content).shadow = Core.atlas.find("" + content.name + "-shadow");
    }
    if(content instanceof mindustry.world.blocks.units.UnitAssembler) {
      ((mindustry.world.blocks.units.UnitAssembler)content).sideRegion1 = Core.atlas.find("" + content.name + "-side1");
      ((mindustry.world.blocks.units.UnitAssembler)content).sideRegion2 = Core.atlas.find("" + content.name + "-side2");
    }
    if(content instanceof mindustry.world.blocks.units.UnitAssemblerModule) {
      ((mindustry.world.blocks.units.UnitAssemblerModule)content).sideRegion1 = Core.atlas.find("" + content.name + "-side1");
      ((mindustry.world.blocks.units.UnitAssemblerModule)content).sideRegion2 = Core.atlas.find("" + content.name + "-side2");
    }
    if(content instanceof mindustry.world.blocks.units.UnitCargoUnloadPoint) {
      ((mindustry.world.blocks.units.UnitCargoUnloadPoint)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
    if(content instanceof mindustry.world.blocks.storage.Unloader) {
      ((mindustry.world.blocks.storage.Unloader)content).centerRegion = Core.atlas.find("" + content.name + "-center", "unloader-center");
    }
    if(content instanceof mindustry.world.blocks.power.VariableReactor) {
      ((mindustry.world.blocks.power.VariableReactor)content).lightsRegion = Core.atlas.find("" + content.name + "-lights");
    }
    if(content instanceof mindustry.world.blocks.production.WallCrafter) {
      ((mindustry.world.blocks.production.WallCrafter)content).rotatorBottomRegion = Core.atlas.find("" + content.name + "-rotator-bottom");
      ((mindustry.world.blocks.production.WallCrafter)content).rotatorRegion = Core.atlas.find("" + content.name + "-rotator");
      ((mindustry.world.blocks.production.WallCrafter)content).topRegion = Core.atlas.find("" + content.name + "-top");
    }
  }
}
