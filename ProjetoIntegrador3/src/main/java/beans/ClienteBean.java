package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mapeamento.Cliente;
import menu.bean.ClienteService;

/**
 *
 * @author Gabriel
 */
@Named
@ViewScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteService clienteService;

    private String nome;
    private String email;
    private String cpf;
    private long telefone;

    @PostConstruct
    public void init() {
        Cliente cliente = new Cliente();
    }

    public void salvar() {
        Cliente cliente = new Cliente();

        if (email != null && !email.isEmpty()) {
            cliente.setCliEmail(this.email);
        }
        cliente.setCliCpf(this.cpf);
        cliente.setCliNome(this.nome);
        cliente.setCliTelefone(this.telefone);

        clienteService.salvar(cliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

}
