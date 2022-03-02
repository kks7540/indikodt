package com.indi.kodt.core.tiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

import com.indi.kodt.core.util.StringUtil;

public class CustomPreparer implements ViewPreparer {

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
        System.out.println("Tiles Menu @@@@@@@@@@@@@@@@@@@@@@@@");
        String attrName = "";
        if(attributeContext != null) {
            for(String key : attributeContext.getLocalAttributeNames()){
                if(key.contains("content")){
                	attrName = key;
                }
            }
        }
        if(!StringUtil.isNull(attrName)) {
        	System.out.println(attrName);
        	System.out.println(attributeContext.getAttribute(attrName));
        	//attributeContext.putAttribute(attrName, new Attribute(attributeContext.getAttribute(attrName)), true);
        }
	}

}
