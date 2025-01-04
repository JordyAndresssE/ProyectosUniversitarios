package ec.edu.ups.pa.verdugos_espinozaj_practica.vista;

import ec.edu.ups.pa.verdugos_espinozaj_practica.controlador.LibroControlador;
import ec.edu.ups.pa.verdugos_espinozaj_practica.controlador.GeneroControlador;
import ec.edu.ups.pa.verdugos_espinozaj_practica.modelo.Libro;
import ec.edu.ups.pa.verdugos_espinozaj_practica.modelo.Genero;

import java.awt.BorderLayout;
import java.awt.GridLayout;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sebas
 */
public class GestionLibreria {
    private LibroControlador libroControlador = new LibroControlador();
    private GeneroControlador generoControlador = new GeneroControlador();

    public void initComponents() {
        JFrame frame = new JFrame("Gestión de Librería");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel labelCodigo = new JLabel("Código del libro:");
        JTextField textCodigo = new JTextField();
        JLabel labelTitulo = new JLabel("Título:");
        JTextField textTitulo = new JTextField();
        JLabel labelFecha = new JLabel("Fecha de Publicación:");
        JTextField textFecha = new JTextField();
        JLabel labelPrecio = new JLabel("Precio:");
        JTextField textPrecio = new JTextField();
        JLabel labelGenero = new JLabel("Géneros:");

        JPanel panelGenero = new JPanel();
        panelGenero.setLayout(new GridLayout(0, 1));

        List<Genero> generos = generoControlador.listarGeneros();
        JCheckBox[] checkBoxes = new JCheckBox[generos.size()];

        for (int i = 0; i < generos.size(); i++) {
            Genero genero = generos.get(i);
            checkBoxes[i] = new JCheckBox(genero.getCodigo() + " - " + genero.getDescripcion());
            panelGenero.add(checkBoxes[i]);
        }

        JButton buttonAgregar = new JButton("Agregar");
        JButton buttonEliminar = new JButton("Eliminar");
        JButton buttonModificar = new JButton("Modificar");
        JButton buttonListar = new JButton("Listar Libros");

        panel.add(labelCodigo);
        panel.add(textCodigo);
        panel.add(labelTitulo);
        panel.add(textTitulo);
        panel.add(labelFecha);
        panel.add(textFecha);
        panel.add(labelPrecio);
        panel.add(textPrecio);
        panel.add(labelGenero);
        panel.add(panelGenero);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonAgregar);
        buttonPanel.add(buttonEliminar);
        buttonPanel.add(buttonModificar);
        buttonPanel.add(buttonListar);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        frame.setVisible(true);

        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textCodigo.getText();
                String titulo = textTitulo.getText();
                Date fechaPublicacion = Date.valueOf(textFecha.getText());
                double precio = Double.parseDouble(textPrecio.getText());

                List<String> generosSeleccionados = new ArrayList<>();
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        String[] parts = checkBox.getText().split(" - ");
                        generosSeleccionados.add(parts[0]);
                    }
                }

                String generoSeleccionado = generosSeleccionados.isEmpty() ? "" : generosSeleccionados.get(0);

                Libro libro = new Libro(codigo, titulo, fechaPublicacion, precio, generoSeleccionado);
                boolean agregado = libroControlador.agregarLibro(libro);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Libro agregado exitosamente");
                    textCodigo.setText("");
                    textTitulo.setText("");
                    textFecha.setText("");
                    textPrecio.setText("");
                    for (JCheckBox checkBox : checkBoxes) {
                        checkBox.setSelected(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar el libro");
                }
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textCodigo.getText();
                boolean eliminado = libroControlador.eliminarLibro(codigo);

                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente");
                    textCodigo.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el libro o el libro no existe");
                }
            }
        });

        buttonModificar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = textCodigo.getText();
        Libro libro = libroControlador.buscarLibroPorCodigo(codigo);

        if (libro != null) {
            // Obtener los datos nuevos desde los campos de texto
            String nuevoTitulo = textTitulo.getText();
            Date nuevaFechaPublicacion = Date.valueOf(textFecha.getText());
            double nuevoPrecio = Double.parseDouble(textPrecio.getText());

            List<String> generosSeleccionados = new ArrayList<>();
            for (JCheckBox checkBox : checkBoxes) {
                if (checkBox.isSelected()) {
                    String[] parts = checkBox.getText().split(" - ");
                    generosSeleccionados.add(parts[0]);
                }
            }

            String nuevoGenero = generosSeleccionados.isEmpty() ? "" : generosSeleccionados.get(0);

            // Establecer los nuevos datos en el objeto libro
            libro.setTitulo(nuevoTitulo);
            libro.setFechaPublicacion(nuevaFechaPublicacion);
            libro.setPrecio(nuevoPrecio);
            libro.setCodigoGenero(nuevoGenero);

            // Llamar al método para actualizar el libro
            boolean modificado = libroControlador.modificarLibro(libro);

            if (modificado) {
                JOptionPane.showMessageDialog(null, "Libro modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el libro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El libro no existe");
        }
    }
});


        buttonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Libro> libros = libroControlador.listarLibros();
                StringBuilder listado = new StringBuilder();

                for (Libro libro : libros) {
                    listado.append(libro.getCodigo()).append(" - ")
                            .append(libro.getTitulo()).append(" - ")
                            .append(libro.getFechaPublicacion()).append(" - ")
                            .append(libro.getPrecio()).append(" - ")
                            .append(libro.getCodigoGenero()).append("\n");
                }

                JOptionPane.showMessageDialog(null, listado.toString());
            }
        });
    }

    public static void main(String[] args) {
        GestionLibreria app = new GestionLibreria();
        app.initComponents();
    }
}
