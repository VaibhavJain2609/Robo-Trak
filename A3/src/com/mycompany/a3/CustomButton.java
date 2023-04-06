package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

public class CustomButton extends Button{

	
	public CustomButton() {
		super();
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setBgTransparency(200);
		this.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		this.getAllStyles().setBorder((Border.createLineBorder(4,ColorUtil.rgb(255, 0, 0))));
		//this.getAllStyles().
	}
}
