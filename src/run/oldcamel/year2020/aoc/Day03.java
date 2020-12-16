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
public class Day03 {
    private List<String> data;

    public Day03(File file) {
        this.data = InputUtils.inputFileToStringList(file);
    }

    public long part1(){
        return run(3,1);
    }
    public long part2(){
        return run(3,1)*run(1,1)*run(5,1)*run(7,1)*run (1,2);
    }

    private long run(int right,int down) {
        long flag = 0;
        int length = data.get(0).length();
        int postion=1;
        for (int i=0; i< data.size();i+=down) {
            String line=data.get(i);
            int i1 = postion % length;
            if(i1!=0){
                char c = line.charAt(i1-1);
                if(c=='#'){
                    flag++;
                }
            }else{
                char c = line.charAt(length-1);
                if(c=='#'){
                    flag++;
                }
            }
            postion=postion+right;
        }
        return flag;
    }

    public static void main(String[] args) {
        Day03 day02 = new Day03(new File("src/file/day03.txt"));
        System.out.println(day02.part1());
        System.out.println(day02.part2());
    }
}
