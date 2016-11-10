package p149;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	public int maxPoints(Point[] points) {
		if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> map = new HashMap<Double, Integer>();//key为斜率,value为相同斜率下面点的个数
            int samex = 1;//与x轴垂直(即与y轴平行)的点,因为无法计算斜率,需要单独计算
            int samep = 0;//和当前点相同的点,即和当前点重合的点
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    map.put(k,map.getOrDefault(k,1)+1);
                    result = Math.max(result, map.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
	}

	public static void main(String[] args) {
		Point[] arr ={
				new Point(84,250),
				new Point(0,0),
				new Point(1,0),
				new Point(0,-70),
				new Point(0,-70),
				new Point(1,-1),
				new Point(21,10),
				new Point(42,90),
				new Point(-42,-230)
		};
		Point[] arr2 = {
				new Point(0,0),
				new Point(1,1),
				new Point(0,0),
		};
		V1 v = new V1();
		System.out.println(v.maxPoints(arr));
	}
}
