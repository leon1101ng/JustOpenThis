package net.leon.myfypproject2.UserInterface;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import net.leon.myfypproject2.Function.VIewVideo;
import net.leon.myfypproject2.Function.ViewImage;
import net.leon.myfypproject2.Function.ViewProduct;
import net.leon.myfypproject2.Function.ViewStream;
import net.leon.myfypproject2.Function.homefragment;
import net.leon.myfypproject2.MainActivity;
import net.leon.myfypproject2.ProfileFragment.BioFragment;
import net.leon.myfypproject2.ProfileFragment.ImagePostFragment;
import net.leon.myfypproject2.ProfileFragment.PostFragment;
import net.leon.myfypproject2.ProfileFragment.VideoFragment;
import net.leon.myfypproject2.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInterface extends AppCompatActivity {
    private CircleImageView userprofile;
    private ImageView profilebgi;
    private TextView no_follower,no_following,no_posts,follow_btn;
    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef;
    String currentUser_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        mAuth = FirebaseAuth.getInstance();
        currentUser_ID = mAuth.getCurrentUser().getUid();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");

        userprofile = (CircleImageView)findViewById(R.id.User_profile);

        no_follower = (TextView)findViewById(R.id.No_Followers);
        no_following = (TextView)findViewById(R.id.No_Following);


        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.userprofile_nav);
        bnv.setOnNavigationItemSelectedListener(navlistener);

        UsersRef.child(currentUser_ID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    if(dataSnapshot.hasChild("ProfilePicture")){
                        String profileimg = dataSnapshot.child("ProfilePicture").getValue().toString();
                        Picasso.get().load(profileimg).placeholder(R.drawable.userprofile).into(userprofile);
                    }else {
                        Toast.makeText(UserInterface.this, "Profile name do not exists", Toast.LENGTH_SHORT).show();
                    }if(dataSnapshot.hasChild("username")){
                        String username = dataSnapshot.child("username").getValue().toString();
                        mTitle.setText(username);
                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment = null;

            switch (item.getItemId()) {
                case R.id.ProfileBio:
                    selectedfragment = new BioFragment();
                    break;
                case R.id.Profileimage:
                    selectedfragment = new ImagePostFragment();
                    break;
                case R.id.ProfilePost:
                    selectedfragment = new PostFragment();
                    break;
                case R.id.Profilevideo:
                    selectedfragment = new VideoFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout_profile, selectedfragment).commit();
            return true;
        }

    };


}
