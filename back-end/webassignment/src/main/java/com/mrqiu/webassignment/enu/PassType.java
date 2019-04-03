package com.mrqiu.webassignment.enu;

public enum PassType {
    PENDING("待审批",1),
    PASSED("已通过",2),
    REJECTED("已驳回",3);

    public String name;
    public int index;

    private PassType(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for(PassType p : PassType.values()){
            if (p.getIndex() == index){
                return p.name;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

}
