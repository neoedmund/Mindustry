package mindustry.gen;

import arc.struct.Seq;
import arc.util.pooling.Pool;
import arc.util.pooling.Pools;
import mindustry.entities.EntityGroup;

public class Groups {
  public static EntityGroup<Entityc> all;

  public static EntityGroup<Building> build;

  public static EntityGroup<Bullet> bullet;

  public static EntityGroup<Drawc> draw;

  public static EntityGroup<Fire> fire;

  private static Seq<Pool.Poolable> freeQueue = new Seq<>();

  public static boolean isClearing;

  public static EntityGroup<WorldLabel> label;

  public static EntityGroup<Player> player;

  public static EntityGroup<Puddle> puddle;

  public static EntityGroup<Syncc> sync;

  public static EntityGroup<Unit> unit;

  public static EntityGroup<WeatherState> weather;

  public static void clear() {
    isClearing = true;
    all.clear();
    player.clear();
    bullet.clear();
    unit.clear();
    build.clear();
    sync.clear();
    draw.clear();
    fire.clear();
    puddle.clear();
    weather.clear();
    label.clear();
    isClearing = false;
  }

  public static void init() {
    all = new EntityGroup<>(mindustry.gen.Entityc.class, false, false);
    player = new EntityGroup<>(mindustry.gen.Player.class, false, true);
    bullet = new EntityGroup<>(mindustry.gen.Bullet.class, true, false);
    unit = new EntityGroup<>(mindustry.gen.Unit.class, true, true);
    build = new EntityGroup<>(mindustry.gen.Building.class, false, false);
    sync = new EntityGroup<>(mindustry.gen.Syncc.class, false, true);
    draw = new EntityGroup<>(mindustry.gen.Drawc.class, false, false);
    fire = new EntityGroup<>(mindustry.gen.Fire.class, false, false);
    puddle = new EntityGroup<>(mindustry.gen.Puddle.class, false, false);
    weather = new EntityGroup<>(mindustry.gen.WeatherState.class, false, false);
    label = new EntityGroup<>(mindustry.gen.WorldLabel.class, false, true);
  }

  public static void queueFree(Pool.Poolable obj) {
    freeQueue.add(obj);
  }

  public static void resize(float x, float y, float w, float h) {
    bullet.resize(x, y, w, h);
    unit.resize(x, y, w, h);
  }

  public static void update() {
    for(Pool.Poolable p : freeQueue) Pools.free(p);
    freeQueue.clear();
    bullet.updatePhysics();
    unit.updatePhysics();
    all.update();
    bullet.collide();
  }
}
