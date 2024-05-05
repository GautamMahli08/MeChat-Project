package com.example.mechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mechat.model.UserModel;
import com.example.mechat.utils.AndroidUtil;
import com.example.mechat.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.auth.User;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        if(FirebaseUtil.isLoggedIn() && getIntent().getExtras()!=null) {
            String userId = getIntent().getExtras().getString("userId");
            FirebaseUtil.allUserCollectionReference().document(userId).get()
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            UserModel model = task.getResult().toObject(UserModel.class);

                            Intent mainIntent = new Intent(this,MainActivity.class);
                            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(mainIntent);

                            Intent intent = new Intent(this, ChatActivity.class);
                            AndroidUtil.passUserModelAsIntent(intent,model);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                             startActivity(intent);
                             finish();
                        }
                    });

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(FirebaseUtil.isLoggedIn()) {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this,LoginPhoneNumberActivity.class));
                    }
                    finish();
                }
            }, 1000);
        }
    }
}