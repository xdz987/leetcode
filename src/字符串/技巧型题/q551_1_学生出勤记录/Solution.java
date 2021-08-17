package 字符串.技巧型题.q551_1_学生出勤记录;

class Solution {
    public boolean checkRecord(String s) {
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        int countA = 0;
        int countL = 0;
        for(int i=0;i<n;i++){
            if(sArr[i] == 'L'){
                countL++;
            }else{
                countL = 0;
            }
            if(sArr[i] == 'A')
                countA++;
            if(countL>=3 || countA>=2){
                return false;
            }
        }
        return true;
    }
}