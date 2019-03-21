package com.kai.vinblood.display;

import com.kai.vinblood.core.Game;
import com.kai.vinblood.core.ResourceManager;
import com.kai.vinblood.util.Bounds;
import com.kai.vinblood.util.VFont;

import java.awt.*;

public class PlayerInfoDisplay extends HUDComponent {
    private int playerHealth, playerMaxHealth;
    private int playerMana, playerMaxMana;
    private int playerBloodthirst, playerSwiftness, playerDefense;

    private static final Bounds HEALTH_BOUNDS = new Bounds(194, 602, 16, 96);
    private static final Bounds MANA_BOUNDS = new Bounds(214,602, 16, 96);

    private static final Bounds BLOODTHIRST_BOUNDS = new Bounds(15, 653);
    private static final Bounds SWIFTNESS_BOUNDS = new Bounds(15, 669);
    private static final Bounds DEFENSE_BOUNDS = new Bounds(15, 685);

    public PlayerInfoDisplay() {
        super(new Bounds(0, 600, 232, 100), ResourceManager.getImage("playerinfodisplay"));
        setDisplayLayer(2);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        g.setColor(Color.RED);
        g.fillRect(HEALTH_BOUNDS.scaledX(), HEALTH_BOUNDS.scaledY() + (HEALTH_BOUNDS.scaledHeight()) - (int)(((double)playerHealth/playerMaxHealth) * HEALTH_BOUNDS.scaledHeight()),
                HEALTH_BOUNDS.scaledWidth(), (int)(((double)playerHealth/playerMaxHealth) * HEALTH_BOUNDS.scaledHeight()));

        g.setColor(new Color(29, 87, 145));
        g.fillRect(MANA_BOUNDS.scaledX(), MANA_BOUNDS.scaledY() + (MANA_BOUNDS.scaledHeight()) - (int)(((double)playerMana/playerMaxMana) * MANA_BOUNDS.scaledHeight()),
                MANA_BOUNDS.scaledWidth(), (int)(((double)playerMana/playerMaxMana) * MANA_BOUNDS.scaledHeight()));

        g.setColor(new Color(56, 160, 170));
        g.setFont(new VFont(0.9));
        g.drawString("Bloodthirst: " + playerBloodthirst, BLOODTHIRST_BOUNDS.scaledX(), BLOODTHIRST_BOUNDS.scaledY());
        g.drawString("Swiftness: " + playerSwiftness, SWIFTNESS_BOUNDS.scaledX(), SWIFTNESS_BOUNDS.scaledY());
        g.drawString("Defense: " + playerDefense, DEFENSE_BOUNDS.scaledX(), DEFENSE_BOUNDS.scaledY());
    }

    @Override
    public void update() {
        //TODO: Make this less costly.
        playerHealth = Game.getPlayer().getStat("health").getValue();
        playerMana = Game.getPlayer().getStat("mana").getValue();
        playerMaxHealth = Game.getPlayer().getStat("max health").getValue();
        playerMaxMana = Game.getPlayer().getStat("max mana").getValue();
        playerBloodthirst = Game.getPlayer().getStat("bloodthirst").getValue();
        playerSwiftness = Game.getPlayer().getStat("swiftness").getValue();
        playerDefense = Game.getPlayer().getStat("defense").getValue();
    }
}
