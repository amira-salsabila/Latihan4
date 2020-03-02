package com.example.fragmentpahlawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailListFragment extends AppCompatActivity {

    ImageView ivDetail;
    TextView tvDetailTitle, tvDetailDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_fragment);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.activitydetail_iv);
        tvDetailTitle = findViewById(R.id.activitydetail_tv_title);
        tvDetailDesc = findViewById(R.id.activitydetail_tv_desc);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getImg = bundle.getInt("img_url");
            String getTitle = bundle.getString("title");
            String getDetail = bundle.getString("detail");

            tvDetailTitle.setText(getTitle);
            tvDetailDesc.setText(getDetail);
            ivDetail.setImageResource(getImg);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
