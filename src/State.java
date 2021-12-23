import java.util.*;
// State as stack 

// <id, val> 
class Pair {
   Identifier id;
   Value val;
   
   Pair (Identifier id, Value v) {
     this.id = id;
     this.val = v;
   }
}

class State extends Stack<Pair> {
    public State( ) { }
    
    public State(Identifier id, Value val) {
        push(id, val);
    }

    // (1) Push function Implementation
    public State push(Identifier id, Value val) {
        // Push Implementation
        // stack에 push
        super.push(new Pair(id, val)); // add (item)
        return this;
    }

    // (2) Pop function Implementation (Optional)
    public Pair pop() {
    	return super.pop();
    	// Pop Implementation (Optional)
    }
    
    // (3) Lookup function Implementation
    public int lookup (Identifier v) {
    	// 루프를 돌면서 해당 ID를 찾음
    	for(int i = super.size() - 1; i > -1; i--) {
			if(v.equals(super.get(i).id)) {
    			return i;
    		}
    	}
    	return -1;
       // Lookup Implementation
    }

    // (4) Set Function Implementation
    //찾아서 값을 넣음
    public State set(Identifier id, Value val) {
    	int i = this.lookup(id);
    	if(i > -1) {
    		super.get(i).val = val;
    	} else {
    		System.out.println("Error" + id + "is not Contain!!!");
    	}
    	return this;
    	// Set Implementation
    }
    
    // (5) Get Function Implementation
    public Value get (Identifier id) {
    	int i = this.lookup(id);
    	if(i > -1) {
    		return super.get(i).val;
    	} else {
    		System.out.println("Error" + id + "is not Contain!!!");
    		return null;
    	}
    	// Get Implementation
    }

	}

