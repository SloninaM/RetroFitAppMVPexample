package robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP.retofitReqresIn.SiteOperationFabric;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    private TextView responseText;
    private Button btnListResources;
    private Button btnCreateUser;
    private Button btnUserList;
    private Button btnClearScreen;
    private ProgressBar progressRetrofitBar;
    private MainContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        if(savedInstanceState != null)
        {
            responseText.setText(savedInstanceState.getString("responseData"));
        }

    }

    private void initialize() {
        responseText = findViewById(R.id.responseText);
        btnCreateUser = findViewById(R.id.btnCreateUser);
        btnListResources = findViewById(R.id.btnListResources);
        btnClearScreen = findViewById(R.id.btnClearScreen);
        btnUserList = findViewById(R.id.btnUserList);
        progressRetrofitBar = findViewById(R.id.progress_retrofitBar);
        mPresenter = new MainPresenter(
                this,
                new SiteOperationFabric()
        );
        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.createUser();
            }
        });
        btnListResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.createListResources();
            }
        });
        btnUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.createUserList();
            }
        });
        btnClearScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.clearScreen();
            }
        });

    }


    @Override
    public void clearText() {
        responseText.setText("");
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showText(String message) {
        responseText.setText(message);
    }

    @Override
    public void showProgress() {
        progressRetrofitBar.setVisibility(View.VISIBLE);
        responseText.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressRetrofitBar.setVisibility(View.GONE);
        responseText.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("responseData",responseText.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
