package com.example.gatheringevent;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogButton = findViewById(R.id.showDialogButton);
        registerForContextMenu(showDialogButton);

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Event Information");
        builder.setMessage("Please enter event details");

        // Add input fields or other custom views if needed

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle OK button click event
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle Cancel button click event
            }
        });

        builder.show();
    }

    // Option Menu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle option menu item clicks
        switch (item.getItemId()) {
            case R.id.menu_item1:
                // Handle menu item 1 click
                return true;
            case R.id.menu_item2:
                // Handle menu item 2 click
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle context menu item clicks
        switch (item.getItemId()) {
            case R.id.context_menu_item1:
                // Handle context menu item 1 click
                return true;
            case R.id.context_menu_item2:
                // Handle context menu item 2 click
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // Popup Menu
    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle popup menu item clicks
                switch (item.getItemId()) {
                    case R.id.popup_menu_item1:
                        // Handle popup menu item 1 click
                        return true;
                    case R.id.popup_menu_item2:
                        // Handle popup menu item 2 click
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
}
