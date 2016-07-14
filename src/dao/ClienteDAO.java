package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Sexo;

public class ClienteDAO {

    private final DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public ClienteDAO(){
        db = new DataBase();
    
    }
    public boolean inserir(Cliente cliente){
        if(db.Connect()){
         sql = "INSERT INTO tb_clientes (cli_nome, cli_cpf,cli_sex_id) VALUES(?,?,?)";
        try{
        ps = db.connection.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2,cliente.getCpf());
        ps.setInt(3, cliente.getSexo().getId());
        if(ps.executeUpdate() == 1){
            ps.close();
            db.discconect();
        return true;
        } 
        ps.close();
        db.discconect();         
        }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
        return false;
        }
        
        }
        
        return false;
    
    
    }
    public boolean excluir(Cliente cliente){
    if(db.Connect()){
         sql = "DELETE FROM tb_clientes WHERE cli_id = ? ";
        try{
        ps = db.connection.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        if(ps.executeUpdate() == 1){
            ps.close();
            db.discconect();
        return true;
        }
         ps.close();
         db.discconect();
        }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
        return false;
        }
        
        }return false;
    
    
    }
    
    public boolean editar(Cliente cliente){
    if(db.Connect()){
         sql = "UPDATE tb_clientes SET cli_nome = ?, cli_cpf = ?, cli_sex_id = ? WHERE cli_id = ?";
        try{
        ps = db.connection.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2,cliente.getCpf());
        ps.setInt(3, cliente.getSexo().getId());
        ps.setInt(4, cliente.getId());
        if(ps.executeUpdate() == 1){
            ps.close();
            db.discconect();
        return true;
        }
         ps.close();
         db.discconect();
        }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
        return false;
        }
        
        }return false;
    
    }
    
    public List<Cliente> listarTUdo(){
    if(db.Connect()){
        List<Cliente> clientes = new ArrayList();
         sql = "SELECT * FROM tb_clientes";
        try{
        ps = db.connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Cliente cliente = new Cliente();
           SexoDAO dao = new SexoDAO();
            cliente.setId(rs.getInt("cli_id"));
            cliente.setNome(rs.getString("cli_nome"));
            cliente.setCpf(rs.getString("cli_cpf"));
          
            cliente.setSexo(dao.buscarPorId(rs.getInt("cli_sex_id")));
            clientes.add(cliente);
       
        }
        rs.close();
         ps.close();
         db.discconect();
        
        return clientes;
        
        }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
        return null;
        }
    } return null;
    
    }
    public Cliente buscarPorCpf(String cpf){
    if(db.Connect()){
        
         sql = "SELECT * FROM tb_clientes WHERE cli_cfp = ?";
        try{
        ps = db.connection.prepareStatement(sql);
        ps.setString(1, cpf);
        rs = ps.executeQuery();
        if(rs.next()){
            Cliente cliente = new Cliente();          
            SexoDAO dao = new SexoDAO();
            cliente.setId(rs.getInt("cli_id"));
            cliente.setNome(rs.getString("cli_nome"));
            cliente.setCpf(rs.getString("cli_cpf"));            
            cliente.setSexo(dao.buscarPorId(rs.getInt("cli_sex_id")));
            rs.close();
         ps.close();
         db.discconect();
            return cliente;
         }
        rs.close();
         ps.close();
         db.discconect();
        
        }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
        return null;
        }
    } return null;
    
    }
}
