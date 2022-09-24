package mindustry.gen;

import arc.func.Prov;
import arc.struct.Seq;
import mindustry.logic.LStatement;
import mindustry.logic.LStatements;

public class LogicIO {
  public static Seq<Prov<LStatement>> allStatements = Seq.with(mindustry.logic.LStatements.InvalidStatement::new, mindustry.logic.LStatements.ReadStatement::new, mindustry.logic.LStatements.WriteStatement::new, mindustry.logic.LStatements.DrawStatement::new, mindustry.logic.LStatements.PrintStatement::new, mindustry.logic.LStatements.DrawFlushStatement::new, mindustry.logic.LStatements.PrintFlushStatement::new, mindustry.logic.LStatements.GetLinkStatement::new, mindustry.logic.LStatements.ControlStatement::new, mindustry.logic.LStatements.RadarStatement::new, mindustry.logic.LStatements.SensorStatement::new, mindustry.logic.LStatements.SetStatement::new, mindustry.logic.LStatements.OperationStatement::new, mindustry.logic.LStatements.WaitStatement::new, mindustry.logic.LStatements.StopStatement::new, mindustry.logic.LStatements.LookupStatement::new, mindustry.logic.LStatements.PackColorStatement::new, mindustry.logic.LStatements.EndStatement::new, mindustry.logic.LStatements.JumpStatement::new, mindustry.logic.LStatements.UnitBindStatement::new, mindustry.logic.LStatements.UnitControlStatement::new, mindustry.logic.LStatements.UnitRadarStatement::new, mindustry.logic.LStatements.UnitLocateStatement::new, mindustry.logic.LStatements.GetBlockStatement::new, mindustry.logic.LStatements.SetBlockStatement::new, mindustry.logic.LStatements.SpawnUnitStatement::new, mindustry.logic.LStatements.ApplyStatusStatement::new, mindustry.logic.LStatements.SpawnWaveStatement::new, mindustry.logic.LStatements.SetRuleStatement::new, mindustry.logic.LStatements.FlushMessageStatement::new, mindustry.logic.LStatements.CutsceneStatement::new, mindustry.logic.LStatements.ExplosionStatement::new, mindustry.logic.LStatements.SetRateStatement::new, mindustry.logic.LStatements.FetchStatement::new, mindustry.logic.LStatements.GetFlagStatement::new, mindustry.logic.LStatements.SetFlagStatement::new);

  public static LStatement read(String[] tokens, int length) {
    if(tokens[0].equals("noop")) {
      LStatements.InvalidStatement result = new LStatements.InvalidStatement();
      result.afterRead();
      return result;
    } else if(tokens[0].equals("read")) {
      LStatements.ReadStatement result = new LStatements.ReadStatement();
      if(length > 1) result.output = (tokens[1]);
      if(length > 2) result.target = (tokens[2]);
      if(length > 3) result.address = (tokens[3]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("write")) {
      LStatements.WriteStatement result = new LStatements.WriteStatement();
      if(length > 1) result.input = (tokens[1]);
      if(length > 2) result.target = (tokens[2]);
      if(length > 3) result.address = (tokens[3]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("draw")) {
      LStatements.DrawStatement result = new LStatements.DrawStatement();
      if(length > 1) result.type = mindustry.world.blocks.logic.LogicDisplay.GraphicsType.valueOf(tokens[1]);
      if(length > 2) result.x = (tokens[2]);
      if(length > 3) result.y = (tokens[3]);
      if(length > 4) result.p1 = (tokens[4]);
      if(length > 5) result.p2 = (tokens[5]);
      if(length > 6) result.p3 = (tokens[6]);
      if(length > 7) result.p4 = (tokens[7]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("print")) {
      LStatements.PrintStatement result = new LStatements.PrintStatement();
      if(length > 1) result.value = (tokens[1]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("drawflush")) {
      LStatements.DrawFlushStatement result = new LStatements.DrawFlushStatement();
      if(length > 1) result.target = (tokens[1]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("printflush")) {
      LStatements.PrintFlushStatement result = new LStatements.PrintFlushStatement();
      if(length > 1) result.target = (tokens[1]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("getlink")) {
      LStatements.GetLinkStatement result = new LStatements.GetLinkStatement();
      if(length > 1) result.output = (tokens[1]);
      if(length > 2) result.address = (tokens[2]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("control")) {
      LStatements.ControlStatement result = new LStatements.ControlStatement();
      if(length > 1) result.type = mindustry.logic.LAccess.valueOf(tokens[1]);
      if(length > 2) result.target = (tokens[2]);
      if(length > 3) result.p1 = (tokens[3]);
      if(length > 4) result.p2 = (tokens[4]);
      if(length > 5) result.p3 = (tokens[5]);
      if(length > 6) result.p4 = (tokens[6]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("radar")) {
      LStatements.RadarStatement result = new LStatements.RadarStatement();
      if(length > 1) result.target1 = mindustry.logic.RadarTarget.valueOf(tokens[1]);
      if(length > 2) result.target2 = mindustry.logic.RadarTarget.valueOf(tokens[2]);
      if(length > 3) result.target3 = mindustry.logic.RadarTarget.valueOf(tokens[3]);
      if(length > 4) result.sort = mindustry.logic.RadarSort.valueOf(tokens[4]);
      if(length > 5) result.radar = (tokens[5]);
      if(length > 6) result.sortOrder = (tokens[6]);
      if(length > 7) result.output = (tokens[7]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("sensor")) {
      LStatements.SensorStatement result = new LStatements.SensorStatement();
      if(length > 1) result.to = (tokens[1]);
      if(length > 2) result.from = (tokens[2]);
      if(length > 3) result.type = (tokens[3]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("set")) {
      LStatements.SetStatement result = new LStatements.SetStatement();
      if(length > 1) result.to = (tokens[1]);
      if(length > 2) result.from = (tokens[2]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("op")) {
      LStatements.OperationStatement result = new LStatements.OperationStatement();
      if(length > 1) result.op = mindustry.logic.LogicOp.valueOf(tokens[1]);
      if(length > 2) result.dest = (tokens[2]);
      if(length > 3) result.a = (tokens[3]);
      if(length > 4) result.b = (tokens[4]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("wait")) {
      LStatements.WaitStatement result = new LStatements.WaitStatement();
      if(length > 1) result.value = (tokens[1]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("stop")) {
      LStatements.StopStatement result = new LStatements.StopStatement();
      result.afterRead();
      return result;
    } else if(tokens[0].equals("lookup")) {
      LStatements.LookupStatement result = new LStatements.LookupStatement();
      if(length > 1) result.type = mindustry.ctype.ContentType.valueOf(tokens[1]);
      if(length > 2) result.result = (tokens[2]);
      if(length > 3) result.id = (tokens[3]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("packcolor")) {
      LStatements.PackColorStatement result = new LStatements.PackColorStatement();
      if(length > 1) result.result = (tokens[1]);
      if(length > 2) result.r = (tokens[2]);
      if(length > 3) result.g = (tokens[3]);
      if(length > 4) result.b = (tokens[4]);
      if(length > 5) result.a = (tokens[5]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("end")) {
      LStatements.EndStatement result = new LStatements.EndStatement();
      result.afterRead();
      return result;
    } else if(tokens[0].equals("jump")) {
      LStatements.JumpStatement result = new LStatements.JumpStatement();
      if(length > 1) result.destIndex = java.lang.Integer.valueOf(tokens[1]);
      if(length > 2) result.op = mindustry.logic.ConditionOp.valueOf(tokens[2]);
      if(length > 3) result.value = (tokens[3]);
      if(length > 4) result.compare = (tokens[4]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("ubind")) {
      LStatements.UnitBindStatement result = new LStatements.UnitBindStatement();
      if(length > 1) result.type = (tokens[1]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("ucontrol")) {
      LStatements.UnitControlStatement result = new LStatements.UnitControlStatement();
      if(length > 1) result.type = mindustry.logic.LUnitControl.valueOf(tokens[1]);
      if(length > 2) result.p1 = (tokens[2]);
      if(length > 3) result.p2 = (tokens[3]);
      if(length > 4) result.p3 = (tokens[4]);
      if(length > 5) result.p4 = (tokens[5]);
      if(length > 6) result.p5 = (tokens[6]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("uradar")) {
      LStatements.UnitRadarStatement result = new LStatements.UnitRadarStatement();
      if(length > 1) result.target1 = mindustry.logic.RadarTarget.valueOf(tokens[1]);
      if(length > 2) result.target2 = mindustry.logic.RadarTarget.valueOf(tokens[2]);
      if(length > 3) result.target3 = mindustry.logic.RadarTarget.valueOf(tokens[3]);
      if(length > 4) result.sort = mindustry.logic.RadarSort.valueOf(tokens[4]);
      if(length > 5) result.radar = (tokens[5]);
      if(length > 6) result.sortOrder = (tokens[6]);
      if(length > 7) result.output = (tokens[7]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("ulocate")) {
      LStatements.UnitLocateStatement result = new LStatements.UnitLocateStatement();
      if(length > 1) result.locate = mindustry.logic.LLocate.valueOf(tokens[1]);
      if(length > 2) result.flag = mindustry.world.meta.BlockFlag.valueOf(tokens[2]);
      if(length > 3) result.enemy = (tokens[3]);
      if(length > 4) result.ore = (tokens[4]);
      if(length > 5) result.outX = (tokens[5]);
      if(length > 6) result.outY = (tokens[6]);
      if(length > 7) result.outFound = (tokens[7]);
      if(length > 8) result.outBuild = (tokens[8]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("getblock")) {
      LStatements.GetBlockStatement result = new LStatements.GetBlockStatement();
      if(length > 1) result.layer = mindustry.logic.TileLayer.valueOf(tokens[1]);
      if(length > 2) result.result = (tokens[2]);
      if(length > 3) result.x = (tokens[3]);
      if(length > 4) result.y = (tokens[4]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("setblock")) {
      LStatements.SetBlockStatement result = new LStatements.SetBlockStatement();
      if(length > 1) result.layer = mindustry.logic.TileLayer.valueOf(tokens[1]);
      if(length > 2) result.block = (tokens[2]);
      if(length > 3) result.x = (tokens[3]);
      if(length > 4) result.y = (tokens[4]);
      if(length > 5) result.team = (tokens[5]);
      if(length > 6) result.rotation = (tokens[6]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("spawn")) {
      LStatements.SpawnUnitStatement result = new LStatements.SpawnUnitStatement();
      if(length > 1) result.type = (tokens[1]);
      if(length > 2) result.x = (tokens[2]);
      if(length > 3) result.y = (tokens[3]);
      if(length > 4) result.rotation = (tokens[4]);
      if(length > 5) result.team = (tokens[5]);
      if(length > 6) result.result = (tokens[6]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("status")) {
      LStatements.ApplyStatusStatement result = new LStatements.ApplyStatusStatement();
      if(length > 1) result.clear = java.lang.Boolean.valueOf(tokens[1]);
      if(length > 2) result.effect = (tokens[2]);
      if(length > 3) result.unit = (tokens[3]);
      if(length > 4) result.duration = (tokens[4]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("spawnwave")) {
      LStatements.SpawnWaveStatement result = new LStatements.SpawnWaveStatement();
      if(length > 1) result.x = (tokens[1]);
      if(length > 2) result.y = (tokens[2]);
      if(length > 3) result.natural = (tokens[3]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("setrule")) {
      LStatements.SetRuleStatement result = new LStatements.SetRuleStatement();
      if(length > 1) result.rule = mindustry.logic.LogicRule.valueOf(tokens[1]);
      if(length > 2) result.value = (tokens[2]);
      if(length > 3) result.p1 = (tokens[3]);
      if(length > 4) result.p2 = (tokens[4]);
      if(length > 5) result.p3 = (tokens[5]);
      if(length > 6) result.p4 = (tokens[6]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("message")) {
      LStatements.FlushMessageStatement result = new LStatements.FlushMessageStatement();
      if(length > 1) result.type = mindustry.logic.MessageType.valueOf(tokens[1]);
      if(length > 2) result.duration = (tokens[2]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("cutscene")) {
      LStatements.CutsceneStatement result = new LStatements.CutsceneStatement();
      if(length > 1) result.action = mindustry.logic.CutsceneAction.valueOf(tokens[1]);
      if(length > 2) result.p1 = (tokens[2]);
      if(length > 3) result.p2 = (tokens[3]);
      if(length > 4) result.p3 = (tokens[4]);
      if(length > 5) result.p4 = (tokens[5]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("explosion")) {
      LStatements.ExplosionStatement result = new LStatements.ExplosionStatement();
      if(length > 1) result.team = (tokens[1]);
      if(length > 2) result.x = (tokens[2]);
      if(length > 3) result.y = (tokens[3]);
      if(length > 4) result.radius = (tokens[4]);
      if(length > 5) result.damage = (tokens[5]);
      if(length > 6) result.air = (tokens[6]);
      if(length > 7) result.ground = (tokens[7]);
      if(length > 8) result.pierce = (tokens[8]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("setrate")) {
      LStatements.SetRateStatement result = new LStatements.SetRateStatement();
      if(length > 1) result.amount = (tokens[1]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("fetch")) {
      LStatements.FetchStatement result = new LStatements.FetchStatement();
      if(length > 1) result.type = mindustry.logic.FetchType.valueOf(tokens[1]);
      if(length > 2) result.result = (tokens[2]);
      if(length > 3) result.team = (tokens[3]);
      if(length > 4) result.index = (tokens[4]);
      if(length > 5) result.extra = (tokens[5]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("getflag")) {
      LStatements.GetFlagStatement result = new LStatements.GetFlagStatement();
      if(length > 1) result.result = (tokens[1]);
      if(length > 2) result.flag = (tokens[2]);
      result.afterRead();
      return result;
    } else if(tokens[0].equals("setflag")) {
      LStatements.SetFlagStatement result = new LStatements.SetFlagStatement();
      if(length > 1) result.flag = (tokens[1]);
      if(length > 2) result.value = (tokens[2]);
      result.afterRead();
      return result;
    }
    return null;
  }

  public static void write(Object obj, StringBuilder out) {
    if(obj.getClass() == LStatements.InvalidStatement.class) {
      out.append("noop");
    } else if(obj.getClass() == LStatements.ReadStatement.class) {
      out.append("read");
      out.append(" ");
      out.append(((LStatements.ReadStatement)obj).output);
      out.append(" ");
      out.append(((LStatements.ReadStatement)obj).target);
      out.append(" ");
      out.append(((LStatements.ReadStatement)obj).address);
    } else if(obj.getClass() == LStatements.WriteStatement.class) {
      out.append("write");
      out.append(" ");
      out.append(((LStatements.WriteStatement)obj).input);
      out.append(" ");
      out.append(((LStatements.WriteStatement)obj).target);
      out.append(" ");
      out.append(((LStatements.WriteStatement)obj).address);
    } else if(obj.getClass() == LStatements.DrawStatement.class) {
      out.append("draw");
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).type.name());
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).x);
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).y);
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).p1);
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).p2);
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).p3);
      out.append(" ");
      out.append(((LStatements.DrawStatement)obj).p4);
    } else if(obj.getClass() == LStatements.PrintStatement.class) {
      out.append("print");
      out.append(" ");
      out.append(((LStatements.PrintStatement)obj).value);
    } else if(obj.getClass() == LStatements.DrawFlushStatement.class) {
      out.append("drawflush");
      out.append(" ");
      out.append(((LStatements.DrawFlushStatement)obj).target);
    } else if(obj.getClass() == LStatements.PrintFlushStatement.class) {
      out.append("printflush");
      out.append(" ");
      out.append(((LStatements.PrintFlushStatement)obj).target);
    } else if(obj.getClass() == LStatements.GetLinkStatement.class) {
      out.append("getlink");
      out.append(" ");
      out.append(((LStatements.GetLinkStatement)obj).output);
      out.append(" ");
      out.append(((LStatements.GetLinkStatement)obj).address);
    } else if(obj.getClass() == LStatements.ControlStatement.class) {
      out.append("control");
      out.append(" ");
      out.append(((LStatements.ControlStatement)obj).type.name());
      out.append(" ");
      out.append(((LStatements.ControlStatement)obj).target);
      out.append(" ");
      out.append(((LStatements.ControlStatement)obj).p1);
      out.append(" ");
      out.append(((LStatements.ControlStatement)obj).p2);
      out.append(" ");
      out.append(((LStatements.ControlStatement)obj).p3);
      out.append(" ");
      out.append(((LStatements.ControlStatement)obj).p4);
    } else if(obj.getClass() == LStatements.RadarStatement.class) {
      out.append("radar");
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).target1.name());
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).target2.name());
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).target3.name());
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).sort.name());
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).radar);
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).sortOrder);
      out.append(" ");
      out.append(((LStatements.RadarStatement)obj).output);
    } else if(obj.getClass() == LStatements.SensorStatement.class) {
      out.append("sensor");
      out.append(" ");
      out.append(((LStatements.SensorStatement)obj).to);
      out.append(" ");
      out.append(((LStatements.SensorStatement)obj).from);
      out.append(" ");
      out.append(((LStatements.SensorStatement)obj).type);
    } else if(obj.getClass() == LStatements.SetStatement.class) {
      out.append("set");
      out.append(" ");
      out.append(((LStatements.SetStatement)obj).to);
      out.append(" ");
      out.append(((LStatements.SetStatement)obj).from);
    } else if(obj.getClass() == LStatements.OperationStatement.class) {
      out.append("op");
      out.append(" ");
      out.append(((LStatements.OperationStatement)obj).op.name());
      out.append(" ");
      out.append(((LStatements.OperationStatement)obj).dest);
      out.append(" ");
      out.append(((LStatements.OperationStatement)obj).a);
      out.append(" ");
      out.append(((LStatements.OperationStatement)obj).b);
    } else if(obj.getClass() == LStatements.WaitStatement.class) {
      out.append("wait");
      out.append(" ");
      out.append(((LStatements.WaitStatement)obj).value);
    } else if(obj.getClass() == LStatements.StopStatement.class) {
      out.append("stop");
    } else if(obj.getClass() == LStatements.LookupStatement.class) {
      out.append("lookup");
      out.append(" ");
      out.append(((LStatements.LookupStatement)obj).type.name());
      out.append(" ");
      out.append(((LStatements.LookupStatement)obj).result);
      out.append(" ");
      out.append(((LStatements.LookupStatement)obj).id);
    } else if(obj.getClass() == LStatements.PackColorStatement.class) {
      out.append("packcolor");
      out.append(" ");
      out.append(((LStatements.PackColorStatement)obj).result);
      out.append(" ");
      out.append(((LStatements.PackColorStatement)obj).r);
      out.append(" ");
      out.append(((LStatements.PackColorStatement)obj).g);
      out.append(" ");
      out.append(((LStatements.PackColorStatement)obj).b);
      out.append(" ");
      out.append(((LStatements.PackColorStatement)obj).a);
    } else if(obj.getClass() == LStatements.EndStatement.class) {
      out.append("end");
    } else if(obj.getClass() == LStatements.JumpStatement.class) {
      out.append("jump");
      out.append(" ");
      out.append(((LStatements.JumpStatement)obj).destIndex);
      out.append(" ");
      out.append(((LStatements.JumpStatement)obj).op.name());
      out.append(" ");
      out.append(((LStatements.JumpStatement)obj).value);
      out.append(" ");
      out.append(((LStatements.JumpStatement)obj).compare);
    } else if(obj.getClass() == LStatements.UnitBindStatement.class) {
      out.append("ubind");
      out.append(" ");
      out.append(((LStatements.UnitBindStatement)obj).type);
    } else if(obj.getClass() == LStatements.UnitControlStatement.class) {
      out.append("ucontrol");
      out.append(" ");
      out.append(((LStatements.UnitControlStatement)obj).type.name());
      out.append(" ");
      out.append(((LStatements.UnitControlStatement)obj).p1);
      out.append(" ");
      out.append(((LStatements.UnitControlStatement)obj).p2);
      out.append(" ");
      out.append(((LStatements.UnitControlStatement)obj).p3);
      out.append(" ");
      out.append(((LStatements.UnitControlStatement)obj).p4);
      out.append(" ");
      out.append(((LStatements.UnitControlStatement)obj).p5);
    } else if(obj.getClass() == LStatements.UnitRadarStatement.class) {
      out.append("uradar");
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).target1.name());
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).target2.name());
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).target3.name());
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).sort.name());
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).radar);
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).sortOrder);
      out.append(" ");
      out.append(((LStatements.UnitRadarStatement)obj).output);
    } else if(obj.getClass() == LStatements.UnitLocateStatement.class) {
      out.append("ulocate");
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).locate.name());
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).flag.name());
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).enemy);
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).ore);
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).outX);
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).outY);
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).outFound);
      out.append(" ");
      out.append(((LStatements.UnitLocateStatement)obj).outBuild);
    } else if(obj.getClass() == LStatements.GetBlockStatement.class) {
      out.append("getblock");
      out.append(" ");
      out.append(((LStatements.GetBlockStatement)obj).layer.name());
      out.append(" ");
      out.append(((LStatements.GetBlockStatement)obj).result);
      out.append(" ");
      out.append(((LStatements.GetBlockStatement)obj).x);
      out.append(" ");
      out.append(((LStatements.GetBlockStatement)obj).y);
    } else if(obj.getClass() == LStatements.SetBlockStatement.class) {
      out.append("setblock");
      out.append(" ");
      out.append(((LStatements.SetBlockStatement)obj).layer.name());
      out.append(" ");
      out.append(((LStatements.SetBlockStatement)obj).block);
      out.append(" ");
      out.append(((LStatements.SetBlockStatement)obj).x);
      out.append(" ");
      out.append(((LStatements.SetBlockStatement)obj).y);
      out.append(" ");
      out.append(((LStatements.SetBlockStatement)obj).team);
      out.append(" ");
      out.append(((LStatements.SetBlockStatement)obj).rotation);
    } else if(obj.getClass() == LStatements.SpawnUnitStatement.class) {
      out.append("spawn");
      out.append(" ");
      out.append(((LStatements.SpawnUnitStatement)obj).type);
      out.append(" ");
      out.append(((LStatements.SpawnUnitStatement)obj).x);
      out.append(" ");
      out.append(((LStatements.SpawnUnitStatement)obj).y);
      out.append(" ");
      out.append(((LStatements.SpawnUnitStatement)obj).rotation);
      out.append(" ");
      out.append(((LStatements.SpawnUnitStatement)obj).team);
      out.append(" ");
      out.append(((LStatements.SpawnUnitStatement)obj).result);
    } else if(obj.getClass() == LStatements.ApplyStatusStatement.class) {
      out.append("status");
      out.append(" ");
      out.append(((LStatements.ApplyStatusStatement)obj).clear);
      out.append(" ");
      out.append(((LStatements.ApplyStatusStatement)obj).effect);
      out.append(" ");
      out.append(((LStatements.ApplyStatusStatement)obj).unit);
      out.append(" ");
      out.append(((LStatements.ApplyStatusStatement)obj).duration);
    } else if(obj.getClass() == LStatements.SpawnWaveStatement.class) {
      out.append("spawnwave");
      out.append(" ");
      out.append(((LStatements.SpawnWaveStatement)obj).x);
      out.append(" ");
      out.append(((LStatements.SpawnWaveStatement)obj).y);
      out.append(" ");
      out.append(((LStatements.SpawnWaveStatement)obj).natural);
    } else if(obj.getClass() == LStatements.SetRuleStatement.class) {
      out.append("setrule");
      out.append(" ");
      out.append(((LStatements.SetRuleStatement)obj).rule.name());
      out.append(" ");
      out.append(((LStatements.SetRuleStatement)obj).value);
      out.append(" ");
      out.append(((LStatements.SetRuleStatement)obj).p1);
      out.append(" ");
      out.append(((LStatements.SetRuleStatement)obj).p2);
      out.append(" ");
      out.append(((LStatements.SetRuleStatement)obj).p3);
      out.append(" ");
      out.append(((LStatements.SetRuleStatement)obj).p4);
    } else if(obj.getClass() == LStatements.FlushMessageStatement.class) {
      out.append("message");
      out.append(" ");
      out.append(((LStatements.FlushMessageStatement)obj).type.name());
      out.append(" ");
      out.append(((LStatements.FlushMessageStatement)obj).duration);
    } else if(obj.getClass() == LStatements.CutsceneStatement.class) {
      out.append("cutscene");
      out.append(" ");
      out.append(((LStatements.CutsceneStatement)obj).action.name());
      out.append(" ");
      out.append(((LStatements.CutsceneStatement)obj).p1);
      out.append(" ");
      out.append(((LStatements.CutsceneStatement)obj).p2);
      out.append(" ");
      out.append(((LStatements.CutsceneStatement)obj).p3);
      out.append(" ");
      out.append(((LStatements.CutsceneStatement)obj).p4);
    } else if(obj.getClass() == LStatements.ExplosionStatement.class) {
      out.append("explosion");
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).team);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).x);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).y);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).radius);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).damage);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).air);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).ground);
      out.append(" ");
      out.append(((LStatements.ExplosionStatement)obj).pierce);
    } else if(obj.getClass() == LStatements.SetRateStatement.class) {
      out.append("setrate");
      out.append(" ");
      out.append(((LStatements.SetRateStatement)obj).amount);
    } else if(obj.getClass() == LStatements.FetchStatement.class) {
      out.append("fetch");
      out.append(" ");
      out.append(((LStatements.FetchStatement)obj).type.name());
      out.append(" ");
      out.append(((LStatements.FetchStatement)obj).result);
      out.append(" ");
      out.append(((LStatements.FetchStatement)obj).team);
      out.append(" ");
      out.append(((LStatements.FetchStatement)obj).index);
      out.append(" ");
      out.append(((LStatements.FetchStatement)obj).extra);
    } else if(obj.getClass() == LStatements.GetFlagStatement.class) {
      out.append("getflag");
      out.append(" ");
      out.append(((LStatements.GetFlagStatement)obj).result);
      out.append(" ");
      out.append(((LStatements.GetFlagStatement)obj).flag);
    } else if(obj.getClass() == LStatements.SetFlagStatement.class) {
      out.append("setflag");
      out.append(" ");
      out.append(((LStatements.SetFlagStatement)obj).flag);
      out.append(" ");
      out.append(((LStatements.SetFlagStatement)obj).value);
    }
  }
}
