package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mhdb.AccessTest;

public class MonsterFrame extends JFrame {
	private static final long serialVersionUID = -3116449965946068711L;
	private AccessTest data;
	private ArrayList<LinkedHashMap<String, ?>> bodyparts;
	private ArrayList<LinkedHashMap<String, ?>> weaponspecialeffects;
	private ArrayList<LinkedHashMap<String, ?>> itemeffects;
	private HitzoneView hitzoneView;
	private StatusView statusView;
	private ItemView itemView;
	private JPanel viewPanel = new JPanel(new BorderLayout());
	private JPanel buttonPanel = new JPanel();
	private ImageIcon icon;
	public MonsterFrame(int id, ImageIcon icon) {
		this.icon = icon;
		data = new AccessTest(id);
		initViews();
	}
	
	public MonsterFrame(String local_name, ImageIcon icon) {
		this.icon = icon;
		data = new AccessTest(local_name);
		initViews();
	}

	private void initViews() {
		bodyparts = data.getBodyParts();
		weaponspecialeffects = data.getWeaponEffects();
		itemeffects = data.getItemEffects();
		hitzoneView = new HitzoneView(bodyparts);
		statusView = new StatusView(weaponspecialeffects);
		itemView = new ItemView(itemeffects);
		createUI();
	}
	private void createUI() {
		JButton hitzoneButton = new JButton(data.getLocalName() + " Hitzones");
		JButton statusButton = new JButton(data.getLocalName() + " Status Resistances");
		JButton itemButton = new JButton(data.getLocalName() + " Item Effects");
		
		hitzoneButton.addActionListener(event -> {
			if (!hitzoneView.isVisible())
				hitzoneView.setVisible(true);
		});
		
		statusButton.addActionListener(event -> {
			if (!statusView.isVisible())
				statusView.setVisible(true);
		});
		
		itemButton.addActionListener(event -> {
			if (!itemView.isVisible())
				itemView.setVisible(true);
		});
		
		buttonPanel.add(hitzoneButton);
		buttonPanel.add(statusButton);
		buttonPanel.add(itemButton);
		viewPanel.add(new JLabel(icon), BorderLayout.CENTER);
		viewPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setTitle("MH4UDB: " + data.getLocalName());

		this.setContentPane(viewPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
