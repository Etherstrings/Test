package Tool.Majiang;

/**
 * @author Justice_wby
 * @create 2023-02-03 2:34
 */

/**
 * 支持 import Java 标准库 (JDK 1.8)
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeUnit;

/**
 * 注意：目前 Java 代码的入口类名称必须为 Main（大小写敏感）
 */
public class Main {

    public enum Tile {
        NL(Suit.NL.ordinal(), ""),

        S1(Suit.Sticks.ordinal(), "一索"), S2(Suit.Sticks.ordinal(), "二索"), S3(Suit.Sticks.ordinal(), "三索"), S4(Suit.Sticks.ordinal(), "四索"), S5(Suit.Sticks.ordinal(), "五索"), S6(Suit.Sticks.ordinal(), "六索"), S7(Suit.Sticks.ordinal(), "七索"), S8(Suit.Sticks.ordinal(), "八索"), S9(Suit.Sticks.ordinal(), "九索"),
        D1(Suit.Dots.ordinal(), "一筒"), D2(Suit.Dots.ordinal(), "二筒"), D3(Suit.Dots.ordinal(), "三筒"), D4(Suit.Dots.ordinal(), "四筒"), D5(Suit.Dots.ordinal(), "五筒"), D6(Suit.Dots.ordinal(), "六筒"), D7(Suit.Dots.ordinal(), "七筒"), D8(Suit.Dots.ordinal(), "八筒"), D9(Suit.Dots.ordinal(), "九筒"),
        M1(Suit.Myriads.ordinal(), "一万"), M2(Suit.Myriads.ordinal(), "二万"), M3(Suit.Myriads.ordinal(), "三万"), M4(Suit.Myriads.ordinal(), "四万"), M5(Suit.Myriads.ordinal(), "五万"), M6(Suit.Myriads.ordinal(), "六万"), M7(Suit.Myriads.ordinal(), "七万"), M8(Suit.Myriads.ordinal(), "八万"), M9(Suit.Myriads.ordinal(), "九万"),

        East(Suit.Winds.ordinal(), "东"), South(Suit.Winds.ordinal(), "南"), West(Suit.Winds.ordinal(), "西"), North(Suit.Winds.ordinal(), "北"),
        Red(Suit.Arrows.ordinal(), "红中"), Green(Suit.Arrows.ordinal(), "发财"), White(Suit.Arrows.ordinal(), "白板"),

        Plum(Suit.Flowers.ordinal(), "梅"), Orchid(Suit.Flowers.ordinal(), "兰"), Chrysanthemum(Suit.Flowers.ordinal(), "菊"), Bamboo(Suit.Flowers.ordinal(), "竹"),
        Spring(Suit.Seasons.ordinal(), "春"), Summer(Suit.Seasons.ordinal(), "夏"), Autumn(Suit.Seasons.ordinal(), "秋"), Winter(Suit.Seasons.ordinal(), "冬");

        /**
         * 当前牌的花色
         */
        private final int suit;

        private final String desc;

        Tile(int suit, String desc){
            this.suit = suit;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return this.desc;
        }

        public static Tile toTile(int v) {
            return Tile.values()[v];
        }
    }

    public enum Suit {
        NL,
        Sticks,
        Dots,
        Myriads,
        Winds,
        Arrows,
        Flowers,
        Seasons;
    }

    public enum Melds {
        Unknown,
        Single,
        Eyes,
        Chow,
        Pong,
        Kong;
    }

    public static class MJMeld {

        public final int firstRealTile;

        public final Suit suit;

        public final Melds meld;

        public final int[] tiles;

        public MJMeld(int firstRealTile, Suit suit, Melds meld, int[] tiles) {
            this.firstRealTile = firstRealTile;
            this.suit = suit;
            this.meld = meld;
            this.tiles = tiles;
        }
    }

    public static final boolean isHonors(Tile tile) {
        return tile.ordinal() >= Tile.East.ordinal() && tile.ordinal() <= Tile.White.ordinal();
    }

    public static final boolean isHonors(Suit suit) {
        return suit == Suit.Winds || suit == Suit.Arrows;
    }

    //清一色 胡牌时只有万，索，筒中的一种牌色组成
    public static boolean isQingYiSe(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }

        int suitTemp = Suit.NL.ordinal();
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (suitTemp == Suit.NL.ordinal()) {
                    if (mjMeld.suit.ordinal() > Suit.Myriads.ordinal()) {
                        return false;
                    }
                    suitTemp = mjMeld.suit.ordinal();
                } else {
                    if (suitTemp == mjMeld.suit.ordinal()) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (Tile t : holdingTiles) {
            if (suitTemp == Suit.NL.ordinal()) {
                if (t.suit > Suit.Myriads.ordinal()) {
                    return false;
                }
                suitTemp = t.suit;
            } else {
                if (suitTemp == t.suit) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    };

    //移除可能顺子
    public static void removeShunzi(int[] countTile, int start, int end) {
        for (; start < end;) {
            if (countTile[start] > 0 && countTile[start + 1] > 0 && countTile[start + 2] > 0 ) { //可能组成顺子
                countTile[start]--;
                countTile[start + 1]--;
                countTile[start + 2]--;
            }
            if (countTile[start] == 0 || countTile[start + 1] == 0 || countTile[start + 2] == 0) {
                start++;
            }
        }
    }

    //看剩下的是刻子 或者 0
    public static boolean isKeZi(int[] countTile){
        for (int i = 0; i < countTile.length; i++) {
            if (countTile[i] != 0 && countTile[i] != 3) {
                return false;
            }
        }
        return true;
    }
    //七小对
    public static boolean isQiXiaoDui(int[] countTile, int tileNum) {
        if (tileNum != 14) {
            return false;
        }
        for (int i = 1; i < countTile.length; i++) {
            if (countTile[i] != 0 && countTile[i] != 2 && countTile[i] !=4) {
                return false;
            }
        }
        return true;
    }

    public static boolean isQiXiaoDui(List<Tile> holdingTiles, Tile winTile) {
        if (holdingTiles == null || holdingTiles.size() == 0) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;

        if(isQiXiaoDui(countTile, holdingTiles.size() + 1 )) {
            return true;
        }
        return false;
    }

    public static boolean isHu(List<Tile> holdingTiles, Tile winTile) {
        if (holdingTiles == null || holdingTiles.size() == 0) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;

        if(isQiXiaoDui(countTile, holdingTiles.size() + 1 )) {
            return true;
        }

        if(isShiSanYao(holdingTiles, winTile )) {
            return true;
        }

        for (int duizi = 1; duizi < countTile.length; duizi++) {
            int[] countTileTmp = Arrays.copyOf(countTile, countTile.length);
            if (countTileTmp[duizi] < 2) {
                continue;
            }
            //移除可能组成将
            countTileTmp[duizi] = countTileTmp[duizi] - 2;

            //移除可能顺子
            removeShunzi(countTileTmp, Tile.S1.ordinal(),  Tile.S8.ordinal());
            removeShunzi(countTileTmp, Tile.D1.ordinal(),  Tile.D8.ordinal());
            removeShunzi(countTileTmp, Tile.M1.ordinal(),  Tile.M8.ordinal());

            if (isKeZi(countTileTmp)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    };

    //混一色  胡牌时除了万，索，筒中的一种牌色，还有字牌
    public static boolean isHunYiSe(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        boolean existHonors = false; //是否存在字牌
        int suitTemp = Suit.NL.ordinal();
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (isHonors(mjMeld.suit)) { //如果是字牌就不用看
                    existHonors = true;
                    continue;
                }
                if (suitTemp == Suit.NL.ordinal()) {
                    if (mjMeld.suit.ordinal() > Suit.Myriads.ordinal()) {
                        return false;
                    }
                    suitTemp = mjMeld.suit.ordinal();
                } else {
                    if (suitTemp == mjMeld.suit.ordinal()) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (Tile t : holdingTiles) {
            if (isHonors(t)) { //如果是字牌就不用看
                existHonors = true;
                continue;
            }
            if (suitTemp == Suit.NL.ordinal()) {
                if (t.suit > Suit.Myriads.ordinal()) {
                    return false;
                }
                suitTemp = t.suit;
            } else {
                if (suitTemp == t.suit) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (existHonors) {
            return true;
        } else {
            return false;
        }
    }

    //字一色  胡牌时只有字牌
    public static boolean isZiYiSe(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        int suitTemp = Suit.NL.ordinal();
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (!isHonors(mjMeld.suit)) {
                    return false;
                }
            }
        }

        for (Tile t : holdingTiles) {
            if (!isHonors(t)) {
                return false;
            }
        }
        return true;
    }

    //碰碰胡
    public static boolean isPengPengHu(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (mjMeld.meld == Melds.Chow) { //有吃就不是
                    return false;
                }
            }
        } else {
            if (isQiXiaoDui(holdingTiles, winTile)) {
                return false;
            }
        }
        return true;
    }

    //获取序列值
    public static int getSeq(int num) {
        if (num == Tile.S1.ordinal() || num == Tile.D1.ordinal() || num == Tile.M1.ordinal()) {
            return 1;
        } else if (num == Tile.S2.ordinal() || num == Tile.D2.ordinal() || num == Tile.M2.ordinal()) {
            return 2;
        } else if (num == Tile.S3.ordinal() || num == Tile.D3.ordinal() || num == Tile.M3.ordinal()) {
            return 3;
        } else if (num == Tile.S4.ordinal() || num == Tile.D4.ordinal() || num == Tile.M4.ordinal()) {
            return 4;
        } else if (num == Tile.S5.ordinal() || num == Tile.D5.ordinal() || num == Tile.M5.ordinal()) {
            return 5;
        } else if (num == Tile.S6.ordinal() || num == Tile.D6.ordinal() || num == Tile.M6.ordinal()) {
            return 6;
        } else if (num == Tile.S7.ordinal() || num == Tile.D7.ordinal() || num == Tile.M7.ordinal()) {
            return 7;
        } else if (num == Tile.S8.ordinal() ||  num == Tile.D8.ordinal() || num == Tile.M8.ordinal()) {
            return 8;
        }  else if (num == Tile.S9.ordinal() ||  num == Tile.D9.ordinal() || num == Tile.M9.ordinal()) {
            return 9;
        }  else {
            return -1;
        }
    }

    //获取序列值
    public static int getSeq(Tile tile) {
        return getSeq(tile.ordinal());
    }

    //检查连续的序列
    public static boolean checkSeq(int[] countTile, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (countTile[i] > 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    //一条龙 ：有一种相同花色的123，456，789三副顺子
    public static boolean isYiTiaoLong(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (mjMeld.meld == Melds.Chow) {
                    int[] tempTiles = mjMeld.tiles;
                    Arrays.sort(tempTiles);
                    if (getSeq(tempTiles[0]) == 1 || getSeq(tempTiles[0]) == 4 || getSeq(tempTiles[0]) == 7) {
                        for (int i = 0; i < tempTiles.length; i++) {
                            countTile[tempTiles[i]]++;
                        }
                    }
                }
            }
        }
        if (checkSeq(countTile, Tile.S1.ordinal(), Tile.S9.ordinal()) || checkSeq(countTile, Tile.D1.ordinal(), Tile.D9.ordinal()) ||
                checkSeq(countTile, Tile.M1.ordinal(), Tile.M9.ordinal())) {
            return true;
        }
        return false;
    }


    //小三元 : 中/发/白，其中2个做刻子或杠，另一个做将
    public static boolean isXiaoSanYuan(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;
        int pongKongNum = 0;
        int eyesNum = 0;
        for (int i = Tile.Red.ordinal(); i <= Tile.White.ordinal(); i++) {
            if (countTile[i] == 3) {
                pongKongNum ++;
            } else if(countTile[i] == 2){
                eyesNum ++;
            }
        }
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (mjMeld.suit == Suit.Arrows && (mjMeld.meld == Melds.Pong || mjMeld.meld == Melds.Kong)) {
                    pongKongNum ++;
                }
            }
        }
        return pongKongNum == 2 && eyesNum == 1;
    }

    //大三元 : 中/发/白，其中3个做刻子或杠
    public static boolean isDaSanYuan(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;
        int pongKongNum = 0;
        for (int i = Tile.Red.ordinal(); i <= Tile.White.ordinal(); i++) {
            if (countTile[i] == 3) {
                pongKongNum ++;
            }
        }
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (mjMeld.suit == Suit.Arrows && (mjMeld.meld == Melds.Pong || mjMeld.meld == Melds.Kong)) {
                    pongKongNum ++;
                }
            }
        }
        return pongKongNum == 3;
    }

    //小四喜: 东/南/西/北，其中3个做刻子或杠，另一个做将，不计风刻
    public static boolean isXiaoSiXi(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;
        int pongKongNum = 0;
        int eyesNum = 0;
        for (int i = Tile.East.ordinal(); i <= Tile.North.ordinal(); i++) {
            if (countTile[i] == 3) {
                pongKongNum ++;
            } else if(countTile[i] == 2){
                eyesNum ++;
            }
        }
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (mjMeld.suit == Suit.Winds && (mjMeld.meld == Melds.Pong || mjMeld.meld == Melds.Kong)) {
                    pongKongNum ++;
                }
            }
        }
        return pongKongNum == 3 && eyesNum == 1;
    }

    //大四喜: 东/南/西/北，4个刻子（杠）
    public static boolean isDaSiXi(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        int[] countTile = new int[Tile.values().length];
        for (int i = 0; i < holdingTiles.size(); i++) {
            countTile[holdingTiles.get(i).ordinal()]++;
        }
        countTile[winTile.ordinal()]++;
        int pongKongNum = 0;
        for (int i = Tile.East.ordinal(); i <= Tile.North.ordinal(); i++) {
            if (countTile[i] == 3) {
                pongKongNum ++;
            }
        }
        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if (mjMeld.suit == Suit.Winds && (mjMeld.meld == Melds.Pong || mjMeld.meld == Melds.Kong)) {
                    pongKongNum ++;
                }
            }
        }
        return pongKongNum == 4;
    }

    //小幺九:  由万索筒的1、9牌和字牌组成的和牌
    public static boolean isXiaoYaoJiu(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        boolean existHonors = false; //是否存在字牌
        holdingTiles.add(winTile);
        for (int i = 0; i < holdingTiles.size(); i++) {
            Tile t = holdingTiles.get(i);
            if (isHonors(t)) {
                if (!existHonors) {
                    existHonors = true;
                }
                continue;
            }
            if (t.ordinal() >= Tile.S1.ordinal() && t.ordinal() <= Tile.M9.ordinal()) {
                //检验是1 或者 9
                if (getSeq(t) != 1 && getSeq(t) != 9) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if ((mjMeld.meld == Melds.Pong || mjMeld.meld == Melds.Kong)) {
                    Tile t = Tile.toTile(mjMeld.firstRealTile);
                    if (isHonors(mjMeld.suit)) {
                        if (!existHonors) {
                            existHonors = true;
                        }
                        continue;
                    }
                    if (t.ordinal() >= Tile.S1.ordinal() && t.ordinal() <= Tile.M9.ordinal()) {
                        //检验是1 或者 9
                        if (getSeq(t) != 1 && getSeq(t) != 9) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //大幺九:  由万索筒的1、9牌组成的和牌
    public static boolean isDaYaoJiu(List<Tile> holdingTiles, List<MJMeld> meldedTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        holdingTiles.add(winTile);
        for (int i = 0; i < holdingTiles.size(); i++) {
            Tile t = holdingTiles.get(i);
            if (isSerialTile(t)) {
                //检验是1 或者 9
                if (getSeq(t) != 1 && getSeq(t) != 9) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (meldedTiles != null && meldedTiles.size() > 0) {
            for (MJMeld mjMeld : meldedTiles) {
                if ((mjMeld.meld == Melds.Pong || mjMeld.meld == Melds.Kong)) {
                    Tile t = Tile.toTile(mjMeld.firstRealTile);
                    if (isSerialTile(t)) {
                        //检验是1 或者 9
                        if (getSeq(t) != 1 && getSeq(t) != 9) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //是否序列牌
    public static boolean isSerialTile(Tile t) {
        if (t.suit == Suit.Myriads.ordinal() || t.suit == Suit.Dots.ordinal() || t.suit == Suit.Sticks.ordinal()) {
            return true;
        }
        return false;
    }

    //九莲宝灯，由一种花色序数牌按1112345678999组成的特定牌型，不能吃、碰、杠牌
    public static boolean isJiuLianBaoDeng(List<Tile> holdingTiles, Tile winTile) {
        if (!isHu(holdingTiles, winTile)) {
            return false;
        }
        if (holdingTiles.size() + 1 != 14) {
            return false;
        }

        int suitTemp = Suit.NL.ordinal();
        int[] seqs = new int[10];
        for (int i = 0; i < holdingTiles.size(); i++) {
            Tile t = holdingTiles.get(i);
            if (isSerialTile(t)) {
                if (suitTemp == Suit.NL.ordinal()) {
                    suitTemp = t.suit;
                } else if (suitTemp != t.suit){
                    return false;
                } else {

                }
            } else {
                return false;
            }
            seqs[getSeq(t)]++;
        }

        for (int i = 1; i < seqs.length; i++) {
            if ((i == 1 || i == 9) && seqs[i] != 3){
                return false;
            }
            if ((i != 1 && i != 9) && seqs[i] != 1) {
                return false;
            }
        }
        if (winTile.suit == suitTemp) {
            return true;
        } else {
            return false;
        }

    }

    //十三幺是由1筒、9筒、1索、9索、1万、9万、东、南、西、北、中、发、白十三种牌组成的
    public static boolean isShiSanYao(List<Tile> holdingTiles, Tile winTile) {
        if (holdingTiles.size() + 1 != 14) {
            return false;
        }
        if (holdingTiles.contains(Tile.S1) && holdingTiles.contains(Tile.S9)
                &&holdingTiles.contains(Tile.M1) && holdingTiles.contains(Tile.M9)
                &&holdingTiles.contains(Tile.D1) && holdingTiles.contains(Tile.D9)
                &&holdingTiles.contains(Tile.East) && holdingTiles.contains(Tile.North)
                &&holdingTiles.contains(Tile.West) && holdingTiles.contains(Tile.South)
                &&holdingTiles.contains(Tile.Red) && holdingTiles.contains(Tile.Green)
                &&holdingTiles.contains(Tile.White)) {
            if (holdingTiles.contains(winTile)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    };

    public static void main(String[] args) {

        List<Tile> tiles = Stream.of( Tile.D1, Tile.S1,
                Tile.S1, Tile.S2, Tile.S3,
                Tile.S3, Tile.S2, Tile.S5,
                Tile.S6, Tile.S7, Tile.M6,
                Tile.M7, Tile.M8).collect(Collectors.toList());

        System.out.println(tiles + "\n结果: " + isHu(tiles, Tile.D1));

        tiles = Stream.of(Tile.West, Tile.West, Tile.S1,
                Tile.S1, Tile.S3, Tile.S3,
                Tile.S6, Tile.S6, Tile.M5,
                Tile.M5,
                Tile.D1).collect(Collectors.toList());

        System.out.println(tiles + "\n结果: " +isHu(tiles, Tile.D1));

        tiles = Stream.of(Tile.West, Tile.West, Tile.S1,
                Tile.S1, Tile.S3, Tile.S3,
                Tile.S6, Tile.S6, Tile.M5,
                Tile.M5, Tile.M9, Tile.M1,
                Tile.D1).collect(Collectors.toList());

        System.out.println(tiles + "\n结果: " +isHu(tiles, Tile.D1));

        System.out.println("\n全部手牌清一色：");
        tiles = Stream.of( Tile.S5, Tile.S1,
                Tile.S1, Tile.S2, Tile.S3,
                Tile.S3, Tile.S2, Tile.S5,
                Tile.S6, Tile.S7, Tile.S6,
                Tile.S7, Tile.S8).collect(Collectors.toList());

        System.out.println(tiles + "\n结果: " + isQingYiSe(tiles, null, Tile.S5));

        System.out.println("\n有吃碰的清一色：");
        tiles = Stream.of( Tile.S5, Tile.S1,
                Tile.S1, Tile.S2, Tile.S3,
                Tile.S3, Tile.S2).collect(Collectors.toList());

        List<MJMeld> meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.S5.ordinal(),  Suit.Sticks, Melds.Chow, new int[]{Tile.S5.ordinal(), Tile.S6.ordinal(), Tile.S7.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.S5.ordinal(),  Suit.Sticks, Melds.Pong, new int[]{Tile.S5.ordinal(), Tile.S6.ordinal(), Tile.S7.ordinal()}));
        System.out.println(tiles + "\n结果: " + isQingYiSe(tiles, meldedTiles, Tile.S5));

        System.out.println("\n不同花色吃碰的不是清一色：");
        tiles = Stream.of( Tile.S5, Tile.S1,
                Tile.S1, Tile.S2, Tile.S3,
                Tile.S3, Tile.S2).collect(Collectors.toList());

        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.S5.ordinal(),  Suit.Sticks, Melds.Chow, new int[]{Tile.S5.ordinal(), Tile.S6.ordinal(), Tile.S7.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D8.ordinal(),  Suit.Dots, Melds.Pong, new int[]{Tile.D8.ordinal(), Tile.D8.ordinal(), Tile.D8.ordinal()}));
        System.out.println(tiles  + "\n结果: " + isQingYiSe(tiles, meldedTiles, Tile.S5));

        System.out.println("\n全部手牌混一色：");
        tiles = Stream.of( Tile.S5, Tile.S1,
                Tile.South, Tile.S2, Tile.South,
                Tile.S3, Tile.South, Tile.S5,
                Tile.S6, Tile.S7, Tile.S6,
                Tile.S7, Tile.S8).collect(Collectors.toList());

        System.out.println(tiles + "\n结果: " + isHunYiSe(tiles, null, Tile.S5));

        System.out.println("\n有吃碰的混一色：");
        tiles = Stream.of( Tile.S5, Tile.East,
                Tile.East, Tile.East, Tile.S1,
                Tile.S3, Tile.S2).collect(Collectors.toList());

        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.S5.ordinal(),  Suit.Sticks, Melds.Chow, new int[]{Tile.S5.ordinal(), Tile.S6.ordinal(), Tile.S7.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.S5.ordinal(),  Suit.Sticks, Melds.Pong, new int[]{Tile.S5.ordinal(), Tile.S6.ordinal(), Tile.S7.ordinal()}));
        System.out.println(tiles + "\n结果: " + isHunYiSe(tiles, meldedTiles, Tile.S5));

        System.out.println("\n全部手牌字一色：");
        tiles = Stream.of( Tile.West, Tile.West,
                Tile.West, Tile.North, Tile.North,
                Tile.North, Tile.South, Tile.South,
                Tile.South, Tile.East, Tile.East,
                Tile.East, Tile.Green).collect(Collectors.toList());

        System.out.println(tiles + "\n结果: " + isZiYiSe(tiles, null, Tile.Green));

        System.out.println("\n有杠碰字一色：");
        tiles = Stream.of( Tile.North, Tile.North,
                Tile.North, Tile.South, Tile.South,
                Tile.South,  Tile.Green).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.West.ordinal(),  Suit.Winds, Melds.Kong, new int[]{Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.Red.ordinal(),  Suit.Arrows, Melds.Pong, new int[]{Tile.Red.ordinal(), Tile.Red.ordinal(), Tile.Red.ordinal()}));
        System.out.println(tiles + "\n结果: " + isZiYiSe(tiles, meldedTiles, Tile.Green));

        System.out.println("\n有杠碰 碰碰胡：");
        tiles = Stream.of( Tile.North, Tile.North,
                Tile.North, Tile.South, Tile.South,
                Tile.South,  Tile.Green).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.West.ordinal(),  Suit.Winds, Melds.Kong, new int[]{Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.Red.ordinal(),  Suit.Arrows, Melds.Pong, new int[]{Tile.Red.ordinal(), Tile.Red.ordinal(), Tile.Red.ordinal()}));
        System.out.println(tiles + "\n结果: " + isPengPengHu(tiles, meldedTiles, Tile.Green));

        System.out.println("\n 七小对不是碰碰胡：");
        tiles = Stream.of( Tile.North, Tile.North,
                Tile.North, Tile.North, Tile.South,
                Tile.South,  Tile.South,  Tile.South,
                Tile.Red,  Tile.Red,  Tile.Red,
                Tile.Bamboo,  Tile.Bamboo).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isPengPengHu(tiles, null, Tile.Red));

        System.out.println("\n 七小对：");
        tiles = Stream.of( Tile.North, Tile.North,
                Tile.North, Tile.North, Tile.South,
                Tile.South,  Tile.South,  Tile.South,
                Tile.Red,  Tile.Red,  Tile.Red,
                Tile.Bamboo,  Tile.Bamboo).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isQiXiaoDui(tiles, Tile.Red));

        System.out.println("\n 一条龙：");
        tiles = Stream.of( Tile.S1, Tile.S1,
                Tile.D1, Tile.D2, Tile.D3,
                Tile.D4,  Tile.D5,  Tile.D7,
                Tile.D8,  Tile.Red,  Tile.Red,
                Tile.D6,  Tile.Red).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isYiTiaoLong(tiles, null, Tile.D9));

        System.out.println("\n 有吃的 一条龙：");
        tiles = Stream.of( Tile.S1,
                Tile.Red,  Tile.Red, Tile.Red).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.D1.ordinal(),  Suit.Dots, Melds.Chow, new int[]{Tile.D3.ordinal(), Tile.D2.ordinal(), Tile.D1.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D7.ordinal(),  Suit.Dots, Melds.Chow, new int[]{Tile.D9.ordinal(), Tile.D7.ordinal(), Tile.D8.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D4.ordinal(),  Suit.Dots, Melds.Chow, new int[]{Tile.D4.ordinal(), Tile.D6.ordinal(), Tile.D5.ordinal()}));
        System.out.println(tiles + "\n结果: " + isYiTiaoLong(tiles, meldedTiles, Tile.S1));

        System.out.println("\n 全部手牌小三元:");
        tiles = Stream.of( Tile.S1, Tile.S2,
                Tile.S3, Tile.D5, Tile.D5,
                Tile.D5,  Tile.White,  Tile.Red,
                Tile.Red,  Tile.Red,  Tile.Green,
                Tile.Green,  Tile.Green).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isXiaoSanYuan(tiles, null, Tile.White));

        System.out.println("\n 有碰杠的 小三元：");
        tiles = Stream.of( Tile.S1,
                Tile.S1,  Tile.S1, Tile.Red).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.White.ordinal(),  Suit.Arrows, Melds.Pong, new int[]{Tile.White.ordinal(), Tile.White.ordinal(), Tile.White.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.Green.ordinal(),  Suit.Arrows, Melds.Kong, new int[]{Tile.Green.ordinal(), Tile.Green.ordinal(), Tile.Green.ordinal(), Tile.Green.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D4.ordinal(),  Suit.Dots, Melds.Pong, new int[]{Tile.D4.ordinal(), Tile.D4.ordinal(), Tile.D4.ordinal()}));
        System.out.println(tiles + "\n结果: " + isXiaoSanYuan(tiles, meldedTiles, Tile.Red));

        System.out.println("\n 全部手牌大三元:");
        tiles = Stream.of( Tile.White, Tile.White,
                Tile.White, Tile.D5, Tile.D5,
                Tile.D5,  Tile.S9,  Tile.Red,
                Tile.Red,  Tile.Red,  Tile.Green,
                Tile.Green,  Tile.Green).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isDaSanYuan(tiles, null, Tile.S9));

        System.out.println("\n 有碰杠的 大三元：");
        tiles = Stream.of( Tile.S1,
                Tile.S1,  Tile.Red, Tile.Red).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.White.ordinal(),  Suit.Arrows, Melds.Pong, new int[]{Tile.White.ordinal(), Tile.White.ordinal(), Tile.White.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.Green.ordinal(),  Suit.Arrows, Melds.Kong, new int[]{Tile.Green.ordinal(), Tile.Green.ordinal(), Tile.Green.ordinal(), Tile.Green.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D4.ordinal(),  Suit.Dots, Melds.Pong, new int[]{Tile.D4.ordinal(), Tile.D4.ordinal(), Tile.D4.ordinal()}));
        System.out.println(tiles + "\n结果: " + isDaSanYuan(tiles, meldedTiles, Tile.Red));

        System.out.println("\n 全部手牌小四喜:");
        tiles = Stream.of( Tile.East, Tile.East,
                Tile.East, Tile.South, Tile.South,
                Tile.South,  Tile.West,  Tile.West,
                Tile.West,  Tile.North,  Tile.North,
                Tile.Green,  Tile.Green).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isXiaoSiXi(tiles, null, Tile.Green));

        System.out.println("\n 有碰杠的 小四喜：");
        tiles = Stream.of( Tile.East,
                Tile.East,  Tile.East, Tile.North).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.South.ordinal(),  Suit.Winds, Melds.Pong, new int[]{Tile.South.ordinal(), Tile.South.ordinal(), Tile.South.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.West.ordinal(),  Suit.Winds, Melds.Kong, new int[]{Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D4.ordinal(),  Suit.Dots, Melds.Pong, new int[]{Tile.D4.ordinal(), Tile.D4.ordinal(), Tile.D4.ordinal()}));
        System.out.println(tiles + "\n结果: " + isXiaoSiXi(tiles, meldedTiles, Tile.North));

        System.out.println("\n 全部手牌大四喜:");
        tiles = Stream.of( Tile.East, Tile.East,
                Tile.East, Tile.South, Tile.South,
                Tile.South,  Tile.West,  Tile.West,
                Tile.West,  Tile.North,  Tile.North,
                Tile.Green,  Tile.Green).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isDaSiXi(tiles, null, Tile.North));

        System.out.println("\n 有碰杠的 大四喜：");
        tiles = Stream.of( Tile.East,
                Tile.East,  Tile.East, Tile.S1).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.South.ordinal(),  Suit.Winds, Melds.Pong, new int[]{Tile.South.ordinal(), Tile.South.ordinal(), Tile.South.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.West.ordinal(),  Suit.Winds, Melds.Kong, new int[]{Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal(), Tile.West.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.North.ordinal(),  Suit.Winds, Melds.Pong, new int[]{Tile.North.ordinal(), Tile.North.ordinal(), Tile.North.ordinal()}));
        System.out.println(tiles + "\n结果: " + isDaSiXi(tiles, meldedTiles, Tile.S1));

        System.out.println("\n 全部手牌 小幺九:");
        tiles = Stream.of( Tile.S1, Tile.S1,
                Tile.S1, Tile.D1, Tile.D1,
                Tile.D1,  Tile.D9,  Tile.D9,
                Tile.D9,  Tile.S9,  Tile.S9,
                Tile.S9,  Tile.East).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isXiaoYaoJiu(tiles, null, Tile.East));

        System.out.println("\n 有碰杠的 小幺九：");
        tiles = Stream.of( Tile.East,
                Tile.East,  Tile.East, Tile.M1).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.S1.ordinal(),  Suit.Sticks, Melds.Pong, new int[]{Tile.S1.ordinal(), Tile.S1.ordinal(), Tile.S1.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D1.ordinal(),  Suit.Dots, Melds.Kong, new int[]{Tile.D1.ordinal(), Tile.D1.ordinal(), Tile.D1.ordinal(), Tile.D1.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.M9.ordinal(),  Suit.Myriads, Melds.Pong, new int[]{Tile.M9.ordinal(), Tile.M9.ordinal(), Tile.M9.ordinal()}));
        System.out.println(tiles + "\n结果: " + isXiaoYaoJiu(tiles, meldedTiles, Tile.M1));

        System.out.println("\n 全部手牌 大幺九:");
        tiles = Stream.of( Tile.S1, Tile.S1,
                Tile.S1, Tile.D1, Tile.D1,
                Tile.D1,  Tile.D9,  Tile.D9,
                Tile.D9,  Tile.S9,  Tile.S9,
                Tile.S9,  Tile.M1).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isDaYaoJiu(tiles, null, Tile.M1));

        System.out.println("\n 有碰杠的 大幺九：");
        tiles = Stream.of( Tile.S9,
                Tile.S9,  Tile.S9, Tile.M1).collect(Collectors.toList());
        meldedTiles = new ArrayList<>();
        meldedTiles.add(new MJMeld(Tile.S1.ordinal(),  Suit.Sticks, Melds.Pong, new int[]{Tile.S1.ordinal(), Tile.S1.ordinal(), Tile.S1.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.D1.ordinal(),  Suit.Dots, Melds.Kong, new int[]{Tile.D1.ordinal(), Tile.D1.ordinal(), Tile.D1.ordinal(), Tile.D1.ordinal()}));
        meldedTiles.add(new MJMeld(Tile.M9.ordinal(),  Suit.Myriads, Melds.Pong, new int[]{Tile.M9.ordinal(), Tile.M9.ordinal(), Tile.M9.ordinal()}));
        System.out.println(tiles + "\n结果: " + isDaYaoJiu(tiles, meldedTiles, Tile.M1));

        System.out.println("\n 全部手牌 九莲宝灯:");
        tiles = Stream.of( Tile.S1, Tile.S1,
                Tile.S1, Tile.S2, Tile.S3,
                Tile.S4,  Tile.S5,  Tile.S6,
                Tile.S7,  Tile.S8,  Tile.S9,
                Tile.S9,  Tile.S9).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isJiuLianBaoDeng(tiles, Tile.S9));

        System.out.println("\n 全部手牌 十三幺:");
        tiles = Stream.of( Tile.M1, Tile.M9,
                Tile.S1, Tile.S9, Tile.D1,
                Tile.D9,  Tile.East,  Tile.North,
                Tile.West,  Tile.South,  Tile.Red,
                Tile.Green,  Tile.White).collect(Collectors.toList());
        System.out.println(tiles + "\n结果: " + isShiSanYao(tiles, Tile.S1));

    }
}
