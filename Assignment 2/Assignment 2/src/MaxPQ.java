

public class MaxPQ {
	
	    private PrintJob[] heap;
	 
	    private int size;
	   
	    public MaxPQ() {
	        
	        this.heap = new PrintJob[11];
	        this.size = 0;
	        
	    }
	    
	    public MaxPQ(int capacity) {
	        if (capacity < 1) throw new IllegalArgumentException();
	        this.heap = new PrintJob[capacity+1];
	        this.size = 0;
	        
	    }
	   
	    public void insert(PrintJob object) {
	        // Ensure object is not null
	        if (object == null) throw new IllegalArgumentException();
	        // Check available space
	        if (size == heap.length-1) throw new IllegalStateException();
	        // Place object at the next available position
	        if(size== 0.75*(heap.length-1)){
	        	resize(heap.length);
	        }
	        heap[++size] = object;
	        // Let the newly added object swim
	        swim(size);
	    }
	    /**
	     * Removes the object at the root of this heap.
	     * throws IllegalStateException if heap is empty.
	     * return The object removed.
	     */
	    public PrintJob getMax() {
	        // Ensure not empty
	        if (size == 0) throw new IllegalStateException();
	        // Keep a reference to the root object
	        PrintJob object = heap[1];
	        // Replace root object with the one at rightmost leaf
	        if (size > 1) heap[1] = heap[size];
	        // Dispose the rightmost leaf
	        heap[size--] = null;
	        // Sink the new root element
	        sink(1);
	        // Return the object removed
	        return object;
	    }
	    /**
	     * Shift up.
	     */
	    public void swim(int i) {
	        while (i > 1) {  //if i root (i==1) return
	            int p = i/2;  //find parent
	            int result = heap[i].compareTo( heap[p]);  //compare parent with child
	            if (result <= 0) return;    //if child <= parent return
	            swap(i, p);                 //else swap and i=p
	            i = p;
	        }
	    }
	    /**
	     * Shift down.
	     */
	    public void sink(int i){
	        int left = 2*i, right = left+1, max = left;
	        // If 2*i >= size, node i is a leaf
	        while (left <= size) {
	            // Determine the largest children of node i
	            if (right <= size) {
	                max = heap[left].compareTo( heap[right]) < 0 ? right : left;
	            }
	            // If the heap condition holds, stop. Else swap and go on.
	            if (heap[i].compareTo( heap[max]) >= 0) return;
	            swap(i, max);
	            i = max; left = 2*i; right = left+1; max = left;
	        }
	    }
	    
	   
	    public void swap(int i, int j) {
	        PrintJob tmp = heap[i];
	        heap[i] = heap[j];
	        heap[j] = tmp;
	    }
	    public void print() {
	        for (int i=1; i<=size; i++){
	            System.out.print(heap[i]+ " ");
	        }
	        System.out.println();
	    }
	    public boolean empty(){
	        return size == 0;
	    }
	    
	    public PrintJob peek(){
	    	return heap[1];
	    }
	    
	    public void resize(int length){
	    	length= length*2;
	    	
	    }

	    public int size(){
	    	return size;
	    }

	    public PrintJob getHeap(int i){
	    	return heap[i];
	    }

}
