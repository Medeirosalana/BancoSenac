package view;

import controller.ClienteController;

import java.util.Scanner;
import model.Cliente;


public class ClienteGUI {

    Scanner sc = new Scanner(System.in);
    
    public ClienteGUI(){}
    
    public void cadastrar(){
        System.out.println("Nome:  ");
        String nome = sc.next();
        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("Sexo: ");
        String sexo = sc.next();
        
        ClienteController cc = new ClienteController();
         if (cc.cadrastar(nome, cpf, sexo)){
             System.out.println("Sucesso");
         }else {
             System.out.println("Falha");
         }
        
        }
    public void buscarTudo(){
    
    ClienteController cc = new ClienteController();
    
        cc.listar();
     
     }
    
    
    
        public static void main(String[] args) {
         ClienteGUI gui = new ClienteGUI();
         gui.buscarTudo();
         
        
    }
    
    }

