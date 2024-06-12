package com.mhdb.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.fasterxml.jackson.databind.ObjectMapper;

//Main Frame for application
//Displays title and buttons for each monster
//Created By Adrian Faircloth
//6-10-24

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -8026416994513756565L;
	private ObjectMapper mapper = new ObjectMapper();
	Map<String, String> jsonMap;
	JPanel viewPanel = new JPanel(new BorderLayout());
	JPanel buttonPanel = new JPanel(new GridLayout(14, 6));
	MonsterFrame monsterFrame;
	
	@SuppressWarnings("unchecked")
	public MainFrame() {
		//Reading in monsters.json
		try {
			jsonMap = mapper.readValue(new File("data/monsters.json"), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Building panels and setting Frame attributes
		buildButtonPanel();
		addTitle();
		JScrollPane pane = new JScrollPane(viewPanel);
		this.setTitle("MH4UDB");
		this.setContentPane(pane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Builds panel of monster buttons
	private void buildButtonPanel() {
		//For each Monster name in jsonMap, create button w/ name and icon and add action listener to open corresponding MonsterFrame
		for (String name : jsonMap.keySet()) {
			JButton button = new JButton(name);
			String filename = name.toLowerCase();

			filename = filename.replace(' ', '_');
			filename = filename.replace('-', '_');
			String filepath = "data/monsterIcons/" + filename + ".png";
			if (!(new File(filepath).isFile())) filepath = "data/monsterIcons/unknown.png";
			ImageIcon icon = new ImageIcon(filepath);
			button.setIcon(icon);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			
			button.addActionListener(event -> {
				monsterFrame = new MonsterFrame(name, icon);
				monsterFrame.setVisible(true);
			});
			buttonPanel.add(button);
		}
		viewPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	//Adds title text to top of panel
	private void addTitle() {
		JLabel title = new JLabel("Monster Hunter 4 Ultimate Monster Database");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Calibri", Font.BOLD, 40));
		viewPanel.add(title, BorderLayout.NORTH);
	}
	

}
