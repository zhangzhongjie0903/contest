package com.contest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class GildedRosedRosedRose {
	 Item[] items;
	 //��ʽ��ʱ���ʽ
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	    public GildedRosedRose(Item[] items) {
	        this.items = items;
	    }
	    
	    //��ʽ�� ��Ʒ��Ʒ�� ��������
	    public int format(int ItemProperty){
	    	
	    	if(ItemProperty<=0){
	    		ItemProperty=0;
	    	}
	    	//��Ʒ��Ʒ��`Quality`��Զ���ᳬ��50
	    	if(ItemProperty>=50){
	    		ItemProperty=50;
	    	}
	    	return ItemProperty ;
	    }
	    
	    //һ�����У��
	    public boolean IsEndDay(String date){
	    	//һ��Ľ���ʱ��  23:59:59
	    	String nowDate = simpleDateFormat.format(date);
	    	Calendar calendar = new GregorianCalendar();
	    	calendar.set(Calendar.HOUR_OF_DAY,23);
	        calendar.set(Calendar.MINUTE,59);
	        calendar.set(Calendar.SECOND,59);
	        calendar.set(Calendar.MILLISECOND,999);
	        Date dayEnd = calendar.getTime();
	        String endStr = simpleDateFormat.format(dayEnd);
	      //�ж�ʱ���Ƿ�Ϊ23:59:59 ��������һ����� ������true�����򷵻�false;
	        if(nowDate.equalsIgnoreCase(endStr)){
	        	return true;
	        }else{
	        	return false;
	        }
	    }
	    
	    public void updateQuality() {
	       // items[0].sellIn = 9;
	       // items[0].quality = 19;
	    	//������ݿ�ʼ������
	        int beforeStart=0;
	        //ѭ�������õ�ÿһ����Ʒ
	        for(int i=0;i<items.length;i++){
	        	
		        //�ж��������Ƿ����
		        //һ���������޹��ڣ�Ʒ��ֵ`Quality`��ÿ���2��
		       	if(items[i].sellIn==0){
		       		items[i].quality=items[i].quality-2;
		       		if(items[i].quality<=0){
		       			items[i].quality=0;
		       		}
		       	}
		       	
		       	
	        	//"Aged Brie"���������ң���Ʒ��`Quality`��ÿ����1��
	        	if("Aged Brie".equals(items[i].name)){
	        		items[i].quality++;
	        	}
	        	
	        	
	        	//�ж���Ʒ�Ƿ�Ϊ"Backstage passes"���糡��̨ͨ��֤��
	        	if("Backstage passes".equals(items[i].name)){
	        		//��Ʒ��`Quality`�ھ糡����ǰ10�����⣬ÿ����1
	        		int remainDays= items[i].sellIn-beforeStart;
	        		if(remainDays>10){
	        			items[i].quality++;
	        		} 
	        		//���뿪�ݲ���10�죨��10�죩ʱ�� Ʒ��`Quality`ÿ����2
	        		if(5<remainDays && remainDays<=10){
	        			items[i].quality=items[i].quality+2;
	        		}
	        		//���뿪�ݲ���5�죨��5�죩ʱ��Ʒ��`Quality`ÿ����3
	        		if(remainDays>0&remainDays<=5){
	        			items[i].quality=items[i].quality+3;
	        		}
	        		//һ���ݳ�������Ʒ�ʾͻήΪ0
	        		if(remainDays<=0){
	        			items[i].quality=0;
	        		} 
	        	}
	        	
	        	
	        	//��ʽ����Ʒ���� ���Ƿ������ʽ
	        	items[i].sellIn=format(items[i].sellIn);
	        	items[i].quality=format(items[i].quality);
	        	
	        	
	        	 //�ж��Ƿ�Ϊһ�����
		        if(IsEndDay(simpleDateFormat.format(new Date()).toString())){
		        	//�ж��Ƿ�Ϊ������Ʒ"Sulfuras"����Ϸ�е�ħ�������ߣ��������ڣ�Ҳ���ή��Ʒ��`Quality`��
		        	if("Sulfuras".equals(items[i].name)){
		        		items[i].sellIn=50;
		        	}else{
		        		items[i].sellIn--;
			        	items[i].quality--;
		        	}
		        }
	        }
	        
	    }
}