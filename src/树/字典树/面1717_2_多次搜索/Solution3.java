package 树.字典树.面1717_2_多次搜索;

class MagicDictionary {

    /** Initialize your data structure here. */
    String[] dic;
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        dic = dictionary;
    }

    public boolean search(String searchWord) {
        char[] sArr = searchWord.toCharArray();
        for(int i=0;i<dic.length;i++){
            int count = 1;
            if(dic[i].length() == sArr.length){
                char[] dArr = dic[i].toCharArray();
                for(int j=0;j<sArr.length;j++){
                    if(dArr[j] != sArr[j]){
                        count--;
                    }
                    if(count == -1)
                        break;
                }
                if(count == 0)
                    return true;
            }
        }
        return false;
    }
}