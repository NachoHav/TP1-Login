package ui.login;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.tp1_lab3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ViewModelMainActivity viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMainActivity.class);

        binding.btnLogin.setOnClickListener(view -> {
            viewModel.login(binding.etEmail.getText().toString(), binding.etPassword.getText().toString());
        });

        binding.btnRegistro.setOnClickListener(view -> {
            viewModel.registrar();
        });
    }


}