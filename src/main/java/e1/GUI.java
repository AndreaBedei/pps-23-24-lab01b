package e1;

import javax.swing.*;

import e1.Utility.Position;
import e1.Utility.PositionImpl;

import java.util.*;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Position> buttons = new HashMap<>();
    private final Logics logics;
    private final static int SIZE = 5;
    
    public GUI() {
        this.logics = new LogicsImpl(SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        
        JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener al = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Position pos = buttons.get(bt);
            if (logics.hit(pos)) {
            	System.exit(0);
            } else {
                draw();            	
            }
        };
                
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(al);
                this.buttons.put(jb,new PositionImpl(i,j));
                panel.add(jb);
            }
        }
        this.draw();
        this.setVisible(true);
    }
    
    private void draw() {
    	for (Entry<JButton,Position> entry: this.buttons.entrySet()) {
    		String str = logics.hasPawn(new PositionImpl(entry.getValue().getRow(), entry.getValue().getCol())) ? "*" :
    					 logics.hasKnight(new PositionImpl(entry.getValue().getRow(), entry.getValue().getCol())) ? "K" : " ";
    		entry.getKey().setText(str);
    	}
    }
    
}
