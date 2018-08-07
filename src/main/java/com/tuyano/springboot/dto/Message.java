package com.tuyano.springboot.dto;

public class Message {

    /**
     * id
    */
    private String id;
    
    /**
     * name
    */
    private String name;
    
    /**
     * text
    */
    private String text;
    
    /**
     * idを返す。
     * @return id
     */
    public String getId() {
        return id;
    }
    
    /**
     * idを設定する。
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * nameを返す。
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * nameを設定する。
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * textを返す。
     * @return text
     */
    public String getText() {
        return text;
    }
    
    /**
     * textを設定する。
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * オブジェクトの文字列表現を返す。
     * @return オブジェクトの文字列表現
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" , ");
        sb.append("[id=").append(getId()).append("]");
        sb.append(" , ");
        sb.append("[name=").append(getName()).append("]");
        sb.append(" , ");
        sb.append("[text=").append(getText()).append("]");
        return sb.toString();
    }

    
}
