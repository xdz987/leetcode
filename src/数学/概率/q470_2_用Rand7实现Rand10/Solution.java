package 数学.概率.q470_2_用Rand7实现Rand10;

class Solution {
    public int rand10() {
        int r2 = rand2();
        int r5 = rand5();
        return r2==0?r5:r5+5;
    }
    public int rand2(){
        int cal = rand7();
        while(cal==7)
            cal = rand7();
        return (cal&1);
    }
    public int rand5(){
        int cal = rand7();
        while(cal>5)
            cal = rand7();
        return cal;
    }
    private int rand7(){return 0;}
}