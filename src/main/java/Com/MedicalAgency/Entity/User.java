package Com.MedicalAgency.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String userGender;

    // Novo atributo para armazenar o código aleatório
    @Transient  // Não será persistido no banco de dados
    private int randomcode;

    // Construtor que gera o código aleatório
    public User() {
        this.randomcode = newRandomCode();
    }

    private int newRandomCode() {
        return (int) (Math.random() * 10000);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getters e Setters

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o código aleatório
    public int getRandomcode() {
        return randomcode;
    }

    // Setter opcional caso precise modificar o código aleatório
    public void setRandomcode(int randomcode) {
        this.randomcode = randomcode;
    }
}

