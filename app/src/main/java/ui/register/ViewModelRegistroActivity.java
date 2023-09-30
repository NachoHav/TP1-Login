package ui.register;

import static Request.ApiClient.guardar;
import static Request.ApiClient.leer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Models.Usuario;
import Request.ApiClient;
import ui.login.MainActivity;

public class ViewModelRegistroActivity extends AndroidViewModel {
    private Context context;

    private MutableLiveData<Usuario> user;

    public ViewModelRegistroActivity(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public void registrar(String dni, String nombre, String apellido, String correo, String contra) {
        long dn = Long.parseLong(dni);
        Usuario u = new Usuario(dn, nombre, apellido, correo, contra);
        ApiClient.guardar(context,u);

        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void cargarUser(){
        user.setValue(ApiClient.leer(context));
    }
}
