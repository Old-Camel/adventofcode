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
                    continue a;
                }

            }
            flag++;
        }
        return flag;
    }

    public long part2() {
        long flag = 0;
        a:
        for (HashMap<String, String> datum : data) {
            if(byr(datum)&&iyr(datum)&&eyr(datum)&&hgt(datum)&&hcl(datum)&&ecl(datum)&&pid(datum)){
                flag++;

            }

        }
        return flag;
    }

    private boolean byr(HashMap<String, String> map) {
        String byr = map.get("byr");
        try{
            int i = Integer.parseInt(byr);
            if(1920<=i&&i<=2002){
                return true;
            }
        }catch (Exception e){
            return  false;
        }
        return false;
    }
    private boolean iyr(HashMap<String, String> map) {
        String byr = map.get("iyr");
        try{
            int i = Integer.parseInt(byr);
            if(2010<=i&&i<=2020){
                return true;
            }
        }catch (Exception e){
            return  false;
        }
        return false;
    }
    private boolean eyr(HashMap<String, String> map) {
        String byr = map.get("eyr");
        try{
            int i = Integer.parseInt(byr);
            if(2020<=i&&i<=2030){
                return true;
            }
        }catch (Exception e){
            return  false;
        }
        return false;
    }
    private boolean hgt(HashMap<String, String> map) {
        String hgt = map.get("hgt");
        try{
           if(hgt.endsWith("cm")){
               String cm = hgt.replaceAll("cm", "");
               int i = Integer.parseInt(cm);
               if(150<=i&&i<=193){
                   return true;
               }
           }else if(hgt.endsWith("in")){
               String cm = hgt.replaceAll("in", "");
               int i = Integer.parseInt(cm);
               if(59<=i&&i<=76){
                   return true;
               }
           }
        }catch (Exception e){
            return  false;
        }
        return false;
    }
    private boolean hcl(HashMap<String, String> map) {

        String hgt = map.get("hcl");
        return hgt!=null&& hgt.matches("#[0-9a-f]{6}");
    }
    private boolean ecl(HashMap<String, String> map) {
        String ecl = map.get("ecl");
        String all="amb blu brn gry grn hzl oth";
        return ecl!=null&&all.contains(ecl);
    }
    private boolean pid(HashMap<String, String> map) {
        String pid = map.get("pid");

        return pid!=null&&pid.matches("[0-9]{9}");
    }

    public static void main(String[] args) {
        //System.out.println("1#333222".matches("a#[0-9a-f]{6}"));
        Day04 day02 = new Day04(new File("src/file/day04.txt"));
        System.out.println(day02.part1());
        System.out.println(day02.part2());
    }
}
