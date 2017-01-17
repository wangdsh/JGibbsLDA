package core.algorithm.lda;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class LDAUtils {

	public static String zeroPad(int number, int width) {
		StringBuffer result = new StringBuffer("");
		for (int i = 0; i < width - Integer.toString(number).length(); i++)
			result.append("0");
		result.append(Integer.toString(number));

		return result.toString();
	}
	/**
	 * ����KLɢ�ȣ��������ʷֲ�������
	 * @param p
	 * @param q
	 * @return
	 */
	public static double KLDivergence(double [] p, double [] q){
		double sim = 0.0;
		if(p.length != q.length){
			return -1;
		}
		for (int i = 0; i < p.length; i++) {
			sim += p[i]* Math.log(p[i]/q[i])/Math.log(2);
		}
		for (int i = 0; i < q.length; i++) {
			sim += q[i]* Math.log(q[i]/p[i])/Math.log(2);
		}
		return sim/2;
	}
	
	/**
	 * �������ƶ�
	 */
	public static double cosineSimilarity(double[] v1, double[] v2){
        return pointMulti(v1, v2) / sqrtMulti(v1, v2); 
	}
    private static double sqrtMulti(double[] v1, double[] v2) {  
        double result = 0;  
        result = squares(v1) * squares(v2);  
        result = Math.sqrt(result);  
        return result;  
    } 
    // 求平方和  
    private static double squares(double[] v) {  
        double result = 0;  
        for (Double d : v) {  
            result += d * d;  
        }  
        return result;  
    } 
    public static double pointMulti(double[] v1, double[] v2) {  
        double result = 0;  
        for (int i = 0; i < v1.length; i++) {  
            result += v1[i] * v2[i];  
        } 
        return result;  
    }
	
	
	
	/**
	 * ��������������dС����nλ
	 * 
	 * @param dout
	 * @param n
	 * @return
	 */
	public static double baoliu(double d, int n) {
		double p = Math.pow(10, n);
		return Math.round(d * p) / p;
	}
	
	
	/**
	 * ���Map��Doubleֵ����Map�����򣬽���
	 */
	public static Comparator<Map.Entry<String, Double>> SortMapByValueComparator = new Comparator<Map.Entry<String,Double>>() {
		@Override
		public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
			if(o2.getValue() - o1.getValue() > 0){
				return 1;
			}else if(o2.getValue() - o1.getValue() < 0){
				return -1;
			}else {
				return 0;
			}
		}
	};
	
	
	public static void main(String[] args) {
		
//		double [] p = {0.6, 0.2, 0.1, 0.1};
//		double [] q = {0.6, 0.3, 0.05, 0.05};
//		System.out.println(KLDivergence(p, q));
		int v0 = 0, v1= 0, v2 = 0, v3 = 0,v4 = 0;
		for (int i = 0; i < 10000; i++) {

			switch (new Random().nextInt(5)) {
			case 0:
				v0++;
				break;
			case 1:
				v1++;
				break;
			case 2:
				v2++;
				break;
			case 3:
				v3++;
				break;
			case 4:
				v4++;
				break;
			default:
				break;
			}

		}
		System.out.println(v0+ " " + v1 + " " + v2 + " " + v3 + " " +v4);
	}
	
	
	
	
	
	
}
