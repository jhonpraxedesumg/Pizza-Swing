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
    private JComboBox Especialidades;

    // private JComboBox<Especialidad> Especialidades;
    private double total = 0;

    private DefaultListModel modeloLista = new DefaultListModel<>();
    private List<Topping> ingredientes = new ArrayList<>();
   // private List<Especialidad> Especialidades = new ArrayList<>();
    private JButton Especialidad;

    public JPanel getJpanelPrincipal() {

        return jpanelPrincipal;
    }

    public frmPizza() {

        cargarToppings();
        //cargarEspecialidades();

        addIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Topping ingrediente = (Topping) Toppings.getSelectedItem();
                modeloLista.addElement(ingrediente.toString());
                lista1.setModel(modeloLista);
                total += ingrediente.getPrecio();

                lblTotal.setText(String.valueOf(total));

            }
        });

          /*Especialidades.addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent e) {
                Especialidad especialidad = (Especialidad) Especialidades.getSelectedItem();
                if (!especialidad.getNombre().equals("Armar desde cero")) {
                    for (Topping ingrediente : especialidad.getIngredientes()) {
                        modeloLista.addElement(ingrediente.toString());
                        lista1.setModel(modeloLista);
                        total += ingrediente.getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
            }
        });
        */

        preparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i = 0; i < lista1.getModel().getSize(); i++) {
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

    /*private void cargarEspecialidades(){ // ESPECIALIDADES
        especialidades.add(new Especialidad("Cuatro Quesos", Arrays.asList(new Topping("Mozzarella", 10), new Topping("Cheddar", 10), new Topping("Parmesano", 10), new Topping("Gorgonzola", 10))));
        especialidades.add(new Especialidad("Pollo Teriyaki", Arrays.asList(new Topping("Pollo", 10), new Topping("Salsa Teriyaki", 5))));
        especialidades.add(new Especialidad("Pizza de Desayuno", Arrays.asList(new Topping("Huevos", 10), new Topping("Bacon", 10), new Topping("Queso Cheddar", 10))));
        especialidades.add(new Especialidad("Vegetariana", Arrays.asList(new Topping("Pimiento", 5), new Topping("Cebolla", 5), new Topping("Aceitunas", 5))));
        especialidades.add(new Especialidad("Pizza Cevichera", Arrays.asList(new Topping("Mariscos", 15), new Topping("Cebolla Roja", 5), new Topping("Cilantro", 5), new Topping("Jugo de Limón", 5))));
        especialidades.add(new Especialidad("Armar desde cero", new ArrayList<>()));

        DefaultComboBoxModel model = new DefaultComboBoxModel(especialidades.toArray());
        Especialidades.setModel(model);
    }*/
}

