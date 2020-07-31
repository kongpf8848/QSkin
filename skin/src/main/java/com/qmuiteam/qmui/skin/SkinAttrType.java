package com.qmuiteam.qmui.skin;

public enum SkinAttrType
{
    BACKGROUD("background"),
    TEXTCOLOR("textColor"),
    SRC("src"),
    TINT("tint"),
    STYLE("style"),
    BACKGROUNDTINT("backgroundTint"),
    TEXTCOLORHINT("textColorHint"),
    DRAWABLETINT("drawableTint"),
    DRAWABLESTART("drawableStart"),
    DRAWABLELEFT("drawableLeft"),
    DRAWABLEEND("drawableEnd"),
    DRAWABLERIGHT("drawableRight"),
    DRAWABLETOP("drawableTop"),
    DRAWABLEBOTTOM("drawableBottom");

    String attrType;
    SkinAttrType(String attrType)
    {
        this.attrType = attrType;
    }
    public String getAttrType()
    {
        return attrType;
    }

    public static SkinAttrType getSupprotAttrType(String attrName)
    {
        for (SkinAttrType attrType : SkinAttrType.values())
        {
            if (attrType.getAttrType().equals(attrName))
                return attrType;
        }
        return null;
    }
}
