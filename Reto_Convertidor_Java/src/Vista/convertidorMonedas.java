package Vista;
//imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;
import Constantes.valMonedas;
public class convertidorMonedas implements valMonedas{

	JFrame frmConvertidroDeMonedas;
	private String monedaInput;
	private double valConvertido;
	public String getMonedaInput() {
		return monedaInput;
	}
	public double getValConvertido() {
		return valConvertido;
	}

	public void setValConvertido(double valConvertido) {
		this.valConvertido = valConvertido;
	}
	public void setMonedaInput(String monedaInput) {
		this.monedaInput = monedaInput;
	}

	/**
	 * Create the application.
	 */
	public convertidorMonedas() {
		JOptionPane.showMessageDialog(null, "Bienvenido al conversor de monedas");
		setMonedaInput(validarInput("Ingrese la cantidad de dinero que desea convertir:"));
		initialize();
		frmConvertidroDeMonedas.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConvertidroDeMonedas = new JFrame();
		frmConvertidroDeMonedas.setTitle("Convertidro de monedas");
		frmConvertidroDeMonedas.setBounds(100, 100, 548, 162);
		frmConvertidroDeMonedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frmConvertidroDeMonedas.getContentPane().add(panel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("Eliga la moneda a la que desea convertir tu dinero");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		final JComboBox cboMonedas = new JComboBox();
		final double valInput=Double.parseDouble(getMonedaInput());
		final DecimalFormat formatNum=new DecimalFormat("#.##");
		cboMonedas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cboMonedas.setEnabled(true);
					if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(1))) {
						setValConvertido(valInput/valMonedas.DOLAR);
						JOptionPane.showMessageDialog(null,"Tienes $"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(2))) {
						setValConvertido(valInput/valMonedas.EURO);
						JOptionPane.showMessageDialog(null,"Tienes €"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(3))) {
						setValConvertido(valInput/valMonedas.REAL);
						JOptionPane.showMessageDialog(null,"Tienes R$"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(4))) {
						setValConvertido(valInput/valMonedas.LIBRA);
						JOptionPane.showMessageDialog(null,"Tienes £"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(5))) {
						setValConvertido(valInput/valMonedas.YEN);
						JOptionPane.showMessageDialog(null,"Tienes ¥"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(6))) {
						setValConvertido(valMonedas.DOLAR*valInput);
						JOptionPane.showMessageDialog(null,"Tienes S/"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(7))) {
						setValConvertido(valMonedas.EURO*valInput);
						JOptionPane.showMessageDialog(null,"Tienes S/"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(8))) {
						setValConvertido(valMonedas.REAL*valInput);
						JOptionPane.showMessageDialog(null,"Tienes S/"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(9))) {
						setValConvertido(valMonedas.LIBRA*valInput);
						JOptionPane.showMessageDialog(null,"Tienes S/"+formatNum.format(getValConvertido()));
					}
					else if(cboMonedas.getSelectedItem().equals(cboMonedas.getItemAt(10))) {
						setValConvertido(valMonedas.YEN*valInput);
						JOptionPane.showMessageDialog(null,"Tienes S/"+formatNum.format(getValConvertido()));
					}
					else {
						JOptionPane.showMessageDialog(null,"Opcion no válida");
					}
					int rpta=JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
					switch(rpta) {
					case 0:frmConvertidroDeMonedas.setVisible(false);
							break;
					case 1:JOptionPane.showMessageDialog(null, "Programa terminado");
							System.exit(0);
							break;
				}
				}
												
			}
		});	cboMonedas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cboMonedas.setModel(new DefaultComboBoxModel(new String[] {"","De Soles a Dólar", "De Soles a Euro", "De Soles a Real", "De Soles a Libra", "De Soles  a Yen", "De Dólar a Soles", "De Euro a Soles", "De Real a Soles", "De Libra a Soles", "De Yen a Soles"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cboMonedas, Alignment.LEADING, 0, 575, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(cboMonedas, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	public static String validarInput(String msg) {
		String numero = null;
        boolean esNumero = false;
        while (!esNumero) {
            numero = JOptionPane.showInputDialog(null, msg);
            if (numero == null || numero.length()==0) { // El usuario presionó Cancelar
            	JOptionPane.showMessageDialog(null, "Por favor ingresa sólo números y un punto decimal.");
            }
            else if (numero.matches("^\\d*\\.?\\d*$")) { // La cadena contiene sólo dígitos y un punto decimal
                esNumero = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingresa sólo números y un punto decimal.");
            }
        }
        return numero;
	}
}
