package com.example.proje;

public class ThirdActivityDesign
{
    private String mImageUrl;
    private String mGiftname;

    public  ThirdActivityDesign(String ImageUrl ,String Giftname){

        mImageUrl=ImageUrl;
        mGiftname = Giftname;
    }
    public String getImageUrl(){
        return mImageUrl;
    }

    public String getGiftname(){
        return mGiftname;
    }

}
