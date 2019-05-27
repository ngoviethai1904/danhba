package com.example.danhba.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import  java.util.List;

import com.example.danhba.R;
import com.example.danhba.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {


    private Context content;
    private int resource;
    private List<Contact> arrayContact;
    public ContactAdapter(Context context, int resource, List<Contact> objects){
        super (context, resource ,objects);
        this.content = content;
        this.resource = resource;
        this.arrayContact = objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(content).inflate(R.layout.item_contact_listview,parent,false);
            viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrayContact.get(position);
        viewHolder.tvName.setText(contact.getmName());
        viewHolder.tvNumber.setText(contact.getmNumber());

        if(contact.isMale()){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.male);
        }
        else {
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.female);
        }

        return convertView;
    }
    public class ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvNumber;
    }
}
