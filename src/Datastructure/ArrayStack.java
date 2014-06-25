package Datastructure;

public class ArrayStack {
    
    int[] num = new int[10];
    private int top=-1;
    
    /**
     * 引数の値をスタックにpush
     * @param d
     * @return
     */
    public int[] push(int d) {
        if(top>=9) {
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
        System.out.println(top);
        if(top < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.num[this.top--]; 
    }
}
