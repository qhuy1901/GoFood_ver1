package com.example.myapplication;

import static android.content.Context.MODE_PRIVATE;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.models.User;
import com.example.myapplication.models.UserSession;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginTabFragment extends Fragment {
    private UserSession userSession;
    private Button btnSwitchToRegisterActivity;
    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword;
    private TextView forgetPass, logIn;
    float v=0;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public static String UID = "66CwgtA9lrZAlkLuKiFzYR9GgHF3";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        userSession = new UserSession(getActivity());

        btnLogin = root.findViewById(R.id.btnLogin);
        edtEmail = root.findViewById(R.id.edtEmail);
        edtPassword = root.findViewById(R.id.edtPassword);
        forgetPass = root.findViewById(R.id.fg_pass);
        logIn = root.findViewById(R.id.login);
        logIn.setTranslationX(300);
        logIn.setAlpha(v);
        logIn. animate().translationX(0).alpha(1).setDuration(300).setStartDelay(300).start();

        edtEmail.setTranslationX(300);
        edtPassword.setTranslationX(300);
        forgetPass.setTranslationX(300);
        btnLogin.setTranslationX(300);
        edtEmail.setAlpha(v);
        edtPassword.setAlpha(v);
        forgetPass.setAlpha(v);
        btnLogin.setAlpha(v);
        edtEmail.animate().translationX(0).alpha(1).setDuration(300).setStartDelay(300).start();
        edtPassword.animate().translationX(0).alpha(1).setDuration(300).setStartDelay(300).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(300).setStartDelay(300).start();
        btnLogin. animate().translationX(0).alpha(1).setDuration(300).setStartDelay(300).start();

        ProgressDialog progressDialog = new ProgressDialog(getActivity());

        // Xử lý sự kiện click button Đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                SweetAlertDialog pDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Đang đăng nhập...");
                pDialog.setCancelable(false);
                pDialog.show();
//                progressDialog.setMessage("Đang đăng nhập...");
//                progressDialog.show();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    UID = mAuth.getCurrentUser().getUid();

                                    /* Lưu thông tin user đăng nhập vào Session */
                                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Users").child(UID);
                                    myRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            User userInfo = snapshot.getValue(User.class);
                                            SharedPreferences.Editor editor = getContext().getSharedPreferences("Session", MODE_PRIVATE).edit();
                                            editor.putString("userId", userInfo.getUserId());
                                            editor.apply();
                                            userSession.saveUser(userInfo);
                                        }
                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                    /*  */

                                    Intent switchActivityIntent = new Intent(getActivity(), WelcomeActivity.class);
                                    startActivity(switchActivityIntent);
                                } else {
                                    new SweetAlertDialog(getContext(), SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("Vui lòng thử lại")
                                            .setContentText("Tên đăng nhập hoặc mật khẩu không đúng.")
                                            .show();
                                    pDialog.dismiss();
                                }
                            }
                        });
            }
        });

        return root;
    }
}