package com.example.student.a2018010803;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class Myadapter extends BaseAdapter {
    ArrayList<Map<String, Object>> Mylist = new ArrayList();
    boolean chks[] = new boolean[6];
    Context context;//把MainActivity裝到這裡面然後

    public Myadapter(Context context, ArrayList<Map<String, Object>> Mylist,boolean chks[]) {
        this.context=context;
        this.Mylist = Mylist;
        this.chks=chks;//資料記得丟過去
    }

    @Override
    //設定要回傳資料的筆數(總共會有幾格)
    public int getCount() {
        return Mylist.size();
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
    //設定每一筆(格)的內容 (第i筆資料(position), 呈現的頁面?, ??)
    public View getView(final int i, View v1, ViewGroup viewGroup) {
   ViewHolder viewHolder;
        if (v1 == null) {//解決回收資源(v1)會有舊資料的問題，假若v1是新資源，則照常生成，如果是舊資源，跳過生成v1的過程，可避免回收的v1帶有舊資料
            //利用v1==null來區分出資源是新生的還是回收的
            // (新生的是null，回收的v1會有之前值，比如說v1=1的欄位消失後下個出來的欄位之v1值就會等於1
            //假設是新生的，就照常執行LayoutInflater inflater = LayoutInflater.from(context);與 v1 = inflater.inflate(R.layout.myitem, null);
            //
//getView重要注意事項：當前畫面看到幾筆就會載入幾筆，其他的會砍掉，之後拉回來再重新載入，是為了節省資源
//所以絕對不可在getView裡面寫需要大量執行的東西，不然會一直重複執行，
// 比如說上網抓資料，每載入一次就抓一次一定會當機.
            LayoutInflater inflater = LayoutInflater.from(context);

            v1 = inflater.inflate(R.layout.myitem, null);
            //全部改用自訂class(ViewHolder)裡面的物件，可以讓findViewById不用一直執行，只有在v1是新生的時候執行
            viewHolder = new ViewHolder();
            viewHolder.tv = v1.findViewById(R.id.textView);
            viewHolder.tv2 = v1.findViewById(R.id.textView2);
            viewHolder.img = v1.findViewById(R.id.imageView);
            viewHolder.chk = (CheckBox) v1.findViewById(R.id.checkBox);
            CheckBox chk = (CheckBox) v1.findViewById(R.id.checkBox);//創造Check物件
        }
        else
            {
                viewHolder = (ViewHolder) v1.getTag();//回收的資源，v1就不是null就直接去找viewholder的標籤
            }


        viewHolder.tv.setText(Mylist.get(i).get("CITY").toString());
        viewHolder.tv2.setText(Mylist.get(i).get("code").toString());
        viewHolder.img.setImageResource((Integer) Mylist.get(i).get("img"));

        viewHolder.chk.setOnCheckedChangeListener(null);
        viewHolder.chk.setChecked(chks[i]);//使第[i]個物件利用01布林陣列(最上面定義的chks)來確認是否點選
        viewHolder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[i] = b;//當第[i]個Checkbox被點選或取消時所得到的布林值填入chks
            }
        });
        v1.setTag(viewHolder);
        return v1;
    }
    static class ViewHolder//弄一個這個class，把回收的資源紀錄?
    {
        TextView tv;
        TextView tv2;
        ImageView img;
        CheckBox chk;
    }
}