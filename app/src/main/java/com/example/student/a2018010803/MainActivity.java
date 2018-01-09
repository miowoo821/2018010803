package com.example.student.a2018010803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lv;
ArrayList<Map<String,Object>> Mylist=new ArrayList<>();//第二個練習   //新增至Mylist.java     ,此頁依然要宣告Mylist
 boolean chks[]=new boolean[6];//新增至Mylist.java     ,此頁依然要宣告Mylist


    //String str[]={"AA","BB","CC","DD","EE"};第一個練習

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listview);

        HashMap<String,Object> m1=new HashMap<>();
        m1.put("CITY","台北");
        m1.put("code","02");
        m1.put("img",R.drawable.tp);
        Mylist.add(m1);

        HashMap<String,Object> m2=new HashMap<>();
        m2.put("CITY","台中");
        m2.put("code","04");
        m2.put("img",R.drawable.tc);
        Mylist.add(m2);

        HashMap<String,Object> m3=new HashMap<>();
        m3.put("CITY","台南");
        m3.put("code","06");
        m3.put("img",R.drawable.tn);
        Mylist.add(m3);

        HashMap<String,Object> m4=new HashMap<>();
        m4.put("CITY","台北");
        m4.put("code","02");
        m4.put("img",R.drawable.tp);
        Mylist.add(m4);

        HashMap<String,Object> m5=new HashMap<>();
        m5.put("CITY","台中");
        m5.put("code","04");
        m5.put("img",R.drawable.tc);
        Mylist.add(m5);

        HashMap<String,Object> m6=new HashMap<>();
        m6.put("CITY","台南");
        m6.put("code","06");
        m6.put("img",R.drawable.tn);
        Mylist.add(m6);
        Myadapter adapt=new Myadapter(MainActivity.this,Mylist,chks);

        lv.setAdapter(adapt);


    }
    //寫一個BaseAdapter的類別出來(BaseAdapter抽象類別，必須繼承必須實作

/*新增至Mylist.java
    class Myadapter extends BaseAdapter{


        @Override
        //設定要回傳資料的筆數(總共會有幾格)
        public int getCount() {            return Mylist.size();        }
        @Override
        public Object getItem(int i) {            return null;        }
        @Override
        public long getItemId(int i) {return 0; }
        @Override
        //設定每一筆(格)的內容 (第i筆資料(position), 呈現的頁面?, ??)
        public View getView(final int i, View view, ViewGroup viewGroup) {
//getView重要注意事項：當前畫面看到幾筆就會載入幾筆，其他的會砍掉，之後拉回來再重新載入，是為了節省資源
//所以絕對不可在getView裡面寫需要大量執行的東西，不然會一直重複執行，
// 比如說上網抓資料，每載入一次就抓一次一定會當機.
            LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
            View v1=inflater.inflate(R.layout.myitem,null);
            TextView tv1=v1.findViewById(R.id.textView);
            tv1.setText(Mylist.get(i).get("CITY").toString());
            TextView tv2=v1.findViewById(R.id.textView2);
            tv2.setText(Mylist.get(i).get("code").toString());
            ImageView img=v1.findViewById(R.id.imageView);
            img.setImageResource((Integer)Mylist.get(i).get("img"));

            CheckBox chk=(CheckBox)v1.findViewById(R.id.checkBox);//創造Check物件
            chk.setChecked(chks[i]);//使第[i]個物件利用01布林陣列(最上面定義的chks)來確認是否點選
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    chks[i]=b;//當第[i]個Checkbox被點選或取消時所得到的布林值填入chks
                }
            });


            Button btn=v1.findViewById(R.id.button);//自己練習按鈕
            btn.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, Mylist.get(i).get("CITY").toString()+Mylist.get(i).get("code").toString(), Toast.LENGTH_SHORT).show();
                }
            }));

            // TextView tv=new TextView(MainActivity.this);//在MainActivity.this弄一個TextView出來
            //tv.setText("HELLO"+"  "+i+"--"+str[i]);
            //return tv;
            return v1;
        }
    }
*/

    public void click1(View v){
        StringBuilder sb=new StringBuilder(); //StringBulider，把字串連在一起的方法，比直接+省資源
        for(int i=0;i<chks.length;i++){//依據chks布林陣列的長度決定迴圈的次數，不能用小於等於，因為i從0開始，布林陣列長度是個數
            if (chks[i]){//假設布林陣列裡面的第i個值為真，則取出Mylist裡面第i筆資料的KEY值為"CITY"的欄位，丟進去sb
                    sb.append(Mylist.get(i).get("CITY")+",");//一直丟進去就會變成XX,XX,XX,.....
            }
        }
        Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_SHORT).show();
    }







/*寫錯
    BaseAdapter Myadapt=new BaseAdapter() {
        @Override
        //回傳資料的筆數(總共會有幾格)
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        //設定每一筆(格)的內容
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
*/
}
