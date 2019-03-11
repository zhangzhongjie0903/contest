package com.contest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class GildedRosedRosedRose {
	 Item[] items;
	 //格式化时间格式
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	    public GildedRosedRose(Item[] items) {
	        this.items = items;
	    }
	    
	    //格式化 商品的品质 销售期限
	    public int format(int ItemProperty){
	    	
	    	if(ItemProperty<=0){
	    		ItemProperty=0;
	    	}
	    	//商品的品质`Quality`永远不会超过50
	    	if(ItemProperty>=50){
	    		ItemProperty=50;
	    	}
	    	return ItemProperty ;
	    }
	    
	    //一天结束校验
	    public boolean IsEndDay(String date){
	    	//一天的结束时间  23:59:59
	    	String nowDate = simpleDateFormat.format(date);
	    	Calendar calendar = new GregorianCalendar();
	    	calendar.set(Calendar.HOUR_OF_DAY,23);
	        calendar.set(Calendar.MINUTE,59);
	        calendar.set(Calendar.SECOND,59);
	        calendar.set(Calendar.MILLISECOND,999);
	        Date dayEnd = calendar.getTime();
	        String endStr = simpleDateFormat.format(dayEnd);
	      //判断时间是否为23:59:59 若是则是一天结束 ，返回true；否则返回false;
	        if(nowDate.equalsIgnoreCase(endStr)){
	        	return true;
	        }else{
	        	return false;
	        }
	    }
	    
	    public void updateQuality() {
	       // items[0].sellIn = 9;
	       // items[0].quality = 19;
	    	//距离表演开始的天数
	        int beforeStart=0;
	        //循环遍历得到每一个商品
	        for(int i=0;i<items.length;i++){
	        	
		        //判断销售期是否过期
		        //一旦销售期限过期，品质值`Quality`会每天减2；
		       	if(items[i].sellIn==0){
		       		items[i].quality=items[i].quality-2;
		       		if(items[i].quality<=0){
		       			items[i].quality=0;
		       		}
		       	}
		       	
		       	
	        	//"Aged Brie"（法国干酪）的品质`Quality`会每天增1；
	        	if("Aged Brie".equals(items[i].name)){
	        		items[i].quality++;
	        	}
	        	
	        	
	        	//判断商品是否为"Backstage passes"（剧场后台通行证）
	        	if("Backstage passes".equals(items[i].name)){
	        		//其品质`Quality`在剧场开演前10天以外，每天增1
	        		int remainDays= items[i].sellIn-beforeStart;
	        		if(remainDays>10){
	        			items[i].quality++;
	        		} 
	        		//当离开演不足10天（含10天）时， 品质`Quality`每天增2
	        		if(5<remainDays && remainDays<=10){
	        			items[i].quality=items[i].quality+2;
	        		}
	        		//当离开演不足5天（含5天）时，品质`Quality`每天增3
	        		if(remainDays>0&remainDays<=5){
	        			items[i].quality=items[i].quality+3;
	        		}
	        		//一旦演出结束，品质就会降为0
	        		if(remainDays<=0){
	        			items[i].quality=0;
	        		} 
	        	}
	        	
	        	
	        	//格式化商品属性 看是否满足格式
	        	items[i].sellIn=format(items[i].sellIn);
	        	items[i].quality=format(items[i].quality);
	        	
	        	
	        	 //判断是否为一天结束
		        if(IsEndDay(simpleDateFormat.format(new Date()).toString())){
		        	//判断是否为传奇商品"Sulfuras"（游戏中的魔法锤道具）永不到期，也不会降低品质`Quality`；
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