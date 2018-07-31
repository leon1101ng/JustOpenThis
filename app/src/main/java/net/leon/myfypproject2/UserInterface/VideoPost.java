package net.leon.myfypproject2.UserInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import net.leon.myfypproject2.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoPost extends AppCompatActivity {
    private CircleImageView HomeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Add Video");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        HomeBtn = (CircleImageView)findViewById(R.id.ImagePOSTHome);
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
