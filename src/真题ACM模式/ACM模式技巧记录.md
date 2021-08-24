## 常用知识
### Scanner

```
import java.util.Scanner;

Scanner in = new Scanner();
in.hasNext()    //是否有下一个输入
in.hasNextLine()//是否有下一行输入
in.nextInt()    //读取下一个数字
in.nextLine()   //读取整行输入，当需要获取不定长字符串时用

- 效率更高
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;

BufferedReader br = new BufferedReader(new InputStream(System.in));
String[] sArr = br.readLine().split(" ");
```
### 注意事项
```
System.exit(0)  //正常退出
System.exit(1)  //非正常退出,通常使用在catch后

读取行数后还需执行in.nextLine()跳到下一行
```

### 位置
```
java.util：Scanner、Arrays
java.lang：Math
```

## 一、数字输入
#### 1. 计算多组a+b
```
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
        }
    }
}
```

#### 2. 计算行之和
```
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n == 0) break;
            int sum = 0;
            for(int i=0;i<n;i++){
                sum+=in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
```

#### 3. 计算行之和（输入数字间有空格）
```
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            String[] cArr = s.split(" ");
            int sum = 0;
            for(int i=0;i<cArr.length;i++){
                sum+=Integer.parseInt(cArr[i]);
            }
            System.out.println(sum);
        }
    }
}
```

## 二、字符串输入
#### 输入输出要求空格分隔
```
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            String[] sArr = s.split(" ");
            Arrays.sort(sArr,(s1,s2)->s1.compareTo(s2));
            for(int i=0;i<sArr.length-1;i++){
                System.out.print(sArr[i]+" ");
            }
            System.out.print(sArr[sArr.length-1]);
            System.out.println();
        }
    }
}
```

#### 将无规则字符串还原规则字符串
```
提前目标：12,3,4 5 7,500 600 800
还原：
    1. 使用replaceAll将,替换为空格
    2. 通过split获得每个数字
```
