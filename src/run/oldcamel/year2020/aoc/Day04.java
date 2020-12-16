package run.oldcamel.year2020.aoc;

import run.oldcamel.year2020.util.InputUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * TODO: TODO
 *
 * @author: 徐成
 * Date: 2020/12/15
 * Time: 2:26 下午
 * Email: old_camel@163.com
 */
public class Day04 {
    private List<HashMap<String, String>> data = new ArrayList<>();
    //    iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
//hcl:#cfa07d byr:1929
    private String[] keys = {"iyr", "ecl", "eyr", "pid", "hcl", "byr", "hgt"};

    public Day04(File file) {
        List<String> list = InputUtils.inputFileToStringList(file);
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            if (s.length() == 0) {
                buildMap(sb);
                sb = new StringBuilder();
            } else {
                sb.append(" ").append(s);
            }
        }
        buildMap(sb);

    }

    private void buildMap(StringBuilder sb) {
        String[] split = sb.toString().split(" ");
        HashMap<String, String> map = new HashMap<>();
        Arrays.stream(split).forEach(x -> {
            if (x.length() > 0) {
                String[] strings = x.split(":");
                map.put(strings[0].replaceAll(" ", ""), strings[1]);
            }
        });
        data.add(map);
    }

    public long part1() {
        long flag = 0;
        a:
        for (HashMap<String, String> datum : data) {

            for (String key : keys) {
                if (!datum.containsKey(key)) {
                    break;
                }
                if (key.equals(keys[keys.length - 1])) {
                    flag++;
                }
            }

        }
        return flag;
    }

    public long part2() {
        return -1;
    }


    public static void main(String[] args) {
        Day04 day02 = new Day04(new File("src/file/day04.txt"));
        System.out.println(day02.part1());
        System.out.println(day02.part2());
    }
}
