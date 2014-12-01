  package com.example.shine.testdata;


  import android.content.Context;
  import android.database.Cursor;
  import android.database.SQLException;
  import android.database.sqlite.SQLiteDatabase;
  /**
   * Created by SHINE on 11/29/2014.
   */
  public class LoginActivity
  {
      static final String DATABASE_NAME = "login.db";
      static final int DATABASE_VERSION = 1;
      public static final int NAME_COLUMN = 1;
      // TODO: Create public field for each column in your table.
      // SQL Statement to create a new database.

      static final String query = "CREATE TABLE LOGIN ( USERNAME TEXT, PASSWORD TEXT)";
      static final String insert_query = "INSERT INTO LOGIN (USERNAME,PASSWORD) VALUES ('admin','admin');";

      // Variable to hold the database instance
      public  SQLiteDatabase db;
      // Context of the application using the database.
      private final Context context;
      // Database open/upgrade helper
      private DataBaseHelper dbHelper;
      public LoginActivity(Context _context)
      {
          context = _context;
          dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
      }
      public  LoginActivity open() throws SQLException
      {
          db = dbHelper.getWritableDatabase();
          return this;
      }
      public void close()
      {
          db.close();
      }

      public  SQLiteDatabase getDatabaseInstance()
      {
          return db;
      }


      public String getSinlgeEntry(String userName)
      {
          Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
          if(cursor.getCount()<1) // UserName Not Exist
          {
              cursor.close();
              return "NOT EXIST";
          }
          cursor.moveToFirst();
          String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
          cursor.close();
          return password;
      }

  }