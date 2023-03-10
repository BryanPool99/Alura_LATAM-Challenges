import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Convertidor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convertidor window = new Convertidor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Convertidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Menu");
		frame.setBounds(100, 100, 630, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jLabel = new JLabel("Seleccione una opcion de conversion");
		jLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(jLabel, BorderLayout.NORTH);
		final JComboBox cbo = new JComboBox();
		cbo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) { 
					if(cbo.getSelectedItem().equals(cbo.getItemAt(1))) {
						JOptionPane.showMessageDialog(null, "Usted escogio "+(String)cbo.getSelectedItem());
						JOptionPane.showMessageDialog(null, "Bienvenido al conversor de monedas");
						frame.setTitle("Convertidor de monedas");
					}else if(cbo.getSelectedItem().equals(cbo.getItemAt(2))) {
						JOptionPane.showMessageDialog(null, "Usted escogio "+(String)cbo.getSelectedItem());
						JOptionPane.showMessageDialog(null, "Bienvenido al conversor de temperatura");
						frame.setTitle("Convertidor de temperatura");
					}else {
						JOptionPane.showMessageDialog(null, "Debe escoger una opcion");
					}
		        }
				
			}
		});
		cbo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cbo.setModel(new DefaultComboBoxModel(new String[] {"", "Conversor de Moneda", "Conversor de Temperatura"}));
		cbo.setSelectedIndex(0);
		frame.getContentPane().add(cbo, BorderLayout.SOUTH);
		
	}

}
