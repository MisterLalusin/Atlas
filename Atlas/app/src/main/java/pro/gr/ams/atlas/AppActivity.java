package pro.gr.ams.atlas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AppActivity extends AppCompatActivity {

    String activeAct = "";

    //Database
    String adminUname = "admin@admin", adminPassword = "12345678";

    int userCount = 2;
    int actUser = -1;
    String u1ID = "1", u1Uname = "lalusin@atlas.edu", u1FName = "John Rovic", u1LastName = "Lalusin", u1Password = "12345678", u1School = "STI Lipa", u1Section = "BSCpE 1.2A";
    String u2ID = "2", u2Uname = "ilagan@atlas.edu", u2FName = "Mae Paulene", u2LastName = "Ilagan", u2Password = "12345678", u2School = "STI Lipa", u2Section = "BSCpE 1.2A";
    String u3ID = "3", u3Uname = "", u3FName = "", u3LastName = "", u3Password = "", u3School = "", u3Section = "";
    String u4ID = "4", u4Uname = "", u4FName = "", u4LastName = "", u4Password = "", u4School = "", u4Section = "";
    String u5ID = "5", u5Uname = "", u5FName = "", u5LastName = "", u5Password = "", u5School = "", u5Section = "";

    String u1Book1 = "JAVA", u1Book2 = "C#", u1Book3 = "", u1Book4 = "", u1Book5 = "";
    String u2Book1 = "SQL", u2Book2 = "ASP.NET", u2Book3 = "", u2Book4 = "", u2Book5 = "";
    String u3Book1 = "", u3Book2 = "", u3Book3 = "", u3Book4 = "", u3Book5 = "";
    String u4Book1 = "", u4Book2 = "", u4Book3 = "", u4Book4 = "", u4Book5 = "";
    String u5Book1 = "", u5Book2 = "", u5Book3 = "", u5Book4 = "", u5Book5 = "";

    String u1BookStatus1 = "Returned", u1BookStatus2 = "Borrowed", u1BookStatus3 = "", u1BookStatus4 = "", u1BookStatus5 = "";
    String u2BookStatus1 = "Borrowed", u2BookStatus2 = "Returned", u2BookStatus3 = "", u2BookStatus4 = "", u2BookStatus5 = "";
    String u3BookStatus1 = "", u3BookStatus2 = "", u3BookStatus3 = "", u3BookStatus4 = "", u3BookStatus5 = "";
    String u4BookStatus1 = "", u4BookStatus2 = "", u4BookStatus3 = "", u4BookStatus4 = "", u4BookStatus5 = "";
    String u5BookStatus1 = "", u5BookStatus2 = "", u5BookStatus3 = "", u5BookStatus4 = "", u5BookStatus5 = "";

    String separator = "------------------";
    String booksLogs = "";
    //Database

    private EditText login_userNameDTTXT;
    private EditText login_passwordDTTXT;
    private Button login_loginBTTN;
    private Button login_registerBTTN;
    private EditText register_fNameDTTXT;
    private EditText register_lNameDTTXT;
    private EditText register_UNameDTTXT;
    private EditText register_PasswordDTTXT;
    private EditText register_ConfirmPasswordDTTXT;
    private Button register_RegisterBTTN;
    private Button register_LogInBTTN;
    private EditText register_SchoolDTTXT;
    private EditText register_SectionDTTXT;
    private TextView mainUser_LastNameTXTVW;
    private TextView mainUser_FNameTXTVW;
    private Button mainUser_LogOutBTTN;
    private LinearLayout mainUser_Data1LNRLYT;
    private LinearLayout mainUser_Data2LNRLYT;
    private LinearLayout mainUser_Data3LNRLYT;
    private LinearLayout mainUser_Data4LNRLYT;
    private LinearLayout mainUser_Data5LNRLYT;
    private TextView mainUser_Data1TXTVW;
    private TextView mainUser_Data2TXTVW;
    private TextView mainUser_Data3TXTVW;
    private TextView mainUser_Data4TXTVW;
    private TextView mainUser_Data5TXTVW;
    private LinearLayout mainAdmin_Data1LNRLYT;
    private LinearLayout mainAdmin_Data2LNRLYT;
    private LinearLayout mainAdmin_Data3LNRLYT;
    private LinearLayout mainAdmin_Data4LNRLYT;
    private LinearLayout mainAdmin_Data5LNRLYT;
    private TextView mainAdmin_Data1TXTVW;
    private TextView mainAdmin_Data2TXTVW;
    private TextView mainAdmin_Data3TXTVW;
    private TextView mainAdmin_Data4TXTVW;
    private TextView mainAdmin_Data5TXTVW;
    private TextView mainAdmin_LastNameTXTVW;
    private TextView mainAdmin_FNameTXTVW;
    private Button mainAdmin_LogOutBTTN;
    private TextView mainAdmin_SearchDTTXT;
    private Button mainAdmin_SearchBTTN;
    private Button mainAdmin_addBTTN;
    private EditText dialogAdd_UNameDTTXT;
    private EditText dialogAdd_BookDTTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        try {
            booksLogsDefult();
            logInActivity();
        }
        catch (Exception ex) {
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
    }

    private void booksLogsDefult() {
        booksLogs = booksLogs + "Book: "+u1Book1+"\nBorrowed By: "+u1FName+" "+u1LastName+"\n"+separator+"\n";
        booksLogs = booksLogs + "Book: "+u1Book2+"\nBorrowed By: "+u1FName+" "+u1LastName+"\n"+separator+"\n";
        booksLogs = booksLogs + "Book: "+u2Book1+"\nBorrowed By: "+u2FName+" "+u2LastName+"\n"+separator+"\n";
        booksLogs = booksLogs + "Book: "+u2Book2+"\nBorrowed By: "+u2FName+" "+u2LastName+"\n"+separator+"\n";
    }

    private void logInActivity() {
        backCount = 0;
        setContentView(R.layout.layout_login);
        activeAct = "login";
        login_userNameDTTXT = (EditText)findViewById(R.id.login_userNameDTTXT);
        login_passwordDTTXT = (EditText)findViewById(R.id.login_passwordDTTXT);
        login_loginBTTN = (Button)findViewById(R.id.login_loginBTTN);
        login_registerBTTN = (Button)findViewById(R.id.login_registerBTTN);
        login_registerBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerActivity();
            }
        });
        login_loginBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = login_userNameDTTXT.getText().toString();
                String pass = login_passwordDTTXT.getText().toString();
                if (user.length() != 0 && pass.length() != 0) {
                    if (user.equals(adminUname) == true && pass.equals(adminPassword) == true) {
                        actUser = 0;
                        mainAdminActivity();
                    }
                    else if (user.equals(u1Uname) == true && pass.equals(u1Password) == true) {
                        actUser = 1;
                        mainUserActivity();
                    }
                    else if (user.equals(u2Uname) == true && pass.equals(u2Password) == true) {
                        actUser = 2;
                        mainUserActivity();
                    }
                    else if (user.equals(u3Uname) == true && pass.equals(u3Password) == true) {
                        actUser = 3;
                        mainUserActivity();
                    }
                    else if (user.equals(u4Uname) == true && pass.equals(u4Password) == true) {
                        actUser = 4;
                        mainUserActivity();
                    }
                    else if (user.equals(u5Uname) == true && pass.equals(u5Password) == true) {
                        actUser = 5;
                        mainUserActivity();
                    }
                    else {
                        Toast.makeText(AppActivity.this, "Log in failed!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(AppActivity.this, "Complete your details!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void mainAdminActivity() {
        backCount = 0;
        setContentView(R.layout.layout_main_admin);
        activeAct = "main_admin";

        mainAdmin_LastNameTXTVW = (TextView)findViewById(R.id.mainAdmin_LastNameTXTVW);
        mainAdmin_FNameTXTVW = (TextView)findViewById(R.id.mainAdmin_FNameTXTVW);
        mainAdmin_LogOutBTTN = (Button)findViewById(R.id.mainAdmin_LogOutBTTN);
        mainAdmin_Data1LNRLYT = (LinearLayout)findViewById(R.id.mainAdmin_Data1LNRLYT);
        mainAdmin_Data2LNRLYT = (LinearLayout)findViewById(R.id.mainAdmin_Data2LNRLYT);
        mainAdmin_Data3LNRLYT = (LinearLayout)findViewById(R.id.mainAdmin_Data3LNRLYT);
        mainAdmin_Data4LNRLYT = (LinearLayout)findViewById(R.id.mainAdmin_Data4LNRLYT);
        mainAdmin_Data5LNRLYT = (LinearLayout)findViewById(R.id.mainAdmin_Data5LNRLYT);
        mainAdmin_Data1TXTVW = (TextView)findViewById(R.id.mainAdmin_Data1TXTVW);
        mainAdmin_Data2TXTVW = (TextView)findViewById(R.id.mainAdmin_Data2TXTVW);
        mainAdmin_Data3TXTVW = (TextView)findViewById(R.id.mainAdmin_Data3TXTVW);
        mainAdmin_Data4TXTVW = (TextView)findViewById(R.id.mainAdmin_Data4TXTVW);
        mainAdmin_Data5TXTVW = (TextView)findViewById(R.id.mainAdmin_Data5TXTVW);
        mainAdmin_SearchDTTXT = (TextView)findViewById(R.id.mainAdmin_SearchDTTXT);
        mainAdmin_SearchBTTN = (Button)findViewById(R.id.mainAdmin_SearchBTTN);
        mainAdmin_addBTTN = (Button)findViewById(R.id.mainAdmin_addBTTN);

        mainAdmin_Data1LNRLYT.setVisibility(View.GONE);
        mainAdmin_Data2LNRLYT.setVisibility(View.GONE);
        mainAdmin_Data3LNRLYT.setVisibility(View.GONE);
        mainAdmin_Data4LNRLYT.setVisibility(View.GONE);
        mainAdmin_Data5LNRLYT.setVisibility(View.GONE);

        mainAdmin_addBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLogs(mainAdmin_SearchBTTN, mainAdmin_SearchDTTXT);
            }
        });

        mainAdmin_SearchBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = mainAdmin_SearchDTTXT.getText().toString().toLowerCase();
                if (search.length() != 0) {
                    int searchedUser = -1;
                    if (u1Uname.equals(search)) {
                        searchedUser = 1;
                    }
                    else if (u2Uname.equals(search)) {
                        searchedUser = 2;
                    }
                    else if (u3Uname.equals(search)) {
                        searchedUser = 3;
                    }
                    else if (u4Uname.equals(search)) {
                        searchedUser = 4;
                    }
                    else if (u5Uname.equals(search)) {
                        searchedUser = 5;
                    }
                    else {
                        Toast.makeText(AppActivity.this, "No user found!", Toast.LENGTH_SHORT).show();
                    }

                    final int finalSearchedUser = searchedUser;
                    mainAdmin_Data1LNRLYT.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updateBookStatus(1 ,finalSearchedUser, mainAdmin_SearchBTTN);
                        }
                    });
                    mainAdmin_Data2LNRLYT.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updateBookStatus(2 ,finalSearchedUser, mainAdmin_SearchBTTN);
                        }
                    });
                    mainAdmin_Data3LNRLYT.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updateBookStatus(3 ,finalSearchedUser, mainAdmin_SearchBTTN);
                        }
                    });
                    mainAdmin_Data4LNRLYT.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updateBookStatus(4 ,finalSearchedUser, mainAdmin_SearchBTTN);
                        }
                    });
                    mainAdmin_Data5LNRLYT.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updateBookStatus(5 ,finalSearchedUser, mainAdmin_SearchBTTN);
                        }
                    });

                    if (searchedUser == 1) {
                        if (u1Book1.length() != 0) {
                            mainAdmin_Data1LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data1TXTVW.setText(u1Book1 + "\n Status: " + u1BookStatus1);
                        }
                        if (u1Book2.length() != 0) {
                            mainAdmin_Data2LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data2TXTVW.setText(u1Book2 + "\n Status: " + u1BookStatus2);
                        }
                        if (u1Book3.length() != 0) {
                            mainAdmin_Data3LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data3TXTVW.setText(u1Book3 + "\n Status: " + u1BookStatus3);
                        }
                        if (u1Book4.length() != 0) {
                            mainAdmin_Data4LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data4TXTVW.setText(u1Book4 + "\n Status: " + u1BookStatus4);
                        }
                        if (u1Book5.length() != 0) {
                            mainAdmin_Data5LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data5TXTVW.setText(u1Book5 + "\n Status: " + u1BookStatus5);
                        }
                    }
                    else if (searchedUser == 2) {
                        if (u2Book1.length() != 0) {
                            mainAdmin_Data1LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data1TXTVW.setText(u2Book1 + "\n Status: " + u2BookStatus1);
                        }
                        if (u2Book2.length() != 0) {
                            mainAdmin_Data2LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data2TXTVW.setText(u2Book2 + "\n Status: " + u2BookStatus2);
                        }
                        if (u2Book3.length() != 0) {
                            mainAdmin_Data3LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data3TXTVW.setText(u2Book3 + "\n Status: " + u2BookStatus3);
                        }
                        if (u2Book4.length() != 0) {
                            mainAdmin_Data4LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data4TXTVW.setText(u2Book4 + "\n Status: " + u2BookStatus4);
                        }
                        if (u2Book5.length() != 0) {
                            mainAdmin_Data5LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data5TXTVW.setText(u2Book5 + "\n Status: " + u2BookStatus5);
                        }
                    }
                    else if (searchedUser == 3) {
                        if (u3Book1.length() != 0) {
                            mainAdmin_Data1LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data1TXTVW.setText(u3Book1 + "\n Status: " + u3BookStatus1);
                        }
                        if (u3Book2.length() != 0) {
                            mainAdmin_Data2LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data2TXTVW.setText(u3Book2 + "\n Status: " + u3BookStatus2);
                        }
                        if (u3Book3.length() != 0) {
                            mainAdmin_Data3LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data3TXTVW.setText(u3Book3 + "\n Status: " + u3BookStatus3);
                        }
                        if (u3Book4.length() != 0) {
                            mainAdmin_Data4LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data4TXTVW.setText(u3Book4 + "\n Status: " + u3BookStatus4);
                        }
                        if (u3Book5.length() != 0) {
                            mainAdmin_Data5LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data5TXTVW.setText(u3Book5 + "\n Status: " + u3BookStatus5);
                        }
                    }
                    else if (searchedUser == 4) {
                        if (u4Book1.length() != 0) {
                            mainAdmin_Data1LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data1TXTVW.setText(u4Book1 + "\n Status: " + u4BookStatus1);
                        }
                        if (u4Book2.length() != 0) {
                            mainAdmin_Data2LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data2TXTVW.setText(u4Book2 + "\n Status: " + u4BookStatus2);
                        }
                        if (u4Book3.length() != 0) {
                            mainAdmin_Data3LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data3TXTVW.setText(u4Book3 + "\n Status: " + u4BookStatus3);
                        }
                        if (u4Book4.length() != 0) {
                            mainAdmin_Data4LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data4TXTVW.setText(u4Book4 + "\n Status: " + u4BookStatus4);
                        }
                        if (u4Book5.length() != 0) {
                            mainAdmin_Data5LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data5TXTVW.setText(u4Book5 + "\n Status: " + u4BookStatus5);
                        }
                    }
                    else if (searchedUser == 5) {
                        if (u5Book1.length() != 0) {
                            mainAdmin_Data1LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data1TXTVW.setText(u5Book1 + "\n Status: " + u5BookStatus1);
                        }
                        if (u5Book2.length() != 0) {
                            mainAdmin_Data2LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data2TXTVW.setText(u5Book2 + "\n Status: " + u5BookStatus2);
                        }
                        if (u5Book3.length() != 0) {
                            mainAdmin_Data3LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data3TXTVW.setText(u5Book3 + "\n Status: " + u5BookStatus3);
                        }
                        if (u5Book4.length() != 0) {
                            mainAdmin_Data4LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data4TXTVW.setText(u5Book4 + "\n Status: " + u5BookStatus4);
                        }
                        if (u5Book5.length() != 0) {
                            mainAdmin_Data5LNRLYT.setVisibility(View.VISIBLE);
                            mainAdmin_Data5TXTVW.setText(u5Book5 + "\n Status: " + u5BookStatus5);
                        }
                    }

                }
                else {
                    Toast.makeText(AppActivity.this, "Type something!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainAdmin_LogOutBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInActivity();
            }
        });

        mainAdmin_LastNameTXTVW.setText("Admin");
        mainAdmin_FNameTXTVW.setText("Atlas");
    }

    private void addLogs(final Button mainAdmin_SearchBTTN, final TextView mainAdmin_SearchDTTXT) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View addDialogView = inflater.inflate(R.layout.dialog_add, null);
        builder.setView(addDialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialogAdd_UNameDTTXT = (EditText) addDialogView.findViewById(R.id.dialogAdd_UNameDTTXT);
                        dialogAdd_BookDTTXT = (EditText) addDialogView.findViewById(R.id.dialogAdd_BookDTTXT);
                        String uname = dialogAdd_UNameDTTXT.getText().toString();
                        String book = dialogAdd_BookDTTXT.getText().toString();
                        if (uname.length() != 0 && book.length() != 0) {
                            if (uname.equals(u1Uname)) {
                                if (u1Book1.length() == 0) {
                                    u1Book1 = book;
                                    u1BookStatus1 = "Borrowed";
                                }
                                else if (u1Book2.length() == 0) {
                                    u1Book2 = book;
                                    u1BookStatus2 = "Borrowed";
                                }
                                else if (u1Book3.length() == 0) {
                                    u1Book3 = book;
                                    u1BookStatus3 = "Borrowed";
                                }
                                else if (u1Book4.length() == 0) {
                                    u1Book4 = book;
                                    u1BookStatus4 = "Borrowed";
                                }
                                else if (u1Book5.length() == 0) {
                                    u1Book5 = book;
                                    u1BookStatus5 = "Borrowed";
                                }
                                else {
                                    Toast.makeText(AppActivity.this, "The number of books available to be borrowed are limited!", Toast.LENGTH_SHORT).show();
                                }
                                if (mainAdmin_SearchDTTXT.getText().toString().equals(uname) == true) {
                                    mainAdmin_SearchBTTN.performClick();
                                }
                            }
                            else if (uname.equals(u2Uname)) {
                                if (u2Book1.length() == 0) {
                                    u2Book1 = book;
                                    u2BookStatus1 = "Borrowed";
                                }
                                else if (u2Book2.length() == 0) {
                                    u2Book2 = book;
                                    u2BookStatus2 = "Borrowed";
                                }
                                else if (u2Book3.length() == 0) {
                                    u2Book3 = book;
                                    u2BookStatus3 = "Borrowed";
                                }
                                else if (u2Book4.length() == 0) {
                                    u2Book4 = book;
                                    u2BookStatus4 = "Borrowed";
                                }
                                else if (u2Book5.length() == 0) {
                                    u2Book5 = book;
                                    u2BookStatus5 = "Borrowed";
                                }
                                else {
                                    Toast.makeText(AppActivity.this, "The number of books available to be borrowed are limited!", Toast.LENGTH_SHORT).show();
                                }
                                if (mainAdmin_SearchDTTXT.getText().toString().equals(uname) == true) {
                                    mainAdmin_SearchBTTN.performClick();
                                }
                            }							else if (uname.equals(u3Uname)) {
                                if (u3Book1.length() == 0) {
                                    u3Book1 = book;
                                    u3BookStatus1 = "Borrowed";
                                }
                                else if (u3Book2.length() == 0) {
                                    u3Book2 = book;
                                    u3BookStatus2 = "Borrowed";
                                }
                                else if (u3Book3.length() == 0) {
                                    u3Book3 = book;
                                    u3BookStatus3 = "Borrowed";
                                }
                                else if (u3Book4.length() == 0) {
                                    u3Book4 = book;
                                    u3BookStatus4 = "Borrowed";
                                }
                                else if (u3Book5.length() == 0) {
                                    u3Book5 = book;
                                    u3BookStatus5 = "Borrowed";
                                }
                                else {
                                    Toast.makeText(AppActivity.this, "The number of books available to be borrowed are limited!", Toast.LENGTH_SHORT).show();
                                }
                                if (mainAdmin_SearchDTTXT.getText().toString().equals(uname) == true) {
                                    mainAdmin_SearchBTTN.performClick();
                                }
                            }
                            else if (uname.equals(u4Uname)) {
                                if (u4Book1.length() == 0) {
                                    u4Book1 = book;
                                    u4BookStatus1 = "Borrowed";
                                }
                                else if (u4Book2.length() == 0) {
                                    u4Book2 = book;
                                    u4BookStatus2 = "Borrowed";
                                }
                                else if (u4Book3.length() == 0) {
                                    u4Book3 = book;
                                    u4BookStatus3 = "Borrowed";
                                }
                                else if (u4Book4.length() == 0) {
                                    u4Book4 = book;
                                    u4BookStatus4 = "Borrowed";
                                }
                                else if (u4Book5.length() == 0) {
                                    u4Book5 = book;
                                    u4BookStatus5 = "Borrowed";
                                }
                                else {
                                    Toast.makeText(AppActivity.this, "The number of books available to be borrowed are limited!", Toast.LENGTH_SHORT).show();
                                }
                                if (mainAdmin_SearchDTTXT.getText().toString().equals(uname) == true) {
                                    mainAdmin_SearchBTTN.performClick();
                                }
                            }
                            else if (uname.equals(u5Uname)) {
                                if (u5Book1.length() == 0) {
                                    u5Book1 = book;
                                    u5BookStatus1 = "Borrowed";
                                }
                                else if (u5Book2.length() == 0) {
                                    u5Book2 = book;
                                    u5BookStatus2 = "Borrowed";
                                }
                                else if (u5Book3.length() == 0) {
                                    u5Book3 = book;
                                    u5BookStatus3 = "Borrowed";
                                }
                                else if (u5Book4.length() == 0) {
                                    u5Book4 = book;
                                    u5BookStatus4 = "Borrowed";
                                }
                                else if (u5Book5.length() == 0) {
                                    u5Book5 = book;
                                    u5BookStatus5 = "Borrowed";
                                }
                                else {
                                    Toast.makeText(AppActivity.this, "The number of books available to be borrowed are limited!", Toast.LENGTH_SHORT).show();
                                }
                                if (mainAdmin_SearchDTTXT.getText().toString().equals(uname) == true) {
                                    mainAdmin_SearchBTTN.performClick();
                                }
                            }
                            else {
                                Toast.makeText(AppActivity.this, "User name don't match!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(AppActivity.this, "No data added!", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                    }
                });
        builder.create();
        builder.show();
    }

    private void updateBookStatus(final int bookNumber, final int user, final Button mainAdmin_SearchBTTN) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update Status")
                .setItems(R.array.options_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String status = "";
                        if (which == 0) {
                            status = "Borrowed";
                        }
                        else if (which == 1) {
                            status = "Returned";
                        }
                        else if (which == 2) {
                            status = "Lost";
                        }

                        if (user == 1) {
                            if (bookNumber == 1) {
                                u1BookStatus1 = status;
                            }
                            if (bookNumber == 2) {
                                u1BookStatus2 = status;
                            }
                            if (bookNumber == 3) {
                                u1BookStatus3 = status;
                            }
                            if (bookNumber == 4) {
                                u1BookStatus4 = status;
                            }
                            if (bookNumber == 5) {
                                u1BookStatus5 = status;
                            }
                        }
                        else if (user == 2) {
                            if (bookNumber == 1) {
                                u2BookStatus1 = status;
                            }
                            if (bookNumber == 2) {
                                u2BookStatus2 = status;
                            }
                            if (bookNumber == 3) {
                                u2BookStatus3 = status;
                            }
                            if (bookNumber == 4) {
                                u2BookStatus4 = status;
                            }
                            if (bookNumber == 5) {
                                u2BookStatus5 = status;
                            }
                        }
                        else if (user == 3) {
                            if (bookNumber == 1) {
                                u3BookStatus1 = status;
                            }
                            if (bookNumber == 2) {
                                u3BookStatus2 = status;
                            }
                            if (bookNumber == 3) {
                                u3BookStatus3 = status;
                            }
                            if (bookNumber == 4) {
                                u3BookStatus4 = status;
                            }
                            if (bookNumber == 5) {
                                u3BookStatus5 = status;
                            }
                        }
                        else if (user == 4) {
                            if (bookNumber == 1) {
                                u4BookStatus1 = status;
                            }
                            if (bookNumber == 2) {
                                u4BookStatus2 = status;
                            }
                            if (bookNumber == 3) {
                                u4BookStatus3 = status;
                            }
                            if (bookNumber == 4) {
                                u4BookStatus4 = status;
                            }
                            if (bookNumber == 5) {
                                u4BookStatus5 = status;
                            }
                        }
                        else if (user == 5) {
                            if (bookNumber == 1) {
                                u5BookStatus1 = status;
                            }
                            if (bookNumber == 2) {
                                u5BookStatus2 = status;
                            }
                            if (bookNumber == 3) {
                                u5BookStatus3 = status;
                            }
                            if (bookNumber == 4) {
                                u5BookStatus4 = status;
                            }
                            if (bookNumber == 5) {
                                u5BookStatus5 = status;
                            }
                        }

                        mainAdmin_SearchBTTN.performClick();
                    }
                });
        builder.create();
        builder.show();
    }

    private void mainUserActivity() {
        backCount = 0;
        setContentView(R.layout.layout_main_user);
        activeAct = "main_user";

        mainUser_LastNameTXTVW = (TextView)findViewById(R.id.mainUser_LastNameTXTVW);
        mainUser_FNameTXTVW = (TextView)findViewById(R.id.mainUser_FNameTXTVW);
        mainUser_LogOutBTTN = (Button)findViewById(R.id.mainUser_LogOutBTTN);
        mainUser_Data1LNRLYT = (LinearLayout)findViewById(R.id.mainUser_Data1LNRLYT);
        mainUser_Data2LNRLYT = (LinearLayout)findViewById(R.id.mainUser_Data2LNRLYT);
        mainUser_Data3LNRLYT = (LinearLayout)findViewById(R.id.mainUser_Data3LNRLYT);
        mainUser_Data4LNRLYT = (LinearLayout)findViewById(R.id.mainUser_Data4LNRLYT);
        mainUser_Data5LNRLYT = (LinearLayout)findViewById(R.id.mainUser_Data5LNRLYT);
        mainUser_Data1TXTVW = (TextView)findViewById(R.id.mainUser_Data1TXTVW);
        mainUser_Data2TXTVW = (TextView)findViewById(R.id.mainUser_Data2TXTVW);
        mainUser_Data3TXTVW = (TextView)findViewById(R.id.mainUser_Data3TXTVW);
        mainUser_Data4TXTVW = (TextView)findViewById(R.id.mainUser_Data4TXTVW);
        mainUser_Data5TXTVW = (TextView)findViewById(R.id.mainUser_Data5TXTVW);

        mainUser_Data1LNRLYT.setVisibility(View.GONE);
        mainUser_Data2LNRLYT.setVisibility(View.GONE);
        mainUser_Data3LNRLYT.setVisibility(View.GONE);
        mainUser_Data4LNRLYT.setVisibility(View.GONE);
        mainUser_Data5LNRLYT.setVisibility(View.GONE);

        if (actUser == 1) {
            if (u1Book1.length() != 0) {
                mainUser_Data1LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data1TXTVW.setText(u1Book1 + "\n Status: " + u1BookStatus1);
            }
            if (u1Book2.length() != 0) {
                mainUser_Data2LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data2TXTVW.setText(u1Book2 + "\n Status: " + u1BookStatus2);
            }
            if (u1Book3.length() != 0) {
                mainUser_Data3LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data3TXTVW.setText(u1Book3 + "\n Status: " + u1BookStatus3);
            }
            if (u1Book4.length() != 0) {
                mainUser_Data4LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data4TXTVW.setText(u1Book4 + "\n Status: " + u1BookStatus4);
            }
            if (u1Book5.length() != 0) {
                mainUser_Data5LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data5TXTVW.setText(u1Book5 + "\n Status: " + u1BookStatus5);
            }
        }
        else if (actUser == 2) {
            if (u2Book1.length() != 0) {
                mainUser_Data1LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data1TXTVW.setText(u2Book1 + "\n Status: " + u2BookStatus1);
            }
            if (u2Book2.length() != 0) {
                mainUser_Data2LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data2TXTVW.setText(u2Book2 + "\n Status: " + u2BookStatus2);
            }
            if (u2Book3.length() != 0) {
                mainUser_Data3LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data3TXTVW.setText(u2Book3 + "\n Status: " + u2BookStatus3);
            }
            if (u2Book4.length() != 0) {
                mainUser_Data4LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data4TXTVW.setText(u2Book4 + "\n Status: " + u2BookStatus4);
            }
            if (u2Book5.length() != 0) {
                mainUser_Data5LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data5TXTVW.setText(u2Book5 + "\n Status: " + u2BookStatus5);
            }
        }
        else if (actUser == 3) {
            if (u3Book1.length() != 0) {
                mainUser_Data1LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data1TXTVW.setText(u3Book1 + "\n Status: " + u3BookStatus1);
            }
            if (u3Book2.length() != 0) {
                mainUser_Data2LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data2TXTVW.setText(u3Book2 + "\n Status: " + u3BookStatus2);
            }
            if (u3Book3.length() != 0) {
                mainUser_Data3LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data3TXTVW.setText(u3Book3 + "\n Status: " + u3BookStatus3);
            }
            if (u3Book4.length() != 0) {
                mainUser_Data4LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data4TXTVW.setText(u3Book4 + "\n Status: " + u3BookStatus4);
            }
            if (u3Book5.length() != 0) {
                mainUser_Data5LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data5TXTVW.setText(u3Book5 + "\n Status: " + u3BookStatus5);
            }
        }
        else if (actUser == 4) {
            if (u4Book1.length() != 0) {
                mainUser_Data1LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data1TXTVW.setText(u4Book1 + "\n Status: " + u4BookStatus1);
            }
            if (u4Book2.length() != 0) {
                mainUser_Data2LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data2TXTVW.setText(u4Book2 + "\n Status: " + u4BookStatus2);
            }
            if (u4Book3.length() != 0) {
                mainUser_Data3LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data3TXTVW.setText(u4Book3 + "\n Status: " + u4BookStatus3);
            }
            if (u4Book4.length() != 0) {
                mainUser_Data4LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data4TXTVW.setText(u4Book4 + "\n Status: " + u4BookStatus4);
            }
            if (u4Book5.length() != 0) {
                mainUser_Data5LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data5TXTVW.setText(u4Book5 + "\n Status: " + u4BookStatus5);
            }
        }
        else if (actUser == 5) {
            if (u5Book1.length() != 0) {
                mainUser_Data1LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data1TXTVW.setText(u5Book1 + "\n Status: " + u5BookStatus1);
            }
            if (u5Book2.length() != 0) {
                mainUser_Data2LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data2TXTVW.setText(u5Book2 + "\n Status: " + u5BookStatus2);
            }
            if (u5Book3.length() != 0) {
                mainUser_Data3LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data3TXTVW.setText(u5Book3 + "\n Status: " + u5BookStatus3);
            }
            if (u5Book4.length() != 0) {
                mainUser_Data4LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data4TXTVW.setText(u5Book4 + "\n Status: " + u5BookStatus4);
            }
            if (u5Book5.length() != 0) {
                mainUser_Data5LNRLYT.setVisibility(View.VISIBLE);
                mainUser_Data5TXTVW.setText(u5Book5 + "\n Status: " + u5BookStatus5);
            }
        }

        mainUser_LogOutBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInActivity();
            }
        });

        if (actUser == 1) {
            mainUser_LastNameTXTVW.setText(u1LastName);
            mainUser_FNameTXTVW.setText(u1FName);
        }
        else if (actUser == 2) {
            mainUser_LastNameTXTVW.setText(u2LastName);
            mainUser_FNameTXTVW.setText(u2FName);
        }
        else if (actUser == 3) {
            mainUser_LastNameTXTVW.setText(u3LastName);
            mainUser_FNameTXTVW.setText(u3FName);
        }
        else if (actUser == 4) {
            mainUser_LastNameTXTVW.setText(u4LastName);
            mainUser_FNameTXTVW.setText(u4FName);
        }
        else if (actUser == 5) {
            mainUser_LastNameTXTVW.setText(u5LastName);
            mainUser_FNameTXTVW.setText(u5FName);
        }
    }

    private void registerActivity() {
        backCount = 0;
        setContentView(R.layout.layout_register);
        activeAct = "register";

        register_fNameDTTXT = (EditText)findViewById(R.id.register_fNameDTTXT);
        register_lNameDTTXT = (EditText)findViewById(R.id.register_lNameDTTXT);
        register_UNameDTTXT = (EditText)findViewById(R.id.register_UNameDTTXT);
        register_SchoolDTTXT = (EditText)findViewById(R.id.register_SchoolDTTXT);
        register_SectionDTTXT = (EditText)findViewById(R.id.register_SectionDTTXT);
        register_PasswordDTTXT = (EditText)findViewById(R.id.register_PasswordDTTXT);
        register_ConfirmPasswordDTTXT = (EditText)findViewById(R.id.register_ConfirmPasswordDTTXT);
        register_RegisterBTTN = (Button)findViewById(R.id.register_RegisterBTTN);
        register_LogInBTTN = (Button)findViewById(R.id.register_LogInBTTN);
        register_LogInBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInActivity();
            }
        });
        register_RegisterBTTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = register_fNameDTTXT.getText().toString();
                String lname = register_lNameDTTXT.getText().toString();
                String uname = register_UNameDTTXT.getText().toString();
                String school = register_SchoolDTTXT.getText().toString();
                String section = register_SectionDTTXT.getText().toString();
                String pass = register_PasswordDTTXT.getText().toString();
                String conPass = register_ConfirmPasswordDTTXT.getText().toString();

                if (fname.length() !=0 && lname.length() !=0 && uname.length() !=0 && school.length() !=0 && section.length() !=0 && pass.length() !=0 && conPass.length() !=0) {
                    if (uname.equals(adminUname) || uname.equals(u1Uname) || uname.equals(u2Uname) || uname.equals(u3Uname) || uname.equals(u4Uname) || uname.equals(u5Uname)) {
                        Toast.makeText(AppActivity.this, "Username is taken!", Toast.LENGTH_SHORT).show();
                    }
                    else if (conPass.equals(pass) == false) {
                        Toast.makeText(AppActivity.this, "Check your password!", Toast.LENGTH_SHORT).show();
                    }
                    else if (pass.length() < 8) {
                        Toast.makeText(AppActivity.this, "Password must be atleast 8 characters!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        registerDB(fname, lname, uname, school, section, pass);
                    }
                }
                else {
                    Toast.makeText(AppActivity.this, "Please complete your details!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void registerDB(String fname, String lname, String uname, String school, String section, String pass) {
        userCount++;
        if (userCount == 3) {
            u3ID = "3"; u3Uname = uname; u3FName = fname; u3LastName = lname; u3Password = pass; u3School = school; u3Section = section;
            logInActivity();
        }
        else if (userCount == 4) {
            u4ID = "4"; u4Uname = uname; u4FName = fname; u4LastName = lname; u4Password = pass; u4School = school; u4Section = section;
            logInActivity();
        }
        else if (userCount == 5) {
            u5ID = "3"; u5Uname = uname; u5FName = fname; u5LastName = lname; u5Password = pass; u5School = school; u5Section = section;
            logInActivity();
        }
        else {
            Toast.makeText(this, "Too many registration on one device!", Toast.LENGTH_SHORT).show();
        }
    }

    int backCount = 0;
    @Override
    public void onBackPressed() {
        backCount++;
        if (activeAct.equals("login")) {
            if (backCount >= 2) {
                super.onBackPressed();
            }
            else {
                Toast.makeText(this, "Press again to exit!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (activeAct.equals("register")) {
            logInActivity();
        }
    }
}
