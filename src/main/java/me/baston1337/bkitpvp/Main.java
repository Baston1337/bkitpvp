package me.baston1337.bkitpvp;

import me.baston1337.bkitpvp.utils.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static MySQL mySQL;

    public static MySQL getMySQL() {
        return mySQL;
    }

    public static void setMySQL(MySQL mySQL) {
        Main.mySQL = mySQL;
    }

    @Override
    public void onEnable() {
        setMySQL(new MySQL(getConfig().getString("storage.mysql.database"), getConfig().getString("storage.mysql.host"),
                getConfig().getString("storage.mysql.port"), getConfig().getString("storage.mysql.pass"),
                getConfig().getString("storage.mysql.user")));
    }
}
