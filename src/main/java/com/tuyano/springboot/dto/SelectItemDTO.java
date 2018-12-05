package com.tuyano.springboot.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * セレクトアイテム
 */
@Component
public class SelectItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * code
    */
    private String code;

    /**
     * label
    */
    private String label;

    /**
     * codeを返す。
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * codeを設定する。
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * labelを返す。
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * labelを設定する。
     * @param label label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * オブジェクトの文字列表現を返す。
     * @return オブジェクトの文字列表現
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" , ");
        sb.append("[code=").append(getCode()).append("]");
        sb.append(" , ");
        sb.append("[label=").append(getLabel()).append("]");
        return sb.toString();
    }

}
