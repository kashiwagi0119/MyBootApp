package com.tuyano.springboot.form;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.tuyano.springboot.entity.Item;
import com.tuyano.springboot.entity.Room;

import lombok.Data;

@Data
@Component
public class MyDataForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public MyDataForm() {
		super();
		room = new Room();
	}

	private String name;

	private String mail;

	private String memo;

	private Room room;

	private Item item;

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
     * チェック3
     */
    private String[] check3;

    /**
     * ラジオ1
    */
    private String radio1;

    /**
     * ラジオ2
     */
    private String radio2;

    /**
     * セレクト1
    */
    private String select1;

    /**
     * セレクト2
    */
    private String[] select2;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}

	public Integer getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}

	public boolean isCheck1() {
		return check1;
	}

	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}

	public String[] getCheck2() {
		return check2;
	}

	public void setCheck2(String[] check2) {
		this.check2 = check2;
	}

	public String[] getCheck3() {
		return check3;
	}

	public void setCheck3(String[] check3) {
		this.check3 = check3;
	}

	public String getRadio1() {
		return radio1;
	}

	public void setRadio1(String radio1) {
		this.radio1 = radio1;
	}

	public String getRadio2() {
		return radio2;
	}

	public void setRadio2(String radio2) {
		this.radio2 = radio2;
	}

	public String getSelect1() {
		return select1;
	}

	public void setSelect1(String select1) {
		this.select1 = select1;
	}

	public String[] getSelect2() {
		return select2;
	}

	public void setSelect2(String[] select2) {
		this.select2 = select2;
	}

	public String getSelect3() {
		return select3;
	}

	public void setSelect3(String select3) {
		this.select3 = select3;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String[] getFavariteMovies() {
		return favariteMovies;
	}

	public void setFavariteMovies(String[] favariteMovies) {
		this.favariteMovies = favariteMovies;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String select3;

    /**
     * 日付1
    */
    private String date1;

    String[] favariteMovies;

	private String name2;
}
