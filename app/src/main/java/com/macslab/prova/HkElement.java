package com.macslab.prova;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by massi on 22/04/2015.
 */
public class HkElement implements Parcelable {
    private int    mHkElemId;
    private String mHkElemName;
    private String mDescr;

    public HkElement() {}

    public HkElement (int id, String name) {
        this.setHkElemId(id);
        this.setHkElemName(name);
    }

    /* Parcelable */
    public HkElement(Parcel in) {
        setHkElemId(in.readInt());
        setHkElemName(in.readString());
        setHkDescr(in.readString());
    }
    public int describeContents() { return 0; }
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(getHkElemId());
        out.writeString(getHkElemName());
        out.writeString(getHkDescr());
    }
    public static final Parcelable.Creator<HkElement> CREATOR
            = new Parcelable.Creator<HkElement>() {
        public HkElement createFromParcel(Parcel in) {
            return new HkElement(in);
        }
        public HkElement[] newArray(int size) {
            return new HkElement[size];
        }
    };
    /* End Parcelable */

    public void setHkElemId(int id)        { this.mHkElemId   = id;   }
    public void setHkElemName(String name) { this.mHkElemName = name; }
    public void setHkDescr(String descr)   { this.mDescr      = descr;}

    public int    getHkElemId()   { return mHkElemId;   }
    public String getHkElemName() { return mHkElemName; }
    public String getHkDescr()    { return mDescr;      }
}