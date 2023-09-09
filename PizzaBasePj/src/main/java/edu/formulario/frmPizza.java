package edu.formulario;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {

    private JPanel jpanelPrincipal;
    private JComboBox Toppings;
    private JTextField txtPizza;
    private JButton addIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton preparar;

    private DefaultListModel modeloLista = new DefaultListModel<>();
    private List<Topping>ingredientes = new ArrayList<>();

    public JPanel getJpanelPrincipal() {
        return jpanelPrincipal;
    }

    public frmPizza() {

        addIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Topping ingrediente = (Topping) Toppings.getSelectedItem();

                DefaultListModel modeloLista = new DefaultListModel();
                modeloLista.addElement(ingrediente.toString());
                lista1.setModel(modeloLista);
                double total = ingrediente.getPrecio();

                lblTotal.setText(String.valueOf(total));

            }
        });
        preparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i=0; i<lista1.getModel().getSize();i++){
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();
            }
        });
    }

    private void cargarToppings(){
        ingredientes.add(new Topping("champinones",12));
        ingredientes.add(new Topping("jalapeno",4));
        ingredientes.add(new Topping("aceitunas",8));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        Toppings.setModel(model);
    }
}
