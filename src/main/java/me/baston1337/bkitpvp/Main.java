package me.baston1337.bkitpvp;

import me.baston1337.bkitpvp.utils.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static MySQL mySQL;

    @Override
    public void onEnable() {
        setMySQL(new MySQL("testes","localhost","3306","","root"));
    }

    public static MySQL getMySQL() {
        return mySQL;
    }

    public static void setMySQL(MySQL mySQL) {
        Main.mySQL = mySQL;
    }
}
