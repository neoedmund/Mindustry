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

import arc.func.Cons;
import arc.math.geom.Position;
import arc.math.geom.QuadTree;
import arc.math.geom.Rect;
import arc.math.geom.Vec2;
import arc.struct.IntSeq;
import arc.util.Interval;
import arc.util.Nullable;
import arc.util.io.Reads;
import arc.util.io.Writes;
import arc.util.pooling.Pool;
import mindustry.annotations.Annotations;
import mindustry.entities.EntityCollisions;
import mindustry.entities.Mover;
import mindustry.entities.bullet.BulletType;
import mindustry.game.Team;
import mindustry.graphics.Trail;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.storage.CoreBlock;

@SuppressWarnings("deprecation")
public class Bullet implements Pool.Poolable, Bulletc, Damagec, Drawc, Entityc, Hitboxc, Ownerc, Posc, Shielderc, Teamc,
		Timedc, Timerc, Velc {
	public transient boolean absorbed;

	protected transient boolean added;

	@Nullable
	public transient Tile aimTile;

	public transient float aimX;

	public transient float aimY;

	public IntSeq collided = new IntSeq(6);

	public float damage;

	public Object data;

	public transient float deltaX;

	public transient float deltaY;

	public transient float drag = 0.0F;

	public float fdata;

	public transient boolean hit;

	public transient float hitSize;

	public transient int id = EntityGroup.nextId();

	public transient boolean keepAlive;

	public transient float lastX;

	public transient float lastY;

	public float lifetime;

	@Nullable
	public transient Mover mover;

	public transient float originX;

	public transient float originY;

	public Entityc owner;

	@Annotations.ReadOnly
	protected float rotation;

	public Team team = Team.derelict;

	public float time;

	public transient Interval timer = new Interval(6);

	@Nullable
	public transient Trail trail;

	public BulletType type;

	@Annotations.SyncLocal
	public Vec2 vel = new Vec2();

	@Annotations.SyncField(true)
	@Annotations.SyncLocal
	public float x;

	@Annotations.SyncField(true)
	@Annotations.SyncLocal
	public float y;

	protected Bullet() {
	}

	@Override
	public Vec2 vel() {
		return vel;
	}

	@Override
	public IntSeq collided() {
		return collided;
	}

	@Override
	public Interval timer() {
		return timer;
	}

	@Override
	public boolean absorbed() {
		return absorbed;
	}

	@Override
	public boolean hit() {
		return hit;
	}

	@Override
	public boolean keepAlive() {
		return keepAlive;
	}

	@Override
	public float aimX() {
		return aimX;
	}

	@Override
	public float aimY() {
		return aimY;
	}

	@Override
	public float damage() {
		return damage;
	}

	@Override
	public float deltaX() {
		return deltaX;
	}

	@Override
	public float deltaY() {
		return deltaY;
	}

	@Override
	public float drag() {
		return drag;
	}

	@Override
	public float fdata() {
		return fdata;
	}

	@Override
	public float lastX() {
		return lastX;
	}

	@Override
	public float lastY() {
		return lastY;
	}

	@Override
	public float lifetime() {
		return lifetime;
	}

	@Override
	public float originX() {
		return originX;
	}

	@Override
	public float originY() {
		return originY;
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
		return 7;
	}

	@Override
	public int id() {
		return id;
	}

	@Override
	public Object data() {
		return data;
	}

	@Override
	public String toString() {
		return "Bullet#" + id;
	}

	@Override
	public Mover mover() {
		return mover;
	}

	@Override
	public BulletType type() {
		return type;
	}

	@Override
	public Team team() {
		return team;
	}

	@Override
	public Entityc owner() {
		return owner;
	}

	@Override
	public Trail trail() {
		return trail;
	}

	@Override
	public Tile aimTile() {
		return aimTile;
	}

	@Override
	public void absorbed(boolean absorbed) {
		this.absorbed = absorbed;
	}

	@Override
	public void aimTile(Tile aimTile) {
		this.aimTile = aimTile;
	}

	@Override
	public void aimX(float aimX) {
		this.aimX = aimX;
	}

	@Override
	public void aimY(float aimY) {
		this.aimY = aimY;
	}

	@Override
	public void collided(IntSeq collided) {
		this.collided = collided;
	}

	@Override
	public void damage(float damage) {
		this.damage = damage;
	}

	@Override
	public void data(Object data) {
		this.data = data;
	}

	@Override
	public void deltaX(float deltaX) {
		this.deltaX = deltaX;
	}

	@Override
	public void deltaY(float deltaY) {
		this.deltaY = deltaY;
	}

	@Override
	public void drag(float drag) {
		this.drag = drag;
	}

	@Override
	public void fdata(float fdata) {
		this.fdata = fdata;
	}

	@Override
	public void hit(boolean hit) {
		this.hit = hit;
	}

	@Override
	public void hitSize(float hitSize) {
		this.hitSize = hitSize;
	}

	@Override
	public void id(int id) {
		this.id = id;
	}

	@Override
	public void keepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	@Override
	public void lastX(float lastX) {
		this.lastX = lastX;
	}

	@Override
	public void lastY(float lastY) {
		this.lastY = lastY;
	}

	@Override
	public void lifetime(float lifetime) {
		this.lifetime = lifetime;
	}

	@Override
	public void mover(Mover mover) {
		this.mover = mover;
	}

	@Override
	public void originX(float originX) {
		this.originX = originX;
	}

	@Override
	public void originY(float originY) {
		this.originY = originY;
	}

	@Override
	public void owner(Entityc owner) {
		this.owner = owner;
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
	public void timer(Interval timer) {
		this.timer = timer;
	}

	@Override
	public void trail(Trail trail) {
		this.trail = trail;
	}

	@Override
	public void type(BulletType type) {
		this.type = type;
	}

	@Override
	public void vel(Vec2 vel) {
		this.vel = vel;
	}

	@Override
	public void x(float x) {
		this.x = x;
	}

	@Override
	public void y(float y) {
		this.y = y;
	}

	public <T extends Entityc> T self() {
		return (T) this;
	}

	public <T> T as() {
		return (T) this;
	}

	public Building buildOn() {
		return world.buildWorld(x, y);
	}

	public boolean canPass(int tileX, int tileY) {
		SolidPred s = solidity();
		return s == null || !s.solid(tileX, tileY);
	}

	public boolean canPassOn() {
		return canPass(tileX(), tileY());
	}

	public boolean cheating() {
		return team.rules().cheat;
	}

	public boolean checkUnderBuild(Building build, float x, float y) {
		return (!build.block.underBullets || (aimTile != null && aimTile.build == build) || (build.team == team)
				|| (type.pierce && aimTile != null
						&& Mathf.dst(x, y, originX, originY) > aimTile.dst(originX, originY) + 2.0F)
				|| (aimX == -1.0F && aimY == -1.0F));
	}

	public boolean collides(Hitboxc other) {
		return type.collides && (other instanceof Teamc t && t.team() != team)
				&& !(other instanceof Flyingc f && !f.checkTarget(type.collidesAir, type.collidesGround))
				&& !(type.pierce && hasCollided(other.id()));
	}

	public boolean hasCollided(int id) {
		return collided.size != 0 && collided.contains(id);
	}

	public boolean inFogTo(Team viewer) {
		return this.team != viewer && !fogControl.isVisible(viewer, x, y);
	}

	public boolean isAdded() {
		return added;
	}

	public boolean isLocal() {
		return true;
	}

	public boolean isNull() {
		return false;
	}

	public boolean isRemote() {
		return ((Object) this) instanceof Unitc u && u.isPlayer() && !isLocal();
	}

	public boolean moving() {
		return !vel.isZero(0.01F);
	}

	public boolean onSolid() {
		Tile tile = tileOn();
		return tile == null || tile.solid();
	}

	public boolean serialize() {
		return false;
	}

	public boolean timer(int index, float time) {
		if (Float.isInfinite(time))
			return false;
		return timer.get(index, time);
	}

	public float clipSize() {
		return type.drawSize;
	}

	public float damageMultiplier() {
		return type.damageMultiplier(this);
	}

	public float deltaAngle() {
		return Mathf.angle(deltaX, deltaY);
	}

	public float deltaLen() {
		return Mathf.len(deltaX, deltaY);
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

	public float hitSize() {
		return hitSize;
	}

	public float rotation() {
		return vel.isZero(0.001F) ? rotation : vel.angle();
	}

	public int tileX() {
		return World.toTile(x);
	}

	public int tileY() {
		return World.toTile(y);
	}

	public EntityCollisions.SolidPred solidity() {
		return null;
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
		return tile == null || tile.block() != Blocks.air ? (Floor) Blocks.air : tile.floor();
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

	public static Bullet create() {
		return Pools.obtain(Bullet.class, Bullet::new);
	}

	public void absorb() {
		bullet: {
			absorbed = true;
			remove();
		}
	}

	public void add() {
		if (added == true)
			return;
		Groups.all.add(this);
		Groups.bullet.add(this);
		Groups.draw.add(this);
		bullet: {
			type.init(this);
		}
		entity: {
			added = true;
		}
		hitbox: {
			updateLastPosition();
		}
	}

	public void afterRead() {
		hitbox: {
			updateLastPosition();
		}
	}

	public void collision(Hitboxc other, float x, float y) {
		bullet: {
			type.hit(this, x, y);
			if (!type.pierce) {
				hit = true;
				remove();
			} else {
				collided.add(other.id());
			}
			type.hitEntity(this, other, other instanceof Healthc h ? h.health() : 0.0F);
		}
	}

	public void draw() {
		bullet: {
			Draw.z(type.layer);
			type.draw(this);
			type.drawLight(this);
			Draw.reset();
		}
	}

	public void getCollisions(Cons<QuadTree> consumer) {
		bullet: {
			Seq<TeamData> data = state.teams.present;
			for (int i = 0; i < data.size; i++) {
				if (data.items[i].team != team) {
					consumer.get(data.items[i].tree());
				}
			}
		}
	}

	public void hitbox(Rect rect) {
		rect.setCentered(x, y, hitSize, hitSize);
	}

	public void hitboxTile(Rect rect) {
		float size = Math.min(hitSize * 0.66F, 7.9F);
		rect.setCentered(x, y, size, size);
	}

	public void initVel(float angle, float amount) {
		vel.trns(angle, amount);
		rotation = angle;
	}

	public void move(Vec2 v) {
		move(v.x, v.y);
	}

	public void move(float cx, float cy) {
		SolidPred check = solidity();
		if (check != null) {
			collisions.move(this, cx, cy, check);
		} else {
			x += cx;
			y += cy;
		}
	}

	public void moveRelative(float x, float y) {
		float rot = rotation();
		this.x += Angles.trnsx(rot, x * Time.delta, y * Time.delta);
		this.y += Angles.trnsy(rot, x * Time.delta, y * Time.delta);
	}

	public void read(Reads read) {
		afterRead();
	}

	public void remove() {
		if (added == false)
			return;
		Groups.all.remove(this);
		Groups.bullet.remove(this);
		Groups.draw.remove(this);
		bullet: {
			if (Groups.isClearing)
				break bullet;
			if (!hit) {
				type.despawned(this);
			}
			type.removed(this);
			collided.clear();
		}
		entity: {
			added = false;
		}
		mindustry.gen.Groups.queueFree((Pool.Poolable) this);
	}

	public void reset() {
		absorbed = false;
		added = false;
		aimTile = null;
		aimX = 0;
		aimY = 0;
		damage = 0;
		data = null;
		deltaX = 0;
		deltaY = 0;
		drag = 0.0F;
		fdata = 0;
		hit = false;
		hitSize = 0;
		id = EntityGroup.nextId();
		keepAlive = false;
		lastX = 0;
		lastY = 0;
		lifetime = 0;
		mover = null;
		originX = 0;
		originY = 0;
		owner = null;
		rotation = 0;
		time = 0;
		trail = null;
		type = null;
		x = 0;
		y = 0;
	}

	public void rotation(float angle) {
		vel.setAngle(rotation = angle);
	}

	public void set(Position pos) {
		set(pos.getX(), pos.getY());
	}

	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tileRaycast(int x1, int y1, int x2, int y2) {
		int x = x1;
		int dx = Math.abs(x2 - x);
		int sx = x < x2 ? 1 : -1;
		int y = y1;
		int dy = Math.abs(y2 - y);
		int sy = y < y2 ? 1 : -1;
		int e2;
		int err = dx - dy;
		int ww = world.width();
		int wh = world.height();
		while (x >= 0 && y >= 0 && x < ww && y < wh) {
			Building build = world.build(x, y);
			if (type.collideFloor || type.collideTerrain) {
				Tile tile = world.tile(x, y);
				if (type.collideFloor && (tile == null || tile.floor().hasSurface() || tile.block() != Blocks.air)
						|| type.collideTerrain && tile != null && tile.block() instanceof StaticWall) {
					remove();
					hit = true;
					return;
				}
			}
			if (build != null && isAdded() && checkUnderBuild(build, x, y) && build.collide(this)
					&& type.testCollision(this, build) && !build.dead() && (type.collidesTeam || build.team != team)
					&& !(type.pierceBuilding && hasCollided(build.id))) {
				boolean remove = false;
				float health = build.health;
				if (build.team != team) {
					remove = build.collision(this);
				}
				if (remove || type.collidesTeam) {
					if (Mathf.dst2(lastX, lastY, x * tilesize, y * tilesize) < Mathf.dst2(lastX, lastY, this.x,
							this.y)) {
						this.x = x * tilesize;
						this.y = y * tilesize;
					}
					if (!type.pierceBuilding) {
						hit = true;
						remove();
					} else {
						collided.add(build.id);
					}
				}
				type.hitTile(this, build, x * tilesize, y * tilesize, health, true);
				if (type.pierceBuilding)
					return;
			}
			if (x == x2 && y == y2)
				break;
			e2 = 2 * err;
			if (e2 > -dy) {
				err -= dy;
				x += sx;
			}
			if (e2 < dx) {
				err += dx;
				y += sy;
			}
		}
	}

	public void trns(Position pos) {
		trns(pos.getX(), pos.getY());
	}

	public void trns(float x, float y) {
		set(this.x + x, this.y + y);
	}

	public void turn(float x, float y) {
		float ang = vel.angle();
		vel.add(Angles.trnsx(ang, x * Time.delta, y * Time.delta), Angles.trnsy(ang, x * Time.delta, y * Time.delta))
				.limit(type.speed);
	}

	public void update() {
		vel: {
			if (!net.client() || isLocal()) {
				float px = x;
				float py = y;
				move(vel.x * Time.delta, vel.y * Time.delta);
				if (Mathf.equal(px, x))
					vel.x = 0;
				if (Mathf.equal(py, y))
					vel.y = 0;
				vel.scl(Math.max(1.0F - drag * Time.delta, 0));
			}
		}
		bullet: {
			if (mover != null) {
				mover.move(this);
			}
			type.update(this);
			if (type.collidesTiles && type.collides && type.collidesGround) {
				tileRaycast(World.toTile(lastX), World.toTile(lastY), tileX(), tileY());
			}
			if (type.removeAfterPierce && type.pierceCap != -1 && collided.size >= type.pierceCap) {
				hit = true;
				remove();
			}
			if (keepAlive) {
				time -= Time.delta;
				keepAlive = false;
			}
		}
		timed: {
			time = Math.min(time + Time.delta, lifetime);
			if (time >= lifetime) {
				remove();
			}
		}
	}

	public void updateLastPosition() {
		deltaX = x - lastX;
		deltaY = y - lastY;
		lastX = x;
		lastY = y;
	}

	public void velAddNet(Vec2 v) {
		vel.add(v);
		if (isRemote()) {
			x += v.x;
			y += v.y;
		}
	}

	public void velAddNet(float vx, float vy) {
		vel.add(vx, vy);
		if (isRemote()) {
			x += vx;
			y += vy;
		}
	}

	public void write(Writes write) {
	}
}
