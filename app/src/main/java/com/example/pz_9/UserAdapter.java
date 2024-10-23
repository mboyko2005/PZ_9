package com.example.pz_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    public UserAdapter(@NonNull Context context, @NonNull List<User> users) {
        super(context, R.layout.list_item, users);
        this.context = context;
        this.users = users;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView nameView;
        TextView descriptionView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            // Инфлейтим layout для элемента списка
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            // Создаем ViewHolder и находим view-элементы
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.user_image);
            holder.nameView = convertView.findViewById(R.id.user_name);
            holder.descriptionView = convertView.findViewById(R.id.user_description);

            // Устанавливаем тег
            convertView.setTag(holder);
        } else {
            // Получаем ViewHolder из тега
            holder = (ViewHolder) convertView.getTag();
        }

        // Получаем текущего пользователя
        User currentUser = users.get(position);

        // Устанавливаем данные в view-элементы
        holder.imageView.setImageResource(currentUser.getImageResId());
        holder.nameView.setText(currentUser.getName());
        holder.descriptionView.setText(currentUser.getDescription());

        return convertView;
    }
}
