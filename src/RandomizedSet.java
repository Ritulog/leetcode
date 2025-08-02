import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {
    public List<Integer> list;
    public HashMap<Integer, Integer> map;
    public Random r;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int ind = map.get(val);
        int lastEle = list.get(list.size()-1);

        list.set(ind, lastEle);
        map.put(lastEle,ind);

        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
       return list.get(r.nextInt(list.size())); 
    }
}