package lab3.studentmanager;

import java.util.Arrays;

public class DynamicStack {
    private int[] stack;
    private int capacity;
    private int top;

    public DynamicStack() {
        this.capacity = 10;
        stack = new int[capacity];
        this.top = -1;
    }

    public void push(int item) {
        if (isFull()) {
            int[] newStack = new int[2 * capacity];
            System.arraycopy(stack, 0, newStack, 0, capacity);
            capacity *= 2;
            stack = newStack;
        }
        ++top;
        stack[top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack!");
        } else {
            int item = stack[top--];
            if(top+1<=capacity/4){
                int[] newStack = new int[capacity / 2];
                System.arraycopy(stack,0,newStack,0,top+1);

                capacity /= 2;
                stack = newStack;

            }
            return item;
        }
    }
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        return "DynamicStack{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}
