package jdbc;

import java.util.ArrayList;
import admin.Admin;
import registrationForm.Form;

public class App {
  ArrayList<Student> students;
    public static void main(String[] args) throws Exception {
      CRUD admin = new App().new CRUD();
      admin.RegApp();
    }

    private class CRUD{
      Admin admin = null;
        
      public void RegApp() throws Exception{
      admin = new Admin();

     /*DataBase created  */
       // DB.createDataBase();

    /*Create Table  */
     //  DAO.createTable();

    /*Insert into student table */   
      //  DAO.insertData(new Student());
     // Form RegForm = new Form();

    /*Read all data */
      students = DAO.readData();
      admin.new Display(students);

    /*Update data in table */
    //   admin.new Update();

    /*Data Deleted */
    // admin.new Delete();
  }
}
}
