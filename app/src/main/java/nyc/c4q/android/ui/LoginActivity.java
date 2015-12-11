package nyc.c4q.android.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import nyc.c4q.android.R;


public class LoginActivity extends Activity {

  private EditText emailField;
  private EditText passwordField;
  private Button loginButton;
  private final AuthenticationManager manager;

  public LoginActivity() {
    // TODO - fix this
    manager = new RealAuthenticationManager();
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // TODO - load view hierarchy in R.layout.activity_login
    // TODO - get references to views, and other setup
    // TODO - call checkCredentials via OnClickListener

    setContentView(R.layout.activity_login);

    loginButton = (Button) findViewById(R.id.login);
    emailField = (EditText) findViewById(R.id.email);
    passwordField = (EditText) findViewById(R.id.password);

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        checkCredentials(emailField.getText().toString(), passwordField.getText().toString());
      }
    });


  }

  private void checkCredentials(String email, String password) {
    if(manager.validateLogin(email, password)) {
      // TODO - go to EmailListActivity
      Intent emailListIntent = new Intent(this, EmailListActivity.class);
      startActivity(emailListIntent);
    }
    else {

      // TODO launch alert dialog on failed login
      // check strings.xml for dialog
      AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplicationContext());
      builder1.setMessage(getResources().getString(R.string.alert_dialog_title));
      builder1.setCancelable(true);
      builder1.setNegativeButton(getResources().getString(R.string.alert_dialog_dismiss),
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  dialog.cancel();
                }
              });

      AlertDialog alert = builder1.create();
      alert.show();


    }
  }
}
