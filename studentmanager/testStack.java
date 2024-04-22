package lab3.studentmanager;

public class testStack {
    public static void main(String[] args) {
        DynamicStack stack= new DynamicStack();
        stack.push(-1);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        System.out.println(stack);
        int item=stack.pop();
        System.out.println(item);
        stack.pop();
        System.out.println(stack);
        stack.printStack();



    }
}
