package controller;

import dao.ClienteDAO;
import dao.SexoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Sexo;

public class ClienteController {

    public boolean cadrastar(String nome, String cpf, String sexo){        
        SexoDAO sdao = new SexoDAO();
        Sexo s = new Sexo(); 
        if (sdao.buscarPorSexo(sexo)!= null){
            s = sdao.buscarPorSexo(sexo);
            Cliente cliente = new Cliente(nome, s, cpf);
            ClienteDAO cdao = new ClienteDAO();
            if (cdao.inserir(cliente)){
            return true;
            }
        }
        
    return false;
    }
    public void listar(){
       ClienteDAO cdao = new ClienteDAO();
       for (Cliente c : cdao.listarTudo()){
           System.out.println("Id: " + c.getId() + "\nCPF: "+ c.getCpf() +"\nnome: " + c.getNome() + "\n Sexo: " + c.getSexo().getSigla());
       }
    }
}
