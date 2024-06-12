package gui.views;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HitzoneView extends JFrame {
	private static final long serialVersionUID = -1027911904930167138L;
	private ArrayList<LinkedHashMap<String, ?>> bodyparts;
	private JPanel viewPanel = new JPanel();
	
	public HitzoneView(ArrayList<LinkedHashMap<String, ?>> bodyparts) {
		this.bodyparts = bodyparts;
		this.setTitle("Hitzone View");
		buildTable();
		this.setContentPane(viewPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("unchecked")
	private void buildTable() {
		JTable hitzoneTable = new JTable(bodyparts.size() + 1, 9);
		hitzoneTable.setValueAt("Body Part", 0, 0);
		hitzoneTable.setValueAt("Cut", 0, 1);
		hitzoneTable.setValueAt("Impact", 0, 2);
		hitzoneTable.setValueAt("Shot", 0, 3);
		hitzoneTable.setValueAt("Fire", 0, 4);
		hitzoneTable.setValueAt("Water", 0, 5);
		hitzoneTable.setValueAt("Thunder", 0, 6);
		hitzoneTable.setValueAt("Ice", 0, 7);
		hitzoneTable.setValueAt("Dragon", 0, 8);
		
		for (int i = 0; i < bodyparts.size(); i++) {
			LinkedHashMap<String, ?> currentPart = bodyparts.get(i);
			LinkedHashMap<String, ?> partRes = (LinkedHashMap<String, ?>) currentPart.get("pivot");
			hitzoneTable.setValueAt(currentPart.get("local_name"), i + 1, 0);
			hitzoneTable.setValueAt(partRes.get("res_cut"), i + 1, 1);
			hitzoneTable.setValueAt(partRes.get("res_impact"), i + 1, 2);
			hitzoneTable.setValueAt(partRes.get("res_shot"), i + 1, 3);
			hitzoneTable.setValueAt(partRes.get("res_fire"), i + 1, 4);
			hitzoneTable.setValueAt(partRes.get("res_water"), i + 1, 5);
			hitzoneTable.setValueAt(partRes.get("res_ice"), i + 1, 6);
			hitzoneTable.setValueAt(partRes.get("res_thunder"), i + 1, 7);
			hitzoneTable.setValueAt(partRes.get("res_dragon"), i + 1, 8);
		}
		viewPanel.add(hitzoneTable);
	}
}
