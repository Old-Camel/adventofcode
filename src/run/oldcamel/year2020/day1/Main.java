package run.oldcamel.year2020.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 *Part1 Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
 *
 * For example, suppose your expense report contained the following:
 *
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 *
 * Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?
 *
 *
 *
 *Part2 Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.
 *
 * In your expense report, what is the product of the three entries that sum to 2020?
 * */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1973,
                1755,
                1601,
                1852,
                493,
                1905,
                1752,
                1946,
                1608,
                1438,
                1383,
                1281,
                1918,
                1125,
                1624,
                1802,
                1513,
                1574,
                1871,
                1831,
                1842,
                1869,
                1982,
                1027,
                1009,
                1020,
                1016,
                1336,
                1519,
                1721,
                1960,
                1889,
                1299,
                1355,
                1622,
                399,
                1919,
                1749,
                1709,
                1425,
                1789,
                1620,
                1071,
                1248,
                1786,
                1879,
                1208,
                1697,
                1643,
                1510,
                1578,
                1152,
                1592,
                1985,
                1653,
                1112,
                591,
                1784,
                1393,
                1607,
                1130,
                1054,
                1120,
                1619,
                1029,
                1453,
                1850,
                1451,
                1753,
                1483,
                1021,
                1553,
                1561,
                1656,
                1975,
                1600,
                1677,
                1912,
                1334,
                1526,
                1345,
                1115,
                2010,
                1758,
                1664,
                1102,
                1588,
                1339,
                1745,
                1605,
                1638,
                1599,
                1741,
                1147,
                1837,
                1142,
                1774,
                1562,
                1936,
                1810,
                1648,
                1576,
                1794,
                1621,
                1194,
                1246,
                1727,
                1915,
                1793,
                1037,
                1587,
                1103,
                1947,
                1116,
                1567,
                1528,
                1964,
                1163,
                1980,
                1672,
                1773,
                1593,
                1586,
                169,
                1613,
                1712,
                1854,
                1632,
                1760,
                1182,
                1812,
                1811,
                1660,
                1728,
                1067,
                1835,
                1501,
                1335,
                1647,
                1853,
                543,
                1108,
                1024,
                1559,
                1717,
                1826,
                1544,
                1585,
                1655,
                1386,
                1331,
                1485,
                1537,
                1290,
                1941,
                1734,
                2003,
                1151,
                1679,
                1782,
                1783,
                1146,
                1277,
                1766,
                1900,
                530,
                1955,
                1268,
                1968,
                1432,
                1170,
                1867,
                1005,
                1202,
                1564,
                1096,
                1707,
                1309,
                1094,
                1295,
                1974,
                1404,
                1229,
                1883,
                1838,
                1997,
                1536,
                408,
                1149,
                1945,
                1454,
                1856,
                1792,
                1614,
                1492,
                1823,
                1803,
                1533,
                1726,
                1364};

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        for (Integer integer : list) {
            int a = 2020 - integer;
            if (list.contains(a)) {
                System.out.println(a + "<==>" + integer);
                System.out.println(a * integer);
                break;
            }
        }
        int asInt = Arrays.stream(arr).flatMap(a -> Arrays.stream(arr).filter(b -> a + b == 2020).map(b -> a * b)).findAny().getAsInt();
        System.out.println(asInt);


        flag:
        for (int i : arr) {
            for (int i1 : arr) {
                for (int i2 : arr) {
                    if (i != i1 && i1 != i2 && i + i1 + i2 == 2020) {
                        System.out.println(i + "+" + i1 + "+" + i2);
                        System.out.println(i * i1 * i2);
                        break flag;
                    }
                }
            }
        }

    }
}
