public class HeapUse {
    public static void main(String[] args) {
        PriorityQueue pq = new MinPriorityQueue();
        pq.add(6);
        pq.add(5);
        pq.add(4);
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(0);



        System.out.println(pq.toString());

        while(!pq.isEmpty()){
            System.out.print(pq.remove()+",");
            System.out.println(pq.toString());
        }

    }
}
