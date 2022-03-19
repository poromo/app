package vn.com.fpt.edu.poromo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.com.fpt.edu.poromo.R;
import vn.com.fpt.edu.poromo.login.model.User;
import vn.com.fpt.edu.poromo.productlist.ProductListController;

public class LoginController extends AppCompatActivity {
    private TextView tvRegister;
    private Button btnSignIn;
    private EditText etUsername;
    private EditText etPassword;
    private List<User> listUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.listUsers.add(new User("tieuhoa", "tieuhoa"));
        this.listUsers.add(new User("tieuhoa2", "tieuhoa"));
        this.listUsers.add(new User("tieuhoa3", "tieuhoa"));
        this.listUsers.add(new User("tieuhoa4", "tieuhoa"));

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_controller);

        this.btnSignIn = findViewById(R.id.btnSignIn);
        this.tvRegister = findViewById(R.id.tvRegister);
        this.etUsername = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);
        this.etUsername = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);

        this.btnLoginHandler(btnSignIn, etUsername, etPassword);
        this.tvRegisterHandler();
    }

    private void btnLoginHandler(Button btn, EditText etUsername, EditText etPassword){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                boolean isUsernameEmpty = etUsername.getText().toString().isEmpty();
                boolean isPassEmpty = etPassword.getText().toString().isEmpty();
                if (isUsernameEmpty && isPassEmpty) {
                    System.out.println("empty");
                    Toast.makeText(getApplicationContext(), "Please enter username and password, then try again!", Toast.LENGTH_LONG).show();
                    return;
                }
                login(username, password, listUsers);
                if (login(username, password, listUsers)) {
                    Intent intent = new Intent(LoginController.this, ProductListController.class);
                    startActivity(intent);
                    System.out.println("vao day nhe");
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email & password. Please try till you die!", Toast.LENGTH_LONG).show();
                    System.out.println("wrong pass");
                }
            }
        });
    }


    private void tvRegisterHandler() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "textt view component has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginController.this, RegisterController.class);
                startActivity(intent);
            }
        });
    }

    /*
     * =============== START OF LOGIC FUNCTIONS ===============
     * */
    private boolean login(String username, String password, List<User> listData) {
        if (listData.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Empty", Toast.LENGTH_LONG).show();
        }
        for(User u : listData) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
}