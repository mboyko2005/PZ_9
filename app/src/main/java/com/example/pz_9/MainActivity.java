package com.example.pz_9;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private UserAdapter adapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        userList = new ArrayList<>();

        // Получаем массивы из ресурсов
        String[] names = getResources().getStringArray(R.array.user_names);
        String[] descriptions = getResources().getStringArray(R.array.user_descriptions);
        TypedArray images = getResources().obtainTypedArray(R.array.user_images);

        // Определяем минимальную длину массивов для предотвращения IndexOutOfBoundsException
        int length = Math.min(names.length, Math.min(descriptions.length, images.length()));

        // Заполняем список пользователей
        for (int i = 0; i < length; i++) {
            // Используем системный placeholder
            int imageResId = images.getResourceId(i, android.R.drawable.ic_menu_gallery);
            userList.add(new User(names[i], descriptions[i], imageResId));
        }

        images.recycle(); // Освобождаем TypedArray

        // Инициализируем адаптер и устанавливаем его в ListView
        adapter = new UserAdapter(this, userList);
        listView.setAdapter(adapter);
    }
}
