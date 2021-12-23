// TypeEnv.java
// Type environment for S
import java.util.*;

// <id, type> 
class Entry {
   Identifier id;
   Type type;
   
   Entry (Identifier id, Type t) {
     this.id = id;
     this.type = t;
   }
}

class TypeEnv extends Stack<Entry> {
    public TypeEnv() { }
    
    public TypeEnv(Identifier id, Type t) {
        push(id, t);
    }
    
    public TypeEnv push(Identifier id, Type t) {
        super.push(new Entry(id, t));
	return this;
    }
    
    
    // (1) Contatins Function Implementation
    public boolean contains (Identifier v) {
       // Contains Implementation
    	for(int i = 0; i < super.size(); i++) {
    		if(v.equals(super.get(i).id)) {
    			return true;
    		}
    	}
		return false;
    }

    // (2) Get Function Implementation
    public Type get(Identifier v) {
    	for(int i = 0; i < super.size(); i++) {
    		if(v.equals(super.get(i).id)) {
    			return super.get(i).type;
    		}
    	}
    	return null;
    }
}