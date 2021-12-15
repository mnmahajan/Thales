package com.main.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.main.controller.WordSearchController;;

/**
 * @author ACER
 *	Swing form for application
 */
public class WordSearchView extends JFrame{    
	private JTextField tf;    
	private JButton button;
	private JLabel label,output;
	private static WordSearchView wordSearchView = null;

	/**
	 *  default constructor invokes form
	 */
	private WordSearchView(){
		label = new JLabel();
		label.setText("Kindly enter word to be searched");
		label.setBounds(0, 0, 200, 10);
		add(label);
		tf=new JTextField(100);    
		tf.setBounds(30,30,95,30);
		add(tf);
		button = new JButton("Search");
		button.setBounds(30,80,95,30);  
		add(button);
		button.addActionListener(e -> {
			tf.getText();
			new WordSearchController(tf.getText());
		});		
		output = new JLabel();
		output.setBounds(30, 130, 200, 10);
		add(output);

		setLayout(new BorderLayout());
		setVisible(true);
		setSize(400, 500);
	}
	
	
	/**
	 * @return singleton object of class wordSearchView
	 */
	public static WordSearchView getBean() {
		if(wordSearchView == null) {
			wordSearchView = new WordSearchView();
		}
		return wordSearchView;
	}

	/**
	 * @param text sets the output text of wordsearchwindow output textfield
	 */
	public void setOutput(String text) {
		this.output.setText(text);
	}
	
	
}  
