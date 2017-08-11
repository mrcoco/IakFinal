package com.cempakaweb.iakfinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                new AlertDialog.Builder(this)
                        .setTitle("Tentang Aplikasi ini")
                        .setMessage("Aplikasi ini dibuat oleh Dwi Agus Purwanto sebagai final project dari Program Indonesia Android Kejar (IAK) batch 3 kelas beginer")
                        .show();
                return true;
            case R.id.exit:
                new AlertDialog.Builder(this)
                        .setTitle("Exit")
                        .setMessage("Apakah anda yakin ingin keluar ?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    finishAffinity();
                                }
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
