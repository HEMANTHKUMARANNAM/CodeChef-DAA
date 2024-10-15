import java.util.*;
import java.lang.*;

class Job {
    int id;
    int t;
    int d;
    int late;

    public Job(int id, int t, int d) {
        this.id = id;
        this.t = t;
        this.d = d;
        this.late = 0;
    }
}

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        Job[] joblist = new Job[t];

        for (int i = 0; i < t; i++) {
            int time = sc.nextInt();
            int dead = sc.nextInt();
            joblist[i] = new Job(i + 1, time, dead);
        }

        maxfun(joblist);
    }

    public static void maxfun(Job[] joblist) {
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.d, b.d)
        );

        pq.addAll(Arrays.asList(joblist));

        ArrayList<Integer> order = new ArrayList<>();
        int currtime = 0;
        
        int maxlate = 0;

        while (!pq.isEmpty()) {
            Job curr = pq.poll();
            currtime += curr.t;  // Adding the job's time to the current time

            order.add(curr.id);

            int late = Math.max(0, currtime - curr.d);
            
            maxlate = Math.max(late,maxlate);


        }

        System.out.println(maxlate);

        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i) + " ");
        }
    }
}
