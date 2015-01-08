/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.admin.Funcionario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import persistence.util.DAO;

/**
 *
 * @author ruioliveiras
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DAO.initConnection();
            AppState app = new AppState();

            app.startLogin();
        } catch (NamingException ex) {
            (new ui.util.ExceptionHandler("Erro nao tem a biblioteca do mysql instalada, instale por favor", ex)).fire();
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro a inicializar a aplicação, verifique o estado do servidor", ex)).fire();
        }
    
    }
 
        /**
     * Como ponho um botao com o texto em duas linhas?
     */
    
}
