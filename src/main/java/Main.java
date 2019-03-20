
import com.abs.controller.DataCollector;
import com.abs.model.ProductVisit;
import com.abs.util.DBHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ghani
 */
public class Main {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection()) {
            DataCollector dc = new DataCollector();
            List<List<ProductVisit>> productVisitsList = dc.getProductVisits("cacvjefds2hf76bg1f1sgku8c7");
            for (List<ProductVisit> pV : productVisitsList) {
                for (ProductVisit pv : pV) {
                    System.out.println("LIST: " + pv.getUser().getSessionId());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
