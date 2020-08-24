package com.lwx.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.util.MyUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RoomInfo {

	protected Shell shell;
	private StackLayout stackLayout= new StackLayout();
    public static MyUtil mu = new MyUtil();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RoomInfo window = new RoomInfo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(RoomInfo.class, "/image/酒店.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/主界面.jpg"));
		shell.setSize(972, 623);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		mu.centerShell(shell);
		Composite composite = new Composite(shell, SWT.NONE);
		
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		
		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/E1.JPG"));
		label_8.setBounds(91, 28, 750, 493);
		
		Label label_9 = new Label(composite_1, SWT.NONE);
		label_9.setText("总统房 没的说");
		label_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_9.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_9.setBounds(350, 524, 252, 42);
		
		Button button = new Button(composite_1, SWT.NONE);
		button.setBounds(846, 312, 98, 30);
		button.setText("下一个类型");
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.setText("上一个类型");
		button_1.setBounds(846, 242, 98, 30);
		
		Button button_12 = new Button(composite_1, SWT.NONE);
		button_12.setBounds(846, 536, 98, 30);
		button_12.setText("返回主菜单");
		
		Composite composite_2 = new Composite(composite, SWT.NONE);
		
		Label label_6 = new Label(composite_2, SWT.NONE);
		label_6.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/D4.JPG"));
		label_6.setBounds(91, 28, 750, 493);
		
		Label label_7 = new Label(composite_2, SWT.NONE);
		label_7.setText("家庭外出游玩休息");
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_7.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_7.setBounds(350, 524, 252, 42);
		
		Button button_2 = new Button(composite_2, SWT.NONE);
		button_2.setText("上一个类型");
		button_2.setBounds(846, 242, 98, 30);
		
		Button button_3 = new Button(composite_2, SWT.NONE);
		button_3.setText("下一个类型");
		button_3.setBounds(846, 312, 98, 30);
		
		Button button_13 = new Button(composite_2, SWT.NONE);
		button_13.setText("返回主菜单");
		button_13.setBounds(846, 536, 98, 30);
		
		Composite composite_3 = new Composite(composite, SWT.NONE);
		
		Label label_4 = new Label(composite_3, SWT.NONE);
		label_4.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/C6.JPG"));
		label_4.setBounds(91, 28, 750, 493);
		
		Label label_5 = new Label(composite_3, SWT.NONE);
		label_5.setText("商务精英体验极佳");
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_5.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_5.setBounds(350, 524, 252, 42);
		
		Button button_4 = new Button(composite_3, SWT.NONE);
		button_4.setText("上一个类型");
		button_4.setBounds(846, 242, 98, 30);
		
		Button button_5 = new Button(composite_3, SWT.NONE);
		button_5.setText("下一个类型");
		button_5.setBounds(846, 312, 98, 30);
		
		Button button_14 = new Button(composite_3, SWT.NONE);
		button_14.setText("返回主菜单");
		button_14.setBounds(846, 536, 98, 30);
		
		Composite composite_4 = new Composite(composite, SWT.NONE);
		
		Label label_2 = new Label(composite_4, SWT.NONE);
		label_2.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/B9.JPG"));
		label_2.setBounds(91, 28, 750, 493);
		
		Label label_3 = new Label(composite_4, SWT.NONE);
		label_3.setText("情侣外出游行必住嗷");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_3.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_3.setBounds(350, 524, 252, 42);
		
		Button button_6 = new Button(composite_4, SWT.NONE);
		button_6.setText("上一个类型");
		button_6.setBounds(846, 242, 98, 30);
		
		Button button_7 = new Button(composite_4, SWT.NONE);
		button_7.setText("下一个类型");
		button_7.setBounds(846, 312, 98, 30);
		
		Button button_15 = new Button(composite_4, SWT.NONE);
		button_15.setText("返回主菜单");
		button_15.setBounds(846, 536, 98, 30);
		
		Composite composite_5 = new Composite(composite, SWT.NONE);
		
		Label label = new Label(composite_5, SWT.NONE);
		label.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/A1.JPG"));
		label.setBounds(91, 28, 750, 493);
		
		Label label_1 = new Label(composite_5, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_1.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_1.setText("经济实惠,没得讲价嗷");
		label_1.setBounds(350, 524, 252, 42);
		
		Button button_8 = new Button(composite_5, SWT.NONE);
		
		button_8.setText("上一个类型");
		button_8.setBounds(846, 242, 98, 30);
		
		Button button_9 = new Button(composite_5, SWT.NONE);
		button_9.setText("下一个类型");
		button_9.setBounds(846, 312, 98, 30);
		
		Composite composite_6 = new Composite(composite, SWT.NONE);
		
		Label label_10 = new Label(composite_6, SWT.NONE);
		label_10.setBackgroundImage(SWTResourceManager.getImage(RoomInfo.class, "/image/F3.JPG"));
		label_10.setBounds(90, 28, 750, 493);
		
		Label label_11 = new Label(composite_6, SWT.NONE);
		label_11.setText("兄弟姊妹萌轰趴必备嗷");
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_11.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_11.setBounds(350, 524, 252, 42);
		
		Button button_10 = new Button(composite_6, SWT.NONE);
		button_10.setText("上一个类型");
		button_10.setBounds(846, 242, 98, 30);
		
		Button button_11 = new Button(composite_6, SWT.NONE);
		button_11.setText("下一个类型");
		button_11.setBounds(846, 312, 98, 30);
		
		Button button_17 = new Button(composite_6, SWT.NONE);
		
		button_17.setText("返回主菜单");
		button_17.setBounds(846, 536, 98, 30);
		composite.setLayout(stackLayout);
		stackLayout.topControl = composite_5;
		
		Button button_16 = new Button(composite_5, SWT.NONE);
		button_16.setText("返回主菜单");
		button_16.setBounds(846, 536, 98, 30);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			mu.alter(shell, "提示信息", "已经到最前面了。。。");
			}
		});
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				composite_5.setVisible(false);
			    composite_4.setVisible(true);
			    composite_3.setVisible(false);
			    composite_6.setVisible(false);
			    composite_1.setVisible(false);
			    composite_2.setVisible(false);
			    
			}
		});
		 button_6.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					composite_5.setVisible(true);
				    composite_4.setVisible(false);
				    composite_3.setVisible(false);
				    composite_6.setVisible(false);
				    composite_1.setVisible(false);
				    composite_2.setVisible(false);
				}
			});
			button_7.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(true);
				    composite_6.setVisible(false);
				    composite_1.setVisible(false);
				    composite_2.setVisible(false);
				
		}
	});
			button_4.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(true);
				    composite_3.setVisible(false);
				    composite_6.setVisible(false);
				    composite_1.setVisible(false);
				    composite_2.setVisible(false);
				}
			});
			button_5.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(false);
				    composite_6.setVisible(false);
				    composite_1.setVisible(false);
				    composite_2.setVisible(true);
				
		}
	});
			button_2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(true);
				    composite_6.setVisible(false);
				    composite_1.setVisible(false);
				    composite_2.setVisible(false);
				}
			});
			button_3.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(false);
				    composite_6.setVisible(false);
				    composite_1.setVisible(true);
				    composite_2.setVisible(false);
				
		}
	});
			button_1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(false);
				    composite_6.setVisible(false);
				    composite_1.setVisible(false);
				    composite_2.setVisible(true);
				}
			});
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(false);
				    composite_6.setVisible(true);
				    composite_1.setVisible(false);
				    composite_2.setVisible(false);
				
		}
	});	
			button_10.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					composite_5.setVisible(false);
				    composite_4.setVisible(false);
				    composite_3.setVisible(false);
				    composite_6.setVisible(false);
				    composite_1.setVisible(true);
				    composite_2.setVisible(false);
				}
			});
			button_11.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					mu.alter(shell, "提示信息", "已经到最后了。。。");
		}
	});	
			button_12.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					returnIndex();
				}
			});
			button_13.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					returnIndex();
				}
			});
			button_14.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					returnIndex();
				}
			});
			button_15.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					returnIndex();
				}
			});
			button_16.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					returnIndex();
				}
			});
			button_17.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					returnIndex();
				}
			});
	}

	protected void returnIndex() {
		shell.dispose();
		Index index = new Index();
		   index.open();
	}

}
