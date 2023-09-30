package ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tp1_lab3.databinding.ActivityRegistroBinding;



import androidx.lifecycle.ViewModelProvider;



public class RegistroActivity extends AppCompatActivity {
    private ActivityRegistroBinding binding;
    private ViewModelRegistroActivity viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistroActivity.class);

        viewModel.getUser().observe(this, user -> {
            binding.etApllidoUsuario.setText(user.getApellido());
            binding.etEmail.setText(user.getEmail());
            binding.etDni.setText(user.getDni()+"");
            binding.etNombreUsuario.setText(user.getNombre());
            binding.etPassword.setText(user.getPassword());
        });

        Intent intent = getIntent();
        if(intent.getBooleanExtra("logueado",false)){
            viewModel.cargarUser();
        }

        binding.btnRegistro.setOnClickListener(view -> {
            viewModel.registrar(binding.etDni.getText().toString(), binding.etNombreUsuario.getText().toString(), binding.etApllidoUsuario.getText().toString(), binding.etEmail.getText().toString(), binding.etPassword.getText().toString());
        });
    }
}