package mindustry.gen;

/**
 * Bits used: 48 / 64
 * <br>  block [0..16]
 * <br>  floor [16..32]
 * <br>  overlay [32..48]
 */
public final class PackTile {
  public static final long bitMaskBlock = (long)(0b0000000000000000000000000000000000000000000000001111111111111111L);

  public static final long bitMaskFloor = (long)(0b0000000000000000000000000000000011111111111111110000000000000000L);

  public static final long bitMaskOverlay = (long)(0b0000000000000000111111111111111100000000000000000000000000000000L);

  public static short block(long packtile) {
    return (short)((packtile >>> 0) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long block(long packtile, short value) {
    return (long)((packtile & (~0b0000000000000000000000000000000000000000000000001111111111111111L)) | ((long)value << 0L));
  }

  public static short floor(long packtile) {
    return (short)((packtile >>> 16) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long floor(long packtile, short value) {
    return (long)((packtile & (~0b0000000000000000000000000000000011111111111111110000000000000000L)) | ((long)value << 16L));
  }

  public static short overlay(long packtile) {
    return (short)((packtile >>> 32) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long overlay(long packtile, short value) {
    return (long)((packtile & (~0b0000000000000000111111111111111100000000000000000000000000000000L)) | ((long)value << 32L));
  }

  public static long get(short block, short floor, short overlay) {
    return (long)((((long)block << 0L) & 0b0000000000000000000000000000000000000000000000001111111111111111L) | (((long)floor << 16L) & 0b0000000000000000000000000000000011111111111111110000000000000000L) | (((long)overlay << 32L) & 0b0000000000000000111111111111111100000000000000000000000000000000L));
  }
}
