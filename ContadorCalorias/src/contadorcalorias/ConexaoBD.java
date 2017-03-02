/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contadorcalorias;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 *
 * @author Marcos
 */
public class ConexaoBD {
    
    // função checa a conecção com o banco de dados
    public void Check() throws SQLException{
        try {
            
            // abre mensagem de conectando ao banco
            JFrame frame = new JFrame("Aguarde Conexão");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel textLabel = new JLabel("Conectando ao Bando de Dados...",SwingConstants.CENTER);
            textLabel.setPreferredSize(new Dimension(300, 100));
            frame.getContentPane().add(textLabel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setSize(250, 150);
            frame.setVisible(true);
            
            
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection( 
                                    "jdbc:postgresql://127.0.0.1:5432/Contador_Caloria", "postgres",
                                    "212889"); 
            System.out.println("Logado com sucesso no banco de dados do sistema.");
            frame.dispose();
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                                    + "Include in your library path!");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");            
    }
    
    
    
    // função que insere no banco de dados
    // uma string S é passada por parametros pelas interfaces de adição
    public static void insert(String S) throws SQLException { 
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            Connection conn = DriverManager.getConnection( 
                                    "jdbc:postgresql://127.0.0.1:5432/Contador_Caloria", "postgres",
                                    "212889"); 
            conn.setAutoCommit(false); 
            Statement st = conn.createStatement(); 
            
            st.executeUpdate(S); 
            st.close(); 
            conn.commit(); 
            conn.close(); 
            System.out.println("Inserido com Sucesso!!!!");
    }
    
}    
