package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import android.os.Parcel;
import android.os.Parcelable;

public class SubscriptionParcel implements Parcelable {
    public String[] subscription_name;
    public String[] subscription_name_lowercase;
    public String[] frequency;
    public String[] subscription_type;
    public String[] cost;
    public String[] renewal_date;
    public int[]paid_status;
    public int[]imgid;
    public SubscriptionParcel(String[] subscription_name, String[] subscription_name_lowercase, String[] frequency,String[] subscription_type,String[] cost,String[] renewal_date,int[] paid_status,int[] imgid){
        this.subscription_name = subscription_name;
        this.subscription_name_lowercase = subscription_name_lowercase;
        this.frequency = frequency;
        this.subscription_type = subscription_type;
        this.cost = cost;
        this.renewal_date = renewal_date;
        this.paid_status = paid_status;
        this.imgid = imgid;
    }

    public String[] getsubscription_name(){return subscription_name;};
    public String[] getsubscription_name_lowercase(){return subscription_name_lowercase;};
    public String[] getfrequency(){return frequency;};
    public String[] getsubscription_type(){return subscription_type;};
    public String[] getcost(){return cost;};
    public String[] getrenewal_date(){return renewal_date;};
    public int[] getpaid_status(){return paid_status;};
    public int[] getimgid(){return imgid;};

    //write object values to parcel for storage
    public void writeToParcel(Parcel dest, int flags){
        //write all properties to the parcle
        dest.writeStringArray(subscription_name);
        dest.writeStringArray(subscription_name_lowercase);
        dest.writeStringArray(frequency);
        dest.writeStringArray(subscription_type);
        dest.writeStringArray(cost);
        dest.writeStringArray(renewal_date);
        dest.writeIntArray(paid_status);
        dest.writeIntArray(imgid);
    }

    //constructor used for parcel
    public SubscriptionParcel(Parcel parcel){
        //read and set saved values from parcel
        subscription_name = parcel.createStringArray();
        subscription_name_lowercase = parcel.createStringArray();
        frequency = parcel.createStringArray();
        subscription_type = parcel.createStringArray();
        cost = parcel.createStringArray();
        renewal_date = parcel.createStringArray();
        paid_status = parcel.createIntArray();
        imgid = parcel.createIntArray();
    }

    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<SubscriptionParcel> CREATOR = new Parcelable.Creator<SubscriptionParcel>(){

        @Override
        public SubscriptionParcel createFromParcel(Parcel parcel) {
            return new SubscriptionParcel(parcel);
        }

        @Override
        public SubscriptionParcel[] newArray(int size) {
            return new SubscriptionParcel[0];
        }
    };

    //return hashcode of object
    public int describeContents() {
        return hashCode();
    }
}