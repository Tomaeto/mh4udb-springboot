package gui;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class StatusView extends JFrame {
	private static final long serialVersionUID = 3250839002905387127L;
	private ArrayList<LinkedHashMap<String, ?>> weaponspecialeffects;
	private JPanel viewPanel = new JPanel();
	
	public StatusView(ArrayList<LinkedHashMap<String, ?>> weaponspecialeffects) {
		this.weaponspecialeffects = weaponspecialeffects;
		this.setTitle("Status Effect View");
		buildTable();
		this.setContentPane(viewPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("unchecked")
	private void buildTable() {
		JTable statusTable = new JTable(weaponspecialeffects.size() + 1, 7);
		statusTable.setValueAt("Status", 0, 0);
		statusTable.setValueAt("Initial", 0, 1);
		statusTable.setValueAt("Increase", 0 , 2);
		statusTable.setValueAt("Max", 0, 3);
		statusTable.setValueAt("Duration", 0, 4);
		statusTable.setValueAt("Damage", 0, 5);
		statusTable.setValueAt("Reduction", 0, 6);
		
		for (int i = 0; i < weaponspecialeffects.size(); i++) {
			LinkedHashMap<String, ?> statuseffect = weaponspecialeffects.get(i);
			LinkedHashMap<String, ?> effectData = (LinkedHashMap<String, ?>) statuseffect.get("pivot");
			
			String reductionStr = effectData.get("reduction_amount") + "/" + effectData.get("reduction_time") + "sec";
			statusTable.setValueAt(statuseffect.get("local_name"), i + 1, 0);
			statusTable.setValueAt(effectData.get("initial"), i + 1, 1);
			statusTable.setValueAt(effectData.get("increase"), i + 1, 2);
			statusTable.setValueAt(effectData.get("increase"), i + 1, 3);
			statusTable.setValueAt(effectData.get("max"), i + 1, 4);
			statusTable.setValueAt(effectData.get("duration"), i + 1, 5);
			statusTable.setValueAt(reductionStr, i + 1, 6);
		}
		viewPanel.add(statusTable);
	}
}
