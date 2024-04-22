package kivetel;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> iStack = new Stack<>();
        try {
            try {
                iStack.push(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                iStack.push(2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            iStack.push(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}