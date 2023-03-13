package Vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class Menu{

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
		frame.setLocationRelativeTo(null);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Menu");
		frame.setBounds(100, 100, 548, 162);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel jLabel = new JLabel("Seleccione una opcion de conversion");
		jLabel.setBounds(10, 10, 514, 31);
		jLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(jLabel);
		final JComboBox cbo = new JComboBox();
		cbo.setFocusable(false);
		cbo.setBounds(10, 67, 514, 35);
		cbo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) { 
				if(cbo.getSelectedItem().equals(cbo.getItemAt(1))) {
						convertidorMonedas ventanaMoneda = new convertidorMonedas();
				        ventanaMoneda.frmConvertidroDeMonedas.setVisible(true);
						
					}else if(cbo.getSelectedItem().equals(cbo.getItemAt(2))) {
						convertidorTemperatura ventanaTemperatura=new convertidorTemperatura();
						ventanaTemperatura.frmConvertidorTemperatura.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Debe escoger una opcion correcta.");
					}	
		        }
			}	
		});
		cbo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cbo.setModel(new DefaultComboBoxModel(new String[] {"", "Conversor de Moneda", "Conversor de Temperatura"}));
		cbo.setSelectedIndex(0);
		frame.getContentPane().add(cbo);
	}
	
}
