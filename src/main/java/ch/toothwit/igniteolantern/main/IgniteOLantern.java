package ch.toothwit.igniteolantern.main; 

import org.bukkit.plugin.java.JavaPlugin; 

public class IgniteOLantern extends JavaPlugin { 
	
	
	private static IgniteOLantern instance; 
	
	private PlayerLanternChecker playerLanternChecker = new PlayerLanternChecker(); 
	
	@Override
    public void onDisable() {
        super.onDisable();
        getLogger().info(this.getName() + "disabled successfully!");
    }
	 
    @Override
    public void onEnable() { 
    	instance = this; 
    	
        super.onEnable();
        
        playerLanternChecker.runTaskTimer(this, 0L, 5L ); 
        
        getLogger().info(this.getName() + "enabled successfully!"); 
    } 
    
    public static IgniteOLantern get(){ 
    	return instance; 
    }
} 