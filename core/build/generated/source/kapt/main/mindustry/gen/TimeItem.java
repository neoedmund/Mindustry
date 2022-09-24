package mindustry.gen;

/**
 * Bits used: 64 / 64
 * <br>  data [0..16]
 * <br>  item [16..32]
 * <br>  time [32..64]
 */
public final class TimeItem {
  public static final long bitMaskData = (long)(0b0000000000000000000000000000000000000000000000001111111111111111L);

  public static final long bitMaskItem = (long)(0b0000000000000000000000000000000011111111111111110000000000000000L);

  public static final long bitMaskTime = (long)(0b1111111111111111111111111111111100000000000000000000000000000000L);

  public static short data(long timeitem) {
    return (short)((timeitem >>> 0) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long data(long timeitem, short value) {
    return (long)((timeitem & (~0b0000000000000000000000000000000000000000000000001111111111111111L)) | ((long)value << 0L));
  }

  public static short item(long timeitem) {
    return (short)((timeitem >>> 16) & 0b0000000000000000000000000000000000000000000000001111111111111111L);
  }

  public static long item(long timeitem, short value) {
    return (long)((timeitem & (~0b0000000000000000000000000000000011111111111111110000000000000000L)) | ((long)value << 16L));
  }

  public static float time(long timeitem) {
    return Float.intBitsToFloat((int)((timeitem >>> 32) & 0b0000000000000000000000000000000011111111111111111111111111111111L));
  }

  public static long time(long timeitem, float value) {
    return (long)((timeitem & (~0b1111111111111111111111111111111100000000000000000000000000000000L)) | ((long)Float.floatToIntBits(value) << 32L));
  }

  public static long get(short data, short item, float time) {
    return (long)((((long)data << 0L) & 0b0000000000000000000000000000000000000000000000001111111111111111L) | (((long)item << 16L) & 0b0000000000000000000000000000000011111111111111110000000000000000L) | ((long)Float.floatToIntBits(time) << 32L));
  }
}
