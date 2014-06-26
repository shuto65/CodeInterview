package Datastructure;

public class ArrayStack {
    //int[] num = new int[MAX_STACK_INT];
    private int top;
    private int maxsize;
    
    int[] num;
    
    public ArrayStack (int size){
        if(size <= 0) {
            throw new IllegalArgumentException();
        }
        this.maxsize = size;
        this.top = -1;
        
        this.num = new int[size];
    }
    
    
    /**
     * 引数の値をスタックにpush
     * @param d
     * @return
     */
    public int[] push(int d) {
        if(top >= maxsize - 1) {
            throw new IndexOutOfBoundsException();
        }
        
        this.num[++this.top] = d;
        return num;
    }
    
    /**
     * topにある値をstackからpop
     * @return
     */
    public int pop() {
        if(top < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.num[this.top--]; 
    }
}
