package ui.login;



import android.app.Application;
import android.content.Context;
import android.content.Intent;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import Request.ApiClient;
import ui.register.RegistroActivity;

public class ViewModelMainActivity extends AndroidViewModel {
    private Context context;
    public ViewModelMainActivity(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login(String correo, String contra) {
        ApiClient.login(context, correo, contra);

        Intent intent = new Intent(context, RegistroActivity.class);
        intent.putExtra("logueado",true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void registrar(){
        Intent intent = new Intent(context, RegistroActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}