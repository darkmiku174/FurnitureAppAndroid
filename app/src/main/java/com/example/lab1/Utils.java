package com.example.lab1;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utils {
    Context context;

    public Utils(Context context) {
        this.context = context;
    }

    static String filename = "database";
    static ArrayList<Furniture> furnitureHistory = new ArrayList<>();

    public void addFurintureHistorry(Furniture furniture) {
        if (furnitureHistory.indexOf(furniture) > 0) {
            this.furnitureHistory.add(0, furniture);
        }
    }

    public ArrayList<Furniture> getFurnitureHistory() {
        return
                this.furnitureHistory;
    }

    public void WriteToFileInternal(ArrayList<Furniture> arrayList) {
        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Furniture> LoadFileInternal() {
        ArrayList<Furniture> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new
                    ObjectInputStream(fileInputStream);
            arrayList = (ArrayList<Furniture>) objectInputStream.readObject();
            Log.d("FurnitureApp", arrayList.size() + "");
            return arrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Furniture> getMockDataFurniture() {
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture(context.getString(R.string.name_product_one),
                context.getString(R.string.product_one), "hinh_1.png",1));
        tmp.add(new Furniture(context.getString(R.string.name_product_two),
                context.getString(R.string.product_two), "hinh_2.png",2));
        tmp.add(new Furniture(context.getString(R.string.name_product_three),
                context.getString(R.string.product_three), "hinh_3.png",3));
        tmp.add(new Furniture(context.getString(R.string.name_product_four),
                context.getString(R.string.product_four), "hinh_4.png",4));
        tmp.add(new Furniture(context.getString(R.string.name_product_five),
                context.getString(R.string.product_five), "hinh_5.png",5));
        return tmp;
    }

    public Bitmap convertStringToBitmapFromAccess(String filename) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Categories> getMockDataCategories() {
        ArrayList<Furniture> arrayListBed = new ArrayList<>();
        ArrayList<Furniture> arrayListLiving = new ArrayList<>();
        ArrayList<Furniture> arrayListMeeting = new ArrayList<>();
        ArrayList<Furniture> arrayListAccessories = new ArrayList<>();
        ArrayList<Categories> tmp = new ArrayList<>();
        tmp.add(new Categories("BedRoom", arrayListBed, "bed_room.png", 1));
        tmp.add(new Categories("LivingRoom", arrayListLiving, "living_room.png", 2));
        tmp.add(new Categories("MeetingRoom", arrayListMeeting, "meeting_room.png", 3));
        tmp.add(new Categories("Accessories", arrayListAccessories, "accessories.png", 4));
        return tmp;
    }

    public ArrayList<Furniture> getFurnitureFromCategories(int pos) {
        ArrayList<Furniture> tmp = new ArrayList<Furniture>();
        switch (pos) {
            case 0:
                tmp.add(new Furniture(context.getString(R.string.name_product_one),
                        context.getString(R.string.product_one), "hinh_1.png", 1));
                tmp.add(new Furniture(context.getString(R.string.name_product_two),
                        context.getString(R.string.product_two), "hinh_2.png", 1));
                tmp.add(new Furniture(context.getString(R.string.name_product_three),
                        context.getString(R.string.product_three), "hinh_3.png", 1));
                tmp.add(new Furniture(context.getString(R.string.name_product_four),
                        context.getString(R.string.product_four), "hinh_4.png", 1));
                break;
            case 1:
                tmp.add(new Furniture(context.getString(R.string.name_product_three),
                        context.getString(R.string.product_three), "hinh_3.png", 2));
                tmp.add(new Furniture(context.getString(R.string.name_product_four),
                        context.getString(R.string.product_four), "hinh_4.png" , 2));
                tmp.add(new Furniture(context.getString(R.string.name_product_two),
                        context.getString(R.string.product_two), "hinh_2.png", 2));
                break;
            case 2:
                tmp.add(new Furniture(context.getString(R.string.name_product_two),
                        context.getString(R.string.product_two), "hinh_2.png", 3));
                tmp.add(new Furniture(context.getString(R.string.name_product_three),
                        context.getString(R.string.product_three), "hinh_3.png", 3));
                tmp.add(new Furniture(context.getString(R.string.name_product_four),
                        context.getString(R.string.product_four), "hinh_4.png", 3));
                tmp.add(new Furniture(context.getString(R.string.name_product_five),
                        context.getString(R.string.product_five), "hinh_5.png", 3));
                break;
            case 3:
                tmp.add(new Furniture(context.getString(R.string.name_product_three),
                        context.getString(R.string.product_three), "hinh_3.png", 4));
                tmp.add(new Furniture(context.getString(R.string.name_product_four),
                        context.getString(R.string.product_four), "hinh_4.png", 4));
                tmp.add(new Furniture(context.getString(R.string.name_product_five),
                        context.getString(R.string.product_five), "hinh_5.png", 4));
                tmp.add(new Furniture(context.getString(R.string.name_product_one),
                        context.getString(R.string.product_one), "hinh_1.png", 4));
                break;
        }
        return tmp;
    }
}

