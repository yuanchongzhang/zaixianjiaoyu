package com.project.zaixianjiaoyu.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.db.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private final int BUFFER_SIZE = 400000;
//    /data/data/com.project.zaixianjiaoyu/databases/question.db
    public static final String DB_NAME = "question.db"; //数据库名字
    public static final String PACKAGE_NAME = "com.project.zaixianjiaoyu";//包名
    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() +
            "/" + PACKAGE_NAME;   //数据库的绝对路径( /data/data/com.*.*(package name))
    private SQLiteDatabase db;
    private Context context;

    public DbManager(Context context) {
        this.context = context;
    }

    //对外提供的打开数据库接口
    public void openDataBase() {
        this.db = this.openDataBase(DB_PATH + "/" + DB_NAME);
    }

    //获取打开后的数据库
    public SQLiteDatabase getDb() {
        return this.db;
    }

    // 本地打开数据方法
    private SQLiteDatabase openDataBase(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) { //判断文件是否存在
                //通过输入流和输出流，把数据库拷贝到"filePath"下
                InputStream is = context.getResources().openRawResource(R.raw.question);//获取输入流，使用R.raw.test资源
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[BUFFER_SIZE];
                int readCount;
                while((readCount = is.read(buffer))>0){
                    fos.write(buffer,0,readCount);
                }
                fos.close();
                is.close();
            }
//打开数据库
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(filePath,null);
            return db;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库
    public  void closeDataBase()
    {
        if(this.db!=null)db.close();
    }

    //获取数据库的数据
    public List<Question> getQuestion() {
        List<Question> list = new ArrayList<>();
        //执行sql语句
        Cursor cursor = db.rawQuery("select * from question", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            //遍历
            for (int i = 0; i < count; i++) {
                cursor.moveToPosition(i);
                Question question = new Question();
                //ID
                question.ID = cursor.getInt(cursor.getColumnIndex("Field1"));
                //问题
                question.question = cursor.getString(cursor.getColumnIndex("Field2"));
                //四个选择
                question.answerA = cursor.getString(cursor.getColumnIndex("Field3"));
                question.answerB = cursor.getString(cursor.getColumnIndex("Field4"));
                question.answerC = cursor.getString(cursor.getColumnIndex("Field5"));
                question.answerD = cursor.getString(cursor.getColumnIndex("Field6"));
                //答案
                question.answer = cursor.getInt(cursor.getColumnIndex("Field7"));
                //解析
                question.explaination = cursor.getString(cursor.getColumnIndex("Field8"));
                //设置为没有选择任何选项
                question.selectedAnswer = -1;
                list.add(question);
            }
        }
        return list;

    }
}
