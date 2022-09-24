package mindustry.gen;

/**
 * Bits used: 26 / 32
 * <br>  health [0..8]
 * <br>  team [8..16]
 * <br>  solid [16..17]
 * <br>  liquid [17..18]
 * <br>  legSolid [18..19]
 * <br>  nearLiquid [19..20]
 * <br>  nearGround [20..21]
 * <br>  nearSolid [21..22]
 * <br>  deep [22..23]
 * <br>  damages [23..24]
 * <br>  allDeep [24..25]
 * <br>  teamPassable [25..26]
 */
public final class PathTile {
  public static final int bitMaskHealth = (int)(0b00000000000000000000000011111111L);

  public static final int bitMaskTeam = (int)(0b00000000000000001111111100000000L);

  public static final int bitMaskSolid = (int)(1L << 16);

  public static final int bitMaskLiquid = (int)(1L << 17);

  public static final int bitMaskLegSolid = (int)(1L << 18);

  public static final int bitMaskNearLiquid = (int)(1L << 19);

  public static final int bitMaskNearGround = (int)(1L << 20);

  public static final int bitMaskNearSolid = (int)(1L << 21);

  public static final int bitMaskDeep = (int)(1L << 22);

  public static final int bitMaskDamages = (int)(1L << 23);

  public static final int bitMaskAllDeep = (int)(1L << 24);

  public static final int bitMaskTeamPassable = (int)(1L << 25);

  public static int health(int pathtile) {
    return (int)((pathtile >>> 0) & 0b00000000000000000000000011111111L);
  }

  public static int health(int pathtile, int value) {
    return (int)((pathtile & (~0b00000000000000000000000011111111L)) | ((int)value << 0L));
  }

  public static int team(int pathtile) {
    return (int)((pathtile >>> 8) & 0b00000000000000000000000011111111L);
  }

  public static int team(int pathtile, int value) {
    return (int)((pathtile & (~0b00000000000000001111111100000000L)) | ((int)value << 8L));
  }

  public static boolean solid(int pathtile) {
    return (pathtile & (1L << 16)) != 0;
  }

  public static int solid(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 16L)));
    } else {
      return (int)((pathtile & ~(1L << 16L)) | (1L << 16L));
    }
  }

  public static boolean liquid(int pathtile) {
    return (pathtile & (1L << 17)) != 0;
  }

  public static int liquid(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 17L)));
    } else {
      return (int)((pathtile & ~(1L << 17L)) | (1L << 17L));
    }
  }

  public static boolean legSolid(int pathtile) {
    return (pathtile & (1L << 18)) != 0;
  }

  public static int legSolid(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 18L)));
    } else {
      return (int)((pathtile & ~(1L << 18L)) | (1L << 18L));
    }
  }

  public static boolean nearLiquid(int pathtile) {
    return (pathtile & (1L << 19)) != 0;
  }

  public static int nearLiquid(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 19L)));
    } else {
      return (int)((pathtile & ~(1L << 19L)) | (1L << 19L));
    }
  }

  public static boolean nearGround(int pathtile) {
    return (pathtile & (1L << 20)) != 0;
  }

  public static int nearGround(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 20L)));
    } else {
      return (int)((pathtile & ~(1L << 20L)) | (1L << 20L));
    }
  }

  public static boolean nearSolid(int pathtile) {
    return (pathtile & (1L << 21)) != 0;
  }

  public static int nearSolid(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 21L)));
    } else {
      return (int)((pathtile & ~(1L << 21L)) | (1L << 21L));
    }
  }

  public static boolean deep(int pathtile) {
    return (pathtile & (1L << 22)) != 0;
  }

  public static int deep(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 22L)));
    } else {
      return (int)((pathtile & ~(1L << 22L)) | (1L << 22L));
    }
  }

  public static boolean damages(int pathtile) {
    return (pathtile & (1L << 23)) != 0;
  }

  public static int damages(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 23L)));
    } else {
      return (int)((pathtile & ~(1L << 23L)) | (1L << 23L));
    }
  }

  public static boolean allDeep(int pathtile) {
    return (pathtile & (1L << 24)) != 0;
  }

  public static int allDeep(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 24L)));
    } else {
      return (int)((pathtile & ~(1L << 24L)) | (1L << 24L));
    }
  }

  public static boolean teamPassable(int pathtile) {
    return (pathtile & (1L << 25)) != 0;
  }

  public static int teamPassable(int pathtile, boolean value) {
    if(value) {
      return (int)((pathtile & ~(1L << 25L)));
    } else {
      return (int)((pathtile & ~(1L << 25L)) | (1L << 25L));
    }
  }

  public static int get(int health, int team, boolean solid, boolean liquid, boolean legSolid,
      boolean nearLiquid, boolean nearGround, boolean nearSolid, boolean deep, boolean damages,
      boolean allDeep, boolean teamPassable) {
    return (int)((((int)health << 0L) & 0b00000000000000000000000011111111L) | (((int)team << 8L) & 0b00000000000000001111111100000000L) | (solid ? 1L << 16L : 0) | (liquid ? 1L << 17L : 0) | (legSolid ? 1L << 18L : 0) | (nearLiquid ? 1L << 19L : 0) | (nearGround ? 1L << 20L : 0) | (nearSolid ? 1L << 21L : 0) | (deep ? 1L << 22L : 0) | (damages ? 1L << 23L : 0) | (allDeep ? 1L << 24L : 0) | (teamPassable ? 1L << 25L : 0));
  }
}
