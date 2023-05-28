package com.example.feadmissionapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOpenDialog = findViewById(R.id.button_open_dialog);
        textViewResult = findViewById(R.id.text_view_result);

        registerForContextMenu(buttonOpenDialog);

        buttonOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        buttonOpenDialog.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopupMenu(v);
                return true;
            }
        });
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Admission Category")
                .setItems(R.array.admission_categories, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] categories = getResources().getStringArray(R.array.admission_categories);
                        String selectedCategory = categories[which];
                        textViewResult.setText("Selected Category: " + selectedCategory);
                        showToast("Selected Category: " + selectedCategory);
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                handlePopupMenuClick(item);
                return true;
            }
        });
        popupMenu.show();
    }

    private void handlePopupMenuClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_popup1:
                showToast("Popup 1 selected");
                break;
            case R.id.menu_popup2:
                showToast("Popup 2 selected");
                break;
            case R.id.menu_popup3:
                showToast("Popup 3 selected");
                break;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_option1:
                showToast("Option 1 selected");
                return true;
            case R.id.menu_option2:
                showToast("Option 2 selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_context1:
                showToast("Context 1 selected");
                return true;
            case R.id.menu_context2:
                showToast("Context 2 selected");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
