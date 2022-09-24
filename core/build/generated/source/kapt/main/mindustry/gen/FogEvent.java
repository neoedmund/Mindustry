package mindustry.gen;

/**
 * Bits used: 56 / 64
 * <br>  x [0..16]
 * <br>  y [16..32]
 * <br>  radius [32..48]
 * <br>  team [48..56]
 */
public final class FogEvent {
  public static final long bitMaskX = (long)(0b0000000000000000000000000000000000000000000000001111111111111111L);

  public static final long bitMaskY = (long)(0b0000000000000000000000000000000011111111111111110000000000000000L);

  public static final long bitMaskRadius = (long)(0b0000000000000000111111111111111100000000000000000000000000000000L);

  public static final long bitMaskTeam = (long)(0b0000000011111111000000000000000000000000000000000000000000000000L);

  public static int x(long fogevent) {
    return (int)((fogevent >>> 0) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long x(long fogevent, int value) {
    return (long)((fogevent & (~0b0000000000000000000000000000000000000000000000001111111111111111L)) | ((long)value << 0L));
  }

  public static int y(long fogevent) {
    return (int)((fogevent >>> 16) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long y(long fogevent, int value) {
    return (long)((fogevent & (~0b0000000000000000000000000000000011111111111111110000000000000000L)) | ((long)value << 16L));
  }

  public static int radius(long fogevent) {
    return (int)((fogevent >>> 32) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long radius(long fogevent, int value) {
    return (long)((fogevent & (~0b0000000000000000111111111111111100000000000000000000000000000000L)) | ((long)value << 32L));
  }

  public static int team(long fogevent) {
    return (int)((fogevent >>> 48) & 0b0000000000000000000000000000000000000000000000000000000011111111L);
  }

  public static long team(long fogevent, int value) {
    return (long)((fogevent & (~0b0000000011111111000000000000000000000000000000000000000000000000L)) | ((long)value << 48L));
  }

  public static long get(int x, int y, int radius, int team) {
    return (long)((((long)x << 0L) & 0b0000000000000000000000000000000000000000000000001111111111111111L) | (((long)y << 16L) & 0b0000000000000000000000000000000011111111111111110000000000000000L) | (((long)radius << 32L) & 0b0000000000000000111111111111111100000000000000000000000000000000L) | (((long)team << 48L) & 0b0000000011111111000000000000000000000000000000000000000000000000L));
  }
}
