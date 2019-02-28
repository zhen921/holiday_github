package user.logiccompute;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import user.model.PersonalTag;

@Component
public class MultiCluster {
	static List<double[]> data= new ArrayList<double[]>();
	static List<double[]> kernal = new ArrayList<double[]>();
	public static List<double[]> clusterCompute(List<PersonalTag> list ) {
		createData(list);
		setKernal(data, 11, 6, 17,21);
		Circle();
		//showResult();
		return data;
	}
	public static void clearList(){
		kernal.clear();
		data.clear();
	}
	public static  void createData(List<PersonalTag> list){
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			PersonalTag personalTag = (PersonalTag) iterator.next();
			double[] item = new double[4];
			item[0]=personalTag.getTotalperson();
			item[1]=personalTag.getTotaltime();
			item[2]=personalTag.getTotalcost();
			data.add(item);
		}

	}

	public static List<double[]> setKernal(List<double[]> list, int a, int b, int c,int d) {
		kernal.add(list.get(a));
		kernal.add(list.get(b));
		kernal.add(list.get(c));
		kernal.add(list.get(d));
		return kernal;
	}
	/**
	 * ���뵥����ݣ����������abc,����ŷ�������̵ı��
	 * @param cluster
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int getDistance(double[] cluster,double[]  a,double[] b,double[] c,double[] d){
		double da,db,dc,dd;
		da=(cluster[0]-a[0])*(cluster[0]-a[0])+(cluster[1]-a[1])*(cluster[1]-a[1])+(cluster[2]-a[2])*(cluster[2]-a[2]);
		db=(cluster[0]-b[0])*(cluster[0]-b[0])+(cluster[1]-b[1])*(cluster[1]-b[1])+(cluster[2]-b[2])*(cluster[2]-b[2]);
		dc=(cluster[0]-c[0])*(cluster[0]-c[0])+(cluster[1]-c[1])*(cluster[1]-c[1])+(cluster[2]-c[2])*(cluster[2]-c[2]);
		dd=(cluster[0]-d[0])*(cluster[0]-d[0])+(cluster[1]-d[1])*(cluster[1]-d[1])+(cluster[2]-d[2])*(cluster[2]-d[2]);
		 if (da == Math.min(Math.min(da, db), dc))   //����һ��ľ�����С����1            
			 return 1;        
		 else if (db == Math.min(Math.min(Math.min(da, db), dc),dd))//���ڶ���ľ�����С����2            
			 return 2;        
		 else if (dc == Math.min(Math.min(Math.min(da, db), dc),dd))//��������ľ�����С����3            
			 return 3;       
		 else if (dd == Math.min(Math.min(Math.min(da, db), dc),dd))//��������ľ�����С����3            
			 return 4;       
		 return 0;
	}
	
	/**
	 * ������ݣ��ͳ�ʼ���ģ��������µĺ���
	 * @param data
	 * @param list
	 * @return
	 */
	public static List<double[]> reComputeCluster(List<double[]> data,List<double[]> list){
		
		List<double[]> newKer=new ArrayList<double[]>(); 
		double[] a=list.get(0);
		double[] b=list.get(1);
		double[] c=list.get(2);
		double[] d=list.get(3);
		double[] temp;
		int i=0;
		while(i<data.size()){
			data.get(i)[3]=getDistance(data.get(i), a, b, c,d);
			i++;
		}
		double[] suma={0,0,0};
		int a1=0;
		double[] sumb={0,0,0};
		int b1=0;
		double[] sumc={0,0,0};
		int c1=0;
		double[] sumd={0,0,0};
		int d1=0;
		i=0;
		while(i<data.size()){
			double[] t=data.get(i);
			if(t[3]==1){
				for(int j=0;j<3;j++){
					suma[j]+=t[j];
				}
				a1++;
			}else if(t[3]==2){
				for(int j=0;j<3;j++){
					sumb[j]+=t[j];
				}
				b1++;
			}else if(t[3]==3){
				for(int j=0;j<3;j++){
					sumc[j]+=t[j];
				}
				c1++;
			}else if(t[3]==4){
				for(int j=0;j<3;j++){
					sumd[j]+=t[j];
				}
				d1++;
			}else{
				
			}
			i++;
		}
		for(int j=0;j<3;j++){
			suma[j]=suma[j]/a1;
			sumb[j]=sumb[j]/b1;
			sumc[j]=sumc[j]/c1;
			sumd[j]=sumd[j]/d1;
		}
		newKer.add(suma);
		newKer.add(sumb);
		newKer.add(sumc);
		newKer.add(sumd);
		return newKer;
	}
	
	public static void Circle(){
		while(true){
			boolean flag=true;
			List<double[]> t=reComputeCluster(data, kernal);
			for(int i=0;i<t.size();i++){
				for(int j=0;j<3;j++){
					if(t.get(i)[j]!=kernal.get(i)[j])
						flag=false;
				}
			}
			if(flag)
				break;
			else
				kernal=t;
		}
	}
	public static void showResult(){
		for(int i=0;i<data.size();i++){
			for(int j=0;j<4;j++){
				System.out.print(data.get(i)[j]+" ");
			}
			System.out.println();
		}

		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(kernal.get(0)[0])+" "+df.format(kernal.get(0)[1])+" "+df.format(kernal.get(0)[2]));
		System.out.println(df.format(kernal.get(1)[0])+" "+df.format(kernal.get(1)[1])+" "+df.format(kernal.get(1)[2]));
		System.out.println(df.format(kernal.get(2)[0])+" "+df.format(kernal.get(2)[1])+" "+df.format(kernal.get(2)[2]));
		System.out.println(df.format(kernal.get(3)[0])+" "+df.format(kernal.get(3)[1])+" "+df.format(kernal.get(3)[2]));
	}
	
	
}
