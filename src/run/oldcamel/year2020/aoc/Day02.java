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
 * Time: 2:26 下午
 * Email: old_camel@163.com
 */
public class Day02 {
    private List<String> data;

    public Day02(File file) {
        this.data = InputUtils.inputFileToStringList(file);
    }

    public int part1(){
        int flag = 0;
        for (String a : data) {
            String[] split = a.split(": ");
            String x = split[0];
            String y = split[1];
            String[] z = x.split(" ");
            String i = z[1];
            String[] n = z[0].split("-");
            int l1 = y.length();
            int l2 = y.replaceAll(i + "", "").length();
            int i3 = l1 - l2;
            int i1 = Integer.parseInt(n[0]);
            int i2 = Integer.parseInt(n[1]);
            if (i1 <= i3 && i3 <= i2) {
                flag++;
            }
        }
        return flag;
    }
    public int part2(){
        int flag = 0;
        for (String a : data) {
            String[] split = a.split(": ");
            String x = split[0];
            String y = split[1];
            String[] z = x.split(" ");
            String i = z[1];
            String[] n = z[0].split("-");
            char c = y.charAt(Integer.parseInt(n[0]) - 1);
            char c2 = y.charAt(Integer.parseInt(n[1]) - 1);
            if(((c+"").equals(i)||(c2+"").equals(i))&&c!=c2){
                flag++;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Day02 day02 = new Day02(new File("src/file/day02.txt"));
        System.out.println(day02.part1());
        System.out.println(day02.part2());
    }
}
