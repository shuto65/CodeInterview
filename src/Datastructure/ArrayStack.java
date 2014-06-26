package Datastructure;

public class ArrayStack {
    static final int MAX_STACK_INT = 10;
    int[] num = new int[MAX_STACK_INT];
    private int top=-1;
    
    /**
     * 引数の値をスタックにpush
     * @param d
     * @return
     */
    public int[] push(int d) {
        if(top >= MAX_STACK_INT - 1) {
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
