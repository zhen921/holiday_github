package user.logiccompute;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.sun.mail.imap.protocol.ListInfo;

import user.model.HistoryPlan;
import user.model.PersonalTag;

@Component
public class CreateIndivTag {
	public PersonalTag getIndivTag(List<HistoryPlan> list) {
		PersonalTag tag = new PersonalTag();
		List<Integer> personList = new ArrayList<Integer>();
		List<Integer> timeList = new ArrayList<Integer>();
		List<Integer> costList = new ArrayList<Integer>();
		List<Integer> sexList=new ArrayList<Integer>();
		List<String> provinceList=new ArrayList<String>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			HistoryPlan historyPlan = (HistoryPlan) iterator.next();
			personList.add(historyPlan.getTotalperson());
			timeList.add(historyPlan.getTotaltime());
			costList.add(historyPlan.getTotalcost());
			sexList.add(historyPlan.getCompanysex());
			provinceList.add(historyPlan.getProvince()); 
		}
	
//学号
		tag.setSno(list.get(0).getSno());
//自己性别
		tag.setSelfsex(list.get(0).getSelfsex());
//人数
		tag.setTotalperson(getListAve(personList));
//时间
		tag.setTotaltime(getListAve(timeList));
//花费
		tag.setTotalcost(getListAve(costList));
//性别
		List<Map.Entry> list1=getSort(sexList);
		if(ObjectToInt(list1.get(0).getValue())>1){
			tag.setCompanysex( ObjectToInt(list1.get(0).getKey()));
		}
//省份
	
		List<Map.Entry> list2=getSort(provinceList);
		if(ObjectToInt(((Entry) list2.get(0)).getValue())>1){
			tag.setProvince( ObjectToString(list2.get(0).getKey()));
		}
//城市
//景点
		return tag;
	}

	/**
	 * 掐头去尾取均值
	 * 
	 * @param list
	 * @return double
	 */
	public double getListAve(List<Integer> list) {
		int sum = 0;
		Collections.sort(list);
		list.remove(0);
		list.remove(list.size() - 1);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			sum = sum + integer;
		}
		double a = sum * 1.0 / list.size();
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(a));
	}
/**
 * 实现词频统计功能，放进任何类型list,返回封装了map的list
 * @param list
 * @return 
 */
	public List getSort(List list) {
		Map map = new HashMap();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (map.get(object) != null) {
				int value = ((Integer) map.get(object)).intValue();
				value++;
				map.put(object, new Integer(value));
			} else {
				map.put(object, new Integer(1));
			}
		}
		return SortMap(map);
	}
	//排序放进list里
	public static List SortMap(Map oldmap) {

		ArrayList<Map.Entry> list = new ArrayList<Map.Entry>(oldmap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry>() {
			public int compare(Entry value1, Entry value2) {
				
				return ObjectToInt(value2.getValue())-ObjectToInt(value1.getValue());// 降序
			}
		});
		return list;
	}
	
	public static Integer ObjectToInt(Object o){
	Object obje = o;
	Integer value3 = null;
	if (obje instanceof Integer)
		value3 = (Integer) obje;
	else {}
	return value3;
	}
	
	public String  ObjectToString(Object o){
		Object obje = o;
		String value3 = null;
		if (obje instanceof String)
			value3 = (String) obje;
		else {}
		return value3;
		}
}
