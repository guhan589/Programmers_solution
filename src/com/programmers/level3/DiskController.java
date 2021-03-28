package com.programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 디스크 컨트롤러 level3 (완성)
 * */
public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};


        int result = solution(jobs);
        System.out.println("result = " + result);

    }

    static int solution(int[][] jobs) {
        int answer = 0;
        //요청시간을 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int count = 0;
        int index = 0;
        int end = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //끝나는 시점을 오름차순으로 정렬
        /*for (int[] job : jobs) {
            System.out.println("job[0]+\",\"+job[1] = " + job[0]+","+job[1]);
        }*/

        while (count < jobs.length) {
            //Jobs.length => 3
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }
            /*for (int[] ints : pq) {
                System.out.println("ints[0]+\",\"+ints[1] = " + ints[0] + "," + ints[1]);
            }
*/

            if (pq.isEmpty()) {//큐가 비어있을 경우 시작시각으로 정렬한 첫 job을 추가한다.
                end = jobs[index][0];
            }else{
                int[] temp = pq.poll();
              /*  System.out.println("temp[0] = " + temp[0]);
                System.out.println("temp[1] = " + temp[1]);
                System.out.println("end1 = " + end);
*/

                answer += temp[1] + end - temp[0]; //요청 처리 후의 시각
                end += temp[1]; //다음 요청 처리 후의 시각
//                System.out.println("end2 = " + end);
                count++;
            }

//            System.out.println(" ============+"+count+"+==========  ");
        }
        return (int) Math.floor(answer / jobs.length);
    }
}
