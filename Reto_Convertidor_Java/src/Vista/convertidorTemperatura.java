package Vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;

public class convertidorTemperatura {

	JFrame frmConvertidorTemperatura;
	private String temperaturaInput;
	private double tempConvertido;
	
	public double getTempConvertido() {
		return tempConvertido;
	}
	public String getTemperaturaInput() {
		return temperaturaInput;
	}
	public void setTemperaturaInput(String temperaturaInput) {
		this.temperaturaInput = temperaturaInput;
	}
	public void setTempConvertido(double tempConvertido) {
		this.tempConvertido = tempConvertido;
	}
	/**
	 * Create the application.
	 */
	public convertidorTemperatura() {
		JOptionPane.showMessageDialog(null, "Bienvenido al conversor de temperatura");
		setTemperaturaInput(validarInput("Ingrese la temperatura que desea convertir:"));
		initialize();
		frmConvertidorTemperatura.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConvertidorTemperatura = new JFrame();
		frmConvertidorTemperatura.setTitle("Convertidor de Temperatura");
		frmConvertidorTemperatura.setBounds(100, 100, 548, 162);
		frmConvertidorTemperatura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConvertidorTemperatura.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 540, 104);
		frmConvertidorTemperatura.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliga una opcion para convertir");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 519, 25);
		panel.add(lblNewLabel);
		final DecimalFormat formatNum=new DecimalFormat("#.##");
		final double tempInput=Double.parseDouble(getTemperaturaInput());
		final JComboBox cboTemperatura = new JComboBox();
		cboTemperatura.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cboTemperatura.setEnabled(true);
					if(cboTemperatura.getSelectedItem().equals(cboTemperatura.getItemAt(1))) {
						setTempConvertido((tempInput*9/5)+32);
						JOptionPane.showMessageDialog(null,tempInput+"°C son "+formatNum.format(getTempConvertido())+"°F");
					}
					else if(cboTemperatura.getSelectedItem().equals(cboTemperatura.getItemAt(2))) {
						setTempConvertido(tempInput+273.15);
						JOptionPane.showMessageDialog(null,tempInput+"°C son "+formatNum.format(getTempConvertido())+"°K");
					}
					else if(cboTemperatura.getSelectedItem().equals(cboTemperatura.getItemAt(3))) {
						setTempConvertido((tempInput*9/5)+491.67);
						JOptionPane.showMessageDialog(null,tempInput+"°C son "+formatNum.format(getTempConvertido())+"°R");
					}
					else if(cboTemperatura.getSelectedItem().equals(cboTemperatura.getItemAt(4))) {
						setTempConvertido((tempInput-32)*5/9);
						JOptionPane.showMessageDialog(null,tempInput+"°F son "+formatNum.format(getTempConvertido())+"°C");
					}
					else if(cboTemperatura.getSelectedItem().equals(cboTemperatura.getItemAt(5))) {
						setTempConvertido(tempInput-273.15);
						JOptionPane.showMessageDialog(null,tempInput+"°K son "+formatNum.format(getTempConvertido())+"°C");
					}
					else if(cboTemperatura.getSelectedItem().equals(cboTemperatura.getItemAt(6))) {
						setTempConvertido((tempInput-491.67)*5/9);
						JOptionPane.showMessageDialog(null,tempInput+"°R son "+formatNum.format(getTempConvertido())+"°C");
					}
					else {
						JOptionPane.showMessageDialog(null,"Opcion no válida");
					}
					int rpta=JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
					switch(rpta) {
						case 0:frmConvertidorTemperatura.setVisible(false);
								
								break;
						case 1:JOptionPane.showMessageDialog(null, "Programa terminado");
								System.exit(0);
								break;
					}
				}
			}
		});
		cboTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cboTemperatura.setModel(new DefaultComboBoxModel(new String[] {"", "Grados Celsius a Grados Fahrenheit", "Grados Celsius a Grados Kelvin", "Grados Celsius a Grados Rankine", "Grados Fahrenheit a Grados Celsius", "Grados Kelvin a Grados Celsius", "Grados Rankine a Grados Celsius"}));
		cboTemperatura.setBounds(10, 53, 519, 30);
		panel.add(cboTemperatura);
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
