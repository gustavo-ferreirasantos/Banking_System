package br.com.hospital.model;

import br.com.hospital.interfaces.Autenticavel;
import br.com.hospital.repository.PacienteRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User implements Autenticavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;


    public abstract boolean autenticar(String email, String senha, PacienteRepository repository);

    public User(String name, String email, String password) {
        this.name = name;
        setEmail(email);
        setPassword(password);
    }


    /* Equivale a isso
    CREATE TABLE user (
            id INT PRIMARY KEY,
            email VARCHAR(255),
    password VARCHAR(255)
     */




    // Setter personalizado para o e-mail
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido!");
        }
        this.email = email.trim().toLowerCase();
    }

    // Setter personalizado para a senha
    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 8 caracteres!");
        }
        this.password = password;
    }



}







