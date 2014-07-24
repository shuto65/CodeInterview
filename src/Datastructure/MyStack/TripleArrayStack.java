package Datastructure.MyStack;

public class TripleArrayStack {
    static final int NUM_OF_ARRAY=3;
    private int top_stack[];
    private int max_stack[];
    private int min_stack[];
    int[] base_stack;
    
    public TripleArrayStack (int size_stack0, int size_stack1, int size_stack2) {
        this.min_stack = new int[NUM_OF_ARRAY]; 
        this.max_stack = new int[NUM_OF_ARRAY]; 
        this.top_stack = new int[NUM_OF_ARRAY]; 
        
        this.min_stack[0] = 0;
        this.min_stack[1] = size_stack0;
        this.min_stack[2] = (size_stack0 + size_stack1);
        
        this.max_stack[0] = size_stack0;
        this.max_stack[1] = this.max_stack[0] + size_stack1;
        this.max_stack[2] = this.max_stack[1] + size_stack2;
        
        this.top_stack[0] = this.min_stack[0] - 1;
        this.top_stack[1] = this.min_stack[1] - 1;
        this.top_stack[2] = this.min_stack[2] - 1;
        
        int base_size= size_stack0 + size_stack1 + size_stack2;
        
        this.base_stack = new int[base_size];
    }
    
    
    
    public void push(int stackId, int entry) {
        System.out.println(top_stack[stackId]+ "top");
        System.out.println(max_stack[stackId]+ "max");
        
        if(stackId < 0 || stackId > 2) {
            throw new IllegalArgumentException();
        }
        if(top_stack[stackId] >= max_stack[stackId]) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        int index = ++top_stack[stackId];
        base_stack[index] = entry;
    }   
    
    public int pop(int stackId) {
        if(stackId < 0 || stackId > 2) {
            throw new IllegalArgumentException();
        }
        if(top_stack[stackId] < min_stack[stackId]) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        int index = top_stack[stackId]--;
        
        return base_stack[index];
    }
}
