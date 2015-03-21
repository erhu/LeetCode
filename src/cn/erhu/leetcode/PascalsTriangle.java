package cn.erhu.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * #请替换掉这里的东东#
 * <p/>
 * User: hujunjie
 * Date: 15/3/21
 * Time: 21:29
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);
        for (int i = 1; i <= numRows; i++) {
            triangle.add(generateOneRow(triangle, i));
        }
        return triangle;
    }

    private List<Integer> generateOneRow(List<List<Integer>> triangle, int rowNum) {
        List<Integer> list = new ArrayList<Integer>(rowNum);
        if (rowNum == 1) {
            list.add(1);
        } else if (rowNum == 2) {
            list.add(1);
            list.add(1);
        } else {
            list.add(1);
            List<Integer> pre_list = getRow(triangle, rowNum - 1);
            for (int i = 1; i < rowNum - 1; i++) {
                list.add(pre_list.get(i - 1) + pre_list.get(i));
            }
            list.add(1);
        }
        return list;
    }

    private List<Integer> getRow(List<List<Integer>> triangle, int rowNum) {
        return triangle.get(rowNum - 1);
    }


    @Test
    public void test() {
        printTriangle(generate(5));
    }

    private void printTriangle(List<List<Integer>> t) {
        for (List<Integer> l : t) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
