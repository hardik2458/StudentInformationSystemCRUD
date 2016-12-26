package com.example.dadabhagwan.studentinformationsystemcrud.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dadabhagwan on 10/26/2016.
 */

public class StudentModel implements Parcelable {
    private int Id;
    private String firstName;
    private String LasttName;
    private String div;
    private String std;
    private String result;
    private String percentage;

//
//    public StudentModel(int id, String firstName, String lasttName, String div, String std, String result, String percentage) {
//        Id = id;
//        this.firstName = firstName;
//        LasttName = lasttName;
//        this.div = div;
//        this.std = std;
//        this.result = result;
//        this.percentage = percentage;
//    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return LasttName;
    }

    public void setLasttName(String lasttName) {
        LasttName = lasttName;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.Id);
        dest.writeString(this.firstName);
        dest.writeString(this.LasttName);
        dest.writeString(this.div);
        dest.writeString(this.std);
        dest.writeString(this.result);
        dest.writeString(this.percentage);
    }

    public StudentModel() {
    }

    protected StudentModel(Parcel in) {
        this.Id = in.readInt();
        this.firstName = in.readString();
        this.LasttName = in.readString();
        this.div = in.readString();
        this.std = in.readString();
        this.result = in.readString();
        this.percentage = in.readString();
    }

    public static final Parcelable.Creator<StudentModel> CREATOR = new Parcelable.Creator<StudentModel>() {
        @Override
        public StudentModel createFromParcel(Parcel source) {
            return new StudentModel(source);
        }

        @Override
        public StudentModel[] newArray(int size) {
            return new StudentModel[size];
        }
    };
}
