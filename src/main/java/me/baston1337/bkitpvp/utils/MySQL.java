package me.baston1337.bkitpvp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    private String database;
    private String host;
    private String porta;
    private String senha;
    private String usuario;

    public MySQL(String database, String host, String porta, String senha, String usuario) {
        setDatabase(database);
        setHost(host);
        setPorta(porta);
        setSenha(senha);
        setUsuario(usuario);
    }

    public synchronized Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + getHost() + ":" + getPorta() + "/" + getDatabase(), getUsuario(), getSenha());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public synchronized void execute(String query) {
        Connection con = conectar();
        try {
            con.prepareStatement(query).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized ResultSet getQueryResult(String query) {
        Connection con = conectar();
        try {
            return con.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
