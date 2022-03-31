package com.pachet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    private String data;
    private JFrame frame1;
    private JFrame frame2;
    public Scoala school;
    protected boolean ok = true;

    Main() {
        school = new Scoala();
    }

    public void initialize() {

        frame1 = new JFrame("Titlu");
        frame1.setLocationRelativeTo(null);
        String clase[] = {"A", "B", "C", "D"};
        frame1.setSize(400, 400);
        JComboBox combo = new JComboBox(clase);
        combo.setBounds(30, 30, 40, 40);
        JButton button = new JButton("Next");
        button.setBounds(80, 30, 80, 40);
        frame1.add(button);
        frame1.add(combo);
        frame1.setLayout(null);
        frame1.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                data = (String) combo.getItemAt(combo.getSelectedIndex());
                frame1.setVisible(false);
                initializare();
                //System.out.println("dsadasd");

            }
        });


    }

    public void meniuprofesori() {
        JFrame frame3 = new JFrame("Meniu profesor");

        JButton afiseaza = new JButton("Afiseaza Profesorul");
        JButton adauga = new JButton("Adauga Profesorul");
        JButton adauganota = new JButton("Adauga Nota");
        JButton test = new JButton("Se da un test");
        JButton performante = new JButton("Performante");
        JButton close = new JButton("Close");

        afiseaza.setBounds(30, 30, 180, 20);
        adauga.setBounds(30, 80, 180, 20);
        adauganota.setBounds(280, 30, 180, 20);
        test.setBounds(280, 80, 180, 20);
        performante.setBounds(150, 300, 180, 20);
        close.setBounds(400, 300, 180, 20);


        frame3.add(close);
        frame3.add(afiseaza);
        frame3.add(adauga);
        frame3.add(adauganota);
        frame3.add(test);
        frame3.add(performante);


        //
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame3.dispose();
                frame2.setVisible(true);
                return;

            }
        });


        //
        afiseaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new JFrame("Date profesor");
                frame4.setLocationRelativeTo(null);


                String coloaneProfesori[] = {"Nume", "Adresa"};
                String dateProfesor[][] = new String[school.mapa.get(data).ExistaProfesor()][2];


                try
                {
                    dateProfesor[0][0] = school.mapa.get(data).NumeProfesor();
                    dateProfesor[0][1] = school.mapa.get(data).AdresaProfesor();

                } catch (Exception e1) {
                    System.out.println("Nu exista profesor adaugat in lista");
                    frame4.dispose();
                }


                JPanel panel = new JPanel();
                JTable table = new JTable(dateProfesor, coloaneProfesori) {
                    public boolean isCellEditable(int dateProfesor, int coloaneProfesori)
                    {
                        return false;
                    }
                };

                JTableHeader header = table.getTableHeader();
                header.setBackground(Color.yellow);
                JScrollPane pane = new JScrollPane(table);
                pane.setPreferredSize(new Dimension(600, 250));
                //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                //pane.setBounds(2,300,30,30);

                panel.add(pane, BorderLayout.WEST);


                frame4.add(panel);
                frame4.setLocationRelativeTo(null);
                frame4.setSize(800, 450);
                frame4.setUndecorated(true);
                frame4.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
                //frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.setVisible(true);


            }
        });

        //
        adauga.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new JFrame("Adaugare Profesor");
                frame4.setSize(300, 300);
                JButton close = new JButton("Close");

                close.setBounds(100, 180, 100, 30);

                frame4.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("Nume");
                JLabel label2 = new JLabel("Adresa");

                label1.setBounds(30, 30, 80, 40);
                label2.setBounds(30, 80, 80, 40);

                JTextField text1 = new JTextField( 30);
                JTextField text2 = new JTextField( 30);

                text1.setBounds(120, 30, 60, 30);
                text2.setBounds(120, 80, 60, 30);

                frame4.add(close);
                frame4.add(label1);
                frame4.add(label2);
                frame4.add(text1);
                frame4.add(text2);

                frame4.setLayout(null);
                frame4.setVisible(true);


                close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String a = text1.getText();
                        String b = text2.getText();


                        try
                        {
                            if(!a.equals("") && !b.equals(""))
                            {
                                school.mapa.get(data).adaugaProfesor(a, b);

                            }

                            frame4.dispose();

                        } catch (Exception exception) {
                            frame4.dispose();
                            System.out.println(exception.getMessage());

                        }

                        //frame3.dispose();

                    }
                });

            }
        });


        //
        adauganota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame4 = new JFrame("Se adauga nota");

                JButton close2 = new JButton("Close");

                JLabel nume = new JLabel("Nume");
                JTextField input = new JTextField(16);
                String note[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                JComboBox combo = new JComboBox(note);

                nume.setBounds(30, 30, 50, 20);
                combo.setBounds(30, 70, 40, 20);
                close2.setBounds(60, 100, 80, 20);
                input.setBounds(150, 30, 50, 30);

                frame4.add(input);
                frame4.add(nume);
                frame4.add(combo);
                frame4.add(close2);


                frame4.setLocationRelativeTo(null);
                frame4.setSize(800, 450);
                frame4.setUndecorated(true);
                frame4.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
                //frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.setLayout(null);
                frame4.setVisible(true);


                close2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int nota = Integer.parseInt((String) combo.getItemAt(combo.getSelectedIndex()));
                        String nume_elev = input.getText();

                        school.atribuieNota(data, nume_elev, nota);

                        frame4.dispose();

                    }
                });


            }
        });


        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (school.mapa.get(data).profesor != null) {

                    //school.atribuieNotaTotiElevii(data, nota_test);
                    school.atribuieRandom(data);
                }
                else
                {
                    System.out.println("Nu exista profesor");
                }

            }
        });


        performante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame4 = new JFrame("Performante");
                JLabel nume = new JLabel("Nume");
                JTextField camp = new JTextField(16);
                nume.setBounds(30, 30, 50, 20);
                camp.setBounds(100, 30, 60, 20);

                JButton back = new JButton("Back");
                back.setBounds(100,120,80,20);

                JButton fol = new JButton("Afiseaza");

                frame4.add(nume);
                frame4.add(camp);
                frame4.add(fol);
                frame4.add(back);

                fol.setBounds(50,90,90,20);


                fol.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String name = camp.getText();
                        performance(name);
                    }
                });

                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame4.dispose();

                    }
                });


                frame4.setLayout(null);
                frame4.setLocationRelativeTo(null);
                frame4.setSize(800, 450);
                frame4.setUndecorated(true);
                frame4.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
                frame4.setVisible(true);

            }
        });


        frame3.setLayout(null);
        frame3.setLocationRelativeTo(null);
        frame3.setSize(800, 450);
        frame3.setUndecorated(true);
        frame3.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame3.setVisible(true);

    }

    private CategoryDataset createDataset(String name)
    {

        var dataset = new DefaultCategoryDataset();

        ArrayList<Integer> lista = new ArrayList<>();
        lista = school.mapa.get(data).returneazaNotaElevNr(name);

        for(int i = 0; i < lista.size(); i++)
        {
            String nota_vertical = "nota " + (i + 1);
            dataset.setValue(lista.get(i),"Note",nota_vertical);
        }

        return dataset;
    }


    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Performante",
                "",
                "Nota",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }

    public void performance(String name)
    {

        CategoryDataset dataset = createDataset(name);

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.WHITE);


        JFrame frame4 = new JFrame("Performante");

        frame4.add(chartPanel);
        frame4.pack();

        frame4.setLayout(null);
        frame4.setLocationRelativeTo(null);
        frame4.setSize(700, 550);
       // frame4.setUndecorated(true);
        //frame4.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame4.setVisible(true);


    }


    public void meniuelevi() {
        JFrame frame3 = new JFrame("Meniu Elevi");

        JButton adauga = new JButton("Adauga elevi");
        JButton afiseaza = new JButton("Afiseaza elevi");
        JButton close = new JButton("Close");

        adauga.setBounds(80, 30, 160, 20);
        afiseaza.setBounds(80, 70, 160, 20);
        close.setBounds(80, 100, 160, 20);

        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame frame4 = new JFrame("Adaugare elev");

                JButton close2 = new JButton("Close");

                JLabel nume = new JLabel("Nume");
                JLabel adresa = new JLabel("Adresa");

                JTextField nume_camp = new JTextField(16);
                JTextField adresa_camp = new JTextField(16);

                nume.setBounds(30, 30, 100, 30);
                adresa.setBounds(30, 60, 100, 30);
                nume_camp.setBounds(150, 30, 80, 20);
                adresa_camp.setBounds(150, 60, 80, 20);
                close2.setBounds(100, 100, 80, 20);

                frame4.add(nume);
                frame4.add(adresa);
                frame4.add(nume_camp);
                frame4.add(adresa_camp);
                frame4.add(close2);

                close2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String name = nume_camp.getText();
                        String adress = adresa_camp.getText();

                        if(!name.equals("") && !adress.equals(""))
                        {
                            school.mapa.get(data).adaugaElevi(name, adress);
                        }


                        frame4.dispose();

                    }
                });

                frame4.setLayout(null);
                frame4.setLocationRelativeTo(null);
                frame4.setSize(800, 450);
                frame4.setUndecorated(true);
                frame4.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
                frame4.setVisible(true);


            }


        });


        afiseaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String coloane[] = {"Nume", "Adresa", "Nota1", "Nota2", "Nota3", "Nota4"
                        , "Nota5", "Nota6", "Nota7", "Nota8", "Nota9", "Nota10"};

                String date[][] = new String[school.mapa.get(data).NumarElevi()][12];


                JFrame frame4 = new JFrame("Tabel");
                //frame3.setLocationRelativeTo(null);


                for (int i = 0; i < school.mapa.get(data).NumarElevi(); i++)
                {
                    date[i][0] = school.mapa.get(data).returneazaNumeleElevulNr(i);
                    date[i][1] = school.mapa.get(data).retuneazaAdresaElevNr(i);
                    //date[i][2] = String.valueOf(school.mapa.get(data).returneazaNotaElevNr(i));

                    ArrayList<Integer> lista = new ArrayList<>();
                    lista = school.mapa.get(data).returneazaNotaElevNr(i);

                    for (int j = 0; j < lista.size(); j++) {
                        date[i][j + 2] = String.valueOf(lista.get(j));
                    }

                }

                JPanel panel = new JPanel();

                JTable table = new JTable(date, coloane)
                {
                    public boolean isCellEditable(int date, int coloane) {
                        return false;
                    }
                };

                JTableHeader header = table.getTableHeader();
                header.setBackground(Color.yellow);
                JScrollPane pane = new JScrollPane(table);
                pane.setPreferredSize(new Dimension(600, 250));
                panel.add(pane, BorderLayout.WEST);


                frame4.add(panel);
                frame4.setLocationRelativeTo(null);
                frame4.setSize(800, 450);
                frame4.setUndecorated(true);
                frame4.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
                frame4.setVisible(true);

            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame3.dispose();
                frame2.setVisible(true);
            }
        });

        frame3.add(adauga);
        frame3.add(afiseaza);
        frame3.add(close);

        frame3.setLayout(null);
        frame3.setLocationRelativeTo(null);
        frame3.setSize(800, 450);
        frame3.setUndecorated(true);
        frame3.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame3.setVisible(true);
    }

    public void initializare() {

        frame2 = new JFrame("Meniu");
        frame2.setLocationRelativeTo(null);

        JButton profesori = new JButton("Meniu profesor");
        JButton elevi = new JButton("Meniu elevi");
        JButton close = new JButton("Back");

        profesori.setBounds(30, 30, 200, 20);
        elevi.setBounds(30, 90, 200, 20);
        close.setBounds(70,150,100,20);

        frame2.setLayout(null);
        frame2.setLocationRelativeTo(null);
        frame2.setSize(800, 450);
        frame2.setUndecorated(true);
        frame2.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame2.setVisible(true);

        frame2.add(profesori);
        frame2.add(elevi);
        frame2.add(close);


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                frame1.setVisible(true);
            }
        });

        profesori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                meniuprofesori();
                //frame2.setVisible(true);
            }
        });


        elevi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame2.setVisible(false);
                meniuelevi();

            }
        });

    }

    public static void main(String[] args) {


        Main mn = new Main();
        mn.initialize();

    }

}
