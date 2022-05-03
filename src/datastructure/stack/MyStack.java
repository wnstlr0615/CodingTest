package datastructure.stack;

import java.util.ArrayList;

public class MyStack <T>{
    ArrayList<T> stack = new ArrayList<>();
    public T pop(){
        if(!stack.isEmpty()){
            return  stack.get(stack.size() - 1);
        }
        return null;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public boolean push(T item){
        return stack.add(item);
    }
}
