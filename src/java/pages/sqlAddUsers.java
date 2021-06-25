package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sqlAddUsers extends HttpServlet {

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
            
            int i = 0;
            if (usr.equals("teacher")) {
                    response.sendRedirect("addTeachers");
            }
            if (usr.equals("student")) {
                String sid = null, sname = null, email = null, psw = null, sub = null;
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                while (itr.hasNext()) {
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (cell.getColumnIndex() == 0) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    sid = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    sid = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 1) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    sname = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    sname = Double.toString(cell.getNumericCellValue());
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
                    String sql = "INSERT INTO student "
                            + "(sid, sroll, sname, email, password, grp, sub, auser) "
                            + "VALUES (NULL , '" + sid + "' ,'" + sname + "', '" + email + "', '" + psw + "', '" + grp + "', '" + sub + "', '" + adm + "')";

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(sql);
                    
                    out.println("<br>");
                }
                    response.sendRedirect("deleteFile");
            }
        } catch (SQLException sqe) {
            System.out.println(sqe);
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
            Logger.getLogger(sqlAddUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sqlAddUsers.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sqlAddUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sqlAddUsers.class.getName()).log(Level.SEVERE, null, ex);
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
