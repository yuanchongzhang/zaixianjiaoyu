package com.project.zaixianjiaoyu.model;

public class UserInfoBean {


    /**
     * gEmployeeID : 39493b7b-5a16-4254-800c-355b7b1ac729
     * cEmployeeID : 230107197505260446
     * cEmployeeName : 测试用户
     * cSex : 男
     * cPhone : 13945083048
     * cIdentityCard : 230107197505260446
     * cAddress :
     * vRegistrationPhoto : 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
     */

    private String gEmployeeID;
    private String cEmployeeID;
    private String cEmployeeName;
    private String cSex;
    private String cPhone;
    private String cIdentityCard;
    private String cAddress;
    private String vRegistrationPhoto;

    public String getGEmployeeID() {
        return gEmployeeID;
    }

    public void setGEmployeeID(String gEmployeeID) {
        this.gEmployeeID = gEmployeeID;
    }

    public String getCEmployeeID() {
        return cEmployeeID;
    }

    public void setCEmployeeID(String cEmployeeID) {
        this.cEmployeeID = cEmployeeID;
    }

    public String getCEmployeeName() {
        return cEmployeeName;
    }

    public void setCEmployeeName(String cEmployeeName) {
        this.cEmployeeName = cEmployeeName;
    }

    public String getCSex() {
        return cSex;
    }

    public void setCSex(String cSex) {
        this.cSex = cSex;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCIdentityCard() {
        return cIdentityCard;
    }

    public void setCIdentityCard(String cIdentityCard) {
        this.cIdentityCard = cIdentityCard;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getVRegistrationPhoto() {
        return vRegistrationPhoto;
    }

    public void setVRegistrationPhoto(String vRegistrationPhoto) {
        this.vRegistrationPhoto = vRegistrationPhoto;
    }
}
