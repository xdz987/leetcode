package 周赛.双周赛20210905.q5848_2_树上的操作;

import java.util.*;

class LockingTree {

    private int[] parent;
    private int[] lock;
    private ArrayList<ArrayList<Integer>> childs = new ArrayList<>();
    public LockingTree(int[] parent) {
        this.parent = parent;
        this.lock = new int[parent.length];
        Arrays.fill(lock,-1);
        for(int i=0;i<parent.length;i++){
            childs.add(new ArrayList());
        }
        initChild(0);
    }

    private void initChild(int num){
        for(int i=0;i<parent.length;i++){
            if(parent[i] == num){
                childs.get(num).add(i);
                initChild(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if(lock[num] == -1){
            lock[num] = user;
            return true;
        }else{
            return false;
        }
    }

    public boolean unlock(int num, int user) {
        if(lock[num] == user){
            lock[num] = -1;
            return true;
        }else{
            return false;
        }
    }

    //如cur的子孙存在锁，且其祖先不存在锁。那么将cur上锁并释放其所有子孙的锁
    public boolean upgrade(int num, int user) {
        if(lock[num] == -1){
            if(testParent(num) && testChild(num)){
                freeChild(num);
                lock[num] = user;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private boolean testParent(int num){
        if(num == -1) return true;
        else if(lock[num] == -1) return testParent(parent[num]);
        else return false;
    }

    private boolean testChild(int num){
        boolean isLock = false;
        for(int child:childs.get(num)) {
            if (lock[child] != -1)
                return true;
            else
                isLock = isLock || testChild(child);
        }
        return isLock;
    }

    private void freeChild(int num){
        for(int child:childs.get(num)){
            lock[child] = -1;
            freeChild(child);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */