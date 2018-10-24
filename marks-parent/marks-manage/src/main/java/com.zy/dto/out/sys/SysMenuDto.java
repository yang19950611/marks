package com.zy.dto.out.sys;

import com.zy.dto.BaseDto;

import java.util.List;

public class SysMenuDto extends BaseDto {
    private String icon;
    private String index;
    private String title;
    private List<SysMenuDto> subs;


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SysMenuDto> getSubs() {
        return subs;
    }

    public void setSubs(List<SysMenuDto> subs) {
        this.subs = subs;
    }
}
