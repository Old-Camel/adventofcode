package run.oldcamel.year2020.aoc;

import run.oldcamel.year2020.util.InputUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * TODO: TODO
 *
 * @author: 徐成
 * Date: 2020/12/15
 * Time: 2:16 下午
 * Email: old_camel@163.com
 */
public class Day05 {
    private List<String> data;
    List<Integer> nums = new ArrayList<>();

    public Day05(File file) {
        data = InputUtils.inputFileToStringList(file);
    }

    public long part1() {


        for (String datum : data) {
            int a = 0;
            int b = 127;
            int row = 0;
            int col = 0;
            String x = datum.substring(0, 7);
            String y = datum.substring(7, 10);
            char[] chars = x.toCharArray();
            for (char aChar : chars) {
                if ((b - a) == 1) {
                    if (aChar == 'F') {
                        row = a;
                    } else {
                        row = b;
                    }

                } else {
                    int c = (a + b - 1) / 2;
                    if (aChar == 'F') {
                        b = c;
                    } else {
                        a = c + 1;
                    }
                }
            }
            a = 0;
            b = 7;
            chars = y.toCharArray();

            for (char aChar : chars) {
                if ((b - a) == 1) {
                    if (aChar == 'L') {
                        col = a;
                    } else {
                        col = b;
                    }

                } else {
                    int c = (a + b - 1) / 2;
                    if (aChar == 'L') {
                        b = c;
                    } else {
                        a = c + 1;
                    }
                }
            }
            nums.add(row * 8 + col);

        }
        Collections.sort(nums);
        Integer integer = nums.get(nums.size() - 1);

        return integer;
    }

    public long part2() {
        Integer integer = nums.get(0);
        for (Integer num : nums) {
            if(!integer.equals(num)){
                return integer;
            }
            integer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Day05 day01 = new Day05(new File("src/file/day05.txt"));
        System.out.println(day01.part1());
        System.out.println(day01.part2());
    }

}
