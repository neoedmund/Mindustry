package neoe.mindustry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mindustry.world.Tile;
import mindustry.world.Tiles;

public class Patchlize {
	List sb;
	Tiles tiles;

	public Patchlize(List sb, Tiles tiles) {
		this.sb = sb;
		this.tiles = tiles;
	}

	int w, h;
	private byte[] b, b2;
	private int cnt;
	short id;

	public void run() {
		w = tiles.width;
		h = tiles.height;
		b = new byte[h * w];// for count taken
		b2 = new byte[h * w];// for single turn searched
		Map<String, List<Object[]>> m = new HashMap();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int p = y * w + x;
				if (b[p] != 0)
					continue;
				b[p] = 1;
				Tile t = tiles.get(x, y);
				id = t.overlayID();
				if (id == 0)
					continue;
				String name = t.overlay().localizedName;
				List ps = (List) m.get(name);
				if (ps == null) {
					ps = new ArrayList();
					m.put(name, ps);
				}
				Arrays.fill(b2, (byte) 0);
				cnt = 1;
				findPatchDeepFirst(x, y);// maybe can return more info
				ps.add(new Object[] { cnt, x, y });
			}
		}

		for (String name : m.keySet()) {
			List<Object[]> v = m.get(name);
			v.sort((b, a) -> {
				int c1 = Integer.compare((int) a[0], (int) b[0]);
				if (c1 == 0)
					return Integer.compare((int) a[1], (int) b[1]);
				else
					return c1;
			});
			print(sb, "%s patch:%d [\n", name, v.size());
			for (Object[] r : v) {
				print(sb, "  cnt:%,d near (%d x %d)\n", r[0], r[1], r[2]);
			}
			print(sb, "]\n");
		}

	}

	private static void print(List sb, String fmt, Object... args) {
		sb.add(String.format(fmt, args));
	}

	private void findPatchDeepFirst(int x, int y) {
		int k = 5;
		for (int i = -k; i <= k; i++) {
			for (int j = -k; j <= k; j++) {
				if (i == 0 && j == 0)
					continue;
				int x1 = x + i;
				int y1 = y + j;
				if (x1 < 0 || x1 >= w || y1 < 0 || y1 >= h)
					continue;
				int p1 = x1 + y1 * w;
				if (b[p1] != 0 || b2[p1] != 0)
					continue;
				b2[p1] = 1;
				short id1 = tiles.get(x1, y1).overlayID();
				if (id1 == id) {
					b[p1] = 1;
					cnt++;
					findPatchDeepFirst(x1, y1);
				}
			}
		}
	}
}
