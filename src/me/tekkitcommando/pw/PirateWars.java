package me.tekkitcommando.pw;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.tekkitcommando.pw.timer.GameTimer;

public class PirateWars extends JavaPlugin {
	
	public static int gameTimerId;
	public static PirateWars instance;
	
	public void onEnable() {
		startGameTimer();
	}
	
	public void onDisable() {
		
	}
	
    @SuppressWarnings("deprecation")
	public void startGameTimer() {
        GameTimer.gameTimer = 30;
        gameTimerId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new GameTimer(this), 20l, 20l);
    }

    public void stopGameTimer() {
        getServer().getScheduler().cancelTask(gameTimerId);
    }

    public void restartTimer() {
        stopGameTimer();
        startGameTimer();
    }
}