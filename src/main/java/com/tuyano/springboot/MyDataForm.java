package com.tuyano.springboot;

import java.io.Serializable;

public class MyDataForm extends MyData implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 年齢From
    */
    private Integer ageFrom;
    
    /**
     * 年齢To
    */
    private Integer ageTo;
    
    /**
     * チェック1
    */
    private boolean check1;
    
    /**
     * チェック2
    */
    private String[] check2;
    
    /**
     * ラジオ1
    */
    private String radio1;
    
    /**
     * セレクト1
    */
    private String select1;
    
    /**
     * セレクト2
    */
    private String[] select2;
    
    /**
     * 日付1
    */
    private String date1;
    
    /**
     * 年齢Fromを返す。
     * @return 年齢From
     */
    public Integer getAgeFrom() {
        return ageFrom;
    }
    
    /**
     * 年齢Fromを設定する。
     * @param ageFrom 年齢From
     */
    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }
    
    /**
     * 年齢Toを返す。
     * @return 年齢To
     */
    public Integer getAgeTo() {
        return ageTo;
    }
    
    /**
     * 年齢Toを設定する。
     * @param ageTo 年齢To
     */
    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }
    
    /**
     * チェック1を返す。
     * @return チェック1
     */
    public boolean isCheck1() {
        return check1;
    }
    
    /**
     * チェック1を設定する。
     * @param check1 チェック1
     */
    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }
    
    /**
     * チェック2を返す。
     * @return チェック2
     */
    public String[] getCheck2() {
        return check2;
    }
    
    /**
     * チェック2を設定する。
     * @param check2 チェック2
     */
    public void setCheck2(String[] check2) {
        this.check2 = check2;
    }
    
    /**
     * ラジオ1を返す。
     * @return ラジオ1
     */
    public String getRadio1() {
        return radio1;
    }
    
    /**
     * ラジオ1を設定する。
     * @param radio1 ラジオ1
     */
    public void setRadio1(String radio1) {
        this.radio1 = radio1;
    }
    
    /**
     * セレクト1を返す。
     * @return セレクト1
     */
    public String getSelect1() {
        return select1;
    }
    
    /**
     * セレクト1を設定する。
     * @param select1 セレクト1
     */
    public void setSelect1(String select1) {
        this.select1 = select1;
    }
    
    /**
     * セレクト2を返す。
     * @return セレクト2
     */
    public String[] getSelect2() {
        return select2;
    }
    
    /**
     * セレクト2を設定する。
     * @param select2 セレクト2
     */
    public void setSelect2(String[] select2) {
        this.select2 = select2;
    }
    
    /**
     * 日付1を返す。
     * @return 日付1
     */
    public String getDate1() {
        return date1;
    }
    
    /**
     * 日付1を設定する。
     * @param date1 日付1
     */
    public void setDate1(String date1) {
        this.date1 = date1;
    }
    
    /**
     * オブジェクトの文字列表現を返す。
     * @return オブジェクトの文字列表現
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" , ");
        sb.append("[ageFrom=").append(getAgeFrom()).append("]");
        sb.append(" , ");
        sb.append("[ageTo=").append(getAgeTo()).append("]");
        sb.append(" , ");
        sb.append("[check1=").append(isCheck1()).append("]");
        sb.append(" , ");
        sb.append("[check2=").append(getCheck2()).append("]");
        sb.append(" , ");
        sb.append("[radio1=").append(getRadio1()).append("]");
        sb.append(" , ");
        sb.append("[select1=").append(getSelect1()).append("]");
        sb.append(" , ");
        sb.append("[select2=").append(getSelect2()).append("]");
        sb.append(" , ");
        sb.append("[date1=").append(getDate1()).append("]");
        return sb.toString();
    }

}
