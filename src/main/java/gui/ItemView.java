package gui;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ItemView extends JFrame {
	private static final long serialVersionUID = 1732854616130990367L;
	private ArrayList<LinkedHashMap<String, ?>> itemeffects;
	private JPanel viewPanel = new JPanel();
	
	public ItemView(ArrayList<LinkedHashMap<String, ?>> itemeffects) {
		this.itemeffects = itemeffects;
		this.setTitle("Item Effects");
		buildTable();
		this.setContentPane(viewPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("unchecked")
	private void buildTable() {
		JTable itemTable = new JTable(itemeffects.size(), 4);
		itemTable.setValueAt("Item", 0, 0);
		itemTable.setValueAt("Normal", 0 , 1);
		itemTable.setValueAt("Enraged", 0, 2);
		itemTable.setValueAt("Exhausted", 0, 3);
		
		for (int i = 0; i < itemeffects.size() - 1; i++) {
			LinkedHashMap<String, ?> item = itemeffects.get(i);
			LinkedHashMap<String, ?> effectdata = (LinkedHashMap<String, ?>) item.get("pivot");
			itemTable.setValueAt(item.get("local_name"), i + 1, 0);
			itemTable.setValueAt(effectdata.get("normal"), i + 1, 1);
			itemTable.setValueAt(effectdata.get("enraged"), i + 1, 2);
			itemTable.setValueAt(effectdata.get("fatigued"), i + 1, 3);
		}
		
		LinkedHashMap<String, ?> canopy = itemeffects.get(4);
		itemTable.setValueAt("Canopy Trap", 4, 0);
		itemTable.setValueAt(canopy.get("normal"), 4, 1);
		itemTable.setValueAt(canopy.get("enraged"), 4, 2);
		itemTable.setValueAt(canopy.get("fatigued"), 4, 3);
		
		viewPanel.add(itemTable);
	}
}
