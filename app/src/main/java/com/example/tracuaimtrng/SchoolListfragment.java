package com.example.tracuaimtrng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SchoolListfragment extends Fragment {

    private static final String KEY_MOT="mot";

    public static SchoolListfragment newInstance(int mot){
        SchoolListfragment fragment = new SchoolListfragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        
    }


    private SchoolAdater schoolAdater;
    private List<SchoolActivity> list= new ArrayList<>();

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.school_list_fragment, null);

        RecyclerView rvSchool = view.findViewById(R.id.rvSchool);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        schoolAdater = new SchoolAdater(getContext(), list);
        rvSchool.setLayoutManager(layoutManager);
        rvSchool.setAdapter(schoolAdater);

        loadData();

        return view;

    }

    private void loadData(){

        SchoolActivity s1 = new SchoolActivity(R.drawable.cntt, "Trường Đại học Công nghệ thông tin và truyền thông","Đường Z 115, Quyết Thắn g, Thành phố Thái Nguyên, Thái Nguyên 250000, Việt Nam", 21.585468, 105.806381);
        list.add(s1);
        SchoolActivity s2 = new SchoolActivity(R.drawable.supham,"Truong DH Sư phạm TN","20 Lương Ngọc Quyến, Quang Trung, Thành phố Thái Nguyên, Thái Nguyên, Việt Nam", 21.599004, 105.822919);
        list.add(s2);
        SchoolActivity s3 = new SchoolActivity(R.drawable.yduoc,"Truong DH Y Duoc TN","284 Lương Ngọc Quyến, Quang Trung, Thành phố Thái Nguyên, Thái Nguyên, Việt Nam", 21.588628, 105.827603);
        list.add(s3);
        SchoolActivity s4 = new SchoolActivity(R.drawable.nonglam,"Truong DH Nong Lam TN","Tân Thịnh, Thành phố Thái Nguyên, Thái Nguyên, Việt Nam", 21.594755, 105.811434);
        list.add(s4);
        SchoolActivity s5 = new SchoolActivity(1,"Truong Khoa Ngoai Ngu TN","Quyết Thắng, Thành phố Thái Nguyên, Thái Nguyên, Việt Nam", 21.584551, 105.807475);
        list.add(s5);
        SchoolActivity s6 = new SchoolActivity(1," Bách Khoa, Hai Bà Trưng, Hà Nội, Việt Nam","Thu Do Ha Noi", 21.005224, 105.843130);
        list.add(s6);
        SchoolActivity s7 = new SchoolActivity(1,"Truong DH Kinh Te Quoc Dan"," Phố Vọng, Đồng Tâm, Hai Bà Trưng, Hà Nội, Việt Nam", 20.999955, 105.842132);
        list.add(s7);
        schoolAdater.notifyDataSetChanged();


    }



}
