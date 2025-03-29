package jcgmeone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class PaintGui extends JFrame implements ActionListener {
			public PaintGui(){
				super("RS libghiti by FIGUIX");
				setDefaultCloseOperation(EXIT_ON_CLOSE);
		  		setTitle("FIGUIX Games IGUIDI QUIZ ");
		  		setVisible(true);
				setPreferredSize(new Dimension(1500, 1000));
				pack();
				setLocationRelativeTo(null);
				addGui();
	}
			
				
				private void addGui() {
				JPanel 	canvapan = new JPanel();
				SpringLayout lay = new SpringLayout();
				canvapan.setLayout(lay);
				
				Canvas canva = new Canvas(1500, 950);
				canvapan.add(canva);
				lay.putConstraint(SpringLayout.NORTH, canva, 50, SpringLayout.NORTH, canvapan);
				
				JButton chooseColorbtn = new JButton("3zl chi loon a iguidi");
				chooseColorbtn.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						Color c= JColorChooser.showDialog(null, "3zl lloon", Color.BLACK);
						chooseColorbtn.setBackground(c);
						canva.setColor(c);
					
				}
				});
				
				canvapan.add(chooseColorbtn);
				
				lay.putConstraint(SpringLayout.NORTH, chooseColorbtn, 10, SpringLayout.NORTH, canvapan);
				lay.putConstraint(SpringLayout.WEST, chooseColorbtn, 25, SpringLayout.WEST, canvapan);
				
				JButton resetButton = new JButton("Kiss ghayad KOLOT");
				resetButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						canva.resetCanvas();
				}
				});
				
				canvapan.add(resetButton);
				lay.putConstraint(SpringLayout.NORTH, resetButton, 10, SpringLayout.NORTH, canvapan);
				lay.putConstraint(SpringLayout.WEST, resetButton, 150, SpringLayout.WEST, canvapan);
				
				
				this.getContentPane().add(canvapan);
						
				}


				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}




}
