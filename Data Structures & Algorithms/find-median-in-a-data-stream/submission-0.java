class MedianFinder {
    private PriorityQueue<Integer> maxh;
    private PriorityQueue<Integer> minh;
    public MedianFinder() {
        maxh = new PriorityQueue<>((a,b)->b-a);
        minh = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxh.offer(num);
        minh.offer(maxh.poll());
        if(minh.size()>maxh.size()){
            maxh.offer(minh.poll());
        }
    }
    
    public double findMedian() {
        if(maxh.size()==minh.size()){
            return (maxh.peek()+minh.peek())/2.0;
        }else{
            return maxh.peek();
        }
    }
}
