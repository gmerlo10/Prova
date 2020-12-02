package main;

import java.sql.SQLException;

public abstract class Template {
    protected String Name;
    protected String Birth;
    protected String Cpf;
    protected String TypeUser;
    protected String Salary;

    abstract void View();

    abstract void SaveUser() throws SQLException;
}
