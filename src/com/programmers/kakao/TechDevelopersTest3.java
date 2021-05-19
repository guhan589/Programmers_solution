package com.programmers.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TechDevelopersTest3 {
    public static void main(String[] args) {
        /**
         * "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
         * "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
         * "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
         * "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
         * */

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

      /*  int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};*/
        String solution = solution(n, k, cmd);
        System.out.println("solution = " + solution);
    }
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        int index = k;
        List<Entity> list = makeLinkedList(n);

        String[] table = new String[n];
        Stack<Entity> log = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].equals("C") || cmd[i].equals("Z")) { //삭제 및 복구
                if (cmd[i].equals("C")) {//삭제하는 경우 바로 아래 행을 선택=
                    log.push(list.get(index));
                    list.remove(index);

                } else {//복구

                    Entity temp = log.pop();

                    boolean last = false;
                    int j = 0 ;
                    for (j = 0; j < list.size(); j++) {
                        if (temp.getIndex() < list.get(j).getIndex()) {
                            list.add(j, temp);
                            break;
                        }

                    }
                    //break가 걸리지 않았다는 것은 마지막 인덱스
                    if (j == list.size()) {
//                        System.out.println("list.get(list.size()-1).getIndex() = " + list.get(list.size()-1).getIndex());
//                        System.out.println("temp.getIndex() = " + temp.getIndex());
                        list.add(list.size(), temp);
                    }


                }

     
            } else { // index이동
                String[] split = cmd[i].split(" ");

                if (split[0].equals("U")) {//위로 이동
                    index -= Integer.parseInt(split[1]);

                } else {//아래로 이동
                    index += Integer.parseInt(split[1]);

                }


            }


        }


        StringBuilder builder = new StringBuilder();
        for (Entity entity : list) {
            table[entity.getIndex()] = "O";
        }
        for (int i = 0; i < table.length; i++) {
            if(table[i]!=null)
                builder.append("O");
            else
                builder.append("X");
        }
        return builder.toString();
    }
    static List<Entity> makeLinkedList(int n) {
        List<Entity> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Entity(i, " "));
        }

        return list;
    }

    static class Entity {
        private int index;
        private String name;

        public Entity(int index, String name) {
            this.index = index;
            this.name = name;
        }
        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }
  /*  static void show(String msg, List<Entity> list) {
        System.out.println("==========" + msg + "==========");
        for (Entity entity : list) {
            System.out.println("entity = " + entity.getName());
            System.out.println("entity = " + entity.getIndex());
        }

        System.out.println(" =================== ");

    }*/


}
