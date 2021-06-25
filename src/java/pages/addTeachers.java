/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 123
 */
public class addTeachers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

            String[] grpInfo = (String[]) session.getAttribute("grpInfo");
            String grp = grpInfo[0];
            String usr = grpInfo[1];
            String adm = grpInfo[2];

            String f = (String) session.getAttribute("userfilename");
            File file = new File("E:\\upload\\" + f);
            FileInputStream fis = new FileInputStream(file);
            String tid = null, tname = null, email = null, psw = null, sub = null;
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
            
                while (itr.hasNext()) {
                    Row row = itr.next();
                    out.print(row.getRowNum());
                    Iterator<Cell> cellIterator = row.cellIterator();
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (cell.getColumnIndex() == 0) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    tid = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    tid = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 1) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    tname = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    tname = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 2) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    email = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    email = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 3) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    psw = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    psw = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 4) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    sub = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    sub = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        }
                        
                    }
                    String sql = "INSERT INTO teacher "
                            + "(tid, troll, tname, email, password, grp, sub, auser) "
                            + "VALUES (NULL , '" + tid + "' ,'" + tname + "', '" + email + "', '" + psw + "', '" + grp + "', '" + sub + "', '" + adm + "')";

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
                    Statement stmt = connection.createStatement();
                    out.println(tname + "<br>");
                    stmt.executeUpdate(sql);
         
                }
                    response.sendRedirect("deleteFile");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addTeachers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addTeachers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addTeachers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addTeachers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
