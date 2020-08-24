package com.lwx.ui;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.lwx.dao.DBHelper;

import java.awt.Font;
import java.util.List;
import java.util.Map;

public class CategoryTest {
	
	private static DBHelper db = new DBHelper();
	
	
	
	public static void openByYear(){

		// 显示表格数据 以列进行分组 以行进行着色
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		String sql1 = "select in_time,roomid,out_time,r_price ,sysdate-in_time as distime from roomtype ,innerinfo,roominfo"
				+ " where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= 10001";
		String sql2 = "select in_time,roomid,out_time,r_price ,sysdate-in_time as distime from roomtype ,innerinfo,roominfo"
				+ " where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= 10002";
		String sql3 = "select in_time,roomid,out_time,r_price ,sysdate-in_time as distime from roomtype ,innerinfo,roominfo"
				+ " where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= 10003";
		String sql4 = "select in_time,roomid,out_time,r_price ,sysdate-in_time as distime from roomtype ,innerinfo,roominfo"
				+ " where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= 10004";
		String sql5 = "select in_time,roomid,out_time,r_price ,sysdate-in_time as distime from roomtype ,innerinfo,roominfo"
				+ " where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= 10005";
		String sql6 = "select in_time,roomid,out_time,r_price ,sysdate-in_time as distime from roomtype ,innerinfo,roominfo"
				+ " where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= 10006";
		List<Map<String, String>> list = db.queryAll(sql1);
		List<Map<String, String>> list2 = db.queryAll(sql2);
		List<Map<String, String>> list3 = db.queryAll(sql3);
		List<Map<String, String>> list4 = db.queryAll(sql4);
		List<Map<String, String>> list5 = db.queryAll(sql5);
		List<Map<String, String>> list6 = db.queryAll(sql6);
		
		String sql = "select * from roomtype";
		List<Map<String, String>> list1 = db.queryAll(sql);
		
		Integer[] value1 = new Integer[list.size()];
		Integer[] value2 = new Integer[list2.size()];
		Integer[] value3 = new Integer[list3.size()];
		Integer[] value4 = new Integer[list4.size()];
		Integer[] value5 = new Integer[list5.size()];
		Integer[] value6 = new Integer[list6.size()];
		
		for(int i = 0; i< value1.length; i++){
			value1[i] = Integer.parseInt(list.get(i).get("r_price"));
		}
		for(int i = 0; i< value2.length; i++){
			value2[i] = Integer.parseInt(list2.get(i).get("r_price"));
		}
		for(int i = 0; i< value3.length; i++){
			value3[i] = Integer.parseInt(list3.get(i).get("r_price"));
		}
		for(int i = 0; i< value4.length; i++){
			value4[i] = Integer.parseInt(list4.get(i).get("r_price"));
		}
		for(int i = 0; i< value5.length; i++){
			value5[i] = Integer.parseInt(list5.get(i).get("r_price"));
		}
		for(int i = 0; i< value6.length; i++){
			value6[i] = Integer.parseInt(list6.get(i).get("r_price"));
		}
		
		//求和
		int count1 = 0;
		for(int i =0; i<value1.length; i++){
			count1 = count1 + value1[i];
		}
		int count2 = 0;
		for(int i =0; i<value2.length; i++){
			count2 = count2 + value2[i];
		}
		int count3 = 0;
		for(int i =0; i<value3.length; i++){
			count3 = count3 + value3[i];
		}
		int count4 = 0;
		for(int i =0; i<value4.length; i++){
			count4 = count4 + value4[i];
		}
		int count5 = 0;
		for(int i =0; i<value5.length; i++){
			count5 = count5 + value5[i];
		}
		int count6 = 0;
		for(int i =0; i<value6.length; i++){
			count6 = count6 + value6[i];
		}
		
		
		
		dataset.setValue(0, list1.get(0).get("r_type") ,"2016");
		dataset.setValue(0, list1.get(1).get("r_type"), "2016");
		dataset.setValue(0, list1.get(2).get("r_type"), "2016");
		dataset.setValue(0, list1.get(3).get("r_type"), "2016");
		dataset.setValue(0, list1.get(4).get("r_type"), "2016");
		dataset.setValue(0, list1.get(5).get("r_type"), "2016");
		
		
		dataset.setValue(0, list1.get(0).get("r_type") ,"2017");
		dataset.setValue(0, list1.get(1).get("r_type"), "2017");
		dataset.setValue(0, list1.get(2).get("r_type"), "2017");
		dataset.setValue(0, list1.get(3).get("r_type"), "2017");
		dataset.setValue(0, list1.get(4).get("r_type"), "2017");
		dataset.setValue(0, list1.get(5).get("r_type"), "2017");
		
		
		dataset.setValue(0, list1.get(0).get("r_type") ,"2018");
		dataset.setValue(0, list1.get(1).get("r_type"), "2018");
		dataset.setValue(0, list1.get(2).get("r_type"), "2018");
		dataset.setValue(0, list1.get(3).get("r_type"), "2018");
		dataset.setValue(0, list1.get(4).get("r_type"), "2018");
		dataset.setValue(0, list1.get(5).get("r_type"), "2018");
		
		
		dataset.setValue(0, list1.get(0).get("r_type") ,"2019");
		dataset.setValue(0, list1.get(1).get("r_type"), "2019");
		dataset.setValue(0, list1.get(2).get("r_type"), "2019");
		dataset.setValue(0, list1.get(3).get("r_type"), "2019");
		dataset.setValue(0, list1.get(4).get("r_type"), "2019");
		dataset.setValue(0, list1.get(5).get("r_type"), "2019");
		
		dataset.setValue(count1, list1.get(0).get("r_type") ,"2020");
		dataset.setValue(count2, list1.get(1).get("r_type"), "2020");
		dataset.setValue(count3, list1.get(2).get("r_type"), "2020");
		dataset.setValue(count4, list1.get(3).get("r_type"), "2020");
		dataset.setValue(count5, list1.get(4).get("r_type"), "2020");
		dataset.setValue(count6, list1.get(5).get("r_type"), "2020");
		
		System.out.println(count3);
//		// 第一行
//		dataset.setValue(144, "Google", "总收入");
//		dataset.setValue(70, "Google", "盈利");
//		dataset.setValue(2467, "Google", "市值");
//
//		// 第二行
//		dataset.setValue(100, "Baidu", "总收入");
//		dataset.setValue(50, "Baidu", "盈利");
//		dataset.setValue(517, "Baidu", "市值");
//
//		// 第三行
//		dataset.setValue(110, "alibaba", "总收入");
//		dataset.setValue(60, "alibaba", "盈利");
//		dataset.setValue(650, "alibaba", "市值");
//
//		// 第四行
//		dataset.setValue(130, "weiruan", "总收入");
//		dataset.setValue(80, "weiruan", "盈利");
//		dataset.setValue(1000, "weiruan", "市值");
		
		
		//jfreechart显示
		JFreeChart chart = ChartFactory.createBarChart("各房型收入", "每一年", "单位(亿/美元)",
														dataset, PlotOrientation.VERTICAL, true, true, false);
		
		//设置图片背景色
		chart.setBackgroundPaint(Color.WHITE);
		
		//解决中文显示的问题
		Font fontTitleFont = new Font("隶书", Font.BOLD, 20);
		Font fontLegendFont = new Font("隶书", Font.BOLD, 10);
		Font fontLabelFont = new Font("隶书", Font.BOLD, 14);
		
		// 修改标题的字体
		TextTitle title = chart.getTitle();
		title.setFont(fontTitleFont);
		// 修改标题的字体
		LegendTitle legend = chart.getLegend();
		legend.setItemFont(fontLegendFont);
		
		//修改图标绘制Plot字体
		//CategoryPlot 用于管理  坐标轴(CategoryAxis,ValueAxis), 数据集(Dataset), 渲染器(BarRender)
		CategoryPlot cp = chart.getCategoryPlot();
		
		//将Plot的背景色设置为灰色		网格线为白色
		cp.setBackgroundPaint(Color.lightGray);
		cp.setRangeGridlinePaint(Color.WHITE);
		
		//设置同一组间每一项的间距为0
		BarRenderer render = (BarRenderer) cp.getRenderer();
		render.setItemMargin(0);
		
		//设置每一项上面显示数字
		render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		render.setBaseItemLabelsVisible(true);
		
		//水平方向
		CategoryAxis cAxis = cp.getDomainAxis();
		cAxis.setLabelFont(fontLabelFont);
		//设置每一列的字体
		cAxis.setTickLabelFont(fontLabelFont);
		
		//垂直方向 
		ValueAxis vAxis = cp.getRangeAxis();
		vAxis.setLabelFont(fontLabelFont);
		
		
		//显示
		ChartFrame frame = new ChartFrame("每一年各房型的收入", chart);
		frame.pack();		//自动调整合适的大小
		frame.setLocationRelativeTo(null);    //居中
		frame.setVisible(true);
	}
}
















