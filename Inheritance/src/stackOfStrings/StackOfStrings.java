package stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String>data;

    public StackOfStrings(ArrayList<String> data) {
        this.data = data;
    }

    public String pop(){
        return this.data.remove(this.data.size()-1);
    }
    public String peek(){
        return this.data.get(this.data.size()-1);
    }
    public void push(String element){
         this.data.add(element);
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
