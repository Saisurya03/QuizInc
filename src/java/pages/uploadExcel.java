package pages;

import com.oreilly.servlet.MultipartRequest;
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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class uploadExcel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String[] user1 = (String[]) session.getAttribute("user1");
            String user = user1[0];
            String sub = user1[1];
            String grp = user1[2];
            String tid = user1[3];

            String f = (String) session.getAttribute("Quizfilename");
            String tb = (String) session.getAttribute("tbname");
            
            File file = new File("E:\\upload\\" + f);
            FileInputStream fis = new FileInputStream(file);

            String question = null, a = null, b = null, c = null, d = null, corr = null;
            int marks = 0;
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
                        if (cell.getColumnIndex() == 1) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    
                                    question = cell.getStringCellValue().replace("'","\\'" );
                                    question = question.replace("\"", "\\\"");
                                    question = question.replace(",", "\\,");
                                    question = question.replace("+", "\\+");
                                    question = question.replace("(", "\\(");
                                    question = question.replace("}", "\\)");
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    question = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 2) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    a = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    a = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 3) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    b = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    b = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 4) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    c = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    c = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        } else if (cell.getColumnIndex() == 5) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    d = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    d = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        }else if (cell.getColumnIndex() == 6) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                    corr = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    corr = Double.toString(cell.getNumericCellValue());
                                    break;
                                default:
                            }
                        }else if (cell.getColumnIndex() == 7) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                                    marks = (int) cell.getNumericCellValue();
                                    break;
                                default:
                            }
                        }
                        
                    }
                    String sql = "INSERT INTO " + tb + " "
                            + "(qid, question, a, b, c, d, corr, mark) "
                            + "VALUES (NULL , '" + question + "' ,'" + a + "', '" + b + "', '" + c + "', '" + d + "', '" + corr + "', '" + marks + "')";

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
                    Statement stmt = connection.createStatement();
                    int r = stmt.executeUpdate(sql);
                    

            }
             response.sendRedirect("teachDelete");
        } catch (SQLException sqe) {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            System.out.println("printTrace /n");
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
