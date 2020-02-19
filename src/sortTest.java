import Generics_Collections.Collection;

import java.util.*;

public class sortTest {
    int[] arr = {0,5,4,3,4,2,22,343,1,2,0,-99,2};

    public static void main(String[] args) {
        sortTest t = new sortTest();
        //Arrays.sort(t.arr);
        //System.out.println(Arrays.toString(t.arr));

        //bubble sort
        for(int i = t.arr.length - 1; i > 0; i --) {
            for (int j = 0; j < i; j++) {
                if(t.arr[j] > t.arr[j+1]) {
                    int tmp = t.arr[j];
                    t.arr[j] = t.arr[j+1];
                    t.arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(t.arr));

        List<Number> list = new ArrayList<>();
        list.add(2);
        list.add(1.23f);
        System.out.println(list);
        Number a = 1;
        Integer b = (Integer) a;


        Integer c = 100;
        Number d = (Number) c;

    }

}
