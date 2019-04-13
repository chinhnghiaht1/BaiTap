package com.example.tracuaimtrng;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class SchoolAdater extends RecyclerView.Adapter<SchoolAdater.ViewHolder> {

    private Context context;
    private List<SchoolActivity> schoolList;

    public SchoolAdater(Context context, List<SchoolActivity> list){

        this.context = context;
        this.schoolList = list ;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeView) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_school_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final SchoolActivity school = schoolList.get(position);
        viewHolder.iv.setImageResource(school.getAvatar());
        viewHolder.nameSchool.setText(school.getName());
        viewHolder.diaChi.setText(school.getDiachi());
        viewHolder.geod.setText(school.getLatitude()+","+school.getLongitude()+"");
        viewHolder.img=school.getAvatar();




        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int prosition, boolean isLongClick) {


                if(isLongClick){
                    Toast.makeText(context, "Long Click: "+schoolList.get(position), Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(context, " "+schoolList.get(position), Toast.LENGTH_SHORT).show();



            }
        });

    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nameSchool;
        TextView diaChi;
        TextView geod;
        ImageView iv;
        private int img;
        private ItemClickListener itemClickListener; // Khai báo interface


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameSchool = itemView.findViewById(R.id.tvNameSchool);
            diaChi = itemView.findViewById(R.id.tvDiaChi);
            geod = itemView.findViewById(R.id.geod);
            iv = itemView.findViewById(R.id.iv);


            final Intent intent = new Intent(context, ChiTietSchool.class);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle data = new Bundle();
                    TextView name = (TextView)v.findViewById(R.id.tvNameSchool);
                    TextView address = (TextView)v.findViewById(R.id.tvDiaChi);
                    TextView geod = (TextView)v.findViewById(R.id.geod);
                    data.putString("name",name.getText().toString() );
                    data.putString("address",address.getText().toString() );
                    data.putString("geod", geod.getText().toString());
                    data.putInt("img", img);
                    intent.putExtras(data);

                    context.startActivity(intent);

                }
            }); // Mấu chốt ở đây , set sự kiên onClick cho View


        }
            //Tạo setter cho biến itemClickListenenr
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {

            itemClickListener.onClick(v,getAdapterPosition(),false); // Gọi interface , false là vì đây là onClick

        }


    }
    @Override
    public int getItemCount() {
        return schoolList.size();
    }

}
