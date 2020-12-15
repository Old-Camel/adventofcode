package run.oldcamel.year2020.aoc;

import run.oldcamel.year2020.util.InputUtils;

import java.io.File;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * TODO: TODO
 *
 * @author: 徐成
 * Date: 2020/12/15
 * Time: 2:16 下午
 * Email: old_camel@163.com
 */
public class Day01 {
    private List<Integer> numbers;
    private final int targetSum = 2020;

    public Day01(File file) {
        numbers = InputUtils.inputFileToIntList(file);
    }

    public long part1() {
       /* for (Integer integer : numbers) {
            int a = 2020 - integer;
            if (numbers.contains(a)) {
                System.out.println(a + "<==>" + integer);
                System.out.println(a * integer);
                break;
            }
        }*/
        int asInt = numbers.stream().flatMap(a -> numbers.stream().filter(b -> a + b == 2020).map(b -> a * b)).findAny().get();
        return asInt;
    }
    public long part2() {
        for (int i : numbers) {
            for (int i1 : numbers) {
                for (int i2 : numbers) {
                    if (i != i1 && i1 != i2 && i + i1 + i2 == 2020) {
                        return i * i1 * i2;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Day01 day01 = new Day01(new File("src/file/day01.txt"));
        System.out.println(day01.part1());
        System.out.println(day01.part2());
    }

}
